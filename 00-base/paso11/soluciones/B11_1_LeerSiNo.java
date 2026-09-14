import java.util.Scanner;


public class B11_1_LeerSiNo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean seguir = Validador.leerSiNo(sc, "Seguir? (s/n): ");
        System.out.println("Respondiste: " + seguir);

        sc.close();
    }
}
