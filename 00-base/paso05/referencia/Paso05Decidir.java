import java.util.Scanner;

/*
 * PASO 05 - DECIDIR: if, else, switch
 *
 * Compilar y ejecutar:
 *     javac Paso05Decidir.java
 *     java Paso05Decidir
 *
 * Idea clave: la condicion va SIEMPRE entre parentesis y el bloque entre
 * llaves. Y los textos se comparan con equals(), nunca con ==.
 */
public class Paso05Decidir {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. if / else if / else: se ejecuta SOLO el primero que se cumple
        System.out.print("Ingresa tu nota (1.0 a 7.0): ");
        double nota = sc.nextDouble();
        sc.nextLine();

        if (nota < 1.0 || nota > 7.0) {
            System.out.println("Esa nota no existe");
        } else if (nota >= 4.0) {
            System.out.println("Aprobado");
        } else {
            System.out.println("Reprobado");
        }

        // 2. Comparar textos: equals, NUNCA ==
        System.out.print("Clave: ");
        String clave = sc.nextLine();

        if (clave.equals("duoc")) {
            System.out.println("Bienvenido");
        } else {
            System.out.println("Clave incorrecta");
        }

        // 3. switch: cuando se elige entre valores exactos
        System.out.print("Dia de la semana (1 a 7): ");
        int dia = sc.nextInt();

        switch (dia) {
            case 1: System.out.println("Lunes"); break;
            case 2: System.out.println("Martes"); break;
            case 3: System.out.println("Miercoles"); break;
            case 4: System.out.println("Jueves"); break;
            case 5: System.out.println("Viernes"); break;
            case 6:
            case 7: System.out.println("Fin de semana"); break;
            default: System.out.println("Ese dia no existe");
        }

        sc.close();
    }
}
