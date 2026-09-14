public class Calculos {

    public static int sumar(int a, int b) {
        System.out.print("  [uso (int, int)]        ");
        return a + b;
    }

    public static double sumar(double a, double b) {
        System.out.print("  [uso (double, double)]  ");
        return a + b;
    }

    public static int sumar(int a, int b, int c) {
        System.out.print("  [uso (int, int, int)]   ");
        return a + b + c;
    }

    public static int sumar(int[] numeros) {
        System.out.print("  [uso (int[])]           ");
        int suma = 0;
        for (int n : numeros) {
            suma += n;
        }
        return suma;
    }
}
