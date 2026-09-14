import java.util.Scanner;

/*
 * VALIDADOR - el del paso 11, con los tres metodos de la hoja agregados.
 *
 *   es... / esta...  PREGUNTAN: devuelven true o false.
 *   leer...          INSISTEN: piden hasta que el dato sirva.
 */
public class Validador {

    // ---------- los que PREGUNTAN ----------

    public static boolean estaEnRango(double valor, double min, double max) {
        return valor >= min && valor <= max;
    }

    public static boolean esCorreoDuoc(String correo) {
        String dominio = "@duocuc.cl";
        return correo.endsWith(dominio)
                && correo.length() > dominio.length()
                && !correo.contains(" ");
    }

    // B11.2
    public static boolean esClaveSegura(String clave) {
        if (clave.length() < 8) {
            return false;
        }
        boolean tieneDigito = false;
        boolean tieneMayuscula = false;
        for (int i = 0; i < clave.length(); i++) {
            char c = clave.charAt(i);
            if (Character.isDigit(c)) {
                tieneDigito = true;
            }
            if (Character.isUpperCase(c)) {
                tieneMayuscula = true;
            }
        }
        return tieneDigito && tieneMayuscula;
    }

    // B11.4
    public static boolean esRutValido(String rut) {
        int guion = rut.indexOf('-');
        if (guion < 7 || guion != rut.lastIndexOf('-')) {
            return false;                       // sin guion, muy corto, o con dos
        }
        if (rut.length() != guion + 2) {
            return false;                       // despues del guion va UN caracter
        }
        for (int i = 0; i < guion; i++) {
            if (!Character.isDigit(rut.charAt(i))) {
                return false;
            }
        }
        char dv = rut.charAt(guion + 1);
        return Character.isDigit(dv) || dv == 'k' || dv == 'K';
    }

    // B11.4 extra: el digito verificador de verdad (modulo 11)
    public static boolean tieneDvCorrecto(String rut) {
        if (!esRutValido(rut)) {
            return false;
        }
        int guion = rut.indexOf('-');
        String cuerpo = rut.substring(0, guion);

        int suma = 0;
        int multiplicador = 2;
        for (int i = cuerpo.length() - 1; i >= 0; i--) {     // de derecha a izquierda
            suma += (cuerpo.charAt(i) - '0') * multiplicador;
            multiplicador++;
            if (multiplicador > 7) {
                multiplicador = 2;
            }
        }

        int resto = 11 - (suma % 11);
        char esperado;
        if (resto == 11) {
            esperado = '0';
        } else if (resto == 10) {
            esperado = 'K';
        } else {
            esperado = (char) ('0' + resto);
        }

        return Character.toUpperCase(rut.charAt(guion + 1)) == esperado;
    }

    // ---------- los que INSISTEN ----------

    public static String leerTexto(Scanner sc, String pregunta) {
        System.out.print(pregunta);
        String texto = sc.nextLine().trim();
        while (texto.isEmpty()) {
            System.out.println("   No puede quedar vacio.");
            System.out.print(pregunta);
            texto = sc.nextLine().trim();
        }
        return texto;
    }

    public static int leerEntero(Scanner sc, String pregunta, int min, int max) {
        while (true) {
            System.out.print(pregunta);
            if (!sc.hasNextInt()) {
                System.out.println("   Eso no es un numero entero.");
                sc.nextLine();
            } else {
                int valor = sc.nextInt();
                sc.nextLine();
                if (estaEnRango(valor, min, max)) {
                    return valor;
                }
                System.out.println("   Tiene que ir de " + min + " a " + max + ".");
            }
        }
    }

    public static double leerDecimal(Scanner sc, String pregunta, double min, double max) {
        while (true) {
            System.out.print(pregunta);
            if (!sc.hasNextDouble()) {
                System.out.println("   Eso no es un numero.");
                sc.nextLine();
            } else {
                double valor = sc.nextDouble();
                sc.nextLine();
                if (estaEnRango(valor, min, max)) {
                    return valor;
                }
                System.out.println("   Tiene que ir de " + min + " a " + max + ".");
            }
        }
    }

    // B11.1
    public static boolean leerSiNo(Scanner sc, String pregunta) {
        while (true) {
            String respuesta = leerTexto(sc, pregunta);
            if (respuesta.equalsIgnoreCase("s")) {
                return true;
            }
            if (respuesta.equalsIgnoreCase("n")) {
                return false;
            }
            System.out.println("   Responde s o n.");
        }
    }
}
