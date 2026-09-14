import java.util.Scanner;


public class B6_1_Centinela {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int suma = 0;
        int cantidad = 0;

        System.out.print("Numero (0 para terminar): ");
        int numero = sc.nextInt();

        while (numero != 0) {
            suma += numero;
            cantidad++;
            System.out.print("Numero (0 para terminar): ");
            numero = sc.nextInt();
        }

        System.out.println("Ingresaste " + cantidad + " numeros");
        System.out.println("Suma: " + suma);

        if (cantidad == 0) {
            System.out.println("Promedio: no hay numeros que promediar");
        } else {
            System.out.println("Promedio: " + (double) suma / cantidad);
        }

        sc.close();
    }
}
