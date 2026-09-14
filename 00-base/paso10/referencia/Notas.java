/*
 * NOTAS - UNA CLASE SIN main, SOLO CON METODOS static
 *
 * Nadie la ejecuta: otras clases la usan. Es una caja de herramientas,
 * igual que Math. Se llama con el nombre de la clase adelante:
 *     Notas.promedio(misNotas)        como        Math.sqrt(16)
 *
 * La usan Paso10Clases y Paso13Notas.
 */
public class Notas {

    // Constantes de la clase: se leen como Notas.NOTA_APROBACION
    public static final double NOTA_MINIMA = 1.0;
    public static final double NOTA_MAXIMA = 7.0;
    public static final double NOTA_APROBACION = 4.0;

    public static double promedio(double[] notas) {
        double suma = 0;
        for (double n : notas) {
            suma += n;
        }
        return suma / notas.length;
    }

    public static double maxima(double[] notas) {
        double mayor = notas[0];
        for (double n : notas) {
            if (n > mayor) {
                mayor = n;
            }
        }
        return mayor;
    }

    public static int contarRojas(double[] notas) {
        int rojas = 0;
        for (double n : notas) {
            if (n < NOTA_APROBACION) {    // dentro de la clase, sin "Notas."
                rojas++;
            }
        }
        return rojas;
    }

    public static boolean aprobo(double promedio) {
        return promedio >= NOTA_APROBACION;
    }
}
