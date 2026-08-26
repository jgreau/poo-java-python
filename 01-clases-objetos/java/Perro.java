/*
 * Perro.java - LA CLASE (el molde)
 *
 * REGLA DE ORO DE JAVA:
 *   un archivo .java = una clase publica, y el nombre del archivo
 *   tiene que ser EXACTAMENTE igual al de la clase.
 *   Perro.java  ->  public class Perro
 *
 * Esta clase no se ejecuta sola: no tiene main(). Es solo el molde.
 */
public class Perro {

    // ATRIBUTOS: los datos que cada perro tiene por separado
    public String nombre;
    public String raza;
    public int edad;

    // CONSTRUCTOR: se ejecuta al crear cada objeto con "new"
    // "this.nombre" = el atributo del objeto.  "nombre" = el parametro.
    public Perro(String nombre, String raza, int edad) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
    }

    // METODOS: las cosas que el perro sabe hacer
    public void ladrar() {
        System.out.println(this.nombre + " dice: Guau!");
    }

    public void cumplirAnios() {
        this.edad = this.edad + 1;
        System.out.println(this.nombre + " ahora tiene " + this.edad + " anios.");
    }

    public void presentarse() {
        System.out.println("Soy " + nombre + ", un " + raza + " de " + edad + " anios.");
    }
}
