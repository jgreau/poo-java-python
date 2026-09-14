import java.util.Arrays;

public class B8_2_Invertir {
    public static void main(String[] args) {
        int[] numeros = {10, 20, 30, 40, 50};
        System.out.println("Original:  " + Arrays.toString(numeros));

        // 1. Solo imprimir al reves: el arreglo queda igual
        System.out.print("Impreso al reves: ");
        for (int i = numeros.length - 1; i >= 0; i--) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println();
        System.out.println("Sigue igual: " + Arrays.toString(numeros));

        // 2. Invertirlo de verdad: solo la MITAD de las vueltas
        for (int i = 0; i < numeros.length / 2; i++) {
            int auxiliar = numeros[i];
            numeros[i] = numeros[numeros.length - 1 - i];
            numeros[numeros.length - 1 - i] = auxiliar;
        }

        System.out.println("Invertido: " + Arrays.toString(numeros));
    }
}
