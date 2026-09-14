public class B8_4_Histograma {
    public static void main(String[] args) {
        double[] notas = {5.5, 6.2, 3.8, 7.0, 4.1};

        for (double nota : notas) {
            System.out.printf("%.1f | ", nota);
            for (int i = 0; i < (int) nota; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
