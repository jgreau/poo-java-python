/*
 * B11.3 - EL MENU BLINDADO
 *
 * Copia a esta carpeta tu Validador.java del paso 11.
 *
 * Copia aqui tu menu del B6.3 y reemplaza el sc.nextInt() por
 *     Validador.leerEntero(sc, "Opcion: ", 0, 3)
 *
 * Ahora escribele abc, -1 y 99: el menu tiene que seguir vivo.
 *
 * Pregunta: con leerEntero validando el rango, sigue haciendo falta el
 * default del switch? Lo dejarias igual? Justifica.
 *
 * Compilar y ejecutar:
 *     javac Validador.java B11_3_MenuBlindado.java
 *     java B11_3_MenuBlindado
 *
 * Enunciado completo: ../ejercicios.md
 */
import java.util.Scanner;

public class B11_3_MenuBlindado {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // TODO 1: el do-while del menu, leyendo con Validador.leerEntero

        // TODO 2: sigue haciendo falta el default? Por que?

        sc.close();
    }
}
