public class B12_1_Perimetro {
    public static void main(String[] args) {
        String formato = "%-26sarea %6.2f   perimetro %6.2f%n";

        System.out.printf(formato, "Circulo de radio 2:",
                Geometria.area(2), Geometria.perimetro(2));
        System.out.printf(formato, "Rectangulo de 3 x 4:",
                Geometria.area(3, 4), Geometria.perimetro(3, 4));
        System.out.printf(formato, "Triangulo de lados 3-4-5:",
                Geometria.area(3, 4, 5), Geometria.perimetro(3, 4, 5));
    }
}
