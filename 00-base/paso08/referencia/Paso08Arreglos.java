import java.util.ArrayList;
import java.util.Arrays;

/*
 * PASO 08 - ARREGLOS (Y UN ADELANTO DE ArrayList)
 *
 * Compilar y ejecutar:
 *     javac Paso08Arreglos.java
 *     java Paso08Arreglos
 *
 * Idea clave: un arreglo es una fila de casilleros del mismo tipo, con
 * largo FIJO. Los casilleros se numeran desde 0, asi que el ultimo es
 * length - 1. Si necesitas que crezca, se usa ArrayList.
 */
public class Paso08Arreglos {
    public static void main(String[] args) {

        // 1. Crear un arreglo con valores
        double[] notas = {5.5, 6.2, 3.8, 7.0};

        System.out.println("Cantidad de notas: " + notas.length);
        System.out.println("Primera: " + notas[0]);
        System.out.println("Ultima: " + notas[notas.length - 1]);

        // 2. Cambiar un casillero
        notas[2] = 4.5;

        // 3. Imprimirlo entero: sin Arrays.toString sale basura
        System.out.println(notas);                      // [D@... !!
        System.out.println(Arrays.toString(notas));     // [5.5, 6.2, 4.5, 7.0]

        // 4. Recorrer con for, cuando necesitas la posicion
        for (int i = 0; i < notas.length; i++) {
            System.out.println("Nota " + (i + 1) + ": " + notas[i]);
        }

        // 5. Recorrer con for-each, cuando solo necesitas el valor
        double suma = 0;
        double mayor = notas[0];
        for (double n : notas) {
            suma += n;
            if (n > mayor) {
                mayor = n;
            }
        }
        System.out.printf("Promedio: %.1f, mayor: %.1f%n", suma / notas.length, mayor);

        // 6. Arreglo vacio: se da el largo, los valores vienen despues
        String[] nombres = new String[3];
        nombres[0] = "Ana";
        nombres[1] = "Luis";
        System.out.println(Arrays.toString(nombres));   // el tercero quedo en null

        // 7. ArrayList: una lista que crece sola (vuelve en la demo 5)
        ArrayList<String> ramos = new ArrayList<>();
        ramos.add("POO");
        ramos.add("Base de datos");
        ramos.add("Ingles");
        System.out.println(ramos.size() + " ramos: " + ramos);
        System.out.println("El segundo es " + ramos.get(1));
    }
}
