import java.util.Scanner;


public class B7_5_Primos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Hasta que numero? ");
        int hasta = sc.nextInt();

        int cuantos = 0;

        for (int n = 2; n <= hasta; n++) {
            boolean esPrimo = true;

            for (int divisor = 2; divisor < n; divisor++) {
                if (n % divisor == 0) {
                    esPrimo = false;
                    break;              // ya se sabe: no sirve seguir buscando
                }
            }

            if (esPrimo) {
                System.out.print(n + " ");
                cuantos++;
            }
        }

        System.out.println();
        System.out.println("Son " + cuantos + " primos");

        sc.close();
    }
}
