/*
 * Dibujable.java - INTERFAZ
 *
 * Un contrato puro: "quien firme esto, sabe dibujar".
 * No tiene atributos ni constructor: solo la lista de lo que hay que saber hacer.
 *
 * Una clase puede heredar de UNA sola clase, pero implementar MUCHAS interfaces.
 * Por eso la interfaz vive en su propio archivo, aparte de la jerarquia.
 */
public interface Dibujable {
    void dibujar();          // en una interfaz todo es public y abstract
}
