/**
 * Contrato de lo que pasa por la cocina antes de salir.
 *
 * <p>CONTRATO DEL GRUPO 1 (Cocina). Lo escribe el G1, pero quien esta
 * OBLIGADO a cumplirlo es el GRUPO 2, en Bebida y en Combo.</p>
 *
 * <p><b>ESTA INTERFAZ LA ESCRIBEN USTEDES.</b> El archivo llega vacio a
 * proposito: abajo esta la descripcion de lo que el contrato tiene que exigir,
 * y el trabajo es traducirla a Java.</p>
 *
 * <p>El contrato debe exigir exactamente estos dos metodos:</p>
 * <ol>
 *   <li><b>minutosPreparacion</b> &mdash; no recibe nada y devuelve un
 *       {@code int}: cuanto demora en estar listo, siempre mayor que cero.</li>
 *   <li><b>estacionCocina</b> &mdash; no recibe nada y devuelve un
 *       {@code String}: en que parte del local se prepara, por ejemplo
 *       {@code "HORNO"}, {@code "FRIO"}, {@code "BARRA"} o {@code "ARMADO"}.</li>
 * </ol>
 *
 * <p>COMO SE ESCRIBE: una interfaz no guarda datos ni escribe codigo, solo
 * exige metodos. Sus metodos NO llevan cuerpo ni llaves, terminan en punto y
 * coma, y no hace falta escribirles {@code public}: ya lo son. Cada uno lleva
 * su propio Javadoc con {@code @return}.</p>
 *
 * <p>LOS NOMBRES Y LOS TIPOS NO SE NEGOCIAN: el GRUPO 2 ya tiene esos dos
 * metodos escritos en sus clases con {@code @Override}. Si ustedes los llaman
 * de otra forma, ellos dejan de compilar. Vayan a hablar con ellos.</p>
 */
public interface Preparable {

    // TODO G1: declarar aqui los dos metodos del contrato, con su Javadoc.
}
