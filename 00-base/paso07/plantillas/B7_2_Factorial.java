/*
 * B7.2 - EL FACTORIAL
 *
 * Pide un numero del 1 al 15 y muestra su factorial (5! = 120).
 *
 * Despues prueba con 13 guardando el resultado en un int: da 1932053504,
 * que esta MAL (13! es 6227020800) y Java no avisa nada. Con 20 sale
 * negativo. Cambialo a long: aguanta hasta el 20 y se rompe en el 21.
 *
 * Salida esperada:
 *     Numero: 5
 *     5! = 120
 *
 * Compilar y ejecutar:
 *     javac B7_2_Factorial.java
 *     java B7_2_Factorial
 *
 * Enunciado completo: ../ejercicios.md
 */
import java.util.Scanner;

public class B7_2_Factorial {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // TODO 1: pedir el numero

        // TODO 2: el for que multiplica desde 1 hasta el numero

        // TODO 3: imprimir el resultado

        // TODO 4: probar con 13 y con 20 en int, y despues en long
        //         System.out.println(Integer.MAX_VALUE);

        sc.close();
    }
}
