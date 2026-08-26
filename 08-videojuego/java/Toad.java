/*
 * Toad.java - el mas rapido, el que peor salta
 */
public class Toad extends Personaje {

    public Toad(int x) {
        super("Toad", x, 8, 3);
    }

    @Override
    public void habilidadEspecial() {
        System.out.println("   Toad: velocidad " + velocidad + ", corre mas que nadie");
    }
}
