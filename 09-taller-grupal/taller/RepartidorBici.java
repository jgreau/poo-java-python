/**
 * Repartidor en bicicleta. GRUPO 5 (Reparto).
 *
 * <p>La otra hija de {@link Repartidor}: mas barata y no le afecta la lluvia.
 * NO sobrescribe {@code montoACobrar()}, se conforma con lo que hereda.
 * Comparen las dos hijas: ahi esta toda la herencia en dos archivos.</p>
 *
 * <p><b>Para compilar solo lo suyo, sin esperar a los demas grupos:</b><br>
 * {@code javac Cobrable.java Calificable.java Repartidor.java RepartidorMoto.java RepartidorBici.java}</p>
 *
 * <p>Un metodo que declara {@code return} y no lo tiene NO COMPILA. Mientras
 * trabajan, dejen un {@code return 0;} provisorio para poder ir compilando.</p>
 */
public class RepartidorBici extends Repartidor {

    /**
     * Contrata un repartidor en bicicleta.
     *
     * @param nombre como se llama
     */
    public RepartidorBici(String nombre) {
        super(nombre);
        // TODO G5
    }

    /** @return $1500 */
    @Override
    public double tarifaBase() {
        // TODO G5
    }

    /** @return siempre {@code "BICICLETA"} */
    @Override
    public String vehiculo() {
        // TODO G5
    }
}
