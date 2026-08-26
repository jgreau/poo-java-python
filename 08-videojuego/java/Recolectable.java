/*
 * Recolectable.java - INTERFAZ
 *
 * El mismo argumento que Aplastable, pero del lado de los objetos.
 *
 * Las monedas, los hongos y las estrellas se recogen. Los bloques NO:
 * son parte del decorado. Si recolectar() viviera en la clase Objeto,
 * el Bloque tendria que fingir que se deja recoger.
 *
 * Fijate ademas que este metodo RECIBE un Personaje: el objeto necesita
 * saber a quien aplicarle su efecto.
 */
public interface Recolectable {

    void recolectar(Personaje quien);

    String efecto();
}
