/**
 * Repartidor en moto. GRUPO 5 (Reparto).
 *
 * <p>Hija concreta de {@link Repartidor}. Ademas de responder lo abstracto,
 * SOBRESCRIBE {@code montoACobrar()}, que en el padre ya venia escrito:
 * cuando llueve cobra mas caro.</p>
 *
 * <p><b>Para compilar solo lo suyo, sin esperar a los demas grupos:</b><br>
 * {@code javac Cobrable.java Calificable.java Repartidor.java RepartidorMoto.java RepartidorBici.java}</p>
 *
 * <p>Un metodo que declara {@code return} y no lo tiene NO COMPILA. Mientras
 * trabajan, dejen un {@code return 0;} provisorio para poder ir compilando.</p>
 */
public class RepartidorMoto extends Repartidor {

    private boolean llueve;

    /**
     * Contrata un repartidor en moto con buen tiempo.
     *
     * <p>SOBRECARGA corta: llamen al otro constructor con {@code this(...)}.</p>
     *
     * @param nombre como se llama
     */
    public RepartidorMoto(String nombre) {
        // TODO G5
    }

    /**
     * Contrata un repartidor en moto indicando el clima.
     *
     * @param nombre como se llama
     * @param llueve {@code true} si esta lloviendo, lo que encarece el despacho
     */
    public RepartidorMoto(String nombre, boolean llueve) {
        super(nombre);
        // TODO G5
    }

    /** @return $2500 */
    @Override
    public double tarifaBase() {
        // TODO G5
    }

    /** @return siempre {@code "MOTO"} */
    @Override
    public String vehiculo() {
        // TODO G5
    }

    /**
     * Contrato {@link Cobrable}, sobrescrito para cobrar la lluvia.
     *
     * <p>No repitan la formula del padre: llamenla con
     * {@code super.montoACobrar()} y sumenle encima.</p>
     *
     * @return lo del padre, mas $1000 si esta lloviendo
     */
    @Override
    public double montoACobrar() {
        // TODO G5
    }
}
