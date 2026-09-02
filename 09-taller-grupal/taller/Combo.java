/**
 * Un combo que junta varios productos con descuento. GRUPO 2 (Barra y combos).
 *
 * <p>LA CLASE MAS INTERESANTE DEL TALLER: ES un {@link Producto} (herencia)
 * y ademas TIENE Productos adentro (composicion).</p>
 *
 * <p>El combo no sabe si le pusieron una pizza, un sushi o una bebida: llama a
 * {@code calcularPrecio()} y cada uno responde lo suyo. Eso es POLIMORFISMO
 * ocurriendo dentro de una clase de alumno, no solo en el main.</p>
 *
 * <p>Cumple {@link Preparable}, del GRUPO 1, y {@link Descontable}, el suyo propio.</p>
 *
 * <p><b>Para compilar solo lo suyo, sin esperar a los demas grupos:</b><br>
 * {@code javac Producto.java Preparable.java Descontable.java Bebida.java Combo.java}</p>
 *
 * <p>Un metodo que declara {@code return} y no lo tiene NO COMPILA. Mientras
 * trabajan, dejen un {@code return 0;} provisorio para poder ir compilando.</p>
 */
public class Combo extends Producto implements Preparable, Descontable {

    private Producto[] items;
    private int cantidad;
    private double porcentajeDescuento;

    /** El descuento con el que nace todo combo. Constante: {@code static final}. */
    public static final double DESCUENTO_COMBO = 15.0;

    /**
     * Crea un combo vacio, con capacidad para 6 productos.
     *
     * <p>El combo no tiene precio propio, por eso le pasa 0 al padre: su precio
     * sale de lo que le vayan metiendo adentro.</p>
     *
     * @param nombre el nombre del combo
     */
    public Combo(String nombre) {
        super(nombre, 0);
        // TODO G2
    }

    /**
     * Mete un producto en el combo.
     *
     * @param p el producto a agregar, de cualquier subclase
     * @throws IllegalStateException si el combo ya esta lleno
     */
    public void agregar(Producto p) {
        // TODO G2
    }

    /** @return cuantos productos tiene el combo adentro */
    public int getCantidad() {
        // TODO G2
    }

    /**
     * La suma de los productos que tiene adentro, con el descuento aplicado.
     *
     * <p>EL CORAZON DEL EJERCICIO: recorran los items sumando
     * {@code calcularPrecio()}. No hace falta ni un solo {@code if}
     * preguntando de que clase es cada uno.</p>
     *
     * @return el precio final del combo en pesos
     */
    @Override
    public double calcularPrecio() {
        // TODO G2
    }

    /**
     * Sobrescribe la version del padre para listar lo que trae el combo.
     *
     * @return algo como {@code Combo Familiar [Napolitana + California + Limonada] - $24041}
     */
    @Override
    public String describir() {
        // TODO G2
    }

    /**
     * Contrato {@link Preparable}, del GRUPO 1.
     *
     * <p>Devuelve el mayor tiempo de los items que sean Preparable, mas 3
     * minutos de armado. Cuidado: no todos los productos lo son, hay que
     * preguntar con {@code instanceof} antes de castear.</p>
     *
     * @return los minutos que demora el combo completo
     */
    @Override
    public int minutosPreparacion() {
        // TODO G2
    }

    /**
     * Contrato {@link Preparable}, del GRUPO 1.
     *
     * @return siempre {@code "ARMADO"}
     */
    @Override
    public String estacionCocina() {
        // TODO G2
    }

    /**
     * Contrato {@link Descontable}, propio del GRUPO 2.
     *
     * @param porcentaje cuanto se descuenta, de 0 a 100
     * @return el precio del combo ya con el descuento nuevo
     * @throws IllegalArgumentException si el porcentaje esta fuera de 0 a 100
     */
    @Override
    public double aplicarDescuento(double porcentaje) {
        // TODO G2
    }

    /**
     * Contrato {@link Descontable}, propio del GRUPO 2.
     *
     * @return {@code true} si el descuento vigente es mayor que cero
     */
    @Override
    public boolean tieneDescuento() {
        // TODO G2
    }
}
