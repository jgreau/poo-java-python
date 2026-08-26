/*
 * Pato.java - hereda de UNA clase, firma DOS contratos
 *
 *   extends Ave                  <- lo que ES     (uno solo)
 *   implements Nadador, Volador  <- lo que SABE HACER (los que sean)
 */
public class Pato extends Ave implements Nadador, Volador {

    public Pato(String nombre, int edad) {
        super(nombre, edad, 3000);
    }

    @Override public String sonido() { return "Cuac"; }

    // --- contrato Nadador ---
    @Override public void nadar() {
        System.out.println("   " + nombre + " chapotea en la laguna");
    }
    @Override public double velocidadEnAgua() { return 8.0; }

    // --- contrato Volador ---
    @Override public void volar() {
        System.out.println("   " + nombre + " levanta vuelo");
    }
    @Override public int alturaMaxima() { return 1000; }
}
