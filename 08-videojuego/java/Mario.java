/*
 * Mario.java - el equilibrado, y ademas sabe nadar
 *
 *   extends Personaje    <- lo que ES
 *   implements Nadador   <- lo que SABE HACER
 *
 * Que un PERSONAJE firme Nadador es lo que hace interesante la demo:
 * el CheepCheep, que es un ENEMIGO, firma exactamente el mismo contrato.
 */
public class Mario extends Personaje implements Nadador {

    public Mario(int x) {
        super("Mario", x, 5, 5);
    }

    @Override
    public void habilidadEspecial() {
        System.out.println("   Mario: equilibrado en todo, sin puntos debiles");
    }

    // --- contrato Nadador ---
    @Override
    public void nadar() {
        System.out.println("   Mario bucea con soltura");
    }

    @Override
    public int profundidadMaxima() { return 20; }
}
