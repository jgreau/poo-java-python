import java.util.Scanner;


public class B11_2_ClaveSegura {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(Validador.esClaveSegura("duoc"));         // false
        System.out.println(Validador.esClaveSegura("duocuc2026"));   // false
        System.out.println(Validador.esClaveSegura("DuocUc2026"));   // true
        System.out.println();

        String clave = Validador.leerTexto(sc, "Clave: ");
        while (!Validador.esClaveSegura(clave)) {
            if (clave.length() < 8) {
                System.out.println("   Le faltan caracteres: tiene " + clave.length() + " de 8.");
            } else {
                System.out.println("   Necesita al menos un numero y una mayuscula.");
            }
            clave = Validador.leerTexto(sc, "Clave: ");
        }
        System.out.println("Clave aceptada");

        sc.close();
    }
}
