/*
 * Delfin.java - LA OTRA JERARQUIA
 *
 * Es un Mamifero, no un Ave. No comparte NINGUN ancestro con el pato
 * salvo Animal. Y aun asi cabe en la misma lista de Nadador que el pato.
 *
 * Eso es lo que la herencia sola no puede hacer.
 */
public class Delfin extends Mamifero implements Nadador {

    public Delfin(String nombre, int edad) {
        super(nombre, edad, false);
    }

    @Override public String sonido() { return "Click click"; }

    // --- contrato Nadador ---
    @Override public void nadar() {
        System.out.println("   " + nombre + " cruza la bahia a toda velocidad");
    }
    @Override public double velocidadEnAgua() { return 40.0; }
}
