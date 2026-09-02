/**
 * Contrato de todo lo que el cliente puede puntuar con estrellas.
 *
 * <p>CONTRATO DEL GRUPO 5 (Reparto). Quien esta OBLIGADO a cumplirlo es el
 * GRUPO 1, en Pizza y Sushi; el propio Repartidor tambien lo implementa.</p>
 *
 * <p>ESTA ES LA INTERFAZ QUE CRUZA LAS DOS JERARQUIAS del sistema: un
 * Producto y un Repartidor no comparten NINGUNA clase padre, pero los dos se
 * pueden calificar y por eso caben en el mismo arreglo
 * {@code Calificable[]}. Ninguna herencia puede hacer eso.</p>
 *
 * <p><b>ESTA INTERFAZ LA ESCRIBEN USTEDES.</b> El archivo llega vacio a
 * proposito: abajo esta la descripcion de lo que el contrato tiene que exigir,
 * y el trabajo es traducirla a Java.</p>
 *
 * <p>El contrato debe exigir exactamente estos dos metodos:</p>
 * <ol>
 *   <li><b>calificar</b> &mdash; recibe un {@code int} con la nota, de 1 a 5,
 *       y no devuelve nada ({@code void}). Debe lanzar
 *       {@code IllegalArgumentException} si la nota esta fuera de rango, y eso
 *       se documenta con {@code @throws}.</li>
 *   <li><b>promedioEstrellas</b> &mdash; no recibe nada y devuelve un
 *       {@code double}: el promedio de las calificaciones recibidas, o 0 si
 *       todavia no hay ninguna.</li>
 * </ol>
 *
 * <p>COMO SE ESCRIBE: los metodos de una interfaz NO llevan cuerpo ni llaves,
 * terminan en punto y coma, y no hace falta escribirles {@code public}. Cada
 * uno lleva su Javadoc con {@code @param}, {@code @return} y {@code @throws}
 * cuando corresponda.</p>
 *
 * <p>LOS NOMBRES Y LOS TIPOS NO SE NEGOCIAN: el GRUPO 1 ya los tiene escritos
 * con {@code @Override}. Vayan a hablar con ellos.</p>
 */
public interface Calificable {

    // TODO G5: declarar aqui los dos metodos del contrato, con su Javadoc.
}
