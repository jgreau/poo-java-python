// Arquitectura.java
abstract class Edificio {
    protected String nombre;

    Edificio(String nombre) {
        this.nombre = nombre;
    }

    void presentar() {                  // ya esta hecho: lo heredan todos
        System.out.println("Soy " + nombre);
    }

    abstract void construir();                 // pendiente: cada hijo lo hace a su manera
}

interface Certificable {
    void certificar();                         // solo la promesa, sin cuerpo
}

class Vivienda extends Edificio implements Certificable {
    Vivienda(String nombre) {
        super(nombre);
    }

    void construir() {
        System.out.println(nombre + " levanta muros y techo de dos aguas");
    }

    public void certificar() {
        System.out.println(nombre + " recibe el certificado de recepcion final");
    }
}

class Torre extends Edificio {
    Torre(String nombre) {
        super(nombre);
    }

    void construir() {
        System.out.println(nombre + " levanta 40 pisos con grua");
    }
}

// Puente NO es un Edificio, pero tambien cumple el contrato Certificable
class Puente implements Certificable {
    private String nombre;

    Puente(String nombre) {
        this.nombre = nombre;
    }

    public void certificar() {
        System.out.println(nombre + " recibe el certificado de ingenieria");
    }
}

public class Arquitectura {
    public static void main(String[] args) {
        // new Edificio("x");   // ERROR: Edificio es abstracta, no se puede instanciar

        Edificio[] grupo = { new Vivienda("Casa de Maipu"), new Torre("Torre Central") };
        for (Edificio p : grupo) {
            p.presentar();
            p.construir();
        }

        Certificable[] lista = { new Vivienda("Casa de Maipu"), new Puente("Puente Bicentenario") };
        for (Certificable x : lista) {
            x.certificar();
        }
    }
}
