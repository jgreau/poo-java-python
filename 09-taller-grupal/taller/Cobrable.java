/**
 * Contrato de quien cobra por un servicio.
 *
 * <p>CONTRATO DEL GRUPO 4 (Pagos). Quien esta OBLIGADO a cumplirlo es el
 * GRUPO 5, en Repartidor.</p>
 *
 * <p>El GRUPO 3 ademas lo usa como TIPO DE PARAMETRO en una de sus
 * sobrecargas: {@code calcularTotal(Cobrable despacho)}. Al pedido no le
 * importa quien reparte, solo exige que sepa cobrar. Son dos grupos
 * dependiendo de lo que ustedes escriban en este archivo.</p>
 *
 * <p><b>ESTA INTERFAZ LA ESCRIBEN USTEDES.</b> El archivo llega vacio a
 * proposito: abajo esta la descripcion de lo que el contrato tiene que exigir,
 * y el trabajo es traducirla a Java.</p>
 *
 * <p>El contrato debe exigir exactamente estos dos metodos:</p>
 * <ol>
 *   <li><b>montoACobrar</b> &mdash; no recibe nada y devuelve un
 *       {@code double}: cuanto hay que pagarle por este servicio.</li>
 *   <li><b>cobrar</b> &mdash; recibe un {@code double} con lo que se le ofrece
 *       pagar y devuelve un {@code boolean}: {@code true} si alcanzo y el
 *       servicio se da por realizado, {@code false} si no alcanzo.</li>
 * </ol>
 *
 * <p>COMO SE ESCRIBE: los metodos de una interfaz NO llevan cuerpo ni llaves,
 * terminan en punto y coma, y no hace falta escribirles {@code public}. Cada
 * uno lleva su Javadoc con {@code @param} y {@code @return}.</p>
 *
 * <p>LOS NOMBRES Y LOS TIPOS NO SE NEGOCIAN: el GRUPO 5 ya los tiene escritos
 * con {@code @Override} y el GRUPO 3 escribio una sobrecarga que recibe esta
 * interfaz. Hablen con los dos.</p>
 */
public interface Cobrable {

    // TODO G4: declarar aqui los dos metodos del contrato, con su Javadoc.
}
