/*
 * Animal.java - CLASE ABSTRACTA (la jerarquia)
 *
 * Esto es lo que un animal ES. Tiene ESTADO compartido (nombre, edad)
 * y comportamiento comun (presentarse). Por eso es una clase abstracta
 * y no una interfaz.
 */
public abstract class Animal {

    protected String nombre;
    protected int edad;

    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Cada especie hace su ruido
    public abstract String sonido();

    // Cada rama de la jerarquia dice a que grupo pertenece
    public abstract String getGrupo();

    public String getNombre() {
        return this.nombre;
    }

    public void presentarse() {
        System.out.println(getClass().getSimpleName() + " " + nombre
                           + " es un " + getGrupo() + ", dice: " + sonido());
    }
}
