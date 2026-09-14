public class B7_1_Multiplos {
    public static void main(String[] args) {
        int cuantos = 0;
        int suma = 0;

        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                cuantos++;
                suma += i;
            }
        }

        System.out.println("Multiplos de 3 entre 1 y 100: " + cuantos);
        System.out.println("Suman: " + suma);
        System.out.println();

        int enLaLinea = 0;
        for (int i = 3; i <= 100; i += 3) {       // partir en 3 y avanzar de 3 en 3
            System.out.print(i + " ");
            enLaLinea++;
            if (enLaLinea == 10) {
                System.out.println();
                enLaLinea = 0;
            }
        }
        System.out.println();
    }
}
