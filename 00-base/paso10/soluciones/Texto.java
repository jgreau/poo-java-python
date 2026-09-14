public class Texto {

    public static String alReves(String texto) {
        String resultado = "";
        for (int i = texto.length() - 1; i >= 0; i--) {
            resultado += texto.charAt(i);
        }
        return resultado;
    }

    public static boolean esPalindromo(String texto) {
        String limpio = texto.toLowerCase();
        return limpio.equals(alReves(limpio));      // usa el metodo de arriba
    }

    public static int contarVocales(String texto) {
        int vocales = 0;
        String minusculas = texto.toLowerCase();
        for (int i = 0; i < minusculas.length(); i++) {
            char c = minusculas.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vocales++;
            }
        }
        return vocales;
    }

    public static String inicialesDe(String nombreCompleto) {
        String iniciales = "";
        for (int i = 0; i < nombreCompleto.length(); i++) {
            if (i == 0 || nombreCompleto.charAt(i - 1) == ' ') {
                iniciales += nombreCompleto.charAt(i);
            }
        }
        return iniciales.toUpperCase();
    }
}
