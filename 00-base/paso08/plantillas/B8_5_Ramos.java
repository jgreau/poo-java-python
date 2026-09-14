/*
 * B8.5 - LA LISTA DE RAMOS (ArrayList)
 *
 * Un menu (paso 6) que administra tus ramos en un ArrayList<String>.
 * Usa ramos.add(...), ramos.size() y ramos.get(i).
 *
 * Despues busca que hacen ramos.remove(0) y ramos.contains("POO"), y
 * agrega las opciones para borrar y para buscar.
 *
 * Compara con el arreglo: podrias haber hecho este menu con un String[]?
 * Que habrias tenido que decidir antes de empezar?
 *
 * Salida esperada:
 *     1) Agregar ramo
 *     2) Listar ramos
 *     3) Cuantos ramos
 *     0) Salir
 *
 * Compilar y ejecutar:
 *     javac B8_5_Ramos.java
 *     java B8_5_Ramos
 *
 * Enunciado completo: ../ejercicios.md
 */
import java.util.ArrayList;
import java.util.Scanner;

public class B8_5_Ramos {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> ramos = new ArrayList<>();

        // TODO 1: el do-while con el menu

        // TODO 2: agregar, listar y contar

        // TODO 3: las opciones de borrar y buscar

        sc.close();
    }
}
