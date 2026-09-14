/*
 * B12.3 - EL PROMEDIO PONDERADO
 *
 * Copia a esta carpeta tu Notas.java del paso 10.
 *
 * Agregale una SEGUNDA version de promedio:
 *     public static double promedio(double[] notas, double[] pesos)
 *
 * Multiplica cada nota por su peso y suma todo. Con {5.0, 6.0, 4.0} y
 * pesos {0.3, 0.3, 0.4} tiene que dar 4.9.
 *
 * Que pasa si los pesos no suman 1.0? Y si el arreglo de pesos tiene
 * menos elementos que el de notas? Decide que deberia hacer el metodo y
 * dejalo anotado: en la demo 10 eso se resuelve lanzando una excepcion.
 *
 * Salida esperada:
 *     Promedio simple:    5.0
 *     Promedio ponderado: 4.9
 *
 * Compilar y ejecutar:
 *     javac Notas.java B12_3_Ponderado.java
 *     java B12_3_Ponderado
 *
 * Enunciado completo: ../ejercicios.md
 */
public class B12_3_Ponderado {
    public static void main(String[] args) {

        double[] notas = {5.0, 6.0, 4.0};
        double[] pesos = {0.3, 0.3, 0.4};

        // TODO 1: agregar la segunda version de promedio a Notas.java

        // TODO 2: imprimir el simple y el ponderado

        // TODO 3: que hago si los pesos no suman 1.0?
    }
}
