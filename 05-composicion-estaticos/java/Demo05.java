/*
 * DEMO 05 - COMPOSICION Y MIEMBROS ESTATICOS
 *
 * Compilar y ejecutar:
 *     javac *.java
 *     java Demo05
 *
 * Tres archivos:
 *     Alumno.java   con atributos de objeto Y de clase (static)
 *     Curso.java    contiene alumnos (composicion)
 *     Demo05.java   el programa   <- estas aqui
 */
public class Demo05 {
    public static void main(String[] args) {

        System.out.println("Alumnos creados hasta ahora: " + Alumno.getTotalCreados());

        Alumno a1 = new Alumno("Camila", 6.5);
        Alumno a2 = new Alumno("Benjamin", 4.2);
        Alumno a3 = new Alumno("Sofia", 5.8);

        System.out.println("Alumnos creados hasta ahora: " + Alumno.getTotalCreados());
        System.out.println("El contador es UNO SOLO, compartido por todos los objetos.");

        System.out.println("--- COMPOSICION: el curso CONTIENE alumnos ---");
        Curso poo = new Curso("Programacion Orientada a Objetos", "Sala 204");
        poo.inscribir(a1);
        poo.inscribir(a2);
        poo.inscribir(a3);
        poo.listar();

        System.out.printf("Promedio del curso: %.2f%n", poo.promedio());
        System.out.println("Cantidad inscritos: " + poo.cantidadAlumnos());

        System.out.println("--- Un metodo del curso que recorre sus alumnos ---");
        poo.mostrarAprobados(4.0);

        System.out.println("--- CONSTANTE de clase (static final) ---");
        System.out.println("Colegio: " + Alumno.COLEGIO);
        // Alumno.COLEGIO = "Otro";   // ERROR: cannot assign a value to final variable

        System.out.println("--- METODO ESTATICO: se llama sin crear objeto ---");
        System.out.println("¿4.0 aprueba? " + Alumno.aprueba(4.0));
        System.out.println("¿3.9 aprueba? " + Alumno.aprueba(3.9));
    }
}
