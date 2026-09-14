import java.util.Arrays;
import java.util.Scanner;


public class B8_1_CincoNotas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] notas = new double[5];

        for (int i = 0; i < notas.length; i++) {
            System.out.print("Nota " + (i + 1) + ": ");
            notas[i] = sc.nextDouble();
        }

        double suma = 0;
        double mayor = notas[0];
        double menor = notas[0];
        int rojas = 0;

        for (double n : notas) {
            suma += n;
            if (n > mayor) {
                mayor = n;
            }
            if (n < menor) {
                menor = n;
            }
            if (n < 4.0) {
                rojas++;
            }
        }

        System.out.println();
        System.out.println("Notas: " + Arrays.toString(notas));
        System.out.printf("Promedio: %.1f%n", suma / notas.length);
        System.out.println("Nota mas alta: " + mayor);
        System.out.println("Nota mas baja: " + menor);
        System.out.println("Notas rojas: " + rojas);

        sc.close();
    }
}
