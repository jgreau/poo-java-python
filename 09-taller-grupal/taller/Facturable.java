/**
 * Contrato de lo que sabe emitir una boleta.
 *
 * <p>CONTRATO DEL GRUPO 3 (Pedido). Quien esta OBLIGADO a cumplirlo es el
 * GRUPO 4, en MedioPago.</p>
 *
 * <p>Ojo con la decision de diseno: la boleta NO la emite el pedido, la emite
 * el medio de pago. Por eso el contrato lo escribe un grupo y lo cumple otro.</p>
 *
 * <p><b>ESTA INTERFAZ LA ESCRIBEN USTEDES.</b> El archivo llega vacio a
 * proposito: abajo esta la descripcion de lo que el contrato tiene que exigir,
 * y el trabajo es traducirla a Java.</p>
 *
 * <p>El contrato debe exigir exactamente estos dos metodos:</p>
 * <ol>
 *   <li><b>detalleBoleta</b> &mdash; no recibe nada y devuelve un
 *       {@code String}: la boleta en una linea, algo como
 *       {@code BOLETA | TARJETA 3 cuota(s) | Camila | neto $10000 | recargo $600 | TOTAL $12614}.</li>
 *   <li><b>totalConIVA</b> &mdash; no recibe nada y devuelve un
 *       {@code double}: el total a pagar con el IVA del 19% ya incluido.</li>
 * </ol>
 *
 * <p>COMO SE ESCRIBE: los metodos de una interfaz NO llevan cuerpo ni llaves,
 * terminan en punto y coma, y no hace falta escribirles {@code public}. Cada
 * uno lleva su Javadoc con {@code @return}.</p>
 *
 * <p>LOS NOMBRES Y LOS TIPOS NO SE NEGOCIAN: el GRUPO 4 ya los tiene escritos
 * con {@code @Override}. Vayan a hablar con ellos.</p>
 */
public interface Facturable {

    // TODO G3: declarar aqui los dos metodos del contrato, con su Javadoc.
}
