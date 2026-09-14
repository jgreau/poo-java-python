/*
 * B5.2 - EL TRAMO DE EDAD
 *
 * menos de 0 o mas de 120  ->  Esa edad no existe
 * 0 a 17                   ->  Menor de edad
 * 18 a 64                  ->  Adulto
 * 65 o mas                 ->  Adulto mayor
 *
 * Ojo con el ORDEN de los else if: si pones primero el 18 a 64, el -5
 * nunca llega a la validacion. Pruebalo al reves para verlo.
 *
 * Compilar y ejecutar:
 *     javac B5_2_TramoEdad.java
 *     java B5_2_TramoEdad
 *
 * Enunciado completo: ../ejercicios.md
 */
import java.util.Scanner;

public class B5_2_TramoEdad {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // TODO 1: pedir la edad

        // TODO 2: el if / else if / else, en el orden correcto

        sc.close();
    }
}
