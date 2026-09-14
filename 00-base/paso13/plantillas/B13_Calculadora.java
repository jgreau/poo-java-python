import java.util.Scanner;

/*
 * PASO 13 - LOS CINCO EJERCICIOS, SOBRE LA CALCULADORA TERMINADA
 *
 * Esta es tu calculadora del paso 13, con los cinco ejercicios marcados
 * donde van. Si la tuya quedo funcionando, trabaja sobre la tuya y usa
 * esta solo para ubicarte.
 *
 * Copia a esta carpeta tu Notas.java (paso 10) y tu Validador.java
 * (paso 11). Si no los tienes, estan en ../referencia/.
 *
 * Compilar y ejecutar:
 *     javac Notas.java Validador.java B13_Calculadora.java
 *     java B13_Calculadora
 *
 * Enunciado completo: ../ejercicios.md
 */
public class B13_Calculadora {

    static void informe(String nombre, double[] notas) {
        System.out.println();
        System.out.println("===== " + nombre + " =====");
        for (int i = 0; i < notas.length; i++) {
            System.out.printf("  Nota %d: %.1f%n", i + 1, notas[i]);
        }

        double p = Notas.promedio(notas);
        System.out.printf("  Promedio: %.1f%n", p);

        // TODO B13.1: con las notas 3.9 y 4.0 esto dice Promedio 4.0 y
        //             REPROBADO. El promedio real es 3.95: quien redondea
        //             y quien no? Agrega Notas.redondear y decide DONDE va.

        // TODO B13.2: mostrar tambien la maxima, la minima y las rojas,
        //             SIN escribir ningun for nuevo aqui.

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

        // TODO B13.3: los acumuladores del resumen del curso van aqui,
        //             ANTES del do-while: alumnos, aprobados, mejor
        //             promedio y el nombre de su dueno.

        do {
            String nombre = Validador.leerTexto(sc, "Nombre del alumno: ");
            int cantidad = Validador.leerEntero(sc, "Cuantas notas tiene? ", 1, 10);

            // TODO B13.4: preguntar si el promedio es simple o ponderado,
            //             y usar la sobrecarga del B12.3 cuando sea ponderado.

            double[] notas = new double[cantidad];
            for (int i = 0; i < notas.length; i++) {
                notas[i] = Validador.leerDecimal(sc, "Nota " + (i + 1) + ": ",
                        Notas.NOTA_MINIMA, Notas.NOTA_MAXIMA);
            }

            informe(nombre, notas);

            // TODO B13.5: guardar el nombre y el promedio de este alumno
            //             para el listado final.

            otro = Validador.leerTexto(sc, "Otro alumno? (s/n): ");
        } while (otro.equalsIgnoreCase("s"));

        // TODO B13.3: imprimir aqui el resumen del curso.

        // TODO B13.5: imprimir aqui el listado ordenado de mayor a menor.

        System.out.println("Listo.");
        sc.close();
    }
}
