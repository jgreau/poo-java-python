#!/bin/bash
# Genera fichas-taller-a4.pdf a partir de fichas-imprimibles.html.
# Siete hojas A4: la ficha general ocupa dos, cada ficha de grupo una.
# Necesita Google Chrome y conexion, para que bajen las tipografias.
set -e
cd "$(dirname "$0")"
TMP=$(mktemp -d)
{
  printf '%s' '<!doctype html><html lang="es" data-theme="light"><head><meta charset="utf-8"><style>body{margin:0}</style>'
  cat fichas-imprimibles.html
  printf '%s' '</body></html>'
} > "$TMP/print.html"

google-chrome --headless --disable-gpu --no-sandbox \
    --virtual-time-budget=15000 --no-pdf-header-footer \
    --print-to-pdf="$PWD/fichas-taller-a4.pdf" "file://$TMP/print.html"

rm -rf "$TMP"
echo "listo: fichas-taller-a4.pdf"
