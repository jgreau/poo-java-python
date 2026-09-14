public class B12_3_Ponderado {
    public static void main(String[] args) {
        double[] notas = {5.0, 6.0, 4.0};
        double[] pesos = {0.3, 0.3, 0.4};

        System.out.printf("Promedio simple:    %.1f%n", Notas.promedio(notas));
        System.out.printf("Promedio ponderado: %.1f%n", Notas.promedio(notas, pesos));

        // La misma nota mas alta pesando 40% en vez de 30%
        double[] otrosPesos = {0.3, 0.4, 0.3};
        System.out.printf("Con otros pesos:    %.1f%n", Notas.promedio(notas, otrosPesos));
    }
}
