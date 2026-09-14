import java.util.Scanner;


public class B5_2_TramoEdad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Edad: ");
        int edad = sc.nextInt();

        if (edad < 0 || edad > 120) {
            System.out.println("Esa edad no existe");
        } else if (edad < 18) {
            System.out.println("Menor de edad");
        } else if (edad < 65) {
            System.out.println("Adulto");
        } else {
            System.out.println("Adulto mayor");
        }

        sc.close();
    }
}
