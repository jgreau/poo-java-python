// Mascotas.java
abstract class Animal {
    protected String nombre;

    Animal(String nombre) {
        this.nombre = nombre;
    }

    void presentar() {                  // ya esta hecho: lo heredan todos
        System.out.println("Soy " + nombre);
    }

    abstract void hacerSonido();                 // pendiente: cada hijo lo hace a su manera
}

interface Adiestrable {
    void adiestrar();                         // solo la promesa, sin cuerpo
}

class Perro extends Animal implements Adiestrable {
    Perro(String nombre) {
        super(nombre);
    }

    void hacerSonido() {
        System.out.println(nombre + " dice guau");
    }

    public void adiestrar() {
        System.out.println(nombre + " aprende a sentarse");
    }
}

class Gato extends Animal {
    Gato(String nombre) {
        super(nombre);
    }

    void hacerSonido() {
        System.out.println(nombre + " dice miau");
    }
}

// RoboMascota NO es un Animal, pero tambien cumple el contrato Adiestrable
class RoboMascota implements Adiestrable {
    private String nombre;

    RoboMascota(String nombre) {
        this.nombre = nombre;
    }

    public void adiestrar() {
        System.out.println(nombre + " aprende a dar la pata");
    }
}

public class Mascotas {
    public static void main(String[] args) {
        // new Animal("x");   // ERROR: Animal es abstracta, no se puede instanciar

        Animal[] grupo = { new Perro("Rocky"), new Gato("Michi") };
        for (Animal p : grupo) {
            p.presentar();
            p.hacerSonido();
        }

        Adiestrable[] lista = { new Perro("Rocky"), new RoboMascota("Robo-Fido") };
        for (Adiestrable x : lista) {
            x.adiestrar();
        }
    }
}
