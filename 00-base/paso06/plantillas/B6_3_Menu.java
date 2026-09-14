/*
 * B6.3 - EL MENU QUE NO SE RINDE
 *
 * Un menu con do-while. La opcion 2 pide dos numeros y muestra la suma.
 * Una opcion que no existe avisa y VUELVE al menu. Solo el 0 termina.
 *
 * Por que do-while y no while? Porque el menu tiene que mostrarse al
 * menos una vez antes de preguntar nada.
 *
 * Salida esperada:
 *     1) Saludar
 *     2) Sumar dos numeros
 *     3) Contar hasta 10
 *     0) Salir
 *     Opcion:
 *
 * Compilar y ejecutar:
 *     javac B6_3_Menu.java
 *     java B6_3_Menu
 *
 * Enunciado completo: ../ejercicios.md
 */
import java.util.Scanner;

public class B6_3_Menu {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        // TODO 1: el do { ... } while (opcion != 0);

        // TODO 2: adentro, mostrar el menu y leer la opcion

        // TODO 3: el switch con las cuatro opciones y el default

        sc.close();
    }
}
