/*
 * DEMO 04 - POLIMORFISMO, CLASES ABSTRACTAS E INTERFACES
 *
 * Compilar y ejecutar:
 *     javac *.java
 *     java Demo04
 *
 * Seis archivos:
 *     Figura.java      la idea abstracta
 *     Dibujable.java   el contrato
 *     Circulo.java     Figura + Dibujable
 *     Rectangulo.java  Figura + Dibujable
 *     Triangulo.java   solo Figura
 *     Demo04.java      el programa   <- estas aqui
 *
 * Idea clave: podemos tratar a muchos objetos distintos COMO SI FUERAN
 * el mismo tipo, y cada uno responde a su manera.
 * "Un mismo llamado, muchas respuestas."
 */
public class Demo04 {
    public static void main(String[] args) {

        // Un arreglo de Figura que en realidad guarda objetos de 3 clases distintas
        Figura[] figuras = {
            new Circulo(3),
            new Rectangulo(4, 5),
            new Triangulo(6, 2)
        };

        System.out.println("--- POLIMORFISMO: el mismo llamado, distinta respuesta ---");
        for (Figura f : figuras) {
            // Java decide en TIEMPO DE EJECUCION cual area() ejecutar
            System.out.printf("%-12s area = %6.2f | perimetro = %6.2f%n",
                              f.getNombre(), f.area(), f.perimetro());
        }

        System.out.println("--- Un metodo que sirve para cualquier Figura ---");
        System.out.printf("Area total: %.2f%n", sumarAreas(figuras));

        System.out.println("--- INTERFAZ: un contrato aparte de la herencia ---");
        for (Figura f : figuras) {
            if (f instanceof Dibujable) {          // ¿cumple el contrato?
                ((Dibujable) f).dibujar();
            } else {
                System.out.println(f.getNombre() + " no sabe dibujarse.");
            }
        }
    }

    // Este metodo NO sabe ni le importa que figuras concretas le pasen.
    // Solo sabe que todas responden a area(). Eso es programar contra la abstraccion.
    static double sumarAreas(Figura[] figuras) {
        double total = 0;
        for (Figura f : figuras) {
            total += f.area();
        }
        return total;
    }
}
