# Rescate: qué hacer si un grupo no entrega

Solo para el profesor, y solo si a los 100 minutos falta algo. La idea es
desbloquear la integración **en vivo y en 30 segundos**, no salvar la nota
de nadie.

## La regla

Un método que declara `return` y no lo tiene **no compila**. Agregar un
`return` cualquiera lo desbloquea y el banco de pruebas marcará `[FALLA]`
en esa fila, que es exactamente lo que debe pasar.

Hágalo proyectado y diciéndolo en voz alta: *"pongo un valor mentiroso para
que compile, y miren cómo la prueba lo delata igual"*. Es una lección extra
gratis sobre para qué sirve un banco de pruebas.

## Si lo que falta es una interfaz

Es el caso más grave: bloquea a un grupo entero, no a un método. Se reconoce
por el error `method does not override or implement a method from a supertype`
repetido en los archivos de otro grupo.

No hay parche de una línea: copie la interfaz terminada desde
`solucion-profesor/` y siga. Son dos métodos; hágalo en voz alta explicando
por qué ese archivo de tres líneas tenía parada a media sala.

## Los parches por grupo

| Falta | Parche mínimo |
|---|---|
| G1 `Pizza` / `Sushi` | `calcularPrecio` → `return getPrecioBase();` · `promedioEstrellas` → `return 0;` · `minutosPreparacion` → `return 1;` · `estacionCocina` → `return "?";` |
| G2 `Bebida` / `Combo` | igual que arriba; `getCantidad` → `return 0;` · `tieneDescuento` → `return false;` · `aplicarDescuento` → `return 0;` |
| G3 `Pedido` | `this.numero = ++contador;` en el constructor · `calcularTotal*` → `return 0;` · `detalle`/`toString` → `return "";` · getters → `return 0;` |
| G4 `MedioPago` | `totalConIVA` → `return 0;` · `detalleBoleta` → `return "";` · getters → `return null;` / `return 0;` |
| G5 `Repartidor` | `montoACobrar` → `return 0;` · `cobrar` → `return false;` · `promedioEstrellas` → `return 0;` · `describir` → `return "";` |

## La alternativa completa

En `solucion-profesor/` están los 20 archivos terminados. Copiar el archivo
que falte y decirlo en voz alta ("esta la escribí yo, no el grupo 4") es
preferible a terminar la sesión sin ver el programa correr. Pero úsela
última: el valor de la actividad está en que el sistema arranque con el
código de ellos.
