/*
 * PASO 10 - CLASES CON METODOS static
 *
 * Compilar y ejecutar (ahora son DOS archivos):
 *     javac Notas.java Paso10Clases.java
 *     java Paso10Clases
 *
 * Idea clave: los metodos del paso 9 se mudan a su propia clase, en su
 * propio archivo. Desde otra clase se llaman con el nombre de la clase
 * adelante, exactamente como Math.sqrt(16).
 */
public class Paso10Clases {
    public static void main(String[] args) {
        double[] notas = {5.5, 6.2, 3.8, 4.5};

        // 1. Llamar a un metodo de otra clase: Clase.metodo(...)
        double p = Notas.promedio(notas);
        System.out.printf("Promedio: %.1f%n", p);
        System.out.println("Nota maxima: " + Notas.maxima(notas));
        System.out.println("Notas rojas: " + Notas.contarRojas(notas));
        System.out.println("Aprobo: " + Notas.aprobo(p));

        // 2. Las constantes tambien: Clase.CONSTANTE
        System.out.println("Se aprueba con " + Notas.NOTA_APROBACION);

        // 3. Lo mismo que venias haciendo con Math desde el paso 3
        System.out.println("Raiz de 16: " + Math.sqrt(16));
        System.out.println("PI: " + Math.PI);
    }
}
