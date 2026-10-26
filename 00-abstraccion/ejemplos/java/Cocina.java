// Cocina.java
abstract class Plato {
    protected String nombre;

    Plato(String nombre) {
        this.nombre = nombre;
    }

    void presentar() {                  // ya esta hecho: lo heredan todos
        System.out.println("Soy " + nombre);
    }

    abstract void preparar();                 // pendiente: cada hijo lo hace a su manera
}

interface Calentable {
    void calentar();                         // solo la promesa, sin cuerpo
}

class Sopa extends Plato implements Calentable {
    Sopa(String nombre) {
        super(nombre);
    }

    void preparar() {
        System.out.println(nombre + " hierve el zapallo y lo muele");
    }

    public void calentar() {
        System.out.println(nombre + " se calienta a fuego lento");
    }
}

class Ensalada extends Plato {
    Ensalada(String nombre) {
        super(nombre);
    }

    void preparar() {
        System.out.println(nombre + " corta tomate y cebolla");
    }
}

// Cafe NO es un Plato, pero tambien cumple el contrato Calentable
class Cafe implements Calentable {
    private String nombre;

    Cafe(String nombre) {
        this.nombre = nombre;
    }

    public void calentar() {
        System.out.println(nombre + " se calienta en la maquina");
    }
}

public class Cocina {
    public static void main(String[] args) {
        // new Plato("x");   // ERROR: Plato es abstracta, no se puede instanciar

        Plato[] grupo = { new Sopa("Sopa de zapallo"), new Ensalada("Ensalada chilena") };
        for (Plato p : grupo) {
            p.presentar();
            p.preparar();
        }

        Calentable[] lista = { new Sopa("Sopa de zapallo"), new Cafe("Cafe de grano") };
        for (Calentable x : lista) {
            x.calentar();
        }
    }
}
