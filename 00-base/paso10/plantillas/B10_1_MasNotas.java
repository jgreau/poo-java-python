/*
 * B10.1 - AGRANDAR LA CLASE Notas
 *
 * Copia a esta carpeta tu Notas.java del paso 10. Si no lo tienes, esta en ../referencia/Notas.java.
 *
 * Agregale estos tres metodos:
 *     public static double minima(double[] notas)
 *     public static int contarAzules(double[] notas)              // sobre 5.0
 *     public static double porcentajeAprobacion(double[] notas)
 *
 * porcentajeAprobacion puede USAR contarRojas, que ya existe: un metodo
 * de la clase llamando a otro de la misma clase, sin prefijo.
 *
 * Salida esperada:
 *     Minima: 3.8
 *     Azules: 2
 *     Aprobacion: 75.0%
 *
 * Compilar y ejecutar:
 *     javac Notas.java B10_1_MasNotas.java
 *     java B10_1_MasNotas
 *
 * Enunciado completo: ../ejercicios.md
 */
public class B10_1_MasNotas {
    public static void main(String[] args) {

        double[] notas = {5.5, 6.2, 3.8, 4.5};

        // TODO 1: agregar los tres metodos a Notas.java

        // TODO 2: descomentar esto cuando existan
        // System.out.println("Minima: " + Notas.minima(notas));
        // System.out.println("Azules: " + Notas.contarAzules(notas));
        // System.out.printf("Aprobacion: %.1f%%%n", Notas.porcentajeAprobacion(notas));
    }
}
