/*
 * Pinguino.java - EL ARGUMENTO CENTRAL DE TODA LA DEMO
 *
 * Es un Ave. Nada mejor que muchos peces. Y NO VUELA.
 *
 * Si volar() estuviera dentro de la clase Ave, el pinguino estaria
 * obligado a heredarlo, y habria que rellenarlo con algo falso
 * ("no hago nada", lanzar un error, devolver 0...).
 *
 * Al estar en la interfaz Volador, el pinguino simplemente NO LA FIRMA.
 * Compara la primera linea de este archivo con la de Pato.java.
 */
public class Pinguino extends Ave implements Nadador {

    public Pinguino(String nombre, int edad) {
        super(nombre, edad, 5000);
    }

    @Override public String sonido() { return "Kua"; }

    // --- contrato Nadador ---
    @Override public void nadar() {
        System.out.println("   " + nombre + " se desliza bajo el hielo");
    }
    @Override public double velocidadEnAgua() { return 12.0; }
}
