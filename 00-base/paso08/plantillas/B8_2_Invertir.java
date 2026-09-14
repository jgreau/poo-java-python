/*
 * B8.2 - AL REVES
 *
 * 1. Imprime el arreglo al reves, recorriendolo de atras para adelante.
 * 2. Ahora dalo vuelta DE VERDAD: intercambia el primero con el ultimo,
 *    el segundo con el penultimo, etc.
 *
 * Para el segundo necesitas el intercambio del B3.5, y recorrer SOLO LA
 * MITAD. Que pasa si lo recorres entero? Pruebalo.
 *
 * Salida esperada:
 *     Original:  [10, 20, 30, 40, 50]
 *     Invertido: [50, 40, 30, 20, 10]
 *
 * Compilar y ejecutar:
 *     javac B8_2_Invertir.java
 *     java B8_2_Invertir
 *
 * Enunciado completo: ../ejercicios.md
 */
import java.util.Arrays;

public class B8_2_Invertir {
    public static void main(String[] args) {

        int[] numeros = {10, 20, 30, 40, 50};
        System.out.println("Original:  " + Arrays.toString(numeros));

        // TODO 1: imprimirlo al reves con un for de atras para adelante

        // TODO 2: darlo vuelta de verdad, recorriendo la mitad

        System.out.println("Invertido: " + Arrays.toString(numeros));
    }
}
