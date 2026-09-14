// Genera un .pdf al lado de cada .md de 00-base (la guia, cada ejercicios.md
// y cada soluciones.md). Necesita Google Chrome y conexion la primera vez,
// para instalar las dos dependencias.
//
// Uso:
//     cd 00-base
//     npm install
//     node generar-pdf.js
const fs = require("fs");
const path = require("path");
const { marked } = require("marked");
const puppeteer = require("puppeteer-core");

const RAIZ = __dirname;
const CHROME =
  process.env.CHROME_PATH ||
  ["/usr/bin/google-chrome", "/usr/bin/chromium", "/usr/bin/chromium-browser"]
    .find((p) => fs.existsSync(p));

marked.setOptions({ gfm: true, breaks: false, headerIds: true, mangle: false });
const css = fs.readFileSync(path.join(__dirname, "estilo-pdf.css"), "utf8");

function armarHtml(mdPath) {
  let cuerpo = marked.parse(fs.readFileSync(mdPath, "utf8"));
  cuerpo = cuerpo.replace(/<details>/g, "<details open>"); // en PDF no hay clic
  const titulo = path.relative(RAIZ, mdPath);
  return `<!doctype html>
<html lang="es">
<head><meta charset="utf-8"><title>${titulo}</title><style>${css}</style></head>
<body>${cuerpo}</body>
</html>`;
}

function listarMarkdown(dir) {
  let resultado = [];
  for (const entrada of fs.readdirSync(dir, { withFileTypes: true })) {
    const ruta = path.join(dir, entrada.name);
    if (entrada.isDirectory()) {
      if (["plantillas", "referencia", "node_modules"].includes(entrada.name)) continue;
      resultado = resultado.concat(listarMarkdown(ruta));
    } else if (entrada.name.endsWith(".md")) {
      resultado.push(ruta);
    }
  }
  return resultado;
}

(async () => {
  if (!CHROME) {
    console.error("No encontre Google Chrome ni Chromium. Define CHROME_PATH.");
    process.exit(1);
  }

  const archivos = listarMarkdown(RAIZ).sort();
  console.log(`Convirtiendo ${archivos.length} archivos .md...`);

  const browser = await puppeteer.launch({
    executablePath: CHROME,
    headless: "new",
    args: ["--no-sandbox", "--disable-gpu"],
  });
  const page = await browser.newPage();

  for (const md of archivos) {
    const htmlTmp = md.replace(/\.md$/, ".pdf.tmp.html");
    const pdfSalida = md.replace(/\.md$/, ".pdf");
    fs.writeFileSync(htmlTmp, armarHtml(md));
    await page.goto("file://" + htmlTmp, { waitUntil: "networkidle0" });
    await page.pdf({
      path: pdfSalida,
      format: "A4",
      printBackground: true,
      displayHeaderFooter: false,
      margin: { top: "0mm", bottom: "0mm", left: "0mm", right: "0mm" },
    });
    fs.unlinkSync(htmlTmp);
    console.log("  " + path.relative(RAIZ, pdfSalida));
  }

  await browser.close();
  console.log("Listo.");
})();
