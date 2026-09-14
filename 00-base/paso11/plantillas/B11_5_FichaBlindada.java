/*
 * B11.5 - DESAFIO: LA FICHA IMPOSIBLE DE ROMPER
 *
 * Copia a esta carpeta tu Validador.java del paso 11.
 *
 * Pide una ficha completa que no se pueda botar ni con letras, ni con
 * vacios, ni con datos fuera de rango:
 *
 *     Nombre            no vacio
 *     RUT               formato valido (B11.4)
 *     Edad              15 a 99
 *     Correo DUOC       termina en @duocuc.cl
 *     Promedio          1.0 a 7.0
 *     Clave             segura (B11.2)
 *     Confirmar clave   igual a la anterior
 *
 * Al final muestra la ficha con printf, SIN mostrar la clave.
 *
 * LA PRUEBA DE FUEGO. Cuando creas que esta listo, correlo una vez y
 * tirale TODA esta lista, en orden, sin reiniciarlo:
 *
 *   1. Enter, sin escribir nada, en el nombre       -> lo vuelve a pedir
 *   2. tres espacios en el nombre                   -> lo vuelve a pedir
 *   3. 12345678 en el RUT (sin guion)                -> lo vuelve a pedir
 *   4. abc en la edad                                -> lo vuelve a pedir, sin caerse
 *   5. 14 y despues 150 en la edad                    -> los dos fuera de rango
 *   6. ana@gmail.com en el correo                    -> lo vuelve a pedir
 *   7. 9.5 y despues 0 en el promedio                 -> los dos fuera de rango
 *   8. duoc en la clave                               -> insegura, la vuelve a pedir
 *   9. una clave y una confirmacion distintas         -> las vuelve a pedir
 *
 * Si en alguno el programa se cae, o acepta el dato, ahi tienes el
 * arreglo. Esta listo cuando llega al final sin morirse ni una vez.
 *
 * Compilar y ejecutar:
 *     javac Validador.java B11_5_FichaBlindada.java
 *     java B11_5_FichaBlindada
 *
 * Enunciado completo: ../ejercicios.md
 */
import java.util.Scanner;

public class B11_5_FichaBlindada {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // TODO 1: pedir los siete datos, cada uno con su validacion

        // TODO 2: imprimir la ficha sin la clave

        sc.close();
    }
}
