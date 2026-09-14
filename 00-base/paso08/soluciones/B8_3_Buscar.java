import java.util.Scanner;


public class B8_3_Buscar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = {10, 20, 30, 40, 50, 60};

        System.out.print("Buscar: ");
        int buscado = sc.nextInt();

        int posicion = -1;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == buscado) {
                posicion = i;
                break;
            }
        }

        if (posicion == -1) {
            System.out.println("No esta en la lista");
        } else {
            System.out.println("Encontrado en la posicion " + posicion
                    + " (el " + (posicion + 1) + "o)");
        }

        sc.close();
    }
}
