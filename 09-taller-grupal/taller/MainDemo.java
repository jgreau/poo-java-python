/**
 * MainDemo.java - EL PROGRAMA QUE SE PROYECTA EN CLASE
 *
 * ESTE ARCHIVO LO ENTREGA EL PROFESOR. NINGUN GRUPO LO MODIFICA.
 *
 * Compilar y ejecutar (con los 20 archivos en la misma carpeta):
 *     javac *.java
 *     java MainDemo
 *
 * Este main es el CLIENTE de las cinco clases de los cinco grupos.
 * No conoce los detalles de ninguna: solo conoce Producto y las cinco
 * interfaces. Si el sistema esta bien construido, este archivo no
 * necesita cambiar aunque manana agreguen un Postre o un RepartidorAuto.
 */
public class MainDemo {

    /**
     * Punto de entrada de la demo.
     *
     * @param args no se usan
     */
    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("        DUOC DELIVERY - Mundo real        ");
        System.out.println("==========================================");

        // ---------------------------------------------------------------
        // 1. LOS PRODUCTOS  (Grupo 1 y Grupo 2)
        // ---------------------------------------------------------------
        System.out.println("\n--- 1. La carta ---");

        Pizza napolitana = new Pizza("Napolitana", 8990, "FAMILIAR");
        napolitana.agregarIngrediente(2);                   // sobrecarga con parametro
        Pizza personal = new Pizza("Peperoni", 5990);       // sobrecarga sin tamano
        personal.agregarIngrediente();                      // sobrecarga sin parametro

        Sushi california = new Sushi("California", 6500, 16, true);
        Bebida bebida = new Bebida("Limonada", 2500, 750, true);

        Combo comboFamiliar = new Combo("Familiar");
        comboFamiliar.agregar(napolitana);
        comboFamiliar.agregar(california);
        comboFamiliar.agregar(bebida);

        System.out.println("  " + napolitana.describir());
        System.out.println("  " + personal.describir());
        System.out.println("  " + california.describir());
        System.out.println("  " + bebida.describir());
        System.out.println("  " + comboFamiliar.describir());

        // ---------------------------------------------------------------
        // 2. POLIMORFISMO: el for que no sabe con quien habla
        // ---------------------------------------------------------------
        System.out.println("\n--- 2. Polimorfismo: un solo for, cuatro clases ---");

        Producto[] carta = { napolitana, personal, california, bebida, comboFamiliar };

        double sumaCarta = 0;
        for (Producto p : carta) {
            // calcularPrecio() esta escrito por CUATRO grupos distintos.
            // Aqui no hay ni un solo if preguntando de que clase es.
            System.out.println("  " + p.getNombre() + " -> " + Producto.pesos(p.calcularPrecio()));
            sumaCarta += p.calcularPrecio();
        }
        System.out.println("  Suma de la carta: " + Producto.pesos(sumaCarta));

        // ---------------------------------------------------------------
        // 3. EL PEDIDO  (Grupo 3) - composicion y sobrecarga
        // ---------------------------------------------------------------
        System.out.println("\n--- 3. El pedido ---");

        Pedido pedido = new Pedido("Camila Rojas");
        pedido.agregar(napolitana);             // sobrecarga 1
        pedido.agregar(bebida, 3);              // sobrecarga 2
        pedido.agregar(california);

        System.out.println(pedido.detalle());

        // ---------------------------------------------------------------
        // 4. TRES VECES EL MISMO NOMBRE: calcularTotal()
        // ---------------------------------------------------------------
        System.out.println("\n--- 4. Sobrecarga: tres calcularTotal() ---");

        RepartidorMoto moto = new RepartidorMoto("Ignacio", true);   // esta lloviendo
        RepartidorBici bici = new RepartidorBici("Ana");

        System.out.println("  calcularTotal()          = " + Producto.pesos(pedido.calcularTotal()));
        System.out.println("  calcularTotal(2000)      = " + Producto.pesos(pedido.calcularTotal(2000)));
        System.out.println("  calcularTotal(moto)      = " + Producto.pesos(pedido.calcularTotal(moto)));
        System.out.println("  calcularTotal(bici)      = " + Producto.pesos(pedido.calcularTotal(bici)));
        System.out.println("  (el compilador elige el metodo por el TIPO del parametro)");

        // ---------------------------------------------------------------
        // 5. LA INTERFAZ COMO TIPO  (contrato del Grupo 2, cumplido por el Grupo 3)
        // ---------------------------------------------------------------
        System.out.println("\n--- 5. Descontable: el contrato del G2 lo cumple el G3 ---");

        Descontable cupon = pedido;             // el pedido visto SOLO como Descontable
        System.out.println("  Antes:   " + Producto.pesos(pedido.calcularTotal())
                + "   tieneDescuento=" + cupon.tieneDescuento());
        cupon.aplicarDescuento(20);
        System.out.println("  Despues: " + Producto.pesos(pedido.calcularTotal())
                + "   tieneDescuento=" + cupon.tieneDescuento());
        System.out.println("  Por la variable 'cupon' solo se ven los 2 metodos del contrato,");
        System.out.println("  aunque el objeto por dentro sea un Pedido completo.");

        // ---------------------------------------------------------------
        // 6. EL DESPACHO  (Grupo 5 cumpliendo el contrato del Grupo 4)
        // ---------------------------------------------------------------
        System.out.println("\n--- 6. El reparto ---");

        Repartidor[] flota = { moto, bici };
        for (Repartidor r : flota) {
            System.out.println("  " + r.describir() + " cobra " + Producto.pesos(r.montoACobrar()));
        }

        System.out.println("  moto.cobrar(1000)  -> " + moto.cobrar(1000) + "  (no alcanza)");
        System.out.println("  moto.cobrar(3500)  -> " + moto.cobrar(3500) + "  (entregado)");
        System.out.println("  " + moto.describir());

        // ---------------------------------------------------------------
        // 7. EL PAGO  (Grupo 4 cumpliendo el contrato del Grupo 3)
        // ---------------------------------------------------------------
        System.out.println("\n--- 7. El pago y la boleta ---");

        double total = pedido.calcularTotal(moto);
        MedioPago[] medios = {
            new Efectivo("Camila Rojas", total, 40000),
            new Tarjeta("Camila Rojas", total),
            new Tarjeta("Camila Rojas", total, 6)
        };

        for (MedioPago mp : medios) {
            System.out.println("  " + mp.detalleBoleta());
        }

        Efectivo enEfectivo = (Efectivo) medios[0];
        System.out.println("  Vuelto en efectivo: " + Producto.pesos(enEfectivo.vuelto()));

        // ---------------------------------------------------------------
        // 8. LA INTERFAZ QUE CRUZA LAS DOS JERARQUIAS
        // ---------------------------------------------------------------
        System.out.println("\n--- 8. Calificable: pizza y repartidor en el mismo arreglo ---");

        napolitana.calificar(5);
        napolitana.calificar(4);
        california.calificar(5);
        moto.calificar(3);
        moto.calificar(5);

        // Una Pizza y un RepartidorMoto NO comparten ninguna clase padre.
        // Sin embargo caben en el mismo arreglo, porque firmaron el mismo contrato.
        Calificable[] calificables = { napolitana, california, moto };
        for (Calificable c : calificables) {
            System.out.println("  " + c.getClass().getSimpleName()
                    + " -> " + String.format("%.1f", c.promedioEstrellas()) + " estrellas");
        }

        // ---------------------------------------------------------------
        // 9. LA COCINA  (Grupo 2 cumpliendo el contrato del Grupo 1)
        // ---------------------------------------------------------------
        System.out.println("\n--- 9. Preparable: cuanto demora cada cosa ---");

        Preparable[] enPreparacion = { napolitana, california, bebida, comboFamiliar };
        int masLento = 0;
        for (Preparable p : enPreparacion) {
            System.out.println("  " + p.estacionCocina() + ": " + p.minutosPreparacion() + " min");
            if (p.minutosPreparacion() > masLento) {
                masLento = p.minutosPreparacion();
            }
        }
        System.out.println("  El pedido sale en " + masLento + " minutos.");

        // ---------------------------------------------------------------
        // 10. LO QUE ES UNO SOLO PARA TODOS: static
        // ---------------------------------------------------------------
        System.out.println("\n--- 10. Atributos static ---");
        System.out.println("  Productos creados en todo el programa: " + Producto.getProductosCreados());
        System.out.println("  Pedidos emitidos: " + Pedido.getPedidosEmitidos());

        System.out.println("\n==========================================");
        System.out.println("  Cinco grupos, un solo programa que corre.");
        System.out.println("==========================================");
    }
}
