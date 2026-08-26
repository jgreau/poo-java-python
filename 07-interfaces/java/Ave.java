/*
 * Ave.java - PRIMERA RAMA de la jerarquia
 *
 * OJO A LO QUE NO ESTA AQUI: no hay ningun metodo volar().
 * Parece el lugar obvio para ponerlo... hasta que aparece el pinguino.
 */
public abstract class Ave extends Animal {

    protected int cantidadPlumas;

    public Ave(String nombre, int edad, int cantidadPlumas) {
        super(nombre, edad);
        this.cantidadPlumas = cantidadPlumas;
    }

    @Override
    public String getGrupo() {
        return "Ave";
    }
}
