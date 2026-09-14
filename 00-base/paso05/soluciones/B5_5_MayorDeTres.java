import java.util.Scanner;


public class B5_5_MayorDeTres {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Primer numero: ");
        int a = sc.nextInt();
        System.out.print("Segundo numero: ");
        int b = sc.nextInt();
        System.out.print("Tercer numero: ");
        int c = sc.nextInt();

        // Forma 1: con if
        int mayor;
        if (a >= b && a >= c) {
            mayor = a;
        } else if (b >= c) {
            mayor = b;
        } else {
            mayor = c;
        }
        System.out.println("Con if:       " + mayor);

        // Forma 2: con Math.max
        System.out.println("Con Math.max: " + Math.max(Math.max(a, b), c));

        sc.close();
    }
}
