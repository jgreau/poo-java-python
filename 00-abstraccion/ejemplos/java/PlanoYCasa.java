// PlanoYCasa.java
class Casa {                            // el PLANO
    String direccion;                   // atributos: lo que la casa TIENE
    int pisos;
    boolean luzEncendida;

    Casa(String direccion, int pisos) {
        this.direccion = direccion;
        this.pisos = pisos;
        this.luzEncendida = false;
    }

    void encenderLuz() {                // metodos: lo que la casa HACE
        luzEncendida = true;
        System.out.println("Luz encendida en " + direccion);
    }

    void describir() {
        System.out.println(direccion + ": " + pisos + " piso(s), luz "
                + (luzEncendida ? "encendida" : "apagada"));
    }
}

public class PlanoYCasa {
    public static void main(String[] args) {
        Casa a = new Casa("Los Olmos 123", 2);   // una CASA real (objeto)
        Casa b = new Casa("Las Rosas 45", 1);    // otra casa, del mismo plano

        a.encenderLuz();
        a.describir();
        b.describir();                           // la luz de b sigue apagada
    }
}
