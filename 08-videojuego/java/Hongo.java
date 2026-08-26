public class Hongo extends Objeto implements Recolectable {

    public Hongo(int x) {
        super("Hongo", x);
    }

    // --- contrato Recolectable ---
    @Override
    public void recolectar(Personaje quien) {
        // El hongo no sabe como se crece: le pide al personaje que crezca.
        // El personaje es el unico dueno de su propio estado.
        quien.crecer();
        quien.sumarPuntos(1000);
        System.out.println("      +1000 puntos (ahora esta " + quien.getEstado() + ")");
    }

    @Override
    public String efecto() { return "crecer a GRANDE, +1000 puntos"; }
}
