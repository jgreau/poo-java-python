// Transporte.java
abstract class Vehiculo {
    protected String nombre;

    Vehiculo(String nombre) {
        this.nombre = nombre;
    }

    void presentar() {                  // ya esta hecho: lo heredan todos
        System.out.println("Soy " + nombre);
    }

    abstract void entregar();                 // pendiente: cada hijo lo hace a su manera
}

interface Rastreable {
    void ubicar();                         // solo la promesa, sin cuerpo
}

class Camion extends Vehiculo implements Rastreable {
    Camion(String nombre) {
        super(nombre);
    }

    void entregar() {
        System.out.println(nombre + " lleva 20 cajas por carretera");
    }

    public void ubicar() {
        System.out.println(nombre + " reporta su GPS: ruta 5 sur");
    }
}

class Moto extends Vehiculo {
    Moto(String nombre) {
        super(nombre);
    }

    void entregar() {
        System.out.println(nombre + " entrega un sobre en 10 minutos");
    }
}

// Paquete NO es un Vehiculo, pero tambien cumple el contrato Rastreable
class Paquete implements Rastreable {
    private String nombre;

    Paquete(String nombre) {
        this.nombre = nombre;
    }

    public void ubicar() {
        System.out.println(nombre + " reporta su GPS: bodega central");
    }
}

public class Transporte {
    public static void main(String[] args) {
        // new Vehiculo("x");   // ERROR: Vehiculo es abstracta, no se puede instanciar

        Vehiculo[] grupo = { new Camion("Camion 7"), new Moto("Moto 3") };
        for (Vehiculo p : grupo) {
            p.presentar();
            p.entregar();
        }

        Rastreable[] lista = { new Camion("Camion 7"), new Paquete("Paquete 55") };
        for (Rastreable x : lista) {
            x.ubicar();
        }
    }
}
