/*
 * Vehiculo.java - LA CLASE PADRE (superclase)
 *
 * Con los archivos separados se ve mejor por que existe "protected":
 * es un permiso que cruza de ESTE archivo a los archivos de los hijos.
 *
 *   private   -> solo Vehiculo.java
 *   protected -> Vehiculo.java + Auto.java + Moto.java (los hijos)
 *   public    -> todo el mundo
 */
public class Vehiculo {

    // protected = privado para el mundo, visible para los hijos
    protected String modelo;
    protected int anio;
    protected int velocidad;

    public Vehiculo(String modelo, int anio) {
        this.modelo = modelo;
        this.anio = anio;
        this.velocidad = 0;
    }

    public void acelerar() {
        this.velocidad += 20;
        System.out.println(this.modelo + " acelera a " + this.velocidad + " km/h");
    }

    public void describir() {
        System.out.println("Vehiculo generico: " + this.modelo + " (" + this.anio + ")");
    }
}
