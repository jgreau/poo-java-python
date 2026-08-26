/*
 * Paratroopa.java - EL CUARTO NIVEL DE LA JERARQUIA
 *
 *   Entidad -> Enemigo -> Koopa -> Paratroopa
 *
 * Dos cosas que vale la pena mirar con calma:
 *
 * 1) NO dice "implements Aplastable" en ninguna parte, y sin embargo
 *    LO ES: lo heredo de Koopa. Los contratos tambien se heredan.
 *
 * 2) Sobrescribe recibirPisoton() para hacer lo que hace en el juego:
 *    pierde las alas y se convierte en un Koopa normal.
 */
public class Paratroopa extends Koopa implements Volador {

    public Paratroopa(int x) {
        super("Paratroopa", x, 1);
    }

    @Override
    public void atacar() {
        System.out.println("   Paratroopa rebota acercandose por el aire");
    }

    @Override
    public void recibirPisoton() {
        System.out.println("      Paratroopa pierde las alas y cae como Koopa");
    }

    // --- contrato Volador ---
    @Override
    public void volar() {
        System.out.println("   Paratroopa revolotea dando saltos");
    }

    @Override
    public int alturaVuelo() { return 5; }
}
