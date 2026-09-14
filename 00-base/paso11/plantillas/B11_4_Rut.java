/*
 * B11.4 - EL RUT
 *
 * Copia a esta carpeta tu Validador.java del paso 11.
 *
 * Agregale:
 *     public static boolean esRutValido(String rut)
 *
 * Por ahora sirve si: tiene UN guion, antes del guion hay SOLO digitos
 * (al menos 7), y despues del guion hay UN caracter, digito o k/K.
 *
 * Pistas: rut.indexOf('-'), rut.substring(0, guion), rut.charAt(i),
 * Character.isDigit(c).
 *
 * EXTRA (dificil): busca como se calcula el digito verificador con el
 * modulo 11 y compruebalo de verdad.
 *
 * Salida esperada:
 *     esRutValido("12345678-5")   -> true
 *     esRutValido("12345678-k")   -> true
 *     esRutValido("12345678")     -> false
 *     esRutValido("1234a678-5")   -> false
 *
 * Compilar y ejecutar:
 *     javac Validador.java B11_4_Rut.java
 *     java B11_4_Rut
 *
 * Enunciado completo: ../ejercicios.md
 */
public class B11_4_Rut {
    public static void main(String[] args) {

        // TODO 1: agregar esRutValido a Validador.java

        // TODO 2: probarlo con los cuatro RUT del ejemplo

        // TODO 3 (extra): el digito verificador con modulo 11
    }
}
