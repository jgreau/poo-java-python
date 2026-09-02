/**
 * Un roll de sushi de la carta. GRUPO 1 (Cocina).
 *
 * <p>La segunda hija de {@link Producto}. Calcula el precio de una forma
 * COMPLETAMENTE distinta a la {@link Pizza}, y esa es toda la gracia: el
 * {@link Pedido} las va a sumar sin saber cual es cual.</p>
 *
 * <p><b>Para compilar solo lo suyo, sin esperar a los demas grupos:</b><br>
 * {@code javac Producto.java Preparable.java Calificable.java Pizza.java Sushi.java}</p>
 *
 * <p>Un metodo que declara {@code return} y no lo tiene NO COMPILA. Mientras
 * trabajan, dejen un {@code return 0;} provisorio para poder ir compilando.</p>
 */
public class Sushi extends Producto implements Calificable, Preparable {

    private int piezas;
    private boolean conPalta;

    private int sumaEstrellas;
    private int votos;

    /**
     * Crea un roll sin palta.
     *
     * <p>SOBRECARGA corta: llamen al otro constructor con {@code this(...)}.</p>
     *
     * @param nombre     el nombre del roll
     * @param precioBase el precio de un roll de 10 piezas
     * @param piezas     cuantas piezas trae
     */
    public Sushi(String nombre, double precioBase, int piezas) {
        // TODO G1
    }

    /**
     * Crea un roll indicando si lleva palta.
     *
     * @param nombre     el nombre del roll
     * @param precioBase el precio de un roll de 10 piezas
     * @param piezas     cuantas piezas trae; tiene que ser mayor que cero
     * @param conPalta   {@code true} si lleva palta, que cuesta $900 mas
     * @throws IllegalArgumentException si las piezas no son mas de cero
     */
    public Sushi(String nombre, double precioBase, int piezas, boolean conPalta) {
        super(nombre, precioBase);
        // TODO G1
    }

    /**
     * El precio segun las piezas y la palta.
     *
     * <p>Se cobra {@code precioBase + (piezas - 10) * 350}, y $900 mas si
     * lleva palta. Un roll de 10 piezas cuesta exactamente el precio base.</p>
     *
     * @return el precio final en pesos
     */
    @Override
    public double calcularPrecio() {
        // TODO G1
    }

    /**
     * Sobrescribe la version del padre para mostrar las piezas y la palta.
     *
     * @return algo como {@code Roll California x16 con palta - $9500}
     */
    @Override
    public String describir() {
        // TODO G1
    }

    /**
     * Registra una calificacion. Contrato {@link Calificable}, del GRUPO 5.
     *
     * @param estrellas la nota, de 1 a 5
     * @throws IllegalArgumentException si las estrellas estan fuera de 1 a 5
     */
    @Override
    public void calificar(int estrellas) {
        // TODO G1
    }

    /**
     * Contrato {@link Calificable}, del GRUPO 5.
     *
     * @return el promedio de las calificaciones, o 0 si todavia no hay votos
     */
    @Override
    public double promedioEstrellas() {
        // TODO G1
    }

    /**
     * Contrato {@link Preparable}, propio del GRUPO 1.
     *
     * @return siempre 8 minutos
     */
    @Override
    public int minutosPreparacion() {
        // TODO G1
    }

    /**
     * Contrato {@link Preparable}, propio del GRUPO 1.
     *
     * @return siempre {@code "FRIO"}
     */
    @Override
    public String estacionCocina() {
        // TODO G1
    }
}
