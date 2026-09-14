/*
 * B7.5 - DESAFIO: LOS PRIMOS
 *
 * Pide un numero n y muestra todos los primos entre 2 y n.
 *
 * Un numero es primo si NINGUN numero entre 2 y n - 1 lo divide exacto.
 * Vas a necesitar un for dentro de otro, una variable boolean esPrimo y
 * un break para cortar apenas encuentres un divisor.
 *
 * Salida esperada:
 *     Hasta que numero? 30
 *     2 3 5 7 11 13 17 19 23 29
 *     Son 10 primos
 *
 * Compilar y ejecutar:
 *     javac B7_5_Primos.java
 *     java B7_5_Primos
 *
 * Enunciado completo: ../ejercicios.md
 */
import java.util.Scanner;

public class B7_5_Primos {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // TODO 1: pedir hasta que numero

        // TODO 2: el for de los candidatos, desde 2

        // TODO 3: adentro, el for que busca un divisor (con break)

        // TODO 4: imprimir los primos y cuantos fueron

        sc.close();
    }
}
