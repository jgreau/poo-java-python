/**
 * La raiz del sistema. Todo lo que se vende en el delivery es un Producto.
 *
 * <p>ESTE ARCHIVO LO ENTREGA EL PROFESOR. NINGUN GRUPO LO MODIFICA.</p>
 *
 * <p>Es una clase ABSTRACTA: define lo que todo producto tiene (nombre y
 * precio base) pero se niega a decir como se calcula el precio final, porque
 * eso depende de si es una pizza, un sushi, una bebida o un combo. Cada grupo
 * responde esa pregunta a su manera.</p>
 *
 * <p>No se puede hacer {@code new Producto(...)}: el compilador lo prohibe.
 * Esta clase tambien es el modelo de como se documenta el resto del taller:
 * cada metodo lleva su Javadoc con {@code @param}, {@code @return} y
 * {@code @throws}.</p>
 */
public abstract class Producto {

    private String nombre;
    private double precioBase;

    /** Cuantos productos se han creado en todo el programa. Es UNO SOLO para todas las hijas. */
    private static int productosCreados = 0;

    /**
     * Crea un producto y valida sus datos antes de dejarlo existir.
     *
     * @param nombre     como se llama; no puede ser nulo ni vacio
     * @param precioBase precio en pesos antes de cualquier calculo; no puede ser negativo
     * @throws IllegalArgumentException si el nombre esta vacio o el precio es negativo
     */
    public Producto(String nombre, double precioBase) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El producto necesita un nombre");
        }
        if (precioBase < 0) {
            throw new IllegalArgumentException("Precio negativo: " + precioBase);
        }
        this.nombre = nombre;
        this.precioBase = precioBase;
        productosCreados++;
    }

    /**
     * El precio final de este producto, ya con todos sus recargos.
     *
     * <p>METODO ABSTRACTO: es la pregunta que la raiz no puede responder.
     * Cada subclase esta OBLIGADA a implementarlo, y cada una lo hace de una
     * forma distinta. Ese es el motor del polimorfismo de todo el taller.</p>
     *
     * @return el precio en pesos
     */
    public abstract double calcularPrecio();

    /**
     * Una linea de texto para mostrar el producto en pantalla.
     *
     * <p>Metodo CONCRETO: se hereda tal cual, pero las hijas pueden
     * sobrescribirlo si quieren mostrar sus propios datos.</p>
     *
     * @return el nombre y el precio final
     */
    public String describir() {
        return nombre + " - " + pesos(calcularPrecio());
    }

    /** @return el nombre del producto */
    public String getNombre() {
        return nombre;
    }

    /** @return el precio base, antes de recargos */
    public double getPrecioBase() {
        return precioBase;
    }

    /**
     * Cambia el precio base validando que sea valido.
     *
     * @param nuevo el precio nuevo, en pesos
     * @throws IllegalArgumentException si es negativo
     */
    public void setPrecioBase(double nuevo) {
        if (nuevo < 0) {
            throw new IllegalArgumentException("Precio negativo: " + nuevo);
        }
        this.precioBase = nuevo;
    }

    /** @return cuantos productos se han creado en todo el programa */
    public static int getProductosCreados() {
        return productosCreados;
    }

    /**
     * Formatea un monto como precio chileno. Usenlo en todo el taller.
     *
     * @param monto el valor a formatear
     * @return el monto con signo peso y sin decimales, por ejemplo {@code $5990}
     */
    public static String pesos(double monto) {
        return String.format("$%.0f", monto);
    }

    /** @return lo mismo que {@link #describir()} */
    @Override
    public String toString() {
        return describir();
    }
}
