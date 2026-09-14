import java.util.Scanner;

/*
 * PASO 11 - VALIDACIONES
 *
 * Compilar y ejecutar:
 *     javac Validador.java Paso11Validar.java
 *     java Paso11Validar
 *
 * Idea clave: el programa no puede confiar en lo que escribe el usuario.
 * Hay que revisar el TIPO (que sea un numero), el RANGO (que este entre
 * 1.0 y 7.0) y el FORMATO (que el correo termine en @duocuc.cl).
 * Escribe "abc" donde pide la edad: en el paso 4 se caia. Aqui no.
 */
public class Paso11Validar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Las validaciones que PREGUNTAN: true o false, sin teclado
        System.out.println(Validador.estaEnRango(5.5, 1.0, 7.0));          // true
        System.out.println(Validador.estaEnRango(9.0, 1.0, 7.0));          // false
        System.out.println(Validador.esCorreoDuoc("ana.perez@duocuc.cl")); // true
        System.out.println(Validador.esCorreoDuoc("ana.perez@gmail.com")); // false
        System.out.println(Validador.esCorreoDuoc("@duocuc.cl"));          // false
        System.out.println();

        // 2. Las lecturas que INSISTEN hasta que el dato sirve
        String nombre = Validador.leerTexto(sc, "Nombre: ");
        int edad = Validador.leerEntero(sc, "Edad: ", 15, 99);
        double nota = Validador.leerDecimal(sc, "Nota: ", 1.0, 7.0);

        // 3. Combinar las dos: leer un texto y validar su formato
        String correo = Validador.leerTexto(sc, "Correo DUOC: ");
        while (!Validador.esCorreoDuoc(correo)) {
            System.out.println("   Tiene que terminar en @duocuc.cl");
            correo = Validador.leerTexto(sc, "Correo DUOC: ");
        }

        System.out.println();
        System.out.printf("%s, %d anios, nota %.1f, %s%n", nombre, edad, nota, correo);

        sc.close();
    }
}
