// ConClases.java
class Heroe {
    String nombre;
    int vida;
    int ataque;

    Heroe(String nombre, int vida, int ataque) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
    }

    void atacar(Heroe objetivo) {
        objetivo.vida = objetivo.vida - ataque;
        System.out.println(nombre + " ataca a " + objetivo.nombre
                + ". Vida de " + objetivo.nombre + ": " + objetivo.vida);
    }
}

public class ConClases {
    public static void main(String[] args) {
        Heroe luna  = new Heroe("Luna", 100, 12);
        Heroe tomas = new Heroe("Tomas", 120, 9);
        Heroe sofia = new Heroe("Sofia", 80, 15);

        luna.atacar(tomas);
        sofia.atacar(tomas);
        tomas.atacar(luna);
    }
}
