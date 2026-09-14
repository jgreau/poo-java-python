/*
 * B12.4 - PROBAR LAS CUATRO VERSIONES
 *
 * Prueba las cinco llamadas y anota CUAL version eligio Java en cada
 * una. La ultima no calza exacto con ninguna: cual uso y por que?
 * Que pasa si borras la version de double?
 *
 * Compilar y ejecutar:
 *     javac Calculos.java B12_4_ProbarCalculos.java
 *     java B12_4_ProbarCalculos
 *
 * Enunciado completo: ../ejercicios.md
 */
public class B12_4_ProbarCalculos {
    public static void main(String[] args) {

        System.out.println(Calculos.sumar(2, 3));
        System.out.println(Calculos.sumar(2.5, 3.5));
        System.out.println(Calculos.sumar(1, 2, 3));
        System.out.println(Calculos.sumar(new int[] {1, 2, 3, 4}));
        System.out.println(Calculos.sumar(2, 3.5));    // esta es la interesante

        // TODO 1: completar los cuatro metodos de Calculos.java

        // TODO 2: sumar(2, 3.5) uso la version ___ porque

        // TODO 3: si borro la version de double, pasa que
    }
}
