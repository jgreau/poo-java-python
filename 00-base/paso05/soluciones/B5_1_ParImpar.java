import java.util.Scanner;


public class B5_1_ParImpar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Numero: ");
        int numero = sc.nextInt();

        if (numero == 0) {
            System.out.println("El cero no cuenta");
        } else if (numero % 2 == 0) {
            System.out.println("Es par");
        } else {
            System.out.println("Es impar");
        }

        sc.close();
    }
}
