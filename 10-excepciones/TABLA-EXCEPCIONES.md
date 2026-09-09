# Demo 10 — Tabla de caza

**Qué tipear para hacer caer cada excepción.** El programa arranca sin un solo
`try-catch`: cada fila es una forma distinta de matarlo.

```bash
cd 10-excepciones/java
javac *.java
java Demo10
```

Cada caída termina el programa. Vuelve a correrlo para la siguiente.

---

## Las 10 nativas de Java

| # | Opción | Qué tipear | Excepción |
|---|--------|-----------|-----------|
| 1 | menú | `abc` en «Opcion:» | `InputMismatchException` |
| 2 | 2 Crear alumno | RUT `123456785` (sin guion) | `StringIndexOutOfBoundsException` |
| 3 | 2 Crear alumno | RUT `abcdefg-1` | `NumberFormatException` |
| 4 | 3 Crear curso | cupo `-3` | `NegativeArraySizeException` |
| 5 | 4 Matricular | dos alumnos más en `PRO101` (cupo 2, ya usa 1) | `ArrayIndexOutOfBoundsException` |
| 6 | 5 Poner nota | la quinta nota de `12345678-5` | `ArrayIndexOutOfBoundsException` |
| 7 | 6 Ver promedio | RUT `11111111-1` (Ana, sin notas) | `ArithmeticException: / by zero` |
| 8 | 6 Ver promedio | RUT `99999999-9` (no existe) | `NullPointerException` |
| 9 | 7 Cargar archivo | `noexiste.csv` | `FileNotFoundException` ← **la única checked** |
| 10 | 8 Informe | *(directo)* | `ClassCastException` |
| 11 | 9 Fecha | `2026-13-45` | `DateTimeParseException` |
| 12 | menú | `Ctrl-D` (cerrar la entrada) | `NoSuchElementException` |

Y una más, que se saca editando el archivo de datos: abre `notas.csv`, cámbiale
un `5.5` por `cinco`, y carga con la opción 7. Sale otro
`NumberFormatException`, esta vez desde adentro del archivo.

> **La fila 9 es la importante.** `FileNotFoundException` es la única
> **checked** del JDK en toda la demo. Bórrale el `throws` a
> `Registro.cargarNotas` y `javac` se niega a compilar. Compárala con la fila
> 1: `InputMismatchException` compila feliz y revienta delante del usuario.
> Esa es la diferencia entre checked y unchecked, en dos filas de una tabla.

---

## Las 3 propias

Sus clases ya están escritas en `Excepciones.java`, pero **nadie las lanza
todavía**: los `throw` son los ejercicios. La columna de la derecha es lo que
pasa hoy.

| Excepción | Tipo | Se lanza en | Hoy, sin el `throw`, pasa esto |
|---|---|---|---|
| `CupoLlenoException` | **checked** | `Curso.matricular` | revienta con *"Index 2 out of bounds for length 2"* |
| `AlumnoNoEncontradoException` | **checked** | `Registro.buscarAlumno` | devuelve `null` y revienta con `NullPointerException` **en otra clase** |
| `NotaInvalidaException` | unchecked | `Alumno.agregarNota` | **acepta un 9.5 en silencio** |

La última fila es la peor de las tres y ahí hay que detenerse: **no revienta**.
Escribe un 9.5 en la opción 5 y el programa dice "Listo". El dato malo entra
al sistema, nadie se entera, y el error aparece después en un promedio que
nadie sabe por qué está mal.

Una excepción que se ve es un buen día. Un dato corrupto silencioso es un mal mes.

---

## El antes y el después

```
ANTES  (java/)
  Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException:
      Index 2 out of bounds for length 2
      at Curso.matricular(Curso.java:47)
      ... y el programa se murió

DESPUES  (solucion-profesor/)
  [cupo] El curso PRO101 ya completo su cupo de 2 alumnos
  ...listo, seguimos.
```

Mismo error, misma línea de código. Lo único que cambió es quién se hace cargo.
