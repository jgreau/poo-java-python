/**
 * Pago con tarjeta, que puede venir en cuotas. GRUPO 4 (Pagos).
 *
 * <p>Hija concreta de la abstracta {@link MedioPago}. Lo unico que tiene que
 * decir es EN QUE SE DIFERENCIA: cobra recargo por cuotas. La boleta, el IVA
 * y el titular los hereda gratis.</p>
 *
 * <p><b>Para compilar solo lo suyo, sin esperar a los demas grupos:</b><br>
 * {@code javac Producto.java Facturable.java MedioPago.java Tarjeta.java Efectivo.java}</p>
 *
 * <p>Un metodo que declara {@code return} y no lo tiene NO COMPILA. Mientras
 * trabajan, dejen un {@code return 0;} provisorio para poder ir compilando.</p>
 */
public class Tarjeta extends MedioPago {

    private int cuotas;

    /**
     * Tarjeta en una sola cuota.
     *
     * <p>SOBRECARGA corta: llamen al otro constructor con {@code this(...)}.</p>
     *
     * @param titular a nombre de quien va la boleta
     * @param monto   el neto a pagar
     */
    public Tarjeta(String titular, double monto) {
        // TODO G4
    }

    /**
     * Tarjeta en la cantidad de cuotas indicada.
     *
     * @param titular a nombre de quien va la boleta
     * @param monto   el neto a pagar
     * @param cuotas  en cuantas cuotas, de 1 a 12
     * @throws IllegalArgumentException si las cuotas estan fuera de 1 a 12
     */
    public Tarjeta(String titular, double monto, int cuotas) {
        super(titular, monto);
        // TODO G4
    }

    /**
     * El recargo por pagar en cuotas.
     *
     * @return 0 si es una sola cuota; si no, el 2% del monto por cada cuota
     */
    @Override
    public double recargo() {
        // TODO G4
    }

    /** @return algo como {@code "TARJETA 3 cuota(s)"} */
    @Override
    public String nombreMedio() {
        // TODO G4
    }
}
