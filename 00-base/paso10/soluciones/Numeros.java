public class Numeros {

    public static boolean esPar(int n) {
        return n % 2 == 0;
    }

    public static boolean esPrimo(int n) {
        if (n < 2) {
            return false;
        }
        for (int divisor = 2; divisor < n; divisor++) {
            if (n % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    public static long factorial(int n) {
        long resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    public static int sumaDigitos(int n) {
        int suma = 0;
        while (n > 0) {
            suma += n % 10;
            n = n / 10;
        }
        return suma;
    }
}
