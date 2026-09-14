/*
 * B6.4 - EL VALIDADOR INSISTENTE
 *
 * Pide una nota de 1.0 a 7.0 y no la sueltes hasta que este en rango.
 * Cuenta cuantas veces se equivoco el usuario y diselo.
 *
 * Salida esperada:
 *     Nota (1.0 a 7.0): 9
 *     Nota invalida. Otra vez: -2
 *     Nota invalida. Otra vez: 5.5
 *     Nota aceptada: 5.5 (te equivocaste 2 veces)
 *
 * Compilar y ejecutar:
 *     javac B6_4_ValidarNota.java
 *     java B6_4_ValidarNota
 *
 * Enunciado completo: ../ejercicios.md
 */
import java.util.Scanner;

public class B6_4_ValidarNota {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int errores = 0;

        // TODO 1: pedir la primera nota

        // TODO 2: el while que insiste mientras este fuera de rango,
        //         contando los errores

        // TODO 3: el mensaje final

        sc.close();
    }
}
