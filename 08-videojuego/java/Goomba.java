/*
 * Goomba.java - el enemigo mas basico
 *
 * Enemigo + Aplastable. El caso normal, el que sirve de referencia
 * para entender por que el Spiny es la excepcion.
 */
public class Goomba extends Enemigo implements Aplastable {

    public Goomba(int x) {
        super("Goomba", x, 1);
    }

    @Override
    public void atacar() {
        System.out.println("   Goomba camina de frente sin pensarlo mucho");
    }

    // --- contrato Aplastable ---
    @Override
    public void recibirPisoton() {
        System.out.println("      Goomba queda aplastado y desaparece");
    }

    @Override
    public int puntosQueDa() { return 100; }
}
