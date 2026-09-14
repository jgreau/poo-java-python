public class B3_3_Digitos {
    public static void main(String[] args) {
        int numero = 573;

        int unidades = numero % 10;          // 3
        int decenas = (numero / 10) % 10;    // 57 -> 7
        int centenas = numero / 100;         // 5

        System.out.println("Centenas: " + centenas);
        System.out.println("Decenas:  " + decenas);
        System.out.println("Unidades: " + unidades);
        System.out.println("Suma de los digitos: " + (centenas + decenas + unidades));
    }
}
