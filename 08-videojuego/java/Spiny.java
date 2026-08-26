/*
 * Spiny.java - EL ARGUMENTO CENTRAL DE LA DEMO
 *
 * Es un Enemigo. Camina como el Goomba. Y esta cubierto de puas.
 *
 * Compara esta primera linea con la de Goomba.java:
 *
 *    public class Goomba extends Enemigo implements Aplastable
 *    public class Spiny  extends Enemigo
 *
 * Esa diferencia de dos palabras es toda la leccion. Si pisas un Spiny,
 * el que sale herido eres tu, y el compilador ya lo sabe: no lo puedes
 * meter en un Aplastable[] ni por error.
 */
public class Spiny extends Enemigo {

    public Spiny(int x) {
        super("Spiny", x, 1);
    }

    @Override
    public void atacar() {
        System.out.println("   Spiny avanza erizado de puas");
    }
}
