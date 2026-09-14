/*
 * B6.1 - LA SUMA CON CENTINELA
 *
 * Pide numeros enteros hasta que el usuario escriba 0. Al final muestra
 * la suma, cuantos numeros ingreso y el promedio.
 *
 * Ojo con el caso en que el PRIMER numero es 0: no puede dividir por
 * cero al sacar el promedio. Pruebalo y arreglalo.
 *
 * Salida esperada:
 *     Numero (0 para terminar): 10
 *     Numero (0 para terminar): 25
 *     Numero (0 para terminar): 7
 *     Numero (0 para terminar): 0
 *     Ingresaste 3 numeros
 *     Suma: 42
 *     Promedio: 14.0
 *
 * Compilar y ejecutar:
 *     javac B6_1_Centinela.java
 *     java B6_1_Centinela
 *
 * Enunciado completo: ../ejercicios.md
 */
import java.util.Scanner;

public class B6_1_Centinela {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int suma = 0;
        int cantidad = 0;

        // TODO 1: pedir el primer numero

        // TODO 2: el while que repite mientras no sea 0

        // TODO 3: mostrar cantidad, suma y promedio (cuidado con el 0)

        sc.close();
    }
}
