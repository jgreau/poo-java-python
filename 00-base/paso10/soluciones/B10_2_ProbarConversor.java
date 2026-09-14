public class B10_2_ProbarConversor {
    public static void main(String[] args) {
        System.out.println("25 C son " + Conversor.celsiusAFahrenheit(25) + " F");
        System.out.printf("5 km son %.1f millas%n", Conversor.kmAMillas(5));
        System.out.printf("1500000 pesos son %.2f UF%n", Conversor.pesosAUf(1500000));
        System.out.println("2.5 UF son " + Conversor.ufAPesos(2.5) + " pesos");
    }
}
