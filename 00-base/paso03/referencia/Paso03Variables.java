/*
 * PASO 03 - VARIABLES Y OPERACIONES
 *
 * Compilar y ejecutar:
 *     javac Paso03Variables.java
 *     java Paso03Variables
 *
 * Idea clave: en Java cada variable se declara con su TIPO, y el tipo
 * no cambia nunca. Una variable int guarda enteros hasta que muere.
 */
public class Paso03Variables {
    public static void main(String[] args) {

        // 1. Declarar: tipo + nombre = valor
        int edad = 20;
        double estatura = 1.75;
        boolean esAlumno = true;
        char seccion = 'A';            // un solo caracter, comillas simples
        String nombre = "Ana";         // texto, comillas dobles. Ojo: String con mayuscula

        System.out.println(nombre + " tiene " + edad + " anios y mide " + estatura);
        System.out.println("Seccion " + seccion + ", es alumno: " + esAlumno);

        // 2. Cambiar el valor (el tipo se queda igual)
        edad = edad + 1;               // 21
        edad++;                        // 22, sumar 1
        edad += 5;                     // 27, sumar 5
        System.out.println("Edad ahora: " + edad);

        // 3. Operaciones
        System.out.println(7 + 2);     // 9
        System.out.println(7 * 2);     // 14
        System.out.println(7 / 2);     // 3 !! entero dividido entero da entero
        System.out.println(7 % 2);     // 1, el resto de la division
        System.out.println(7 / 2.0);   // 3.5, basta con que uno sea decimal

        // 4. Convertir de tipo (cast)
        int suma = 17;
        int cantidad = 3;
        double malo = suma / cantidad;              // 5.0: se dividio antes de convertir
        double bueno = (double) suma / cantidad;    // 5.666...
        int sinDecimales = (int) 5.99;              // 5: corta, no redondea
        System.out.println(malo + " / " + bueno + " / " + sinDecimales);

        // 5. Constantes: final impide volver a asignarla
        final double NOTA_MINIMA = 4.0;
        System.out.println("Se aprueba con " + NOTA_MINIMA);

        // 6. Math: las operaciones que no tienen simbolo
        System.out.println(Math.sqrt(16));       // 4.0
        System.out.println(Math.pow(2, 10));     // 1024.0
        System.out.println(Math.round(5.5));     // 6
        System.out.println(Math.max(3, 8));      // 8
    }
}
