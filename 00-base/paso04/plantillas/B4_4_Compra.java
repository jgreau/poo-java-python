/*
 * B4.4 - EL TOTAL DE LA COMPRA
 *
 * Pide el nombre de un producto, su precio unitario y la cantidad.
 * Muestra la boleta con printf, como en el paso 2.
 *
 * Salida esperada:
 *     Producto: Cuaderno
 *     Precio unitario: 1990
 *     Cantidad: 3
 *
 *     Cuaderno x3
 *     Neto:      5970
 *     IVA:       1134
 *     Total:     7104
 *
 * Compilar y ejecutar:
 *     javac B4_4_Compra.java
 *     java B4_4_Compra
 *
 * Enunciado completo: ../ejercicios.md
 */
import java.util.Scanner;

public class B4_4_Compra {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        final double IVA = 0.19;

        // TODO 1: pedir producto, precio y cantidad

        // TODO 2: calcular neto, iva y total

        // TODO 3: imprimir la boleta

        sc.close();
    }
}
