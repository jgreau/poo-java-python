import java.util.Scanner;


public class B11_3_MenuBlindado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println();
            System.out.println("1) Saludar");
            System.out.println("2) Sumar dos numeros");
            System.out.println("3) Contar hasta 10");
            System.out.println("0) Salir");

            opcion = Validador.leerEntero(sc, "Opcion: ", 0, 3);

            switch (opcion) {
                case 1:
                    System.out.println("Hola!");
                    break;
                case 2:
                    int a = Validador.leerEntero(sc, "Primer numero: ", -1000, 1000);
                    int b = Validador.leerEntero(sc, "Segundo numero: ", -1000, 1000);
                    System.out.println(a + " + " + b + " = " + (a + b));
                    break;
                case 3:
                    for (int i = 1; i <= 10; i++) {
                        System.out.print(i + " ");
                    }
                    System.out.println();
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
