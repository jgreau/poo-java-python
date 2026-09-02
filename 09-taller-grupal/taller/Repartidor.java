/**
 * Quien lleva el pedido hasta la puerta. GRUPO 5 (Reparto).
 *
 * <p>LA TERCERA CLASE ABSTRACTA DEL SISTEMA. Cumple {@link Cobrable}, el
 * contrato del GRUPO 4, y {@link Calificable}, el suyo propio.</p>
 *
 * <p>Calificable es la interfaz clave del taller: la implementan el Repartidor
 * y la {@link Pizza}, que NO comparten ninguna clase padre. Ninguna herencia
 * puede unirlas; una interfaz si, y por eso en el main aparecen las dos en el
 * mismo arreglo {@code Calificable[]}.</p>
 *
 * <p><b>Para compilar solo lo suyo, sin esperar a los demas grupos:</b><br>
 * {@code javac Cobrable.java Calificable.java Repartidor.java RepartidorMoto.java RepartidorBici.java}</p>
 *
 * <p>Un metodo que declara {@code return} y no lo tiene NO COMPILA. Mientras
 * trabajan, dejen un {@code return 0;} provisorio para poder ir compilando.</p>
 */
public abstract class Repartidor implements Cobrable, Calificable {

    private String nombre;
    private int entregasHechas;
    private double recaudado;

    private int sumaEstrellas;
    private int votos;

    /**
     * Contrata a un repartidor, sin entregas hechas todavia.
     *
     * @param nombre como se llama
     * @throws IllegalArgumentException si el nombre es nulo o vacio
     */
    public Repartidor(String nombre) {
        // TODO G5
    }

    /**
     * Lo que cobra este repartidor por una entrega normal.
     *
     * <p>ABSTRACTO: cada vehiculo cobra distinto, asi que la clase padre no
     * puede responderlo.</p>
     *
     * @return la tarifa en pesos
     */
    public abstract double tarifaBase();

    /**
     * En que anda repartiendo.
     *
     * @return por ejemplo {@code "MOTO"} o {@code "BICICLETA"}
     */
    public abstract String vehiculo();

    /** @return el nombre del repartidor */
    public String getNombre() {
        // TODO G5
    }

    /** @return cuantas entregas lleva cobradas */
    public int getEntregasHechas() {
        // TODO G5
    }

    /** @return cuanta plata lleva recaudada */
    public double getRecaudado() {
        // TODO G5
    }

    /**
     * Una linea con el estado del repartidor.
     *
     * @return algo como {@code Ignacio en MOTO (3 entregas, 4.5 estrellas)}
     */
    public String describir() {
        // TODO G5
    }

    /**
     * Contrato {@link Cobrable}, del GRUPO 4.
     *
     * @return la tarifa base; las hijas pueden sobrescribirlo para cobrar mas
     */
    @Override
    public double montoACobrar() {
        // TODO G5
    }

    /**
     * Contrato {@link Cobrable}, del GRUPO 4.
     *
     * <p>Si lo que le ofrecen no alcanza, no entrega y no anota nada.</p>
     *
     * @param monto lo que se le ofrece pagar
     * @return {@code true} si alcanzo y quedo registrada la entrega,
     *         {@code false} si no alcanzo
     */
    @Override
    public boolean cobrar(double monto) {
        // TODO G5
    }

    /**
     * Contrato {@link Calificable}, propio del GRUPO 5.
     *
     * @param estrellas la nota del cliente, de 1 a 5
     * @throws IllegalArgumentException si las estrellas estan fuera de 1 a 5
     */
    @Override
    public void calificar(int estrellas) {
        // TODO G5
    }

    /**
     * Contrato {@link Calificable}, propio del GRUPO 5.
     *
     * @return el promedio de estrellas, o 0 si todavia no lo califica nadie
     */
    @Override
    public double promedioEstrellas() {
        // TODO G5
    }
}
