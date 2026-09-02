# Taller grupal: DUOC Delivery

**5 grupos, 2 horas, un solo programa que tiene que correr.**

Cada grupo escribe clases distintas y es **dueño de una interfaz que otro
grupo está obligado a implementar**. Nadie puede terminar solo. El profesor
entrega la clase raíz y los dos `main`; los grupos escriben las 5 interfaces
y las 11 clases restantes.

---

## Cómo está escrito el material

**El Javadoc es la especificación.** Ningún archivo de alumno trae comentarios
sueltos diciendo qué hacer: trae el Javadoc completo de cada método —
descripción, `@param`, `@return`, `@throws` — y el cuerpo vacío con un
`// TODO`. El alumno lee el contrato y escribe el código que lo cumple, que es
exactamente lo que va a hacer el resto de su vida laboral.

Las cinco interfaces van un paso más allá: **llegan vacías**. Traen el Javadoc
de clase describiendo en prosa qué métodos debe exigir el contrato, con qué
tipos y qué debe lanzar, y el grupo dueño lo traduce a Java. Es lo primero que
se hace en la sesión.

```java
/**
 * El precio segun el tamano y los ingredientes extra.
 *
 * <p>FAMILIAR multiplica por 1.6, MEDIANA por 1.0 y PERSONAL por 0.7.
 * Sobre eso se suman $700 por cada ingrediente extra.</p>
 *
 * @return el precio final en pesos
 */
@Override
public double calcularPrecio() {
    // TODO G1
}
```

`Producto.java` y `Verificador.java`, que entrega el profesor, están
documentados igual: sirven de modelo de cómo se escribe un Javadoc.

## La arquitectura

```
Producto (abstracta, la entrega el profesor)
 |- Pizza, Sushi          G1   implements Calificable (G5) + Preparable (propia)
 |- Bebida                G2   implements Preparable (G1)
 \- Combo                 G2   implements Preparable (G1) + Descontable (propia)
                               y ademas CONTIENE Productos  (composicion)

Pedido                    G3   implements Descontable (G2)   contiene Producto[]

MedioPago (abstracta)     G4   implements Facturable (G3)
 |- Tarjeta               G4
 \- Efectivo              G4

Repartidor (abstracta)    G5   implements Cobrable (G4) + Calificable (propia)
 |- RepartidorMoto        G5
 \- RepartidorBici        G5
```

**Tres clases abstractas**: `Producto` (nuestra), `MedioPago` (G4) y
`Repartidor` (G5). El banco de pruebas intenta instanciar las tres.

## El anillo de contratos

| Interfaz | La escribe | Está obligado a cumplirla |
|---|---|---|
| `Preparable` | G1 Cocina | **G2** (Bebida, Combo) |
| `Descontable` | G2 Bebidas | **G3** (Pedido) |
| `Facturable` | G3 Pedido | **G4** (MedioPago) |
| `Cobrable` | G4 Pagos | **G5** (Repartidor) |
| `Calificable` | G5 Reparto | **G1** (Pizza, Sushi) |

`Calificable` es la interfaz que **cruza las dos jerarquías**: la implementan
la Pizza y el Repartidor, que no comparten ninguna clase padre. Es el mismo
argumento del pingüino de la demo 7, en otro dominio.

## Dónde se demuestra cada concepto

| Concepto | Dónde se ve |
|---|---|
| Clase abstracta | `Producto`, `MedioPago`, `Repartidor` — sección A de las pruebas |
| Herencia | 8 subclases; `RepartidorMoto` usa `super.montoACobrar()` |
| Interfaz | las 5 del anillo; `Descontable cupon = pedido;` como tipo |
| Polimorfismo | el `for` de `Pedido.calcularTotal()` sobre 4 clases distintas |
| Sobrecarga | `agregar()` x2, `calcularTotal()` x3, constructores x2, `Verificador.chequear()` x3 |
| Composición | `Combo` tiene `Producto[]`, `Pedido` tiene `Producto[]` |
| Encapsulamiento | todo `private` + validación que lanza `IllegalArgumentException` |
| static | `Producto.productosCreados`, `Pedido.contador`, `MedioPago.IVA` |

---

## El detalle técnico que hay que explicar sí o sí

**Una clase abstracta no se puede probar con `try/catch` de la forma obvia.**

```java
Producto p = new Producto("x", 1000);   // NO compila. No lanza nada.
```

El `try/catch` no atrapa esto porque no es una excepción: es un error de
compilación, el programa nunca llega a existir. Para poder comprobarlo **en
tiempo de ejecución** hay que instanciar por reflexión, y ahí sí aparece una
excepción atrapable:

```java
Producto.class.getDeclaredConstructor(String.class, double.class)
              .newInstance("x", 1000.0);      // lanza InstantiationException
```

`MainPruebas` hace las dos cosas: la prueba por reflexión (sección A) y deja
la línea del `new` comentada para descomentarla en clase y ver al compilador
negarse. Vale la pena hacerlo en vivo: es el mejor momento de la sesión.

---

## Cómo corre esto

```bash
cd taller
javac *.java        # con los 20 archivos: solo compila si los 5 grupos terminaron
java MainDemo       # la demo narrativa, para proyectar
java MainPruebas    # el banco de pruebas [OK]/[FALLA], 40 verificaciones
```

**Una vez escritas las cinco interfaces**, cada grupo compila solo lo suyo sin
esperar a nadie, porque ninguna clase de alumno depende de una clase de otro
grupo, solo de interfaces:

```bash
javac Producto.java Preparable.java Calificable.java Pizza.java Sushi.java          # G1
javac Producto.java Preparable.java Descontable.java Bebida.java Combo.java        # G2
javac Producto.java Descontable.java Cobrable.java Pedido.java                     # G3
javac Producto.java Facturable.java MedioPago.java Tarjeta.java Efectivo.java      # G4
javac Cobrable.java Calificable.java Repartidor.java RepartidorMoto.java RepartidorBici.java   # G5
```

Esa línea va impresa en la ficha de cada grupo y en el Javadoc de su archivo.

## Diccionario de errores de compilación

Los tres que van a ver, y qué significan. Vale la pena proyectarlo.

| Error | Qué pasó |
|---|---|
| `method does not override or implement a method from a supertype` | La interfaz que debían cumplir **todavía está vacía**. No es problema de ustedes: es el grupo dueño el que no la ha escrito. |
| `missing return statement` | El método está vacío. Ese es su trabajo. Para ir compilando a medias, un `return 0;` provisorio. |
| `constructor X cannot be applied to given types` | El constructor está vacío y Java está intentando llamar solo a `super()`. Falta el `this(...)` o el `super(...)` con sus parámetros. |

## Las carpetas

| Carpeta | Qué es |
|---|---|
| `taller/` | **lo que se copia a los 5 PC.** 4 archivos listos + 5 interfaces vacías con su especificación + 11 stubs con Javadoc y cuerpo vacío |
| `solucion-profesor/` | los 20 archivos completos. Compila y da 40/40. **Fuera del repo** (`.gitignore`): existe solo en el computador del profesor. |
| `fichas-imprimibles.html` | las 6 fichas de papel: 1 general + 5 de grupo |
| `fichas-taller-a4.pdf` | esas mismas fichas en 7 hojas A4, listas para la impresora |
| `generar-pdf.sh` | rehace el PDF si edita el HTML (necesita Chrome) |
| `RESCATE.md` | los parches de una línea si un grupo no entrega |

---

## Los 120 minutos

| Min | Qué pasa |
|---|---|
| **0-15** | Presentar el caso y el diagrama. Correr `javac *.java` con todo en TODO: **falla a la vista de todos**. Esa es la foto inicial. |
| **15-25** | Repartir fichas y formar grupos. Cada grupo lee su ficha y el Javadoc de sus archivos. |
| **25-40** | **Ronda de contratos.** Cada grupo escribe su interfaz —son dos métodos— y sale a explicársela al grupo que debe cumplirla, mirándolo a la cara. Al final de la ronda las 5 interfaces están escritas y se distribuyen a los 5 PC. |
| **40-70** | Implementación. Cada grupo compila lo suyo con su línea de `javac`. |
| **70-80** | **Checkpoint proyectado.** Los 5 grupos muestran su compilación aislada. Aquí aparecen los problemas, no a los 110. |
| **80-100** | Integración: se copian los 16 archivos a una sola carpeta y `javac *.java` en vivo. Se arreglan los errores en pantalla. |
| **100-115** | `java MainDemo` y `java MainPruebas`. Se lee el marcador. |
| **115-120** | Cierre. |

**La ronda de contratos es una barrera dura, no un trámite.** Mientras una
interfaz esté vacía, el grupo que la implementa no compila: sus `@Override`
apuntan a métodos que todavía no existen. No dejar que nadie empiece a
escribir cuerpos antes del minuto 40; ese orden —primero el contrato, después
la implementación— es media lección por sí solo.

**El otro riesgo conocido:** como los stubs no compilan hasta que se rellenan,
si un grupo no entrega no corre nada. Es la lección elegida, y el checkpoint
de los 70 minutos existe para que se descubra a tiempo. Si aun así falta algo
a los 100, está `RESCATE.md`.

## Preguntas para el cierre (5 minutos, valen la clase entera)

1. ¿Por qué `Pedido` no necesitó saber que existía la clase `Combo`?
2. ¿Qué habría pasado si `Calificable` fuera una clase abstracta en vez de
   una interfaz? (respuesta: `Pizza` ya hereda de `Producto`, no puede)
3. Si mañana agregamos `Postre`, ¿cuántos archivos hay que tocar?
4. ¿Qué grupo tenía más poder para romper a los demás, y por qué?
