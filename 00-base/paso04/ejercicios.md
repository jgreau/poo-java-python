# Paso 4 - Leer del teclado | Ejercicios

Todos los programas de esta hoja empiezan igual:

```java
import java.util.Scanner;

public class LoQueSea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ...

        sc.close();
    }
}
```

> **Acuérdate de las dos trampas:** después de un `nextInt()` o `nextDouble()`,
> si lo que sigue es un `nextLine()`, hay que comerse el Enter con un
> `sc.nextLine()` suelto. Y si tu PC está en español, los decimales van con
> **coma**.

▶ **Plantillas:** [plantillas/](plantillas/) — un `.java` por ejercicio, con el enunciado, la salida esperada y los `// TODO` donde va tu código.
Si las usas, el archivo ya viene creado (`B4_1_Calculadora.java`) y **ese** nombre manda sobre el
que diga el enunciado.

✅ **Solucionario:** [soluciones/](soluciones/soluciones.md) — el código de cada
ejercicio, la salida real y por qué se resuelve así. Ábrelo **después** de intentarlo.

> **Cómo se lee cada ejercicio:** el título dice qué hay que lograr; el bloque
> de abajo es la **salida esperada**, o sea lo que tiene que aparecer en tu
> pantalla (en los programas que preguntan cosas, lo que va después de la
> pregunta es lo que **escribe el usuario**); las citas como esta son pistas.
> Si no sabes por dónde partir, abre la plantilla: los `// TODO` numerados son
> los pasos, en orden. Compila y ejecuta después de cada uno.

---

### B4.1 - La calculadora

**Qué practicas:** leer enteros con `Scanner`, y forzar una división decimal con un cast.

Escribe `Calculadora.java`: pide dos números enteros e imprime las cuatro
operaciones. La división tiene que salir **con decimales**.

```
Primer numero: 7
Segundo numero: 2
7 + 2 = 9
7 - 2 = 5
7 * 2 = 14
7 / 2 = 3.5
```

> Si te sale `7 / 2 = 3`, vuelve al paso 3: es la división entera.

---

### B4.2 - La ficha completa

**Qué practicas:** combinar `nextLine`, `nextInt` y `nextDouble` en el orden correcto, y resolver la trampa del Enter entre ellos.

Escribe `FichaAlumno.java`. Pide, **en este orden**: nombre (texto), edad
(entero), estatura en metros (decimal) y comuna (texto). Imprime:

```
Nombre:    Ana Perez
Edad:      20 anios
Estatura:  1.68 m
Comuna:    Puente Alto
```

Este orden es a propósito: si no te acuerdas del `sc.nextLine()` de más, el
programa te va a saltar la comuna.

---

### B4.3 - El IMC

**Qué practicas:** leer dos decimales, y por qué los paréntesis cambian el resultado de una fórmula.

Escribe `Imc.java`: pide el peso en kilos y la estatura en metros, y muestra el
índice de masa corporal (`peso / (estatura * estatura)`) con **un** decimal.

```
Peso en kilos: 70
Estatura en metros: 1.75
Tu IMC es 22.9
```

> Todavía no podemos decir si es bajo, normal o alto: eso es el paso 5.

---

### B4.4 - El total de la compra

**Qué practicas:** combinar lectura de teclado, cálculo y `printf` en un solo programa, como en una boleta real.

Pide el nombre de un producto, su precio unitario y la cantidad. Muestra una
boleta con `printf`, usando lo del paso 2:

```
Producto: Cuaderno
Precio unitario: 1990
Cantidad: 3

Cuaderno x3
Neto:      5970
IVA:       1134
Total:     7104
```

---

### B4.5 - Desafío: el cambio

**Qué practicas:** aplicar la división entera y el resto varias veces seguidas para desglosar un valor en partes.

Pide cuánto cuesta algo y con cuánto paga el cliente. Muestra el vuelto
desglosado en billetes y monedas, usando `/` y `%` del paso 3:

```
Precio: 7300
Paga con: 20000

Vuelto: 12700
  1 billete(s) de 10000
  0 billete(s) de 5000
  1 billete(s) de 2000
  0 billete(s) de 1000
  1 moneda(s) de 500
  2 moneda(s) de 100
```

> ¿Qué pasa si paga con menos de lo que cuesta? Por ahora, anótalo como
> pendiente: se arregla en el paso 5.

---

Cuando termines, sigue con el [paso 5](../PASO-A-PASO.md#paso-5---decidir-if-else-switch).
