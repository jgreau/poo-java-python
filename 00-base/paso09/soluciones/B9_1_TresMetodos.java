public class B9_1_TresMetodos {

    static boolean esPar(int n) {
        return n % 2 == 0;
    }

    static double areaCirculo(double radio) {
        return Math.PI * radio * radio;
    }

    static void saludar(String nombre, int veces) {
        for (int i = 1; i <= veces; i++) {
            System.out.println("Hola, " + nombre);
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (esPar(i)) {
                System.out.println(i + " es par");
            } else {
                System.out.println(i + " es impar");
            }
        }

        System.out.printf("Area de radio 2: %.2f%n", areaCirculo(2));
        saludar("Ana", 3);
    }
}
