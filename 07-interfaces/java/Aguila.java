/*
 * Aguila.java - Ave que vuela pero NO nada
 *
 * Junto con el pinguino demuestra que las dos capacidades son
 * independientes entre si, e independientes de la jerarquia.
 */
public class Aguila extends Ave implements Volador {

    public Aguila(String nombre, int edad) {
        super(nombre, edad, 7000);
    }

    @Override public String sonido() { return "Screech"; }

    // --- contrato Volador ---
    @Override public void volar() {
        System.out.println("   " + nombre + " planea sobre la cordillera");
    }
    @Override public int alturaMaxima() { return 6000; }
}
