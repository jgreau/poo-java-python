import java.util.Scanner;


public class B5_4_Switch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Primer numero: ");
        double a = sc.nextDouble();

        System.out.print("Segundo numero: ");
        double b = sc.nextDouble();

        System.out.println("1) Sumar  2) Restar  3) Multiplicar  4) Dividir");
        System.out.print("Operacion: ");
        int operacion = sc.nextInt();

        switch (operacion) {
            case 1:
                System.out.println(a + " + " + b + " = " + (a + b));
                break;
            case 2:
                System.out.println(a + " - " + b + " = " + (a - b));
                break;
            case 3:
                System.out.println(a + " * " + b + " = " + (a * b));
                break;
            case 4:
                if (b == 0) {
                    System.out.println("No se puede dividir por cero");
                } else {
                    System.out.println(a + " / " + b + " = " + (a / b));
                }
                break;
            default:
                System.out.println("Esa operacion no existe");
        }

        sc.close();
    }
}
