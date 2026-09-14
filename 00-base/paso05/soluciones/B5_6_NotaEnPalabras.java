import java.util.Scanner;


public class B5_6_NotaEnPalabras {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nota (1.0 a 7.0): ");
        double nota = sc.nextDouble();

        if (nota < 1.0 || nota > 7.0) {
            System.out.println("Esa nota no existe");
        } else if (nota >= 6.5) {
            System.out.println("Excelente");
        } else if (nota >= 5.5) {
            System.out.println("Muy buena");
        } else if (nota >= 4.0) {
            System.out.println("Suficiente");
        } else {
            System.out.println("Insuficiente");
        }

        sc.close();
    }
}
