/*
 * B8.6 - DESAFIO: SIN REPETIDOS
 *
 * Pide 5 numeros y guardalos en un arreglo, pero RECHAZA los repetidos:
 * si el usuario escribe uno que ya esta, se lo dices y se lo vuelves a
 * pedir.
 *
 * Necesitas un for que recorra lo que ya llevas guardado cada vez que
 * entra un numero nuevo, dentro de un while que insiste.
 *
 * Salida esperada:
 *     Numero 1: 7
 *     Numero 2: 3
 *     Numero 3: 7
 *        El 7 ya esta en la lista
 *     Numero 3: 9
 *
 * Compilar y ejecutar:
 *     javac B8_6_SinRepetidos.java
 *     java B8_6_SinRepetidos
 *
 * Enunciado completo: ../ejercicios.md
 */
import java.util.Scanner;

public class B8_6_SinRepetidos {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[5];
        int guardados = 0;

        // TODO 1: el while (o for) que llena el arreglo

        // TODO 2: adentro, revisar si el numero ya esta

        // TODO 3: guardarlo solo si no estaba

        sc.close();
    }
}
