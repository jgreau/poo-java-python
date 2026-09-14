import java.util.Scanner;


public class B6_3_Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println();
            System.out.println("1) Saludar");
            System.out.println("2) Sumar dos numeros");
            System.out.println("3) Contar hasta 10");
            System.out.println("0) Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Hola!");
                    break;
                case 2:
                    System.out.print("Primer numero: ");
                    int a = sc.nextInt();
                    System.out.print("Segundo numero: ");
                    int b = sc.nextInt();
                    System.out.println(a + " + " + b + " = " + (a + b));
                    break;
                case 3:
                    for (int i = 1; i <= 10; i++) {
                        System.out.println(i);
                    }
                    break;
                case 0:
                    System.out.println("Chao");
                    break;
                default:
                    System.out.println("Esa opcion no existe");
            }
        } while (opcion != 0);

        sc.close();
    }
}
