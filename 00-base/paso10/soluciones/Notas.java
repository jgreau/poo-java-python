/*
 * NOTAS - la del paso 10, con los tres metodos del B10.1 agregados al final.
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
            if (n < NOTA_APROBACION) {
                rojas++;
            }
        }
        return rojas;
    }

    public static boolean aprobo(double promedio) {
        return promedio >= NOTA_APROBACION;
    }

    // ---------- B10.1 ----------

    public static double minima(double[] notas) {
        double menor = notas[0];
        for (double n : notas) {
            if (n < menor) {
                menor = n;
            }
        }
        return menor;
    }

    public static int contarAzules(double[] notas) {
        int azules = 0;
        for (double n : notas) {
            if (n > 5.0) {
                azules++;
            }
        }
        return azules;
    }

    public static double porcentajeAprobacion(double[] notas) {
        int aprobadas = notas.length - contarRojas(notas);   // usa el que ya existe
        return aprobadas * 100.0 / notas.length;
    }
}
