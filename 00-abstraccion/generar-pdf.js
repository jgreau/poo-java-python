// Genera ABSTRACCION.pdf a partir de ABSTRACCION.md.
// Reutiliza las dependencias y el estilo de 00-base (hay que haber corrido
// alli "npm install" una vez). Necesita Google Chrome o Chromium.
//
// Uso:
//     cd 00-abstraccion
//     node generar-pdf.js
const fs = require("fs");
const path = require("path");
const base = path.join(__dirname, "..", "00-base");
const { marked } = require(path.join(base, "node_modules", "marked"));
const puppeteer = require(path.join(base, "node_modules", "puppeteer-core"));

const CHROME =
  process.env.CHROME_PATH ||
  ["/usr/bin/google-chrome", "/usr/bin/chromium", "/usr/bin/chromium-browser"]
    .find((p) => fs.existsSync(p));

marked.setOptions({ gfm: true, breaks: false, headerIds: true, mangle: false });
const css = fs.readFileSync(path.join(base, "estilo-pdf.css"), "utf8");

const md = path.join(__dirname, "ABSTRACCION.md");
const pdf = path.join(__dirname, "ABSTRACCION.pdf");
const tmp = path.join(__dirname, "ABSTRACCION.pdf.tmp.html");

(async () => {
  if (!CHROME) {
    console.error("No encontre Google Chrome ni Chromium. Define CHROME_PATH.");
    process.exit(1);
  }
  let cuerpo = marked.parse(fs.readFileSync(md, "utf8"));
  cuerpo = cuerpo.replace(/<details>/g, "<details open>"); // en PDF no hay clic
  fs.writeFileSync(
    tmp,
    `<!doctype html><html lang="es"><head><meta charset="utf-8">` +
      `<title>Abstraccion</title><style>${css}</style></head><body>${cuerpo}</body></html>`
  );
  const browser = await puppeteer.launch({
    executablePath: CHROME,
    headless: "new",
    args: ["--no-sandbox", "--disable-gpu"],
  });
  const page = await browser.newPage();
  await page.goto("file://" + tmp, { waitUntil: "networkidle0" });
  await page.pdf({
    path: pdf,
    format: "A4",
    printBackground: true,
    margin: { top: "0mm", bottom: "0mm", left: "0mm", right: "0mm" },
  });
  fs.unlinkSync(tmp);
  await browser.close();
  console.log("Listo: " + path.relative(process.cwd(), pdf));
})();
