public class B9_5_Primos {

    static boolean esPrimo(int n) {
        if (n < 2) {
            return false;
        }
        for (int divisor = 2; divisor < n; divisor++) {
            if (n % divisor == 0) {
                return false;          // encontro un divisor: no es primo
            }
        }
        return true;
    }

    static int contarPrimos(int hasta) {
        int cuantos = 0;
        for (int n = 2; n <= hasta; n++) {
            if (esPrimo(n)) {
                cuantos++;
            }
        }
        return cuantos;
    }

    public static void main(String[] args) {
        System.out.println("Primos hasta 30: " + contarPrimos(30));
        System.out.println("Primos hasta 100: " + contarPrimos(100));
        System.out.println("Es primo el 97? " + esPrimo(97));
        System.out.println("Es primo el 1? " + esPrimo(1));
    }
}
