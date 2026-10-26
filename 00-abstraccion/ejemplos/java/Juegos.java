// Juegos.java
abstract class Personaje {
    protected String nombre;

    Personaje(String nombre) {
        this.nombre = nombre;
    }

    void presentar() {                  // ya esta hecho: lo heredan todos
        System.out.println("Soy " + nombre);
    }

    abstract void atacar();                 // pendiente: cada hijo lo hace a su manera
}

interface Volador {
    void volar();                         // solo la promesa, sin cuerpo
}

class Mago extends Personaje implements Volador {
    Mago(String nombre) {
        super(nombre);
    }

    void atacar() {
        System.out.println(nombre + " lanza una bola de fuego");
    }

    public void volar() {
        System.out.println(nombre + " vuela sobre el campo de batalla");
    }
}

class Guerrero extends Personaje {
    Guerrero(String nombre) {
        super(nombre);
    }

    void atacar() {
        System.out.println(nombre + " golpea con su espada");
    }
}

// Dragon NO es un Personaje, pero tambien cumple el contrato Volador
class Dragon implements Volador {
    private String nombre;

    Dragon(String nombre) {
        this.nombre = nombre;
    }

    public void volar() {
        System.out.println(nombre + " vuela y escupe fuego");
    }
}

public class Juegos {
    public static void main(String[] args) {
        // new Personaje("x");   // ERROR: Personaje es abstracta, no se puede instanciar

        Personaje[] grupo = { new Mago("Merlina"), new Guerrero("Thor") };
        for (Personaje p : grupo) {
            p.presentar();
            p.atacar();
        }

        Volador[] lista = { new Mago("Merlina"), new Dragon("Smaug") };
        for (Volador x : lista) {
            x.volar();
        }
    }
}
