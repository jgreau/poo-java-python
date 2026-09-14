import java.util.Scanner;


public class B4_5_Vuelto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Precio: ");
        int precio = sc.nextInt();

        System.out.print("Paga con: ");
        int paga = sc.nextInt();

        int vuelto = paga - precio;
        System.out.println();
        System.out.println("Vuelto: " + vuelto);

        System.out.println("  " + vuelto / 10000 + " billete(s) de 10000");
        vuelto = vuelto % 10000;

        System.out.println("  " + vuelto / 5000 + " billete(s) de 5000");
        vuelto = vuelto % 5000;

        System.out.println("  " + vuelto / 2000 + " billete(s) de 2000");
        vuelto = vuelto % 2000;

        System.out.println("  " + vuelto / 1000 + " billete(s) de 1000");
        vuelto = vuelto % 1000;

        System.out.println("  " + vuelto / 500 + " moneda(s) de 500");
        vuelto = vuelto % 500;

        System.out.println("  " + vuelto / 100 + " moneda(s) de 100");
        vuelto = vuelto % 100;

        System.out.println("  quedan " + vuelto + " pesos sin dar");

        sc.close();
    }
}
