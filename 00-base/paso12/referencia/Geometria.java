/*
 * GEOMETRIA - TRES METODOS CON EL MISMO NOMBRE
 *
 * Los tres se llaman area. Java sabe cual usar mirando CUANTOS datos
 * le pasas y DE QUE TIPO son. Eso es la sobrecarga.
 *
 * Son las mismas figuras de la demo 4. Alla seran clases, y el
 * polimorfismo sera otro: el que decide mientras el programa corre.
 *
 * La usa Paso12Sobrecarga.
 */
public class Geometria {

    // Circulo: un dato
    public static double area(double radio) {
        return Math.PI * radio * radio;
    }

    // Rectangulo: dos datos
    public static double area(double base, double altura) {
        return base * altura;
    }

    // Triangulo, por sus tres lados (formula de Heron)
    public static double area(double a, double b, double c) {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}
