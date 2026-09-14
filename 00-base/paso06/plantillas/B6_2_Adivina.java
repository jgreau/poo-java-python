/*
 * B6.2 - ADIVINA EL NUMERO
 *
 * El programa tiene un numero secreto y el usuario tiene que adivinarlo.
 * En cada intento dice Mas alto o Mas bajo, y al final cuantos intentos
 * tomo.
 *
 * Extras: 1) que el secreto sea al azar con
 *            (int) (Math.random() * 10) + 1
 *         2) que solo tenga 3 intentos, y si se le acaban:
 *            Perdiste, era el 7
 *
 * Salida esperada:
 *     Adivina (1 a 10): 3
 *     Mas alto
 *     Adivina (1 a 10): 9
 *     Mas bajo
 *     Adivina (1 a 10): 7
 *     Acertaste en 3 intentos!
 *
 * Compilar y ejecutar:
 *     javac B6_2_Adivina.java
 *     java B6_2_Adivina
 *
 * Enunciado completo: ../ejercicios.md
 */
import java.util.Scanner;

public class B6_2_Adivina {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int secreto = 7;
        int intentos = 0;

        // TODO 1: pedir el primer intento

        // TODO 2: el while que repite mientras no acierte,
        //         diciendo Mas alto o Mas bajo y contando los intentos

        // TODO 3: el mensaje final

        sc.close();
    }
}
