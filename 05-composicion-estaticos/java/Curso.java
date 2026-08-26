/*
 * Curso.java - COMPOSICION
 *
 * Un Curso TIENE alumnos. No "es un" alumno: por eso NO hay herencia
 * aqui, sino un atributo que guarda otros objetos.
 *
 *   herencia    ->  ES UN    (Auto es un Vehiculo)
 *   composicion ->  TIENE UN (Curso tiene Alumnos)
 *
 * Esa pregunta, hecha en voz alta, resuelve el 90% de las dudas de diseno.
 */
import java.util.ArrayList;

public class Curso {

    private String nombre;
    private String sala;

    // COMPOSICION: este atributo guarda OTROS OBJETOS
    private ArrayList<Alumno> alumnos;

    public Curso(String nombre, String sala) {
        this.nombre = nombre;
        this.sala = sala;
        this.alumnos = new ArrayList<>();   // nace vacia, no null
    }

    public void inscribir(Alumno alumno) {
        this.alumnos.add(alumno);
        System.out.println(alumno.getNombre() + " inscrito en " + this.nombre);
    }

    public int cantidadAlumnos() {
        return this.alumnos.size();
    }

    public double promedio() {
        if (alumnos.isEmpty()) return 0;
        double suma = 0;
        for (Alumno a : alumnos) {
            suma += a.getNota();
        }
        return suma / alumnos.size();
    }

    public void listar() {
        System.out.println("Curso: " + nombre + " (" + sala + ")");
        for (Alumno a : alumnos) {
            System.out.printf("   - %-10s %.1f%n", a.getNombre(), a.getNota());
        }
    }

    public void mostrarAprobados(double minimo) {
        for (Alumno a : alumnos) {
            if (a.getNota() >= minimo) {
                System.out.println("   APROBADO: " + a.getNombre());
            } else {
                System.out.println("   reprobado: " + a.getNombre());
            }
        }
    }
}
