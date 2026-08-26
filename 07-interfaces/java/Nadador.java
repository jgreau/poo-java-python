/*
 * Nadador.java - INTERFAZ
 *
 * Una interfaz NO dice lo que algo ES. Dice lo que algo SABE HACER.
 *
 *   Animal   -> ES UN        (herencia)
 *   Nadador  -> SABE NADAR   (interfaz)
 *
 * Fijate que no tiene atributos ni constructor: no guarda estado,
 * solo exige capacidades. Los metodos van sin cuerpo y sin "public":
 * en una interfaz todo es public y abstract automaticamente.
 */
public interface Nadador {

    void nadar();

    double velocidadEnAgua();   // km/h
}
