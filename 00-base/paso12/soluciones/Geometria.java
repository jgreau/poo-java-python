/*
 * GEOMETRIA - la del paso 12, con el perimetro (B12.1) y esTriangulo (B12.2).
 */
public class Geometria {

    public static double area(double radio) {
        return Math.PI * radio * radio;
    }

    public static double area(double base, double altura) {
        return base * altura;
    }

    public static double area(double a, double b, double c) {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    // ---------- B12.1 ----------

    public static double perimetro(double radio) {
        return 2 * Math.PI * radio;
    }

    public static double perimetro(double base, double altura) {
        return 2 * (base + altura);
    }

    public static double perimetro(double a, double b, double c) {
        return a + b + c;
    }

    // ---------- B12.2 ----------

    public static boolean esTriangulo(double a, double b, double c) {
        return a < b + c && b < a + c && c < a + b;
    }
}
