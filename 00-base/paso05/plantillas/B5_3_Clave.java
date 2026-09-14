/*
 * B5.3 - LA CLAVE
 *
 * El acceso es correcto si el usuario es alumno (sin importar
 * mayusculas) y la clave es exactamente duoc2026.
 *
 * 1. Escribelo primero con == para la clave: compila y SIEMPRE falla.
 * 2. Arreglalo con equals.
 * 3. Para el usuario usa equalsIgnoreCase, y explica por que para la
 *    clave NO conviene.
 *
 * Salida esperada:
 *     Usuario: ALUMNO
 *     Clave: duoc2026
 *     Bienvenido, ALUMNO
 *
 * Compilar y ejecutar:
 *     javac B5_3_Clave.java
 *     java B5_3_Clave
 *
 * Enunciado completo: ../ejercicios.md
 */
import java.util.Scanner;

public class B5_3_Clave {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // TODO 1: pedir usuario y clave

        // TODO 2: comparar con == y comprobar que falla

        // TODO 3: arreglarlo con equals / equalsIgnoreCase

        // TODO 4: para la clave no uso equalsIgnoreCase porque

        sc.close();
    }
}
