/*
 * PASO 09 - METODOS: SACAR CODIGO DEL main
 *
 * Compilar y ejecutar:
 *     javac Paso09Metodos.java
 *     java Paso09Metodos
 *
 * Idea clave: un metodo es un pedazo de codigo con nombre. Los void
 * HACEN algo; los que tienen tipo RESPONDEN algo con return.
 * Todos llevan static porque todavia no hay objetos: en la demo 1
 * aparecen los metodos sin static, y ese es el salto a POO.
 */
public class Paso09Metodos {

    // 1. void: hace algo y no devuelve nada
    static void linea() {
        System.out.println("------------------------------");
    }

    // 2. Con parametro: el dato entra por los parentesis
    static void saludar(String nombre) {
        System.out.println("Hola, " + nombre);
    }

    // 3. Con return: el tipo de la izquierda es lo que devuelve
    static double promedio(double[] notas) {
        double suma = 0;
        for (double n : notas) {
            suma += n;
        }
        return suma / notas.length;
    }

    static boolean aprobo(double promedio) {
        return promedio >= 4.0;
    }

    public static void main(String[] args) {
        linea();
        saludar("Ana");
        saludar("Luis");
        linea();

        double[] notasAna = {5.5, 6.2, 4.5};
        double[] notasLuis = {3.2, 4.1, 3.5};

        double pAna = promedio(notasAna);
        double pLuis = promedio(notasLuis);

        System.out.printf("Ana:  %.1f  aprobo: %b%n", pAna, aprobo(pAna));
        System.out.printf("Luis: %.1f  aprobo: %b%n", pLuis, aprobo(pLuis));
        linea();
    }
}
