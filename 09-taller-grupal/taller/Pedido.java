/**
 * El pedido de un cliente. GRUPO 3 (Pedido).
 *
 * <p>La unica clase del sistema que NO hereda de {@link Producto}, y la que
 * usa el trabajo de todos los demas. Cumple {@link Descontable}, el contrato
 * del GRUPO 2, y es duena de {@link Facturable}, que cumple el GRUPO 4.</p>
 *
 * <p>En este archivo viven cuatro conceptos a la vez:</p>
 * <ul>
 *   <li>COMPOSICION: el pedido TIENE productos</li>
 *   <li>POLIMORFISMO: el for suma sin preguntar de que clase es cada item</li>
 *   <li>SOBRECARGA: {@code agregar()} dos veces, {@code calcularTotal()} tres</li>
 *   <li>STATIC: el numero de pedido sale de un contador compartido</li>
 * </ul>
 *
 * <p><b>Para compilar solo lo suyo, sin esperar a los demas grupos:</b><br>
 * {@code javac Producto.java Descontable.java Cobrable.java Pedido.java}</p>
 *
 * <p>Un metodo que declara {@code return} y no lo tiene NO COMPILA. Mientras
 * trabajan, dejen un {@code return 0;} provisorio para poder ir compilando.</p>
 */
public class Pedido implements Descontable {

    /** Cuantos pedidos lleva el programa. Es UNO SOLO para todos los objetos. */
    private static int contador = 0;

    /** El numero de este pedido. Es {@code final}: se asigna una vez y no cambia mas. */
    private final int numero;

    private String cliente;
    private Producto[] items;
    private int cantidad;
    private double porcentajeDescuento;

    /**
     * Abre un pedido vacio con capacidad para 20 productos.
     *
     * <p>Sube el contador {@code static} y usa ese valor como numero de este
     * pedido. Cuidado: {@code numero} es {@code final}, hay que asignarlo si o
     * si dentro del constructor.</p>
     *
     * @param cliente a nombre de quien va el pedido
     * @throws IllegalArgumentException si el cliente es nulo o vacio
     */
    public Pedido(String cliente) {
        // TODO G3
    }

    /**
     * Agrega un producto al pedido.
     *
     * <p>SOBRECARGA corta: reutiliza la otra version.</p>
     *
     * @param p el producto, de cualquier subclase
     */
    public void agregar(Producto p) {
        // TODO G3
    }

    /**
     * Agrega el mismo producto varias veces.
     *
     * @param p     el producto, de cualquier subclase
     * @param veces cuantas unidades agregar; tiene que ser mayor que cero
     * @throws IllegalArgumentException si el producto es nulo o las veces no son mas de cero
     * @throws IllegalStateException    si ya no caben mas productos en el pedido
     */
    public void agregar(Producto p, int veces) {
        // TODO G3
    }

    /**
     * El total del pedido con su descuento vigente.
     *
     * <p>EL FOR POLIMORFICO, lo mas importante del taller: se suma
     * {@code items[i].calcularPrecio()} y ese metodo esta escrito por cuatro
     * grupos distintos, sin que este archivo necesite saber cual es cual.</p>
     *
     * @return el total en pesos
     */
    public double calcularTotal() {
        // TODO G3
    }

    /**
     * El total mas una propina.
     *
     * <p>SOBRECARGA 2: mismo nombre, otro parametro.</p>
     *
     * @param propina lo que se deja de propina, nunca negativo
     * @return el total con propina
     * @throws IllegalArgumentException si la propina es negativa
     */
    public double calcularTotal(double propina) {
        // TODO G3
    }

    /**
     * El total mas el costo del despacho.
     *
     * <p>SOBRECARGA 3, y la mas interesante: fijense en el tipo del parametro,
     * es una INTERFAZ y no una clase. Al pedido no le importa si reparte una
     * moto o una bicicleta, solo exige que sepa cobrar.</p>
     *
     * @param despacho quien hace la entrega
     * @return el total con el despacho sumado
     * @throws IllegalArgumentException si el despacho es nulo
     */
    public double calcularTotal(Cobrable despacho) {
        // TODO G3
    }

    /**
     * El pedido completo en varias lineas: encabezado, un item por linea y el total.
     *
     * @return el detalle listo para imprimir en pantalla
     */
    public String detalle() {
        // TODO G3
    }

    /** @return el numero correlativo de este pedido */
    public int getNumero() {
        // TODO G3
    }

    /** @return el nombre del cliente */
    public String getCliente() {
        // TODO G3
    }

    /** @return cuantos productos tiene el pedido */
    public int getCantidad() {
        // TODO G3
    }

    /**
     * Cuantos pedidos lleva el programa completo, no este objeto.
     *
     * @return el valor del contador {@code static}
     */
    public static int getPedidosEmitidos() {
        // TODO G3
    }

    /**
     * Contrato {@link Descontable}, del GRUPO 2.
     *
     * @param porcentaje cuanto se descuenta, de 0 a 100
     * @return el total ya rebajado
     * @throws IllegalArgumentException si el porcentaje esta fuera de 0 a 100
     */
    @Override
    public double aplicarDescuento(double porcentaje) {
        // TODO G3
    }

    /**
     * Contrato {@link Descontable}, del GRUPO 2.
     *
     * @return {@code true} si el pedido tiene algun descuento aplicado
     */
    @Override
    public boolean tieneDescuento() {
        // TODO G3
    }

    /** @return una linea corta con el numero, la cantidad de items y el total */
    @Override
    public String toString() {
        // TODO G3
    }
}
