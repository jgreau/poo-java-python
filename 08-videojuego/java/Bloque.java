/*
 * Bloque.java - EL SPINY DE LOS OBJETOS
 *
 * Es un Objeto del nivel, pero no se recoge: es parte del decorado.
 *
 * Compara con Moneda.java:
 *
 *    public class Moneda extends Objeto implements Recolectable
 *    public class Bloque extends Objeto
 *
 * Si recolectar() estuviera dentro de la clase Objeto, el Bloque
 * tendria que fingir que se deja recoger. Al estar en la interfaz,
 * simplemente no la firma.
 *
 * Esta clase existe para que la interfaz Recolectable se gane su lugar:
 * si TODOS los objetos fueran recolectables, la interfaz sobraria y
 * bastaria con la clase Objeto.
 */
public class Bloque extends Objeto {

    private boolean golpeado;

    public Bloque(int x) {
        super("Bloque", x);
        this.golpeado = false;
    }

    public void golpear() {
        if (golpeado) {
            System.out.println("      El bloque ya estaba golpeado");
            return;
        }
        this.golpeado = true;
        System.out.println("      El bloque suelta una moneda y se apaga");
    }
}
