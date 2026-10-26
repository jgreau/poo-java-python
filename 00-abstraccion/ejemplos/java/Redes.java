// Redes.java
abstract class Publicacion {
    protected String nombre;

    Publicacion(String nombre) {
        this.nombre = nombre;
    }

    void presentar() {                  // ya esta hecho: lo heredan todos
        System.out.println("Soy " + nombre);
    }

    abstract void mostrar();                 // pendiente: cada hijo lo hace a su manera
}

interface Compartible {
    void compartir();                         // solo la promesa, sin cuerpo
}

class Foto extends Publicacion implements Compartible {
    Foto(String nombre) {
        super(nombre);
    }

    void mostrar() {
        System.out.println(nombre + " se muestra en pantalla completa");
    }

    public void compartir() {
        System.out.println(nombre + " se comparte con 120 personas");
    }
}

class Video extends Publicacion {
    Video(String nombre) {
        super(nombre);
    }

    void mostrar() {
        System.out.println(nombre + " se reproduce en bucle");
    }
}

// Perfil NO es un Publicacion, pero tambien cumple el contrato Compartible
class Perfil implements Compartible {
    private String nombre;

    Perfil(String nombre) {
        this.nombre = nombre;
    }

    public void compartir() {
        System.out.println(nombre + " se comparte con 300 seguidores");
    }
}

public class Redes {
    public static void main(String[] args) {
        // new Publicacion("x");   // ERROR: Publicacion es abstracta, no se puede instanciar

        Publicacion[] grupo = { new Foto("Foto del atardecer"), new Video("Video de la fiesta") };
        for (Publicacion p : grupo) {
            p.presentar();
            p.mostrar();
        }

        Compartible[] lista = { new Foto("Foto del atardecer"), new Perfil("Perfil de Ana") };
        for (Compartible x : lista) {
            x.compartir();
        }
    }
}
