/*
 * Luigi.java - salta mas alto que nadie
 *
 * No firma ninguna interfaz: es "solo" un Personaje.
 * Sirve para que se vea que implementar interfaces es OPCIONAL.
 */
public class Luigi extends Personaje {

    public Luigi(int x) {
        super("Luigi", x, 4, 8);
    }

    @Override
    public void habilidadEspecial() {
        System.out.println("   Luigi: salto altisimo (" + salto + "), pero resbala al frenar");
    }
}
