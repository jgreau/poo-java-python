import java.util.Scanner;


public class B6_2_Adivina {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int secreto = 7;
        int intentos = 0;

        System.out.print("Adivina (1 a 10): ");
        int intento = sc.nextInt();
        intentos++;

        while (intento != secreto) {
            if (intento < secreto) {
                System.out.println("Mas alto");
            } else {
                System.out.println("Mas bajo");
            }
            System.out.print("Adivina (1 a 10): ");
            intento = sc.nextInt();
            intentos++;
        }

        System.out.println("Acertaste en " + intentos + " intentos!");
        sc.close();
    }
}
