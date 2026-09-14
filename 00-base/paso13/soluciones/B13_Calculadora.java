import java.util.Scanner;

/*
 * PASO 13 - LA CALCULADORA DE NOTAS, CON LOS CINCO EJERCICIOS RESUELTOS.
 *
 *   B13.1  el promedio se redondea en Notas.redondear
 *   B13.2  el informe muestra maxima, minima y rojas
 *   B13.3  el resumen del curso al salir
 *   B13.4  promedio simple o ponderado
 *   B13.5  el listado final ordenado de mayor a menor
 *
 *     javac Notas.java Validador.java B13_Calculadora.java
 *     java B13_Calculadora
 */
public class B13_Calculadora {

    static final int MAXIMO_ALUMNOS = 50;
    static final double[] PESOS = {0.3, 0.3, 0.4};

    static void informe(String nombre, double[] notas, double promedio, boolean ponderado) {
        System.out.println();
        System.out.println("===== " + nombre + " =====");
        for (int i = 0; i < notas.length; i++) {
            System.out.printf("  Nota %d: %.1f%n", i + 1, notas[i]);
        }

        System.out.printf("  Promedio%s: %.1f%n", ponderado ? " ponderado" : "", promedio);
        System.out.printf("  Maxima: %.1f   Minima: %.1f   Rojas: %d%n",
                Notas.maxima(notas), Notas.minima(notas), Notas.contarRojas(notas));

        if (Notas.aprobo(promedio)) {
            System.out.println("  APROBADO");
        } else {
            System.out.printf("  REPROBADO, le faltan %.1f%n", Notas.NOTA_APROBACION - promedio);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] nombres = new String[MAXIMO_ALUMNOS];
        double[] promedios = new double[MAXIMO_ALUMNOS];
        int cuantos = 0;
        int aprobados = 0;
        double mejorPromedio = 0;
        String mejorAlumno = "";

        boolean seguir = true;
        while (seguir && cuantos < MAXIMO_ALUMNOS) {
            String nombre = Validador.leerTexto(sc, "Nombre del alumno: ");

            boolean ponderado = Validador.leerSiNo(sc, "Ponderado? (s/n): ");
            double[] notas;
            double promedio;

            if (ponderado) {
                notas = new double[PESOS.length];
                for (int i = 0; i < notas.length; i++) {
                    notas[i] = Validador.leerDecimal(sc,
                            "Nota " + (i + 1) + " (" + (int) (PESOS[i] * 100) + "%): ",
                            Notas.NOTA_MINIMA, Notas.NOTA_MAXIMA);
                }
                promedio = Notas.promedio(notas, PESOS);
            } else {
                int cantidad = Validador.leerEntero(sc, "Cuantas notas tiene? ", 1, 10);
                notas = new double[cantidad];
                for (int i = 0; i < notas.length; i++) {
                    notas[i] = Validador.leerDecimal(sc, "Nota " + (i + 1) + ": ",
                            Notas.NOTA_MINIMA, Notas.NOTA_MAXIMA);
                }
                promedio = Notas.promedio(notas);
            }

            informe(nombre, notas, promedio, ponderado);

            nombres[cuantos] = nombre;
            promedios[cuantos] = promedio;
            cuantos++;
            if (Notas.aprobo(promedio)) {
                aprobados++;
            }
            if (cuantos == 1 || promedio > mejorPromedio) {   // el primero manda, despues gana el mayor
                mejorPromedio = promedio;
                mejorAlumno = nombre;
            }

            seguir = Validador.leerSiNo(sc, "Otro alumno? (s/n): ");
        }

        // ---------- B13.3: el resumen ----------
        System.out.println();
        System.out.println("===== RESUMEN DEL CURSO =====");
        System.out.println("Alumnos ingresados: " + cuantos);
        System.out.printf("Aprobados: %d (%.1f%%)%n", aprobados, aprobados * 100.0 / cuantos);
        System.out.println("Reprobados: " + (cuantos - aprobados));
        System.out.printf("Mejor promedio: %.1f (%s)%n", mejorPromedio, mejorAlumno);

        // ---------- B13.5: el listado ordenado ----------
        System.out.println();
        System.out.println("===== NOTAS FINALES =====");
        boolean[] yaMostrado = new boolean[cuantos];

        for (int puesto = 1; puesto <= cuantos; puesto++) {
            int mejor = -1;
            for (int i = 0; i < cuantos; i++) {
                if (!yaMostrado[i] && (mejor == -1 || promedios[i] > promedios[mejor])) {
                    mejor = i;
                }
            }
            yaMostrado[mejor] = true;
            System.out.printf("%d. %-14s %.1f  %s%n", puesto, nombres[mejor], promedios[mejor],
                    Notas.aprobo(promedios[mejor]) ? "APROBADO" : "REPROBADO");
        }

        System.out.println();
        System.out.println("Listo.");
        sc.close();
    }
}
