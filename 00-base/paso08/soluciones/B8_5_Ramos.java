import java.util.ArrayList;
import java.util.Scanner;


public class B8_5_Ramos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> ramos = new ArrayList<>();
        int opcion;

        do {
            System.out.println();
            System.out.println("1) Agregar ramo");
            System.out.println("2) Listar ramos");
            System.out.println("3) Cuantos ramos");
            System.out.println("4) Borrar el primero");
            System.out.println("5) Buscar un ramo");
            System.out.println("0) Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();                     // el Enter que dejo nextInt

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del ramo: ");
                    ramos.add(sc.nextLine());
                    System.out.println("Agregado");
                    break;
                case 2:
                    for (int i = 0; i < ramos.size(); i++) {
                        System.out.println("  " + (i + 1) + ". " + ramos.get(i));
                    }
                    break;
                case 3:
                    System.out.println("Tienes " + ramos.size() + " ramos");
                    break;
                case 4:
                    if (ramos.isEmpty()) {
                        System.out.println("No hay nada que borrar");
                    } else {
                        System.out.println("Borrado: " + ramos.remove(0));
                    }
                    break;
                case 5:
                    System.out.print("Que ramo buscas? ");
                    String buscado = sc.nextLine();
                    System.out.println(ramos.contains(buscado) ? "Si lo tienes" : "No lo tienes");
                    break;
                case 0:
                    System.out.println("Chao");
                    break;
                default:
                    System.out.println("Esa opcion no existe");
            }
        } while (opcion != 0);

        sc.close();
    }
}
