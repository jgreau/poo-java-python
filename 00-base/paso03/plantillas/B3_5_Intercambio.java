/*
 * B3.5 - INTERCAMBIAR DOS VARIABLES
 *
 * Haz que a y b terminen al reves, SIN escribir los numeros otra vez.
 * Pista: necesitas una tercera variable. Prueba primero a = b; b = a;
 * y mira que queda.
 *
 * Salida esperada:
 *     Antes:    a = 3, b = 8
 *     Despues:  a = 8, b = 3
 *
 * Compilar y ejecutar:
 *     javac B3_5_Intercambio.java
 *     java B3_5_Intercambio
 *
 * Enunciado completo: ../ejercicios.md
 */
public class B3_5_Intercambio {
    public static void main(String[] args) {

        int a = 3;
        int b = 8;
        System.out.println("Antes:    a = " + a + ", b = " + b);

        // TODO: intercambiarlas

        System.out.println("Despues:  a = " + a + ", b = " + b);
    }
}
