/**
 * El banco de pruebas del taller: imprime {@code [OK]} o {@code [FALLA]}.
 *
 * <p>ESTE ARCHIVO LO ENTREGA EL PROFESOR. NINGUN GRUPO LO MODIFICA.</p>
 *
 * <p>Es un mini framework de pruebas de 40 lineas. Sirve para dos cosas: que
 * cada grupo sepa si su clase funciona sin esperar al profesor, y ser en si
 * mismo un ejemplo de {@code static} y de SOBRECARGA, porque
 * {@code chequear()} existe tres veces con parametros distintos.</p>
 */
public class Verificador {

    /** Cuantas pruebas se han corrido. Es UNO SOLO para todo el programa. */
    private static int total = 0;

    /** Cuantas de esas pruebas pasaron. */
    private static int aprobadas = 0;

    /**
     * Comprueba que una condicion se cumpla.
     *
     * <p>SOBRECARGA 1: recibe un booleano.</p>
     *
     * @param descripcion que es lo que se esta comprobando
     * @param condicion   {@code true} si la prueba pasa
     */
    public static void chequear(String descripcion, boolean condicion) {
        total++;
        if (condicion) {
            aprobadas++;
            System.out.println("  [OK]     " + descripcion);
        } else {
            System.out.println("  [FALLA]  " + descripcion);
        }
    }

    /**
     * Comprueba que dos numeros sean iguales, con tolerancia de un centavo.
     *
     * <p>SOBRECARGA 2: mismo nombre, dos {@code double}.</p>
     *
     * @param descripcion que es lo que se esta comprobando
     * @param esperado    el valor que deberia dar
     * @param obtenido    el valor que dio de verdad
     */
    public static void chequear(String descripcion, double esperado, double obtenido) {
        boolean ok = Math.abs(esperado - obtenido) < 0.01;
        total++;
        if (ok) {
            aprobadas++;
            System.out.println("  [OK]     " + descripcion);
        } else {
            System.out.println("  [FALLA]  " + descripcion
                    + "   esperado=" + esperado + " obtenido=" + obtenido);
        }
    }

    /**
     * Comprueba que dos textos sean iguales.
     *
     * <p>SOBRECARGA 3: mismo nombre, dos {@code String}.</p>
     *
     * @param descripcion que es lo que se esta comprobando
     * @param esperado    el texto que deberia dar
     * @param obtenido    el texto que dio de verdad
     */
    public static void chequear(String descripcion, String esperado, String obtenido) {
        boolean ok = esperado.equals(obtenido);
        total++;
        if (ok) {
            aprobadas++;
            System.out.println("  [OK]     " + descripcion);
        } else {
            System.out.println("  [FALLA]  " + descripcion
                    + "   esperado=\"" + esperado + "\" obtenido=\"" + obtenido + "\"");
        }
    }

    /**
     * Imprime el titulo de una seccion de pruebas.
     *
     * @param titulo el nombre de la seccion
     */
    public static void seccion(String titulo) {
        System.out.println();
        System.out.println("--- " + titulo + " ---");
    }

    /** Imprime el marcador final: cuantas pruebas pasaron de cuantas. */
    public static void resumen() {
        System.out.println();
        System.out.println("=======================================");
        System.out.println("  RESULTADO: " + aprobadas + " de " + total + " pruebas OK");
        if (aprobadas == total) {
            System.out.println("  El sistema completo funciona.");
        } else {
            System.out.println("  Faltan " + (total - aprobadas) + ". Revisen los [FALLA].");
        }
        System.out.println("=======================================");
    }
}
