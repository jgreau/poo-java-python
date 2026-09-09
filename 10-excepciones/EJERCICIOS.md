# Demo 10 — Excepciones | Ejercicios

**13 ejercicios, marcados como `// TODO E10.x` dentro del código.**
Pensados para resolverse en **una clase**.

La regla de la carpeta `java/`: no hay un solo `try-catch` en los cinco
archivos. Ese es el trabajo.

Antes de empezar, corre `TABLA-EXCEPCIONES.md` de punta a cabo y bota el
programa de las 12 formas posibles. No se puede arreglar lo que no se vio
fallar.

---

## E10.0 — El `throws Exception` del main

**Archivo:** `Demo10.java`, la línea del `main`.

Borra el `throws Exception` y compila:

```bash
javac *.java
```

Aparecen **6 errores**, todos de excepciones checked:

```
Demo10.java:44: error: unreported exception CupoLlenoException;
        must be caught or declared to be thrown
        precargar(registro);
                 ^
```

Son 3 de `AlumnoNoEncontradoException`, 2 de `CupoLlenoException` y 1 de
`FileNotFoundException`. Cuéntalos tú también, y después vuelve a poner el
`throws Exception`: cero errores de nuevo.

> Ese `throws Exception` existe en código real, y casi siempre significa "no
> me quise hacer cargo". Fíjate en lo que **no** apareció en esa lista: las
> excepciones unchecked, que son 11 de las 12 formas de botar el programa.
> **El compilador solo te protege de la mitad.**

**Pregunta para la clase:** si las checked te obligan y las unchecked no,
¿por qué el JDK hizo unchecked al `NullPointerException`, que es la que más
daño hace?

---

## Bloque 1 — Lanzar (E10.1 a E10.10)

Diez `TODO` repartidos por las clases. **Ninguno necesita un `try-catch`**:
son todos `throw`, validaciones o cambios de estructura.

### `Alumno.java`

**E10.1 — el RUT sin guion.**
Si `indexOf('-')` devuelve −1, lanza `IllegalArgumentException`. Sin esto, la
línea siguiente hace `substring(0, -1)` y revienta con un mensaje que no le
sirve a nadie.

**E10.2 — la nota fuera de rango.**
Lanza `NotaInvalidaException` si la nota no está entre 1.0 y 7.0.

> **Este es el ejercicio más importante de los diez**, porque hoy no revienta:
> acepta el 9.5 y dice "Listo". Todos los demás fallan a gritos; este falla
> callado, que es mucho peor.

**E10.3 — la quinta nota.**
Lanza `IllegalStateException` cuando el arreglo está lleno.

> ¿Por qué `IllegalStateException` y no `IllegalArgumentException`? La nota
> que llega es válida; lo que está mal es el **estado** del objeto que la
> recibe. El JDK respeta esa distinción en todas partes y en la prueba se
> pregunta.

**E10.4 — el promedio sin notas.**
Hay **dos respuestas defendibles** y hay que elegir una y argumentarla:

| Opción | A favor | En contra |
|---|---|---|
| Lanzar `IllegalStateException` | no miente nunca | obliga a `try-catch` a quien liste alumnos |
| Devolver `0.0` | simple, nadie se cae | **es mentira**: dice REPROBADO de alguien que no ha rendido nada |

La solución del profesor toma la primera. Discutan si están de acuerdo.

### `Curso.java`

**E10.5 — cupo negativo** → `IllegalArgumentException` (**unchecked**)
**E10.6 — cupo lleno** → `CupoLlenoException` (**checked**)

**La pregunta de la demo:** las dos son "un problema con el cupo".
¿Por qué una es checked y la otra no?

> Pista: ¿puede el programa que llama *hacer algo* al respecto? Ante un cupo
> lleno, sí: ofrecer otra sección. Ante un cupo de −3, no: eso es un bug, y lo
> único que corresponde es arreglar el código.

### `Registro.java`

**E10.7 — la búsqueda que devuelve `null`.**
Lanza `AlumnoNoEncontradoException` en vez de devolver `null`.

> Fíjate en que **no hay que tocar la firma**: el `throws` ya estaba
> declarado. Por eso el programa compilaba aunque el `throw` no existiera.
> Declarar una excepción que nunca lanzas es legal en Java, y es una trampa
> silenciosa.

**E10.8 — la línea mala del archivo.**
Envuelve el `parseDouble` en un `try-catch` y relanza un
`IllegalArgumentException` que diga **qué línea** falló, pasando el
`NumberFormatException` original como **causa**:

```java
throw new IllegalArgumentException("Linea " + n + " ilegible", e);
//                                                             ^ la causa
```

Corre el programa y busca el `Caused by:` en el stack trace. **No se perdió
nada**: se le agregó contexto. Traducir una excepción sin conservar la causa
sí es perder información, y es un error grave.

**E10.9 — el `close()` que no siempre corre.**
Si una línea revienta, el archivo queda abierto. Escribe **las dos**
soluciones y compáralas:

```java
// 1. finally
Scanner archivo = null;
try {
    archivo = new Scanner(new File(ruta));
    ...
} finally {
    if (archivo != null) archivo.close();
}

// 2. try-with-resources
try (Scanner archivo = new Scanner(new File(ruta))) {
    ...
}                                  // se cierra solo, pase lo que pase
```

**E10.10 — el cast a ciegas.**
Usa `instanceof` en vez de capturar el `ClassCastException`. En Java 17 se
escribe así y el cast desaparece del código:

```java
if (o instanceof Alumno a) {
    System.out.println(a.getNombre());
}
```

> Capturar excepciones para controlar el flujo normal es mala práctica. La
> excepción es para lo **excepcional**.

---

## Bloque 2 — Capturar (E10.11 y E10.12)

Recién ahora, y solo en `Demo10`. **Los diez ejercicios anteriores casi no
necesitaron un `catch`**: se resolvieron validando antes o cambiando la
estructura. Ese orden no es casualidad, es la lección de la demo.

**E10.11 — el menú que no se muere.**
Envuelve el `switch` en un `try` y captura **de lo más específico a lo más
general**:

```java
} catch (CupoLlenoException e) {            // propia, checked
} catch (AlumnoNoEncontradoException e) {   // propia, checked
} catch (FileNotFoundException e) {         // la unica checked del JDK aqui
} catch (NotaInvalidaException e) {         // propia, unchecked
} catch (RuntimeException e) {              // la red de seguridad
}
```

Ahora prueba a poner el `catch (Exception e)` **arriba de todos** y compila:

```
error: exception CupoLlenoException has already been caught
```

El compilador te lo impide: los `catch` se evalúan en orden y el primero que
calza gana, así que el general arriba dejaría a los demás inalcanzables.

Aprovecha de lanzar el `IllegalArgumentException` de la opción inválida (está
en el `default` del `switch`) para que escribir `99` no mate el programa.

**E10.12 — `finally` y el Scanner.**
Agrega un `finally` que imprima algo en cada vuelta y compruébalo: se ejecuta
con éxito, con excepción **y** con `break`. Después reescribe la apertura del
`Scanner` como `try-with-resources` y borra el `sc.close()`.

---

## Si sobra tiempo

**E10.13 — el `InputMismatchException` y el bucle infinito.**
Escribe un método `leerEntero(Scanner, String)` que insista hasta recibir un
número. Vas a caer en la trampa clásica:

```java
} catch (InputMismatchException e) {
    System.out.println("No es un numero");   // y gira para siempre
}
```

El texto malo **sigue en el buffer** del Scanner: falta un `sc.nextLine()`
dentro del `catch`.

Y cuidado con el orden: `InputMismatchException` **hereda de**
`NoSuchElementException`. Si capturas la segunda primero, la primera nunca se
alcanza, y el compilador ni te avisa porque técnicamente es legal.

**E10.14 — una cuarta excepción propia.**
Crea `MatriculaDuplicadaException` para cuando un alumno se matricula dos
veces en el mismo curso. Decide **tú** si es checked o unchecked, con el
criterio de E10.5 y E10.6, y defiende la decisión.

**E10.15 — el catch vacío.**
Escribe esto en cualquier parte:

```java
try {
    ...
} catch (Exception e) {
    // nada
}
```

Corre el programa: **no pasa nada**. Ningún mensaje, ningún error, y sigue
con datos malos. Es el peor pecado del tema y el más frecuente en el código
real. Bórralo.

**E10.16 — el recuento.**
De los 12 arreglos que hiciste, ¿cuántos fueron un `try-catch`? Cuenta bien
antes de escribir la conclusión.
