public class B9_3_TablaMetodo {

    static void tabla(int n) {
        tabla(n, 10);                 // la version corta llama a la larga
    }

    static void tabla(int n, int hasta) {
        System.out.println("Tabla del " + n + ":");
        for (int i = 1; i <= hasta; i++) {
            System.out.printf("%d x %2d = %3d%n", n, i, n * i);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        tabla(3);
        tabla(7, 3);
        tabla(9, 5);
    }
}
