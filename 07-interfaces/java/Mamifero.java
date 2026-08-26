/*
 * Mamifero.java - SEGUNDA RAMA de la jerarquia
 *
 * Un Mamifero y un Ave no tienen NADA en comun salvo ser Animal.
 * Y sin embargo, un delfin y un pato saben hacer lo mismo: nadar.
 * Ese "y sin embargo" es la razon de existir de las interfaces.
 */
public abstract class Mamifero extends Animal {

    protected boolean tienePelaje;

    public Mamifero(String nombre, int edad, boolean tienePelaje) {
        super(nombre, edad);
        this.tienePelaje = tienePelaje;
    }

    @Override
    public String getGrupo() {
        return "Mamifero";
    }
}
