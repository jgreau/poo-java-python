/*
 * Entidad.java - LA RAIZ DE TODO
 *
 * Todo lo que existe en el nivel es una Entidad: los personajes, los
 * enemigos y los objetos. Lo unico que de verdad comparten es que
 * tienen un nombre y estan en alguna parte del mapa.
 *
 * Por eso Entidad guarda MUY POCO. Es un error clasico de principiante
 * meterle a la clase raiz cosas como vidas, danio o puntos: las monedas
 * no tienen vidas y Mario no hace danio por existir.
 *
 *   ¿Que va en la raiz?  Solo lo que TODOS tienen, sin excepcion.
 */
public abstract class Entidad {

    protected String nombre;
    protected int x;              // posicion en el nivel

    public Entidad(String nombre, int x) {
        this.nombre = nombre;
        this.x = x;
    }

    // Cada rama de la jerarquia dice que clase de cosa es
    public abstract String getTipo();

    public String getNombre() { return this.nombre; }
    public int getX()         { return this.x; }

    public void describir() {
        String etiqueta = "[" + getTipo() + "]";
        System.out.printf("%-12s %-12s en x=%d%n", etiqueta, nombre, x);
    }
}
