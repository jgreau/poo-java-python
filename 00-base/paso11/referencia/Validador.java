import java.util.Scanner;

/*
 * VALIDADOR - LEER DEL TECLADO SIN QUE EL PROGRAMA SE CAIGA
 *
 * Dos familias de metodos:
 *   es... / esta...  PREGUNTAN: reciben un dato y devuelven true o false.
 *                    No leen ni imprimen nada.
 *   leer...          INSISTEN: piden el dato hasta que sirva, y lo devuelven.
 *                    Usan a los de arriba para decidir si sirve.
 *
 * Todos los leer... se comen la linea completa, Enter incluido:
 * con ellos, la trampa del Enter del paso 4 desaparece.
 *
 * La usan Paso11Validar y Paso13Notas.
 */
public class Validador {

    // ---------- los que PREGUNTAN ----------

    public static boolean estaEnRango(double valor, double min, double max) {
        return valor >= min && valor <= max;
    }

    public static boolean esCorreoDuoc(String correo) {
        String dominio = "@duocuc.cl";
        return correo.endsWith(dominio)
                && correo.length() > dominio.length()      // algo antes del @
                && !correo.contains(" ");
    }

    // ---------- los que INSISTEN ----------

    public static String leerTexto(Scanner sc, String pregunta) {
        System.out.print(pregunta);
        String texto = sc.nextLine().trim();       // trim borra los espacios de los bordes
        while (texto.isEmpty()) {
            System.out.println("   No puede quedar vacio.");
            System.out.print(pregunta);
            texto = sc.nextLine().trim();
        }
        return texto;
    }

    public static int leerEntero(Scanner sc, String pregunta, int min, int max) {
        while (true) {
            System.out.print(pregunta);
            if (!sc.hasNextInt()) {
                System.out.println("   Eso no es un numero entero.");
                sc.nextLine();                     // bota lo que escribio
            } else {
                int valor = sc.nextInt();
                sc.nextLine();                     // se come el Enter
                if (estaEnRango(valor, min, max)) {
                    return valor;                  // la unica salida del while
                }
                System.out.println("   Tiene que ir de " + min + " a " + max + ".");
            }
        }
    }

    public static double leerDecimal(Scanner sc, String pregunta, double min, double max) {
        while (true) {
            System.out.print(pregunta);
            if (!sc.hasNextDouble()) {
                System.out.println("   Eso no es un numero.");
                sc.nextLine();
            } else {
                double valor = sc.nextDouble();
                sc.nextLine();
                if (estaEnRango(valor, min, max)) {
                    return valor;
                }
                System.out.println("   Tiene que ir de " + min + " a " + max + ".");
            }
        }
    }
}
