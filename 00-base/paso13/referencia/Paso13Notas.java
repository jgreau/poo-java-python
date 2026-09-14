import java.util.Scanner;

/*
 * PASO 13 - TODO JUNTO: CALCULADORA DE NOTAS
 *
 * Compilar y ejecutar (usa las clases de los pasos 10 y 11):
 *     javac Notas.java Validador.java Paso13Notas.java
 *     java Paso13Notas
 *
 * Usa printf (2), Scanner (4), if y equals (5), do-while (6), for (7),
 * arreglo (8), metodos (9), la clase Notas (10) y la clase Validador (11).
 * Escribele letras, notas de 9, nombres vacios: no se cae.
 */
public class Paso13Notas {

    static void informe(String nombre, double[] notas) {
        System.out.println();
        System.out.println("===== " + nombre + " =====");
        for (int i = 0; i < notas.length; i++) {
            System.out.printf("  Nota %d: %.1f%n", i + 1, notas[i]);
        }

        double p = Notas.promedio(notas);
        System.out.printf("  Promedio: %.1f%n", p);
        if (Notas.aprobo(p)) {
            System.out.println("  APROBADO");
        } else {
            System.out.printf("  REPROBADO, le faltan %.1f%n", Notas.NOTA_APROBACION - p);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String otro;

        do {
            String nombre = Validador.leerTexto(sc, "Nombre del alumno: ");
            int cantidad = Validador.leerEntero(sc, "Cuantas notas tiene? ", 1, 10);

            double[] notas = new double[cantidad];
            for (int i = 0; i < notas.length; i++) {
                notas[i] = Validador.leerDecimal(sc, "Nota " + (i + 1) + ": ",
                        Notas.NOTA_MINIMA, Notas.NOTA_MAXIMA);
            }

            informe(nombre, notas);

            otro = Validador.leerTexto(sc, "Otro alumno? (s/n): ");
        } while (otro.equalsIgnoreCase("s"));

        System.out.println("Listo.");
        sc.close();
    }
}
