public class Estrella extends Objeto implements Recolectable {

    public Estrella(int x) {
        super("Estrella", x);
    }

    // --- contrato Recolectable ---
    @Override
    public void recolectar(Personaje quien) {
        quien.sumarPuntos(2000);
        System.out.println("      " + quien.getNombre() + " suma 2000 puntos");
    }

    @Override
    public String efecto() { return "+2000 puntos"; }

    /*
     * NOTA: en el juego real la estrella da invencibilidad, y eso es
     * otro ESTADO del personaje, como PEQUENO/GRANDE. No esta implementado
     * a proposito: es el ejercicio E8.5.
     *
     * Fijate que el codigo no promete nada que no cumpla. Un metodo que
     * dice "invencible" y no hace nada es peor que uno que no lo dice.
     */
}
