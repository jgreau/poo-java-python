public class B3_6_Propinas {
    public static void main(String[] args) {
        double cuenta = 23400;
        int personas = 3;
        final double PROPINA = 0.10;

        double propina = cuenta * PROPINA;
        double total = cuenta + propina;

        System.out.printf("Cuenta:            %6.0f%n", cuenta);
        System.out.printf("Propina (10%%):     %6.0f%n", propina);
        System.out.printf("Total:             %6.0f%n", total);
        System.out.printf("Cada uno paga:     %6.0f%n", total / personas);

        System.out.println();

        // Con 7 personas la division no es exacta
        personas = 7;
        double porPersona = total / personas;
        System.out.println("Con 7 personas, exacto: " + porPersona);
        System.out.printf("Redondeando hacia arriba (ceil):  %.0f%n", Math.ceil(porPersona));
        System.out.printf("Redondeando al mas cercano:       %.0f%n", (double) Math.round(porPersona));
        System.out.printf("Con ceil, se juntan %.0f y sobran %.0f pesos%n",
                Math.ceil(porPersona) * personas, Math.ceil(porPersona) * personas - total);
    }
}
