public class B2_5_Tabla {
    public static void main(String[] args) {
        // Version 1: espacios a mano. Se descuadra con el numero mas largo.
        System.out.println("Producto         Precio    IVA");
        System.out.println("Completo         2500.0  475.0");
        System.out.println("Bebida           1200.0  228.0");
        System.out.println("Torta            12500.0 2375.0");

        System.out.println();

        // Version 2: printf con anchos fijos. Aguanta cualquier dato.
        System.out.printf("%-16s%8s%8s%n", "Producto", "Precio", "IVA");
        System.out.printf("%-16s%8.1f%8.1f%n", "Completo", 2500.0, 475.0);
        System.out.printf("%-16s%8.1f%8.1f%n", "Bebida", 1200.0, 228.0);
        System.out.printf("%-16s%8.1f%8.1f%n", "Torta", 12500.0, 2375.0);
    }
}
