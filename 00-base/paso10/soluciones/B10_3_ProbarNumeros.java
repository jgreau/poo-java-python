public class B10_3_ProbarNumeros {
    public static void main(String[] args) {
        System.out.printf("%3s %6s %7s %12s %14s%n",
                "n", "par", "primo", "factorial", "suma digitos");

        for (int n = 1; n <= 20; n++) {
            System.out.printf("%3d %6s %7s %12d %14d%n",
                    n,
                    Numeros.esPar(n) ? "si" : "no",
                    Numeros.esPrimo(n) ? "si" : "no",
                    Numeros.factorial(n),
                    Numeros.sumaDigitos(n));
        }
    }
}
