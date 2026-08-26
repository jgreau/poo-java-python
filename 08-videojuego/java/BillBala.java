/*
 * BillBala.java - el proyectil
 *
 * Volador, pero NO Aplastable: es de metal y va a toda velocidad.
 * Junto con el Spiny demuestra que "ser enemigo" y "poder ser pisado"
 * son dos cosas independientes.
 *
 * Ademas hace mas danio que el resto: 2 en vez de 1.
 */
public class BillBala extends Enemigo implements Volador {

    public BillBala(int x) {
        super("BillBala", x, 2);
    }

    @Override
    public void atacar() {
        System.out.println("   BillBala sale disparada del canion sin desviarse");
    }

    // --- contrato Volador ---
    @Override
    public void volar() {
        System.out.println("   BillBala vuela recto, sin frenar nunca");
    }

    @Override
    public int alturaVuelo() { return 4; }
}
