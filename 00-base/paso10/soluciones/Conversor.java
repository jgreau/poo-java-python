public class Conversor {

    public static final int UF = 39000;        // valor aproximado, en pesos

    public static double celsiusAFahrenheit(double c) {
        return c * 9 / 5 + 32;
    }

    public static double kmAMillas(double km) {
        return km * 0.621371;
    }

    public static double pesosAUf(int pesos) {
        return (double) pesos / UF;
    }

    public static int ufAPesos(double uf) {
        return (int) (uf * UF);
    }
}
