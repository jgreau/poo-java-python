/**
 * Pago en efectivo, contra entrega. GRUPO 4 (Pagos).
 *
 * <p>La otra hija de {@link MedioPago}: sin recargo, pero calcula vuelto.
 * Con dos hijas ya se puede recorrer un {@code MedioPago[]} polimorfico.</p>
 *
 * <p><b>Para compilar solo lo suyo, sin esperar a los demas grupos:</b><br>
 * {@code javac Producto.java Facturable.java MedioPago.java Tarjeta.java Efectivo.java}</p>
 *
 * <p>Un metodo que declara {@code return} y no lo tiene NO COMPILA. Mientras
 * trabajan, dejen un {@code return 0;} provisorio para poder ir compilando.</p>
 */
public class Efectivo extends MedioPago {

    private double conQuePaga;

    /**
     * Prepara un pago en efectivo.
     *
     * @param titular    a nombre de quien va la boleta
     * @param monto      el neto a pagar
     * @param conQuePaga con cuanta plata paga el cliente
     */
    public Efectivo(String titular, double monto, double conQuePaga) {
        super(titular, monto);
        // TODO G4
    }

    /**
     * @return siempre 0: el efectivo no tiene recargo
     */
    @Override
    public double recargo() {
        // TODO G4
    }

    /** @return siempre {@code "EFECTIVO"} */
    @Override
    public String nombreMedio() {
        // TODO G4
    }

    /**
     * El vuelto que hay que devolverle al cliente.
     *
     * <p>Metodo propio, que no existe en el padre: solo un pago en efectivo
     * tiene vuelto.</p>
     *
     * @return lo que pago menos el total con IVA, o 0 si no alcanzo a cubrirlo
     */
    public double vuelto() {
        // TODO G4
    }
}
