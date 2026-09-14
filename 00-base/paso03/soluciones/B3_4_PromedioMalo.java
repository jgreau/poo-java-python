public class B3_4_PromedioMalo {
    public static void main(String[] args) {
        int nota1 = 5;
        int nota2 = 6;
        int nota3 = 5;

        // MAL: los tres son int, asi que la division es entera
        double malo = (nota1 + nota2 + nota3) / 3;
        System.out.println("Mal:          " + malo);

        // Arreglo 1: convertir la suma a double ANTES de dividir
        double bueno1 = (double) (nota1 + nota2 + nota3) / 3;
        System.out.println("Con cast:     " + bueno1);

        // Arreglo 2: que el divisor sea decimal, y listo
        double bueno2 = (nota1 + nota2 + nota3) / 3.0;
        System.out.println("Con el 3.0:   " + bueno2);
    }
}
