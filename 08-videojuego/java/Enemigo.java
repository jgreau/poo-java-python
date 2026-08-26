/*
 * Enemigo.java - RAMA 2 de la jerarquia
 *
 * OJO A LO QUE NO ESTA AQUI: no hay ningun recibirPisoton().
 *
 * Parece el lugar natural para ponerlo, y es justo la trampa: el Spiny
 * y la Bill Bala son enemigos a los que NO se les puede saltar encima.
 * Ese metodo vive en la interfaz Aplastable, y cada enemigo decide si
 * la firma o no.
 */
public abstract class Enemigo extends Entidad {

    protected int danio;

    public Enemigo(String nombre, int x, int danio) {
        super(nombre, x);
        this.danio = danio;
    }

    @Override
    public String getTipo() { return "Enemigo"; }

    // Todos los enemigos atacan, cada uno a su manera
    public abstract void atacar();

    public int getDanio() { return danio; }
}
