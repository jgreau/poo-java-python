/*
 * NOTAS - la version final, con todo lo que le agregaron los ejercicios:
 * minima (B10.1), el promedio ponderado (B12.3) y redondear (B13.1).
 */
public class Notas {

    public static final double NOTA_MINIMA = 1.0;
    public static final double NOTA_MAXIMA = 7.0;
    public static final double NOTA_APROBACION = 4.0;

    /** Deja el valor con UN decimal: 3.95 -> 4.0 */
    public static double redondear(double valor) {
        return Math.round(valor * 10) / 10.0;
    }

    public static double promedio(double[] notas) {
        double suma = 0;
        for (double n : notas) {
            suma += n;
        }
        return redondear(suma / notas.length);
    }

    public static double promedio(double[] notas, double[] pesos) {
        double suma = 0;
        for (int i = 0; i < notas.length; i++) {
            suma += notas[i] * pesos[i];
        }
        return redondear(suma);
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

    public static double minima(double[] notas) {
        double menor = notas[0];
        for (double n : notas) {
            if (n < menor) {
                menor = n;
            }
        }
        return menor;
    }

    public static int contarRojas(double[] notas) {
        int rojas = 0;
        for (double n : notas) {
            if (n < NOTA_APROBACION) {
                rojas++;
            }
        }
        return rojas;
    }

    public static boolean aprobo(double promedio) {
        return promedio >= NOTA_APROBACION;
    }
}
