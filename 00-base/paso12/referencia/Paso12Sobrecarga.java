/*
 * PASO 12 - SOBRECARGA: UN NOMBRE, VARIAS VERSIONES
 *
 * Compilar y ejecutar:
 *     javac Geometria.java Paso12Sobrecarga.java
 *     java Paso12Sobrecarga
 *
 * Idea clave: dos metodos pueden llamarse igual si reciben parametros
 * distintos (en cantidad o en tipo). Java elige la version al COMPILAR,
 * mirando lo que le pasaste. Es la primera forma de polimorfismo:
 * "muchas formas" para un mismo nombre.
 */
public class Paso12Sobrecarga {

    // 2. Distinta CANTIDAD de parametros: lo que Python hace con valores por defecto
    static void linea() {
        linea(30);                     // llama a la version de abajo
    }

    static void linea(int largo) {
        linea(largo, '-');
    }

    static void linea(int largo, char simbolo) {
        for (int i = 0; i < largo; i++) {
            System.out.print(simbolo);
        }
        System.out.println();
    }

    // 3. Distinto TIPO de parametro
    static void describir(int n) {
        System.out.println(n + " es un entero");
    }

    static void describir(double n) {
        System.out.println(n + " es un decimal");
    }

    static void describir(String texto) {
        System.out.println("\"" + texto + "\" es un texto de " + texto.length() + " letras");
    }

    public static void main(String[] args) {

        // 1. Un nombre, tres figuras: Java elige por la cantidad de datos
        System.out.printf("Circulo de radio 2:       %6.2f%n", Geometria.area(2));
        System.out.printf("Rectangulo de 3 x 4:      %6.2f%n", Geometria.area(3, 4));
        System.out.printf("Triangulo de lados 3-4-5: %6.2f%n", Geometria.area(3, 4, 5));

        linea();
        linea(10);
        linea(10, '*');

        describir(7);
        describir(7.0);
        describir("siete");
        linea();

        // 4. La sobrecarga que usas desde el paso 1: println tiene 10 versiones
        System.out.println(7);
        System.out.println(7.0);
        System.out.println('7');
        System.out.println(true);
    }
}
