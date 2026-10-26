// Futbol.java
abstract class Jugador {
    protected String nombre;

    Jugador(String nombre) {
        this.nombre = nombre;
    }

    void presentar() {                  // ya esta hecho: lo heredan todos
        System.out.println("Soy " + nombre);
    }

    abstract void jugar();                 // pendiente: cada hijo lo hace a su manera
}

interface Sancionable {
    void sancionar();                         // solo la promesa, sin cuerpo
}

class Delantero extends Jugador implements Sancionable {
    Delantero(String nombre) {
        super(nombre);
    }

    void jugar() {
        System.out.println(nombre + " remata al arco");
    }

    public void sancionar() {
        System.out.println(nombre + " recibe tarjeta amarilla");
    }
}

class Portero extends Jugador {
    Portero(String nombre) {
        super(nombre);
    }

    void jugar() {
        System.out.println(nombre + " ataja un penal");
    }
}

// Entrenador NO es un Jugador, pero tambien cumple el contrato Sancionable
class Entrenador implements Sancionable {
    private String nombre;

    Entrenador(String nombre) {
        this.nombre = nombre;
    }

    public void sancionar() {
        System.out.println(nombre + " recibe tarjeta roja desde el banco");
    }
}

public class Futbol {
    public static void main(String[] args) {
        // new Jugador("x");   // ERROR: Jugador es abstracta, no se puede instanciar

        Jugador[] grupo = { new Delantero("Alexis"), new Portero("Bravo") };
        for (Jugador p : grupo) {
            p.presentar();
            p.jugar();
        }

        Sancionable[] lista = { new Delantero("Alexis"), new Entrenador("Bielsa") };
        for (Sancionable x : lista) {
            x.sancionar();
        }
    }
}
