/*
 * NOTAS - con la segunda version de promedio (B12.3).
 */
public class Notas {

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

    // B12.3: misma idea, pero cada nota pesa distinto
    public static double promedio(double[] notas, double[] pesos) {
        double suma = 0;
        for (int i = 0; i < notas.length; i++) {
            suma += notas[i] * pesos[i];
        }
        return suma;
    }

    public static boolean aprobo(double promedio) {
        return promedio >= NOTA_APROBACION;
    }
}
