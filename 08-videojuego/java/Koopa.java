/*
 * Koopa.java - tortuga con caparazon
 *
 * Es Aplastable, pero no muere: se esconde en el caparazon.
 * Fijate en que el resultado del pisoton es DISTINTO al del Goomba,
 * aunque los dos firmen el mismo contrato. Eso es polimorfismo.
 */
public class Koopa extends Enemigo implements Aplastable {

    public Koopa(String nombre, int x, int danio) {
        super(nombre, x, danio);
    }

    public Koopa(int x) {
        this("Koopa", x, 1);      // constructor sobrecargado
    }

    @Override
    public void atacar() {
        System.out.println("   Koopa avanza y se da vuelta en los bordes");
    }

    // --- contrato Aplastable ---
    @Override
    public void recibirPisoton() {
        System.out.println("      Koopa se esconde en su caparazon");
    }

    @Override
    public int puntosQueDa() { return 200; }
}
