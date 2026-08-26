/*
 * Moto.java - OTRA CLASE HIJA
 *
 * Hereda de lo mismo que Auto, pero resuelve describir() a su manera.
 * Ese es el germen del polimorfismo (demo 04).
 */
public class Moto extends Vehiculo {

    private boolean tieneCarenado;

    public Moto(String modelo, int anio, boolean tieneCarenado) {
        super(modelo, anio);
        this.tieneCarenado = tieneCarenado;
    }

    @Override
    public void describir() {
        String extra = this.tieneCarenado ? "con carenado" : "sin carenado";
        System.out.println("Moto " + this.modelo + " (" + this.anio + "), " + extra);
    }

    public void hacerCaballito() {
        System.out.println(this.modelo + ": caballito!");
    }
}
