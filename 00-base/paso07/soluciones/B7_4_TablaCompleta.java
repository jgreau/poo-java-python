public class B7_4_TablaCompleta {
    public static void main(String[] args) {
        for (int fila = 1; fila <= 10; fila++) {
            for (int columna = 1; columna <= 10; columna++) {
                System.out.printf("%4d", fila * columna);
            }
            System.out.println();
        }
    }
}
