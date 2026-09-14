/*
 * B8.3 - BUSCAR
 *
 * Pide un numero por teclado y responde en que posicion esta, o que no
 * esta.
 *
 * Pista: una variable int posicion = -1; antes del for, y break apenas lo
 * encuentres. El -1 es la forma clasica de decir 'no esta'.
 *
 * Salida esperada:
 *     Buscar: 30
 *     Encontrado en la posicion 2 (el tercero)
 *
 *     Buscar: 99
 *     No esta en la lista
 *
 * Compilar y ejecutar:
 *     javac B8_3_Buscar.java
 *     java B8_3_Buscar
 *
 * Enunciado completo: ../ejercicios.md
 */
import java.util.Scanner;

public class B8_3_Buscar {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] numeros = {10, 20, 30, 40, 50, 60};
        int posicion = -1;

        // TODO 1: pedir el numero a buscar

        // TODO 2: el for que lo busca, con break

        // TODO 3: el if que responde segun posicion

        sc.close();
    }
}
