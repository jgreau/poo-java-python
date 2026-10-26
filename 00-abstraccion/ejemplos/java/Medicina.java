// Medicina.java
abstract class Profesional {
    protected String nombre;

    Profesional(String nombre) {
        this.nombre = nombre;
    }

    void presentar() {                  // ya esta hecho: lo heredan todos
        System.out.println("Soy " + nombre);
    }

    abstract void atender();                 // pendiente: cada hijo lo hace a su manera
}

interface Cobrable {
    void cobrar();                         // solo la promesa, sin cuerpo
}

class Medico extends Profesional implements Cobrable {
    Medico(String nombre) {
        super(nombre);
    }

    void atender() {
        System.out.println(nombre + " revisa al paciente y receta un tratamiento");
    }

    public void cobrar() {
        System.out.println(nombre + " cobra 25000 por la consulta");
    }
}

class Enfermero extends Profesional {
    Enfermero(String nombre) {
        super(nombre);
    }

    void atender() {
        System.out.println(nombre + " toma la presion y registra los signos vitales");
    }
}

// ExamenDeSangre NO es un Profesional, pero tambien cumple el contrato Cobrable
class ExamenDeSangre implements Cobrable {
    private String nombre;

    ExamenDeSangre(String nombre) {
        this.nombre = nombre;
    }

    public void cobrar() {
        System.out.println(nombre + " cuesta 15000 mas el laboratorio");
    }
}

public class Medicina {
    public static void main(String[] args) {
        // new Profesional("x");   // ERROR: Profesional es abstracta, no se puede instanciar

        Profesional[] grupo = { new Medico("Dra. Soto"), new Enfermero("Luis") };
        for (Profesional p : grupo) {
            p.presentar();
            p.atender();
        }

        Cobrable[] lista = { new Medico("Dra. Soto"), new ExamenDeSangre("Examen de sangre") };
        for (Cobrable x : lista) {
            x.cobrar();
        }
    }
}
