/**
 * Con que se paga un pedido. GRUPO 4 (Pagos).
 *
 * <p>LA SEGUNDA CLASE ABSTRACTA DEL SISTEMA, y la escribe un grupo.</p>
 *
 * <p>Cumple {@link Facturable}, el contrato del GRUPO 3. Fijense en la
 * division del trabajo: los dos metodos de ese contrato se escriben UNA sola
 * vez, aqui, y lo que de verdad cambia entre una tarjeta y el efectivo (el
 * recargo) queda abstracto. Las hijas solo rellenan aquello en lo que se
 * diferencian.</p>
 *
 * <p>El banco de pruebas intenta hacer {@code new MedioPago(...)} por
 * reflexion y ESPERA que falle con {@code InstantiationException}.</p>
 *
 * <p><b>Para compilar solo lo suyo, sin esperar a los demas grupos:</b><br>
 * {@code javac Producto.java Facturable.java MedioPago.java Tarjeta.java Efectivo.java}</p>
 *
 * <p>Un metodo que declara {@code return} y no lo tiene NO COMPILA. Mientras
 * trabajan, dejen un {@code return 0;} provisorio para poder ir compilando.</p>
 */
public abstract class MedioPago implements Facturable {

    /** El IVA chileno, 19%. Constante: {@code static final}. */
    public static final double IVA = 0.19;

    private String titular;
    private double monto;

    /**
     * Prepara un medio de pago por un monto determinado.
     *
     * @param titular a nombre de quien va la boleta
     * @param monto   el neto a pagar, sin IVA ni recargos
     * @throws IllegalArgumentException si el monto es negativo
     */
    public MedioPago(String titular, double monto) {
        // TODO G4
    }

    /**
     * Lo que este medio de pago cobra por encima del neto.
     *
     * <p>ABSTRACTO: es lo unico que de verdad diferencia a una tarjeta de un
     * pago en efectivo, asi que cada hija esta obligada a responderlo.</p>
     *
     * @return el recargo en pesos
     */
    public abstract double recargo();

    /**
     * Como se llama este medio de pago en la boleta.
     *
     * @return por ejemplo {@code "EFECTIVO"} o {@code "TARJETA 3 cuota(s)"}
     */
    public abstract String nombreMedio();

    /** @return a nombre de quien va la boleta */
    public String getTitular() {
        // TODO G4
    }

    /** @return el neto a pagar, sin IVA ni recargos */
    public double getMonto() {
        // TODO G4
    }

    /**
     * Contrato {@link Facturable}, del GRUPO 3.
     *
     * <p>Calcula {@code (monto + recargo()) * (1 + IVA)}. Fijense en que
     * llama a {@code recargo()}, que en esta clase todavia no existe: cuando
     * el programa corra, respondera la hija concreta. Eso es polimorfismo.</p>
     *
     * @return el total a pagar con IVA incluido
     */
    @Override
    public double totalConIVA() {
        // TODO G4
    }

    /**
     * Contrato {@link Facturable}, del GRUPO 3.
     *
     * <p>Se escribe una sola vez aqui y lo heredan Tarjeta y Efectivo. Para
     * formatear los montos usen {@link Producto#pesos(double)}.</p>
     *
     * @return una linea como
     *         {@code BOLETA | TARJETA 3 cuota(s) | Camila | neto $10000 | recargo $600 | TOTAL $12614}
     */
    @Override
    public String detalleBoleta() {
        // TODO G4
    }
}
