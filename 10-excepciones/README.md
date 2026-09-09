# Demo 10: Excepciones — Registro DUOC

**Un programa que compila perfecto y se cae con todo.**

Cinco archivos Java, cero `try-catch`. El alumno lo corre, lo bota de las 12
formas posibles, y recién entonces lo arregla.

```bash
cd 10-excepciones/java
javac *.java
java Demo10
```

Escribe `abc` donde pide una opción. Ese es el primer minuto de la clase.

---

## Por qué esta demo es distinta a las nueve anteriores

Las demos 1 a 9 muestran código que **funciona**. Esta muestra código que
**se rompe**, y esa es la única forma honesta de enseñar excepciones: un
`try-catch` explicado en abstracto es un ritual sin sentido; explicado después
de ver el programa morirse delante del curso, es una herramienta.

El orden de la sesión es **primero el dolor, después el remedio** — el mismo
truco del `toString()` de la demo 6, llevado a una demo entera.

---

## El gancho: el `throws Exception` del main

```java
public static void main(String[] args) throws Exception {
```

Esa firma es lo único que permite que el proyecto compile sin manejar nada.
El primer ejercicio (E10.0) es borrarla y compilar: aparecen **6 errores** de
excepciones checked que antes no existían.

Y ahí está el tema completo en un solo experimento:

- las **checked** no aparecían... porque el `throws` las tapaba;
- las **unchecked** siguen sin aparecer, y son **11 de las 12** formas de
  botar el programa.

El compilador solo te protege de la mitad. La otra mitad es tu problema.

---

## Los cinco archivos

```
10-excepciones/
├── java/                    <- lo que se le entrega al alumno. Compila y revienta.
│   ├── Demo10.java          el menú: 9 opciones, 9 formas de morir
│   ├── Alumno.java          notas en arreglo fijo, promedio, RUT, fecha
│   ├── Curso.java           inscritos en arreglo fijo: el cupo
│   ├── Registro.java        las búsquedas que devuelven null, y el archivo
│   ├── Excepciones.java     las 3 excepciones propias, juntas
│   └── notas.csv            el archivo de datos
├── solucion-profesor/       los mismos 5 archivos, blindados. NO se publica.
├── EJERCICIOS.md            13 ejercicios (E10.0 a E10.12) + 4 opcionales
└── TABLA-EXCEPCIONES.md     qué tipear para hacer caer cada excepción
```

Carpeta plana y paquete por defecto, igual que las nueve demos anteriores:
`javac *.java && java Demo10`.

> **`Excepciones.java` rompe a propósito la regla de la hoja 00.** Un archivo
> `.java` puede contener varias clases siempre que ninguna de las extra sea
> `public`: solo la clase `public` obliga a que el archivo se llame igual que
> ella. Lo hacemos para que la demo quepa en cinco archivos, y conviene decirlo
> en voz alta en clase, porque es justo la excepción a una regla que el curso
> viene aplicando desde el primer día. En un proyecto real cada excepción va en
> su propio archivo, como en el taller 09.

---

## Las 3 excepciones propias

Vienen **escritas** (son el modelo a copiar), pero **nadie las lanza todavía**:
los `throw` son los ejercicios.

| Clase | Tipo | Lo que enseña |
|---|---|---|
| `CupoLlenoException` | checked | el caso base: `throws` obligatorio en toda la cadena |
| `AlumnoNoEncontradoException` | checked | una excepción lleva **datos**, no solo un mensaje |
| `NotaInvalidaException` | unchecked | hereda de `IllegalArgumentException`, no de `Exception`: una excepción propia puede colgarse de cualquier punto de la jerarquía del JDK |

**Checked y unchecked mezcladas a propósito.** Es la distinción que más cuesta
y la que más se pregunta.

`NotaInvalidaException` es además la más interesante de las tres, porque hoy
**no revienta**: `Alumno` acepta un 9.5 y dice "Listo". Un dato corrupto que
nadie ve hace más daño que cualquier stack trace.

---

## Las 10 nativas

Cada una tiene su detonante en el menú; qué tipear está en
`TABLA-EXCEPCIONES.md`.

`InputMismatchException` · `StringIndexOutOfBoundsException` ·
`NumberFormatException` · `NegativeArraySizeException` ·
`ArrayIndexOutOfBoundsException` · `ArithmeticException` ·
`NullPointerException` · `FileNotFoundException` · `ClassCastException` ·
`DateTimeParseException` (+ `NoSuchElementException` con Ctrl-D)

`FileNotFoundException` es la única **checked** del JDK en toda la demo.
Bórrale el `throws` a `Registro.cargarNotas` y `javac` se planta. Ese contraste
con `InputMismatchException` —que compila feliz y revienta en producción— es la
mejor definición de "checked" que se puede dar en clase.

---

## La lección que no está en el título

De los 12 arreglos del ejercicio, **solo dos son un `try-catch`**. El resto son
validaciones puestas antes (`Alumno`, `Curso`), una búsqueda que deja de
devolver `null`, un `instanceof` en vez de un cast a ciegas y un
`try-with-resources` para cerrar el archivo.

El `try-catch` aparece recién en el bloque 2 y solo en `Demo10`, que es el
único lugar donde alguien puede **decidir qué hacer** con el error.

Por eso los ejercicios van en ese orden: **lanzar antes que capturar.** Un
curso que parte por el `try-catch` produce alumnos que envuelven todo en
`catch (Exception e) { }` y siguen.

---

## Cómo se ve el después

```
ANTES   Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException:
            Index 2 out of bounds for length 2
        ... y el programa se murió

DESPUES [cupo] El curso PRO101 ya completo su cupo de 2 alumnos
        ...listo, seguimos.
```

La versión del profesor es **imposible de botar desde el teclado**: se le puede
tirar toda la tabla de caza en una sola sesión y el menú sigue vivo. Además
muestra lo que la versión rota no puede: `try-with-resources`, multi-catch,
`finally`, el orden obligatorio de los `catch` y la causa encadenada
(`Caused by:`).

---

## Sugerencia de sesión (90 minutos)

| Tiempo | Qué |
|---|---|
| 0-15 | Correr `java Demo10` y botarlo entre todos. Proyectar `TABLA-EXCEPCIONES.md` y que el curso vaya cantando qué tipear. |
| 15-25 | E10.0: borrar el `throws Exception`. Contar los 6 errores. Checked vs unchecked queda explicado solo. |
| 25-60 | Bloque 1, los 10 `throw`. En parejas. El profesor resuelve E10.1, E10.5 y E10.6 en la pizarra. |
| 60-80 | Bloque 2, el `try-catch` en `Demo10`. Aquí sí, todos juntos. |
| 80-90 | E10.15 (el catch vacío) y E10.16 (contar cuántos arreglos fueron try-catch). Cierre. |

Verificado con OpenJDK 17.
