/**
 * MainPruebas.java - EL BANCO DE PRUEBAS DEL TALLER
 *
 * ESTE ARCHIVO LO ENTREGA EL PROFESOR. NINGUN GRUPO LO MODIFICA.
 *
 *     javac *.java
 *     java MainPruebas
 *
 * Cada grupo puede correr esto y ver si su parte quedo bien, sin
 * preguntarle a nadie. Al final imprime cuantas pruebas pasaron.
 *
 * ATENCION AL DETALLE MAS IMPORTANTE DEL TALLER:
 * "new Producto(...)" NO lanza una excepcion: directamente NO COMPILA.
 * El try/catch no puede atrapar un error de compilacion, porque el
 * programa nunca llega a existir. Para poder PROBAR en tiempo de
 * ejecucion que una clase es abstracta hay que instanciarla por
 * reflexion, y ahi si aparece una excepcion atrapable:
 * InstantiationException.
 */
public class MainPruebas {

    /**
     * Punto de entrada del banco de pruebas.
     *
     * @param args no se usan
     */
    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println("   BANCO DE PRUEBAS - DUOC DELIVERY      ");
        System.out.println("=========================================");

        // ===============================================================
        // A. LAS TRES CLASES ABSTRACTAS
        // ===============================================================
        Verificador.seccion("A. Las clases abstractas no se pueden instanciar");

        // Descomenten la linea siguiente en clase: el proyecto DEJA DE COMPILAR.
        // Producto fantasma = new Producto("fantasma", 1000);
        // error: Producto is abstract; cannot be instantiated

        probarQueEsAbstracta("Producto", Producto.class,
                new Class<?>[] { String.class, double.class },
                new Object[] { "fantasma", 1000.0 });

        probarQueEsAbstracta("MedioPago (G4)", MedioPago.class,
                new Class<?>[] { String.class, double.class },
                new Object[] { "fantasma", 1000.0 });

        probarQueEsAbstracta("Repartidor (G5)", Repartidor.class,
                new Class<?>[] { String.class },
                new Object[] { "fantasma" });

        // El contraste: una clase CONCRETA si se deja instanciar por reflexion
        try {
            Object p = Pizza.class.getDeclaredConstructor(String.class, double.class)
                                  .newInstance("Prueba", 1000.0);
            Verificador.chequear("Pizza SI se puede instanciar (es concreta)", p != null);
        } catch (InstantiationException e) {
            Verificador.chequear("Pizza deberia ser concreta, pero es abstracta", false);
        } catch (Exception e) {
            Verificador.chequear("Pizza no tiene el constructor (String, double)", false);
        }

        // A partir de aqui, los objetos con los que se prueba todo
        Pizza pizza = new Pizza("Napolitana", 10000, "FAMILIAR");
        Sushi sushi = new Sushi("California", 6500, 10);
        Bebida bebida = new Bebida("Limonada", 2000, 500);
        Combo combo = new Combo("Duo");
        combo.agregar(pizza);
        combo.agregar(bebida);

        Pedido pedido = new Pedido("Cliente de prueba");
        RepartidorMoto moto = new RepartidorMoto("Moto de prueba");
        RepartidorBici bici = new RepartidorBici("Bici de prueba");
        Tarjeta tarjeta = new Tarjeta("Cliente de prueba", 10000, 3);
        Efectivo efectivo = new Efectivo("Cliente de prueba", 10000, 20000);

        // ===============================================================
        // B. HERENCIA
        // ===============================================================
        Verificador.seccion("B. Herencia: cada hija ES un padre");

        Verificador.chequear("Pizza extends Producto", pizza instanceof Producto);
        Verificador.chequear("Sushi extends Producto", sushi instanceof Producto);
        Verificador.chequear("Bebida extends Producto", bebida instanceof Producto);
        Verificador.chequear("Combo extends Producto", combo instanceof Producto);
        Verificador.chequear("Tarjeta extends MedioPago", tarjeta instanceof MedioPago);
        Verificador.chequear("Efectivo extends MedioPago", efectivo instanceof MedioPago);
        Verificador.chequear("RepartidorMoto extends Repartidor", moto instanceof Repartidor);
        Verificador.chequear("RepartidorBici extends Repartidor", bici instanceof Repartidor);

        Verificador.chequear("Pizza sobrescribe describir()",
                !pizza.describir().equals(pizza.getNombre() + " - " + Producto.pesos(pizza.calcularPrecio())));

        // ===============================================================
        // C. EL ANILLO DE CONTRATOS: cada grupo cumple el del vecino
        // ===============================================================
        Verificador.seccion("C. El anillo de interfaces entre grupos");

        Verificador.chequear("G2 cumple Preparable, contrato del G1  (Bebida)",
                bebida instanceof Preparable);
        Verificador.chequear("G2 cumple Preparable, contrato del G1  (Combo)",
                combo instanceof Preparable);
        Verificador.chequear("G3 cumple Descontable, contrato del G2 (Pedido)",
                pedido instanceof Descontable);
        Verificador.chequear("G4 cumple Facturable, contrato del G3  (MedioPago)",
                tarjeta instanceof Facturable);
        Verificador.chequear("G5 cumple Cobrable, contrato del G4    (Repartidor)",
                moto instanceof Cobrable);
        Verificador.chequear("G1 cumple Calificable, contrato del G5 (Pizza)",
                pizza instanceof Calificable);
        Verificador.chequear("G1 cumple Calificable, contrato del G5 (Sushi)",
                sushi instanceof Calificable);

        Verificador.chequear("Preparable devuelve minutos > 0", bebida.minutosPreparacion() > 0);
        Verificador.chequear("Facturable calcula el IVA (10000 -> 11900 sin recargo)",
                11900.0, new Tarjeta("X", 10000).totalConIVA());

        // ===============================================================
        // D. POLIMORFISMO
        // ===============================================================
        Verificador.seccion("D. Polimorfismo");

        Producto[] carta = { pizza, sushi, bebida, combo };
        double suma = 0;
        for (Producto p : carta) {
            suma += p.calcularPrecio();
        }
        Verificador.chequear("El for polimorfico suma las 4 clases",
                pizza.calcularPrecio() + sushi.calcularPrecio()
                        + bebida.calcularPrecio() + combo.calcularPrecio(), suma);

        Verificador.chequear("Cada clase calcula el precio a su manera",
                pizza.calcularPrecio() != bebida.calcularPrecio());

        // La interfaz que cruza las dos jerarquias
        Verificador.chequear("Producto y Repartidor NO comparten clase padre",
                !Producto.class.isAssignableFrom(RepartidorMoto.class));
        Calificable[] mezcla = { pizza, moto };
        Verificador.chequear("...pero caben en el mismo arreglo Calificable[]",
                mezcla.length == 2 && mezcla[0] instanceof Producto && mezcla[1] instanceof Repartidor);

        Repartidor[] flota = { moto, bici };
        Verificador.chequear("La moto cobra mas caro que la bici",
                flota[0].montoACobrar() > flota[1].montoACobrar());

        // ===============================================================
        // E. SOBRECARGA
        // ===============================================================
        Verificador.seccion("E. Sobrecarga: mismo nombre, distintos parametros");

        pedido.agregar(bebida);              // sobrecarga 1
        pedido.agregar(bebida, 2);           // sobrecarga 2
        Verificador.chequear("agregar(p) + agregar(p,2) dejan 3 items", 3.0, pedido.getCantidad());

        double base = pedido.calcularTotal();
        Verificador.chequear("calcularTotal(1000) = total + propina",
                base + 1000, pedido.calcularTotal(1000.0));
        Verificador.chequear("calcularTotal(bici) = total + despacho",
                base + bici.montoACobrar(), pedido.calcularTotal(bici));
        Verificador.chequear("Las tres versiones dan resultados distintos",
                pedido.calcularTotal() != pedido.calcularTotal(1000.0));

        Pizza sinTamano = new Pizza("Peperoni", 10000);
        Verificador.chequear("El constructor corto asume MEDIANA (factor 1.0)",
                10000.0, sinTamano.calcularPrecio());

        // ===============================================================
        // F. ENCAPSULAMIENTO: los datos se defienden solos
        // ===============================================================
        Verificador.seccion("F. Encapsulamiento y validacion (try/catch de verdad)");

        try {
            new Bebida("Rota", -5000, 500);
            Verificador.chequear("Un precio negativo deberia ser rechazado", false);
        } catch (IllegalArgumentException e) {
            Verificador.chequear("Precio negativo rechazado: " + e.getMessage(), true);
        }

        try {
            pizza.setPrecioBase(-1);
            Verificador.chequear("setPrecioBase(-1) deberia ser rechazado", false);
        } catch (IllegalArgumentException e) {
            Verificador.chequear("setPrecioBase(-1) rechazado", true);
        }

        try {
            pizza.calificar(9);
            Verificador.chequear("calificar(9) deberia ser rechazado", false);
        } catch (IllegalArgumentException e) {
            Verificador.chequear("calificar(9) rechazado: solo 1 a 5", true);
        }

        try {
            pedido.aplicarDescuento(150);
            Verificador.chequear("Un descuento de 150% deberia ser rechazado", false);
        } catch (IllegalArgumentException e) {
            Verificador.chequear("Descuento de 150% rechazado", true);
        }

        // ===============================================================
        // G. LOS ERRORES CLASICOS EN TIEMPO DE EJECUCION
        // ===============================================================
        Verificador.seccion("G. Errores que si se atrapan con try/catch");

        Producto disfrazada = bebida;        // una Bebida vista como Producto
        try {
            Pizza noEsPizza = (Pizza) disfrazada;
            Verificador.chequear("Castear Bebida a Pizza deberia fallar", noEsPizza == null);
        } catch (ClassCastException e) {
            Verificador.chequear("ClassCastException al castear Bebida a Pizza", true);
        }

        try {
            pedido.agregar(null);
            Verificador.chequear("Agregar null deberia ser rechazado", false);
        } catch (IllegalArgumentException e) {
            Verificador.chequear("Agregar un producto nulo rechazado", true);
        }

        // ===============================================================
        // H. STATIC: lo que es uno solo para todos
        // ===============================================================
        Verificador.seccion("H. Atributos static");

        int antes = Producto.getProductosCreados();
        new Bebida("Agua", 1500, 500);
        Verificador.chequear("El contador static de Producto subio en 1",
                antes + 1.0, Producto.getProductosCreados());

        Pedido otro = new Pedido("Segundo cliente");
        Verificador.chequear("Cada pedido recibe un numero distinto",
                otro.getNumero() != pedido.getNumero());

        Verificador.resumen();
    }

    /*
     * Instanciar una clase abstracta por REFLEXION.
     * Esta es la unica forma de comprobar en tiempo de ejecucion algo que
     * normalmente el compilador impide antes de que el programa exista.
     */
    private static void probarQueEsAbstracta(String etiqueta, Class<?> clase,
                                             Class<?>[] tiposParametros, Object[] valores) {
        try {
            clase.getDeclaredConstructor(tiposParametros).newInstance(valores);
            Verificador.chequear(etiqueta + " deberia ser abstracta y se instancio", false);
        } catch (InstantiationException e) {
            Verificador.chequear(etiqueta + " es abstracta -> InstantiationException", true);
        } catch (NoSuchMethodException e) {
            Verificador.chequear(etiqueta + ": no existe ese constructor", false);
        } catch (Exception e) {
            Verificador.chequear(etiqueta + ": excepcion inesperada "
                    + e.getClass().getSimpleName(), false);
        }
    }
}
