import java.util.Scanner;


public class B5_3_Clave {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Usuario: ");
        String usuario = sc.nextLine();

        System.out.print("Clave: ");
        String clave = sc.nextLine();

        // Con == esto SIEMPRE dice que la clave esta mala:
        // if (clave == "duoc2026") { ... }

        if (usuario.equalsIgnoreCase("alumno") && clave.equals("duoc2026")) {
            System.out.println("Bienvenido, " + usuario);
        } else {
            System.out.println("Usuario o clave incorrectos");
        }

        sc.close();
    }
}
