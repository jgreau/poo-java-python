public class B12_2_Triangulo {
    public static void main(String[] args) {
        mostrar(3, 4, 5);
        mostrar(1, 1, 5);
        mostrar(2, 2, 4);      // el caso justo: 4 = 2 + 2, no es triangulo

        System.out.println();
        System.out.println("Sin validar, area(1, 1, 5) = " + Geometria.area(1, 1, 5));
    }

    static void mostrar(double a, double b, double c) {
        if (Geometria.esTriangulo(a, b, c)) {
            System.out.printf("Lados %.0f, %.0f, %.0f:  area %.2f%n", a, b, c, Geometria.area(a, b, c));
        } else {
            System.out.printf("Lados %.0f, %.0f, %.0f:  ese triangulo no existe%n", a, b, c);
        }
    }
}
