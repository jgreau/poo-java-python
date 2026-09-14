public class B10_1_MasNotas {
    public static void main(String[] args) {
        double[] notas = {5.5, 6.2, 3.8, 4.5};

        System.out.println("Minima: " + Notas.minima(notas));
        System.out.println("Azules: " + Notas.contarAzules(notas));
        System.out.printf("Aprobacion: %.1f%%%n", Notas.porcentajeAprobacion(notas));
    }
}
