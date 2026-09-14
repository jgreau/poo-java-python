/*
 * B11.1 - leerSiNo
 *
 * Copia a esta carpeta tu Validador.java del paso 11. Si no lo tienes, esta en ../referencia/Validador.java.
 *
 * Agregale:
 *     public static boolean leerSiNo(Scanner sc, String pregunta)
 *
 * Devuelve true con s o S, false con n o N, e insiste con cualquier otra
 * cosa. Escribelo usando el leerTexto que ya tienes, no un nextLine
 * nuevo. Pista: respuesta.equalsIgnoreCase("s").
 *
 * Salida esperada:
 *     Seguir? (s/n): tal vez
 *        Responde s o n.
 *     Seguir? (s/n): S
 *
 * Compilar y ejecutar:
 *     javac Validador.java B11_1_LeerSiNo.java
 *     java B11_1_LeerSiNo
 *
 * Enunciado completo: ../ejercicios.md
 */
import java.util.Scanner;

public class B11_1_LeerSiNo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // TODO 1: agregar leerSiNo a Validador.java

        // TODO 2: descomentar cuando exista
        // boolean seguir = Validador.leerSiNo(sc, "Seguir? (s/n): ");
        // System.out.println("Respondiste: " + seguir);

        sc.close();
    }
}
