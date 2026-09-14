import java.util.Scanner;

/*
 * PASO 06 - REPETIR CON while
 *
 * Compilar y ejecutar:
 *     javac Paso06While.java
 *     java Paso06While
 *
 * Idea clave: while repite MIENTRAS la condicion se cumpla. Se usa cuando
 * no sabes cuantas vueltas vas a dar: validar un dato, un menu.
 * Si nada adentro cambia la condicion, no termina nunca (Ctrl+C lo corta).
 */
public class Paso06While {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Contar
        int i = 1;
        while (i <= 5) {
            System.out.println("Vuelta " + i);
            i++;                       // sin esta linea, no termina nunca
        }

        // 2. Validar: pedir otra vez MIENTRAS el dato este malo
        System.out.print("Ingresa una nota (1.0 a 7.0): ");
        double nota = sc.nextDouble();
        while (nota < 1.0 || nota > 7.0) {
            System.out.print("Nota invalida. Otra vez: ");
            nota = sc.nextDouble();
        }
        System.out.println("Nota aceptada: " + nota);

        // 3. do-while: el cuerpo corre al menos UNA vez, ideal para un menu
        int opcion;
        do {
            System.out.println();
            System.out.println("1) Saludar");
            System.out.println("2) Contar hasta 3");
            System.out.println("0) Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1: System.out.println("Hola!"); break;
                case 2: System.out.println("1, 2, 3"); break;
                case 0: System.out.println("Chao"); break;
                default: System.out.println("Esa opcion no existe");
            }
        } while (opcion != 0);

        sc.close();
    }
}
