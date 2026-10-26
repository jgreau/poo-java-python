// Musica.java
abstract class Instrumento {
    protected String nombre;

    Instrumento(String nombre) {
        this.nombre = nombre;
    }

    void presentar() {                  // ya esta hecho: lo heredan todos
        System.out.println("Soy " + nombre);
    }

    abstract void tocar();                 // pendiente: cada hijo lo hace a su manera
}

interface Amplificable {
    void amplificar();                         // solo la promesa, sin cuerpo
}

class Guitarra extends Instrumento implements Amplificable {
    Guitarra(String nombre) {
        super(nombre);
    }

    void tocar() {
        System.out.println(nombre + " rasguea un acorde de mi menor");
    }

    public void amplificar() {
        System.out.println(nombre + " se conecta al amplificador y suena fuerte");
    }
}

class Piano extends Instrumento {
    Piano(String nombre) {
        super(nombre);
    }

    void tocar() {
        System.out.println(nombre + " toca una escala de do mayor");
    }
}

// Microfono NO es un Instrumento, pero tambien cumple el contrato Amplificable
class Microfono implements Amplificable {
    private String nombre;

    Microfono(String nombre) {
        this.nombre = nombre;
    }

    public void amplificar() {
        System.out.println(nombre + " capta la voz y la manda al parlante");
    }
}

public class Musica {
    public static void main(String[] args) {
        // new Instrumento("x");   // ERROR: Instrumento es abstracta, no se puede instanciar

        Instrumento[] grupo = { new Guitarra("Guitarra electrica"), new Piano("Piano de cola") };
        for (Instrumento p : grupo) {
            p.presentar();
            p.tocar();
        }

        Amplificable[] lista = { new Guitarra("Guitarra electrica"), new Microfono("Microfono") };
        for (Amplificable x : lista) {
            x.amplificar();
        }
    }
}
