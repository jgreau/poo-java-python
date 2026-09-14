/*
 * B3.4 - EL PROMEDIO MAL CALCULADO
 *
 * Este codigo esta mal y compila igual. Con las notas 5, 6 y 4 imprime
 * 5.0, que casualmente es correcto. Cambia nota3 a 5: deberia dar 5.33
 * y da 5.0.
 *
 * Arreglalo de DOS formas distintas: una con cast, otra sin cast.
 *
 * Compilar y ejecutar:
 *     javac B3_4_PromedioMalo.java
 *     java B3_4_PromedioMalo
 *
 * Enunciado completo: ../ejercicios.md
 */
public class B3_4_PromedioMalo {
    public static void main(String[] args) {

        int nota1 = 5;
        int nota2 = 6;
        int nota3 = 4;

        double promedio = (nota1 + nota2 + nota3) / 3;
        System.out.println("Promedio: " + promedio);

        // TODO 1: arreglo con cast

        // TODO 2: arreglo sin cast

        // TODO 3: por que el error se escondia con las notas originales?
    }
}
