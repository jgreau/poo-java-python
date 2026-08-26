/*
 * Auto.java - CLASE HIJA
 *
 * "extends Vehiculo" se lee: un Auto ES UN Vehiculo.
 * Si no puedes decir "ES UN" en voz alta, probablemente no es herencia.
 *
 * Fijate que este archivo NO importa nada: Vehiculo esta en la misma
 * carpeta, o sea en el mismo paquete.
 */
public class Auto extends Vehiculo {

    private int puertas;   // atributo que el padre NO tiene

    public Auto(String modelo, int anio, int puertas) {
        super(modelo, anio);      // llama al constructor del padre. SIEMPRE primero.
        this.puertas = puertas;
    }

    @Override                     // avisa al compilador: estoy reemplazando el del padre
    public void describir() {
        System.out.println("Auto " + this.modelo + " (" + this.anio + "), "
                           + this.puertas + " puertas");
    }

    public void abrirMaletero() {        // metodo exclusivo de Auto
        System.out.println(this.modelo + ": maletero abierto");
    }
}
