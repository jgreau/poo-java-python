/**
 * Contrato de todo aquello a lo que se le puede rebajar el precio.
 *
 * <p>CONTRATO DEL GRUPO 2 (Barra y combos). Quien esta OBLIGADO a cumplirlo
 * es el GRUPO 3, en Pedido.</p>
 *
 * <p><b>ESTA INTERFAZ LA ESCRIBEN USTEDES.</b> El archivo llega vacio a
 * proposito: abajo esta la descripcion de lo que el contrato tiene que exigir,
 * y el trabajo es traducirla a Java.</p>
 *
 * <p>El contrato debe exigir exactamente estos dos metodos:</p>
 * <ol>
 *   <li><b>aplicarDescuento</b> &mdash; recibe un {@code double} con el
 *       porcentaje a descontar (de 0 a 100) y devuelve un {@code double}: el
 *       precio nuevo, ya rebajado. Debe lanzar
 *       {@code IllegalArgumentException} si el porcentaje esta fuera de rango,
 *       y eso se documenta con {@code @throws}.</li>
 *   <li><b>tieneDescuento</b> &mdash; no recibe nada y devuelve un
 *       {@code boolean}: si ahora mismo hay algun descuento vigente.</li>
 * </ol>
 *
 * <p>COMO SE ESCRIBE: los metodos de una interfaz NO llevan cuerpo ni llaves,
 * terminan en punto y coma, y no hace falta escribirles {@code public}. Cada
 * uno lleva su Javadoc con {@code @param}, {@code @return} y {@code @throws}
 * cuando corresponda.</p>
 *
 * <p>LOS NOMBRES Y LOS TIPOS NO SE NEGOCIAN: el GRUPO 3 ya los tiene escritos
 * con {@code @Override}. Vayan a hablar con ellos antes de cambiar nada.</p>
 */
public interface Descontable {

    // TODO G2: declarar aqui los dos metodos del contrato, con su Javadoc.
}
