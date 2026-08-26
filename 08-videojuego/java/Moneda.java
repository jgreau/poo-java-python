/*
 * Moneda.java
 *
 * Fijate en la firma del metodo: recolectar(Personaje quien).
 * El objeto recibe al personaje y le aplica su efecto. Cada
 * Recolectable hace algo COMPLETAMENTE distinto con el mismo llamado.
 */
public class Moneda extends Objeto implements Recolectable {

    public Moneda(int x) {
        super("Moneda", x);
    }

    // --- contrato Recolectable ---
    @Override
    public void recolectar(Personaje quien) {
        quien.sumarMonedas(1);
        quien.sumarPuntos(50);
        System.out.println("      +1 moneda (lleva " + quien.getMonedas() + ")");
    }

    @Override
    public String efecto() { return "+1 moneda, +50 puntos"; }
}
