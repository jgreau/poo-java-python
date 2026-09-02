/**
 * Una pizza de la carta. GRUPO 1 (Cocina).
 *
 * <p>ES un {@link Producto} (herencia) y firma dos contratos:
 * {@link Calificable}, que escribe el GRUPO 5, y {@link Preparable}, el suyo
 * propio.</p>
 *
 * <p>Aqui vive la SOBRECARGA del taller: hay dos constructores y dos
 * {@code agregarIngrediente()}, con el mismo nombre y distintos parametros.</p>
 *
 * <p><b>Para compilar solo lo suyo, sin esperar a los demas grupos:</b><br>
 * {@code javac Producto.java Preparable.java Calificable.java Pizza.java Sushi.java}</p>
 *
 * <p>Un metodo que declara {@code return} y no lo tiene NO COMPILA. Mientras
 * trabajan, dejen un {@code return 0;} provisorio para poder ir compilando.</p>
 */
public class Pizza extends Producto implements Calificable, Preparable {

    /** PERSONAL, MEDIANA o FAMILIAR. Decide el factor que multiplica el precio. */
    private String tamano;
    private int ingredientesExtra;

    private int sumaEstrellas;
    private int votos;

    /**
     * Crea una pizza MEDIANA.
     *
     * <p>SOBRECARGA corta: no repitan el codigo del otro constructor,
     * llamenlo con {@code this(...)}.</p>
     *
     * @param nombre     el nombre de la pizza
     * @param precioBase el precio de la version mediana
     */
    public Pizza(String nombre, double precioBase) {
        // TODO G1
    }

    /**
     * Crea una pizza del tamano indicado, sin ingredientes extra.
     *
     * @param nombre     el nombre de la pizza
     * @param precioBase el precio de la version mediana
     * @param tamano     {@code "PERSONAL"}, {@code "MEDIANA"} o {@code "FAMILIAR"}
     */
    public Pizza(String nombre, double precioBase, String tamano) {
        super(nombre, precioBase);
        // TODO G1
    }

    /**
     * Agrega un ingrediente extra.
     *
     * <p>SOBRECARGA sin parametros: reutiliza la otra version.</p>
     */
    public void agregarIngrediente() {
        // TODO G1
    }

    /**
     * Agrega varios ingredientes extra de una vez.
     *
     * @param cantidad cuantos ingredientes agregar, nunca negativo
     * @throws IllegalArgumentException si la cantidad es negativa
     */
    public void agregarIngrediente(int cantidad) {
        // TODO G1
    }

    /**
     * El precio segun el tamano y los ingredientes extra.
     *
     * <p>FAMILIAR multiplica por 1.6, MEDIANA por 1.0 y PERSONAL por 0.7.
     * Sobre eso se suman $700 por cada ingrediente extra.</p>
     *
     * @return el precio final en pesos
     */
    @Override
    public double calcularPrecio() {
        // TODO G1
    }

    /**
     * Sobrescribe la version del padre para mostrar tamano e ingredientes.
     *
     * @return algo como {@code Pizza Napolitana (FAMILIAR, 2 extras) - $15784}
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
     * @return 12 minutos, mas uno por cada ingrediente extra
     */
    @Override
    public int minutosPreparacion() {
        // TODO G1
    }

    /**
     * Contrato {@link Preparable}, propio del GRUPO 1.
     *
     * @return siempre {@code "HORNO"}
     */
    @Override
    public String estacionCocina() {
        // TODO G1
    }
}
