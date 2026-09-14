import java.util.Scanner;


public class B6_4_ValidarNota {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int errores = 0;

        System.out.print("Nota (1.0 a 7.0): ");
        double nota = sc.nextDouble();

        while (nota < 1.0 || nota > 7.0) {
            errores++;
            System.out.print("Nota invalida. Otra vez: ");
            nota = sc.nextDouble();
        }

        System.out.println("Nota aceptada: " + nota + " (te equivocaste " + errores + " veces)");
        sc.close();
    }
}
