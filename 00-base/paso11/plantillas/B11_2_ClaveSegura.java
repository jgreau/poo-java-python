/*
 * B11.2 - LA CLAVE SEGURA
 *
 * Copia a esta carpeta tu Validador.java del paso 11.
 *
 * Agregale:
 *     public static boolean esClaveSegura(String clave)
 *
 * Sirve si tiene 8 caracteres o mas, al menos un digito y al menos una
 * mayuscula. Pistas: clave.length(), clave.charAt(i),
 * Character.isDigit(c), Character.isUpperCase(c). Necesitas dos boolean
 * y un for.
 *
 * Despues usala en un while que pida la clave hasta que sirva, y que
 * diga QUE le falta en cada intento.
 *
 * Salida esperada:
 *     esClaveSegura("duoc")          -> false
 *     esClaveSegura("duocuc2026")    -> false
 *     esClaveSegura("DuocUc2026")    -> true
 *
 * Compilar y ejecutar:
 *     javac Validador.java B11_2_ClaveSegura.java
 *     java B11_2_ClaveSegura
 *
 * Enunciado completo: ../ejercicios.md
 */
import java.util.Scanner;

public class B11_2_ClaveSegura {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // TODO 1: agregar esClaveSegura a Validador.java

        // TODO 2: probarla con las tres claves del ejemplo

        // TODO 3: el while que pide la clave hasta que sirva

        sc.close();
    }
}
