public class B3_5_Intercambio {
    public static void main(String[] args) {
        int a = 3;
        int b = 8;
        System.out.println("Antes:    a = " + a + ", b = " + b);

        int auxiliar = a;    // guardo el 3 antes de pisarlo
        a = b;               // a vale 8
        b = auxiliar;        // b vale el 3 que tenia guardado

        System.out.println("Despues:  a = " + a + ", b = " + b);
    }
}
