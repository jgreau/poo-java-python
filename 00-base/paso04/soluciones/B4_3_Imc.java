import java.util.Scanner;


public class B4_3_Imc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Peso en kilos: ");
        double peso = sc.nextDouble();

        System.out.print("Estatura en metros: ");
        double estatura = sc.nextDouble();

        double imc = peso / (estatura * estatura);
        System.out.printf("Tu IMC es %.1f%n", imc);

        sc.close();
    }
}
