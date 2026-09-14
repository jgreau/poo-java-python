import java.util.Scanner;


public class B11_5_FichaBlindada {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nombre = Validador.leerTexto(sc, "Nombre: ");

        String rut = Validador.leerTexto(sc, "RUT: ");
        while (!Validador.esRutValido(rut)) {
            System.out.println("   Formato: 12345678-5");
            rut = Validador.leerTexto(sc, "RUT: ");
        }

        int edad = Validador.leerEntero(sc, "Edad: ", 15, 99);

        String correo = Validador.leerTexto(sc, "Correo DUOC: ");
        while (!Validador.esCorreoDuoc(correo)) {
            System.out.println("   Tiene que terminar en @duocuc.cl");
            correo = Validador.leerTexto(sc, "Correo DUOC: ");
        }

        double promedio = Validador.leerDecimal(sc, "Promedio: ", 1.0, 7.0);

        String clave = Validador.leerTexto(sc, "Clave: ");
        while (!Validador.esClaveSegura(clave)) {
            System.out.println("   8 caracteres, un numero y una mayuscula.");
            clave = Validador.leerTexto(sc, "Clave: ");
        }

        String confirmacion = Validador.leerTexto(sc, "Confirmar clave: ");
        while (!confirmacion.equals(clave)) {
            System.out.println("   No coinciden.");
            confirmacion = Validador.leerTexto(sc, "Confirmar clave: ");
        }

        System.out.println();
        System.out.println("===== FICHA =====");
        System.out.printf("%-10s %s%n", "Nombre:", nombre);
        System.out.printf("%-10s %s%n", "RUT:", rut);
        System.out.printf("%-10s %d anios%n", "Edad:", edad);
        System.out.printf("%-10s %s%n", "Correo:", correo);
        System.out.printf("%-10s %.1f%n", "Promedio:", promedio);
        System.out.printf("%-10s %s%n", "Clave:", "********");

        sc.close();
    }
}
