import java.util.Scanner;

/*
 * PASO 04 - LEER DEL TECLADO CON SCANNER
 *
 * Compilar y ejecutar:
 *     javac Paso04Teclado.java
 *     java Paso04Teclado
 *
 * Idea clave: Scanner no viene "puesto", hay que importarlo y crearlo.
 * Y tiene una trampa famosa: nextInt y nextDouble dejan el Enter en la
 * entrada, y el siguiente nextLine se lo come como si fuera una respuesta.
 */
public class Paso04Teclado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Como te llamas? ");
        String nombre = sc.nextLine();

        System.out.print("Cuantos anios tienes? ");
        int edad = sc.nextInt();

        System.out.print("Cuanto mides en metros? ");
        double estatura = sc.nextDouble();
        sc.nextLine();                 // se come el Enter que dejo nextDouble

        System.out.print("Que carrera estudias? ");
        String carrera = sc.nextLine();

        System.out.println();
        System.out.println("Hola " + nombre + ", de " + carrera);
        System.out.println("El proximo anio vas a tener " + (edad + 1) + " anios");
        System.out.printf("Mides %.2f metros%n", estatura);

        sc.close();
    }
}
