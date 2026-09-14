import java.util.Arrays;
import java.util.Scanner;


public class B8_6_SinRepetidos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[5];
        int guardados = 0;

        while (guardados < numeros.length) {
            System.out.print("Numero " + (guardados + 1) + ": ");
            int numero = sc.nextInt();

            boolean repetido = false;
            for (int i = 0; i < guardados; i++) {      // solo lo ya guardado
                if (numeros[i] == numero) {
                    repetido = true;
                    break;
                }
            }

            if (repetido) {
                System.out.println("   El " + numero + " ya esta en la lista");
            } else {
                numeros[guardados] = numero;
                guardados++;
            }
        }

        System.out.println(Arrays.toString(numeros));
        sc.close();
    }
}
