/*
 * B4.5 - DESAFIO: EL CAMBIO
 *
 * Pide cuanto cuesta algo y con cuanto paga el cliente. Muestra el
 * vuelto desglosado en billetes y monedas, usando / y % del paso 3.
 *
 * Que pasa si paga con menos de lo que cuesta? Anotalo como pendiente:
 * se arregla en el paso 5.
 *
 * Salida esperada:
 *     Precio: 7300
 *     Paga con: 20000
 *
 *     Vuelto: 12700
 *       1 billete(s) de 10000
 *       0 billete(s) de 5000
 *       1 billete(s) de 2000
 *       0 billete(s) de 1000
 *       1 moneda(s) de 500
 *       2 moneda(s) de 100
 *
 * Compilar y ejecutar:
 *     javac B4_5_Vuelto.java
 *     java B4_5_Vuelto
 *
 * Enunciado completo: ../ejercicios.md
 */
import java.util.Scanner;

public class B4_5_Vuelto {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // TODO 1: pedir precio y con cuanto paga

        // TODO 2: calcular el vuelto

        // TODO 3: cuantos de 10000, 5000, 2000, 1000, 500 y 100
        //         (division entera para cuantos, resto para lo que queda)

        sc.close();
    }
}
