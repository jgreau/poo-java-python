import java.util.Scanner;


public class B7_3_Figuras {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Tamano: ");
        int n = sc.nextInt();

        System.out.println("\nCreciente:");
        for (int fila = 1; fila <= n; fila++) {
            for (int col = 1; col <= fila; col++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("\nDecreciente:");
        for (int fila = n; fila >= 1; fila--) {
            for (int col = 1; col <= fila; col++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("\nPiramide:");
        for (int fila = 1; fila <= n; fila++) {
            for (int espacio = 1; espacio <= n - fila; espacio++) {
                System.out.print(" ");
            }
            for (int estrella = 1; estrella <= 2 * fila - 1; estrella++) {
                System.out.print("*");
            }
            System.out.println();
        }

        sc.close();
    }
}
