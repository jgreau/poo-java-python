/*
 * B5.4 - LA CALCULADORA CON switch
 *
 * Pide dos numeros y la operacion (1 sumar, 2 restar, 3 multiplicar,
 * 4 dividir). Usa switch.
 *
 * Requisitos: si la operacion no existe, el default lo avisa; si es
 * dividir y el segundo numero es 0, avisa SIN que el programa se caiga.
 *
 * Salida esperada:
 *     Primer numero: 8
 *     Segundo numero: 0
 *     1) Sumar  2) Restar  3) Multiplicar  4) Dividir
 *     Operacion: 4
 *     No se puede dividir por cero
 *
 * Compilar y ejecutar:
 *     javac B5_4_Switch.java
 *     java B5_4_Switch
 *
 * Enunciado completo: ../ejercicios.md
 */
import java.util.Scanner;

public class B5_4_Switch {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // TODO 1: pedir los dos numeros y la operacion

        // TODO 2: el switch con sus cuatro case, sus break y el default

        // TODO 3: el caso de dividir por cero

        sc.close();
    }
}
