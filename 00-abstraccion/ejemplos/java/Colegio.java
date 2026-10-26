// Colegio.java
abstract class Persona {
    protected String nombre;

    Persona(String nombre) {
        this.nombre = nombre;
    }

    void presentar() {                  // ya esta hecho: lo heredan todos
        System.out.println("Soy " + nombre);
    }

    abstract void participar();                 // pendiente: cada hijo lo hace a su manera
}

interface Evaluable {
    void evaluar();                         // solo la promesa, sin cuerpo
}

class Alumno extends Persona implements Evaluable {
    Alumno(String nombre) {
        super(nombre);
    }

    void participar() {
        System.out.println(nombre + " levanta la mano y responde");
    }

    public void evaluar() {
        System.out.println(nombre + " recibe nota 6.5");
    }
}

class Profesor extends Persona {
    Profesor(String nombre) {
        super(nombre);
    }

    void participar() {
        System.out.println(nombre + " explica el contenido en la pizarra");
    }
}

// Proyecto NO es un Persona, pero tambien cumple el contrato Evaluable
class Proyecto implements Evaluable {
    private String nombre;

    Proyecto(String nombre) {
        this.nombre = nombre;
    }

    public void evaluar() {
        System.out.println(nombre + " recibe nota 6.0");
    }
}

public class Colegio {
    public static void main(String[] args) {
        // new Persona("x");   // ERROR: Persona es abstracta, no se puede instanciar

        Persona[] grupo = { new Alumno("Camila"), new Profesor("Sr. Rojas") };
        for (Persona p : grupo) {
            p.presentar();
            p.participar();
        }

        Evaluable[] lista = { new Alumno("Camila"), new Proyecto("Proyecto de ciencias") };
        for (Evaluable x : lista) {
            x.evaluar();
        }
    }
}
