# Paso 4 - Leer del teclado | Solucionario

Las cinco soluciones del paso 4. Ahora las salidas son **sesiones completas**: lo que aparece después de cada pregunta es lo que se escribió por teclado.

> **Úsalo después de intentarlo.** Cada solución viene con la salida real
> del programa: si la tuya coincide, está bien aunque el código sea distinto.
> Los `.java` de esta carpeta son los mismos que se muestran abajo, listos
> para ejecutar: `cd soluciones/paso04` y `javac *.java`.

---

## B4.1 - La calculadora

Cuatro operaciones. La única con truco es la división: hay que forzar el decimal.

<details>
<summary><b>Ver la solución</b> (B4_1_Calculadora.java)</summary>

`B4_1_Calculadora.java`

```java
import java.util.Scanner;


public class B4_1_Calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Primer numero: ");
        int a = sc.nextInt();

        System.out.print("Segundo numero: ");
        int b = sc.nextInt();

        System.out.println(a + " + " + b + " = " + (a + b));
        System.out.println(a + " - " + b + " = " + (a - b));
        System.out.println(a + " * " + b + " = " + (a * b));
        System.out.println(a + " / " + b + " = " + (double) a / b);

        sc.close();
    }
}
```

</details>

**Salida:**

```
Primer numero: 7
Segundo numero: 2
7 + 2 = 9
7 - 2 = 5
7 * 2 = 14
7 / 2 = 3.5
```

**Lo que importa.** El `(double) a / b`: sin el cast, `7 / 2` da 3 y la calculadora miente. Y fíjate en los **paréntesis** de `(a + b)`: sin ellos, `"7 + " + a + b` pega los números en vez de sumarlos, que es el B2.1 otra vez.

> Si tu división mostró `3.5` pero la suma mostró `72`, ya sabes cuál de los dos paréntesis te faltó.

---

## B4.2 - La ficha completa

El orden de las preguntas es la trampa: después del `nextDouble` viene una pregunta de texto, así que hay que comerse el Enter.

<details>
<summary><b>Ver la solución</b> (B4_2_Ficha.java)</summary>

`B4_2_Ficha.java`

```java
import java.util.Scanner;


public class B4_2_Ficha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Edad: ");
        int edad = sc.nextInt();

        System.out.print("Estatura en metros: ");
        double estatura = sc.nextDouble();
        sc.nextLine();                       // se come el Enter que dejo nextDouble

        System.out.print("Comuna: ");
        String comuna = sc.nextLine();

        System.out.println();
        System.out.printf("Nombre:    %s%n", nombre);
        System.out.printf("Edad:      %d anios%n", edad);
        System.out.printf("Estatura:  %.2f m%n", estatura);
        System.out.printf("Comuna:    %s%n", comuna);

        sc.close();
    }
}
```

</details>

**Salida:**

```
Nombre: Ana Perez
Edad: 20
Estatura en metros: 1.68
Comuna: Puente Alto

Nombre:    Ana Perez
Edad:      20 anios
Estatura:  1.68 m
Comuna:    Puente Alto
```

**Lo que importa.** El `sc.nextLine();` suelto después del `nextDouble()`. Sin esa línea, el programa **no te deja escribir la comuna**: la imprime vacía y termina. No es un error de Java, es que el Enter que apretaste seguía esperando en la fila.

> La regla para no pensarlo nunca más: **cada vez que un `nextInt()` o `nextDouble()` está antes de un `nextLine()`, va un `sc.nextLine()` de relleno entremedio.** En el paso 11 esto desaparece para siempre, porque `Validador` lee siempre la línea completa.

---

## B4.3 - El IMC

Una fórmula y un `printf` con un decimal.

<details>
<summary><b>Ver la solución</b> (B4_3_Imc.java)</summary>

`B4_3_Imc.java`

```java
import java.util.Scanner;


public class B4_3_Imc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Peso en kilos: ");
        double peso = sc.nextDouble();

        System.out.print("Estatura en metros: ");
        double estatura = sc.nextDouble();

        double imc = peso / (estatura * estatura);
        System.out.printf("Tu IMC es %.1f%n", imc);

        sc.close();
    }
}
```

</details>

**Salida:**

```
Peso en kilos: 70
Estatura en metros: 1.75
Tu IMC es 22.9
```

**Lo que importa.** Los paréntesis de `peso / (estatura * estatura)`. Sin ellos, Java divide y después multiplica (van de izquierda a derecha), o sea calcula `(peso / estatura) * estatura`, que da... el peso. Y 70.0 parece un IMC posible, así que el error pasa piola.

> Aquí no hace falta ningún cast: `peso` y `estatura` ya son `double`. La división entera solo aparece cuando **los dos** lados son `int`.

---

## B4.4 - El total de la compra

Se junta el `Scanner` del paso 4 con el `printf` del paso 2 y la constante del paso 3.

<details>
<summary><b>Ver la solución</b> (B4_4_Compra.java)</summary>

`B4_4_Compra.java`

```java
import java.util.Scanner;


public class B4_4_Compra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final double IVA = 0.19;

        System.out.print("Producto: ");
        String producto = sc.nextLine();

        System.out.print("Precio unitario: ");
        int precio = sc.nextInt();

        System.out.print("Cantidad: ");
        int cantidad = sc.nextInt();

        double neto = precio * cantidad;
        double iva = neto * IVA;
        double total = neto + iva;

        System.out.println();
        System.out.println(producto + " x" + cantidad);
        System.out.printf("%-11s%4.0f%n", "Neto:", neto);
        System.out.printf("%-11s%4.0f%n", "IVA:", iva);
        System.out.printf("%-11s%4.0f%n", "Total:", total);

        sc.close();
    }
}
```

</details>

**Salida:**

```
Producto: Cuaderno
Precio unitario: 1990
Cantidad: 3

Cuaderno x3
Neto:      5970
IVA:       1134
Total:     7104
```

**Lo que importa.** Que el neto sea `precio * cantidad` calculado y no un número escrito a mano, y que el IVA salga de la constante. Cambiar `IVA` a `0.20` tiene que corregir las dos últimas líneas solo.

> El IVA real da 1134.3 y el total 7104.3. Con `%.0f` se muestran redondeados a 1134 y 7104, **pero por dentro siguen teniendo decimales**: por eso 1134 + 5970 no da exactamente 7104 si los sumas tú. Es la misma trampa que en el paso 13 hace que un promedio 3.95 se muestre como 4.0 y repruebe.

---

## B4.5 - Desafío: el cambio

El mismo par `/` y `%` del B3.3, aplicado seis veces: la división entera dice **cuántos** billetes caben, y el resto dice **qué queda** para el siguiente.

<details>
<summary><b>Ver la solución</b> (B4_5_Vuelto.java)</summary>

`B4_5_Vuelto.java`

```java
import java.util.Scanner;


public class B4_5_Vuelto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Precio: ");
        int precio = sc.nextInt();

        System.out.print("Paga con: ");
        int paga = sc.nextInt();

        int vuelto = paga - precio;
        System.out.println();
        System.out.println("Vuelto: " + vuelto);

        System.out.println("  " + vuelto / 10000 + " billete(s) de 10000");
        vuelto = vuelto % 10000;

        System.out.println("  " + vuelto / 5000 + " billete(s) de 5000");
        vuelto = vuelto % 5000;

        System.out.println("  " + vuelto / 2000 + " billete(s) de 2000");
        vuelto = vuelto % 2000;

        System.out.println("  " + vuelto / 1000 + " billete(s) de 1000");
        vuelto = vuelto % 1000;

        System.out.println("  " + vuelto / 500 + " moneda(s) de 500");
        vuelto = vuelto % 500;

        System.out.println("  " + vuelto / 100 + " moneda(s) de 100");
        vuelto = vuelto % 100;

        System.out.println("  quedan " + vuelto + " pesos sin dar");

        sc.close();
    }
}
```

</details>

**Salida:**

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
  quedan 0 pesos sin dar
```

**Lo que importa.** El patrón se repite igual seis veces: `cuantos = vuelto / valor;` y después `vuelto = vuelto % valor;`. Si te saltas el `%`, el resto de las líneas reparte el vuelto completo otra vez y terminas entregando de más.

**Y el pendiente:** si el cliente paga con menos, el vuelto queda **negativo** y el programa entrega billetes negativos con toda tranquilidad. Eso se arregla con un `if` (paso 5) o, mejor, no dejando entrar el dato malo (paso 11).

> La última línea (`quedan N pesos sin dar`) no la pedía el enunciado, pero es honesta: en Chile no hay monedas de 1, así que un vuelto de 12750 deja 50 pesos que nadie puede pagar.

---

Volver a la [hoja del paso 4](../ejercicios.md) o al [paso 4 de la guía](../../PASO-A-PASO.md).
