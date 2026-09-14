/*
 * B9.4 - PARTIR UN PROGRAMA EN METODOS
 *
 * Toma tu solucion del B8.1 (las cinco notas) y partela en estos
 * metodos, sin cambiar lo que hace. El main tiene que quedar en CUATRO O
 * CINCO lineas.
 *
 * Compara el antes y el despues: cual se entiende mas rapido?
 *
 * Este ejercicio es el ensayo del paso 10, donde estos metodos se mudan a
 * su propia clase.
 *
 * Compilar y ejecutar:
 *     javac B9_4_NotasEnMetodos.java
 *     java B9_4_NotasEnMetodos
 *
 * Enunciado completo: ../ejercicios.md
 */
import java.util.Scanner;

public class B9_4_NotasEnMetodos {
    static double[] leerNotas(Scanner sc, int cantidad) {
        // TODO 1
        return new double[cantidad];
    }

    static double promedio(double[] notas) {
        // TODO 2
        return 0;
    }

    static double maxima(double[] notas) {
        // TODO 3
        return 0;
    }

    static int contarRojas(double[] notas) {
        // TODO 4
        return 0;
    }

    static void imprimirInforme(double[] notas) {
        // TODO 5
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // TODO 6: el main, en cuatro o cinco lineas

        sc.close();
    }
}
