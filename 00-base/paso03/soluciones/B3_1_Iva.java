public class B3_1_Iva {
    public static void main(String[] args) {
        int neto = 10000;
        final double IVA = 0.19;

        double iva = neto * IVA;
        double total = neto + iva;

        System.out.printf("Neto:  %5.0f%n", (double) neto);
        System.out.printf("IVA:   %5.0f%n", iva);
        System.out.printf("Total: %5.0f%n", total);
    }
}
