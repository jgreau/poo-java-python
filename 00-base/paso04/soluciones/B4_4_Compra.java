import java.util.Scanner;


public class B4_4_Compra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final double IVA = 0.19;

        System.out.print("Producto: ");
        String producto = sc.nextLine();

        System.out.print("Precio unitario: ");
        int precio = sc.nextInt();

        System.out.print("Cantidad: ");
        int cantidad = sc.nextInt();

        double neto = precio * cantidad;
        double iva = neto * IVA;
        double total = neto + iva;

        System.out.println();
        System.out.println(producto + " x" + cantidad);
        System.out.printf("%-11s%4.0f%n", "Neto:", neto);
        System.out.printf("%-11s%4.0f%n", "IVA:", iva);
        System.out.printf("%-11s%4.0f%n", "Total:", total);

        sc.close();
    }
}
