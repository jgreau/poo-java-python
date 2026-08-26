/*
 * Objeto.java - RAMA 3 de la jerarquia
 *
 * Todo lo que esta en el nivel y no es personaje ni enemigo.
 *
 * Y otra vez la misma decision: recolectar() NO esta aqui. Vive en la
 * interfaz Recolectable, porque el Bloque es un Objeto que no se recoge.
 */
public abstract class Objeto extends Entidad {

    public Objeto(String nombre, int x) {
        super(nombre, x);
    }

    @Override
    public String getTipo() { return "Objeto"; }
}
