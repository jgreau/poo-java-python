import java.util.Scanner;


public class B7_2_Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Numero: ");
        int n = sc.nextInt();

        int factorialInt = 1;
        long factorialLong = 1;

        for (int i = 1; i <= n; i++) {
            factorialInt *= i;
            factorialLong *= i;
        }

        System.out.println(n + "! en int:  " + factorialInt);
        System.out.println(n + "! en long: " + factorialLong);
        System.out.println("El int llega hasta " + Integer.MAX_VALUE);

        sc.close();
    }
}
