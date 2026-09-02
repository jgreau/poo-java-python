/**
 * Una bebida de la barra. GRUPO 2 (Barra y combos).
 *
 * <p>ES un {@link Producto} y cumple {@link Preparable}, el contrato que
 * escribe el GRUPO 1. Si el G1 cambia la firma de ese contrato, esta clase
 * deja de compilar: ese es exactamente el punto del taller.</p>
 *
 * <p><b>Para compilar solo lo suyo, sin esperar a los demas grupos:</b><br>
 * {@code javac Producto.java Preparable.java Descontable.java Bebida.java Combo.java}</p>
 *
 * <p>Un metodo que declara {@code return} y no lo tiene NO COMPILA. Mientras
 * trabajan, dejen un {@code return 0;} provisorio para poder ir compilando.</p>
 */
public class Bebida extends Producto implements Preparable {

    private int mililitros;
    private boolean conHielo;

    /**
     * Crea una bebida sin hielo.
     *
     * <p>SOBRECARGA corta: llamen al otro constructor con {@code this(...)}.</p>
     *
     * @param nombre     el nombre de la bebida
     * @param precioBase el precio hasta 500 cc
     * @param mililitros el tamano en centimetros cubicos
     */
    public Bebida(String nombre, double precioBase, int mililitros) {
        // TODO G2
    }

    /**
     * Crea una bebida indicando si va con hielo.
     *
     * @param nombre     el nombre de la bebida
     * @param precioBase el precio hasta 500 cc
     * @param mililitros el tamano en centimetros cubicos; tiene que ser mayor que cero
     * @param conHielo   {@code true} si se sirve con hielo, lo que demora un minuto mas
     * @throws IllegalArgumentException si los mililitros no son mas de cero
     */
    public Bebida(String nombre, double precioBase, int mililitros, boolean conHielo) {
        super(nombre, precioBase);
        // TODO G2
    }

    /**
     * El precio base, con un recargo de $500 si pasa de 500 cc.
     *
     * @return el precio final en pesos
     */
    @Override
    public double calcularPrecio() {
        // TODO G2
    }

    /**
     * Sobrescribe la version del padre para mostrar el tamano y el hielo.
     *
     * @return algo como {@code Bebida Limonada 750cc con hielo - $3000}
     */
    @Override
    public String describir() {
        // TODO G2
    }

    /**
     * Contrato {@link Preparable}, del GRUPO 1.
     *
     * @return 2 minutos si lleva hielo, 1 si no
     */
    @Override
    public int minutosPreparacion() {
        // TODO G2
    }

    /**
     * Contrato {@link Preparable}, del GRUPO 1.
     *
     * @return siempre {@code "BARRA"}
     */
    @Override
    public String estacionCocina() {
        // TODO G2
    }
}
