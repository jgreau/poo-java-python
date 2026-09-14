import java.util.Arrays;
import java.util.Scanner;


public class B9_4_NotasEnMetodos {

    static double[] leerNotas(Scanner sc, int cantidad) {
        double[] notas = new double[cantidad];
        for (int i = 0; i < notas.length; i++) {
            System.out.print("Nota " + (i + 1) + ": ");
            notas[i] = sc.nextDouble();
        }
        return notas;
    }

    static double promedio(double[] notas) {
        double suma = 0;
        for (double n : notas) {
            suma += n;
        }
        return suma / notas.length;
    }

    static double maxima(double[] notas) {
        double mayor = notas[0];
        for (double n : notas) {
            if (n > mayor) {
                mayor = n;
            }
        }
        return mayor;
    }

    static int contarRojas(double[] notas) {
        int rojas = 0;
        for (double n : notas) {
            if (n < 4.0) {
                rojas++;
            }
        }
        return rojas;
    }

    static void imprimirInforme(double[] notas) {
        System.out.println();
        System.out.println("Notas: " + Arrays.toString(notas));
        System.out.printf("Promedio: %.1f%n", promedio(notas));
        System.out.println("Nota mas alta: " + maxima(notas));
        System.out.println("Notas rojas: " + contarRojas(notas));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] notas = leerNotas(sc, 5);
        imprimirInforme(notas);
        sc.close();
    }
}
