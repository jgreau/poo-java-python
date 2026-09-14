/*
 * PASO 02 - IMPRIMIR
 *
 * Compilar y ejecutar:
 *     javac Paso02Imprimir.java
 *     java Paso02Imprimir
 *
 * Idea clave: println salta de linea al final, print no.
 * El + pega textos, pero lee de izquierda a derecha: cuidado con los numeros.
 */
public class Paso02Imprimir {
    public static void main(String[] args) {

        // 1. println vs print
        System.out.println("Linea uno");
        System.out.print("Esto queda ");
        System.out.print("en la misma linea");
        System.out.println();                  // solo un salto de linea

        // 2. Pegar textos y numeros con +
        System.out.println("Tengo " + 20 + " anios");
        System.out.println("1 + 2 = " + 1 + 2);       // imprime 12 !!
        System.out.println("1 + 2 = " + (1 + 2));     // imprime 3

        // 3. Caracteres especiales: \n salto, \t tabulacion, \" comillas
        System.out.println("Nombre:\tAna\nCarrera:\tInformatica");
        System.out.println("Ella dijo \"hola\"");

        /*
         * 4. printf: un molde con huecos que se rellenan en orden
         *    %s texto   %d entero   %.2f decimal con 2 cifras   %n salto
         */
        System.out.printf("%s tiene %d anios y mide %.2f m%n", "Ana", 20, 1.6789);
    }
}
