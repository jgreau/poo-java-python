import java.util.Scanner;


public class B4_2_Ficha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Edad: ");
        int edad = sc.nextInt();

        System.out.print("Estatura en metros: ");
        double estatura = sc.nextDouble();
        sc.nextLine();                       // se come el Enter que dejo nextDouble

        System.out.print("Comuna: ");
        String comuna = sc.nextLine();

        System.out.println();
        System.out.printf("Nombre:    %s%n", nombre);
        System.out.printf("Edad:      %d anios%n", edad);
        System.out.printf("Estatura:  %.2f m%n", estatura);
        System.out.printf("Comuna:    %s%n", comuna);

        sc.close();
    }
}
