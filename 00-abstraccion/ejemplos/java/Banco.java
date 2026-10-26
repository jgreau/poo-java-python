// Banco.java
abstract class Cuenta {
    protected String nombre;

    Cuenta(String nombre) {
        this.nombre = nombre;
    }

    void presentar() {                  // ya esta hecho: lo heredan todos
        System.out.println("Soy " + nombre);
    }

    abstract void cobrarMantencion();                 // pendiente: cada hijo lo hace a su manera
}

interface Auditable {
    void auditar();                         // solo la promesa, sin cuerpo
}

class CuentaCorriente extends Cuenta implements Auditable {
    CuentaCorriente(String nombre) {
        super(nombre);
    }

    void cobrarMantencion() {
        System.out.println(nombre + " cobra 3000 de mantencion");
    }

    public void auditar() {
        System.out.println(nombre + " entrega su historial al auditor");
    }
}

class CuentaAhorro extends Cuenta {
    CuentaAhorro(String nombre) {
        super(nombre);
    }

    void cobrarMantencion() {
        System.out.println(nombre + " no cobra mantencion");
    }
}

// Transferencia NO es un Cuenta, pero tambien cumple el contrato Auditable
class Transferencia implements Auditable {
    private String nombre;

    Transferencia(String nombre) {
        this.nombre = nombre;
    }

    public void auditar() {
        System.out.println(nombre + " entrega su registro al auditor");
    }
}

public class Banco {
    public static void main(String[] args) {
        // new Cuenta("x");   // ERROR: Cuenta es abstracta, no se puede instanciar

        Cuenta[] grupo = { new CuentaCorriente("Cuenta corriente 001"), new CuentaAhorro("Cuenta de ahorro 002") };
        for (Cuenta p : grupo) {
            p.presentar();
            p.cobrarMantencion();
        }

        Auditable[] lista = { new CuentaCorriente("Cuenta corriente 001"), new Transferencia("Transferencia 9001") };
        for (Auditable x : lista) {
            x.auditar();
        }
    }
}
