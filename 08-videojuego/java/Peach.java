/*
 * Peach.java - la que flota
 *
 *   extends Personaje    <- lo que ES
 *   implements Volador   <- lo que SABE HACER
 *
 * Peach va a aparecer en el mismo Volador[] que el Paratroopa y la
 * Bill Bala, que son enemigos. Una princesa y un proyectil en la misma
 * lista, unidos solo por saber mantenerse en el aire.
 */
public class Peach extends Personaje implements Volador {

    public Peach(int x) {
        super("Peach", x, 4, 6);
    }

    @Override
    public void habilidadEspecial() {
        System.out.println("   Peach: puede quedarse flotando en el aire");
    }

    // --- contrato Volador ---
    @Override
    public void volar() {
        System.out.println("   Peach flota suavemente con su vestido");
    }

    @Override
    public int alturaVuelo() { return 3; }
}
