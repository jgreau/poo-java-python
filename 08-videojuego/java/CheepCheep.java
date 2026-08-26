/*
 * CheepCheep.java - el pez
 *
 * Enemigo + Nadador. Y Mario tambien es Nadador, aunque sea un
 * Personaje: dos ramas distintas firmando el mismo contrato.
 *
 * Tampoco es Aplastable: en el agua no se le puede saltar encima.
 */
public class CheepCheep extends Enemigo implements Nadador {

    public CheepCheep(int x) {
        super("CheepCheep", x, 1);
    }

    @Override
    public void atacar() {
        System.out.println("   CheepCheep nada en zigzag hacia el jugador");
    }

    // --- contrato Nadador ---
    @Override
    public void nadar() {
        System.out.println("   CheepCheep se mueve rapido bajo el agua");
    }

    @Override
    public int profundidadMaxima() { return 30; }
}
