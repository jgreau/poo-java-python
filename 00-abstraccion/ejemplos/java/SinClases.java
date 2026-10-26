// SinClases.java
public class SinClases {
    public static void main(String[] args) {
        // Tres personajes de un juego, con variables sueltas
        String nombre1 = "Luna";   int vida1 = 100;   int ataque1 = 12;
        String nombre2 = "Tomas";  int vida2 = 120;   int ataque2 = 9;
        String nombre3 = "Sofia";   int vida3 = 80;    int ataque3 = 15;

        // Luna ataca a Tomas
        vida2 = vida2 - ataque1;
        System.out.println(nombre1 + " ataca a " + nombre2 + ". Vida de " + nombre2 + ": " + vida2);

        // Sofia ataca a Tomas
        vida2 = vida2 - ataque3;
        System.out.println(nombre3 + " ataca a " + nombre2 + ". Vida de " + nombre2 + ": " + vida2);

        // Tomas ataca a Luna
        vida1 = vida1 - ataque2;
        System.out.println(nombre2 + " ataca a " + nombre1 + ". Vida de " + nombre1 + ": " + vida1);
    }
}
