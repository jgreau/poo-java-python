import java.util.Scanner;

/*
 * PASO 07 - REPETIR CON for
 *
 * Compilar y ejecutar:
 *     javac Paso07For.java
 *     java Paso07For
 *
 * Idea clave: for junta en una linea las tres partes que en el while
 * estaban repartidas: donde parte, hasta cuando sigue, como avanza.
 * Se usa cuando sabes cuantas vueltas vas a dar.
 */
public class Paso07For {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. El mismo conteo del paso 6, en una sola linea
        for (int i = 1; i <= 5; i++) {
            System.out.println("Vuelta " + i);
        }

        // 2. Hacia atras y de 2 en 2
        for (int i = 10; i >= 0; i -= 2) {
            System.out.print(i + " ");
        }
        System.out.println();

        // 3. Acumular: sumar del 1 al 100
        int suma = 0;
        for (int i = 1; i <= 100; i++) {
            suma += i;
        }
        System.out.println("Suma del 1 al 100: " + suma);

        // 4. Una tabla de multiplicar
        System.out.print("Que tabla quieres? ");
        int tabla = sc.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x %2d = %3d%n", tabla, i, tabla * i);
        }

        // 5. Un for dentro de otro: el de afuera son filas, el de adentro columnas
        for (int fila = 1; fila <= 4; fila++) {
            for (int col = 1; col <= fila; col++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 6. continue salta a la siguiente vuelta; break corta el for entero
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue;
            }
            if (i > 7) {
                break;
            }
            System.out.print(i + " ");
        }
        System.out.println();

        sc.close();
    }
}
