/*
 * B8.1 - LAS CINCO NOTAS
 *
 * Pide 5 notas por teclado, guardalas en un double[] y muestra el
 * promedio, la mas alta, la mas baja y cuantas son rojas (bajo 4.0).
 *
 * Para la mas baja, parte suponiendo que es la primera y ve comparando.
 *
 * Salida esperada:
 *     Notas: [5.5, 6.2, 3.8, 7.0, 4.1]
 *     Promedio: 5.3
 *     Nota mas alta: 7.0
 *     Nota mas baja: 3.8
 *     Notas rojas: 1
 *
 * Compilar y ejecutar:
 *     javac B8_1_CincoNotas.java
 *     java B8_1_CincoNotas
 *
 * Enunciado completo: ../ejercicios.md
 */
import java.util.Arrays;
import java.util.Scanner;

public class B8_1_CincoNotas {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double[] notas = new double[5];

        // TODO 1: el for que llena el arreglo pidiendo cada nota

        // TODO 2: imprimirlo con Arrays.toString

        // TODO 3: promedio, maxima, minima y cuantas rojas

        sc.close();
    }
}
