import java.util.Scanner;


public class B6_5_AlReves {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Numero: ");
        int numero = sc.nextInt();

        int digitos = 0;
        int suma = 0;

        System.out.print("Al reves: ");
        while (numero > 0) {
            int ultimo = numero % 10;
            System.out.print(ultimo);
            suma += ultimo;
            digitos++;
            numero = numero / 10;
        }
        System.out.println();

        System.out.println("Tiene " + digitos + " digitos");
        System.out.println("Suma de sus digitos: " + suma);

        sc.close();
    }
}
