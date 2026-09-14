public class B12_5_Tarjeta {

    static void tarjeta(String nombre) {
        tarjeta(nombre, "Feliz cumpleanios");
    }

    static void tarjeta(String nombre, String mensaje) {
        tarjeta(nombre, mensaje, '*');
    }

    static void tarjeta(String nombre, String mensaje, char borde) {
        int ancho = Math.max(mensaje.length(), nombre.length()) + 4;

        dibujarLinea(ancho, borde);
        System.out.printf("%c %-" + (ancho - 4) + "s %c%n", borde, mensaje, borde);
        System.out.printf("%c %-" + (ancho - 4) + "s %c%n", borde, nombre, borde);
        dibujarLinea(ancho, borde);
        System.out.println();
    }

    static void dibujarLinea(int ancho, char borde) {
        for (int i = 0; i < ancho; i++) {
            System.out.print(borde);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        tarjeta("Ana");
        tarjeta("Luis", "Que te mejores");
        tarjeta("Sofia", "Feliz titulacion", '#');
    }
}
