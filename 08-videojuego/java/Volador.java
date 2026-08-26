/*
 * Volador.java - INTERFAZ
 *
 * La firman un PERSONAJE (Peach) y dos ENEMIGOS (Paratroopa, BillBala).
 * Tres clases que no comparten mas ancestro que Entidad, y aun asi
 * caben en el mismo Volador[].
 *
 * Eso es exactamente lo que la herencia sola no puede hacer.
 */
public interface Volador {

    void volar();

    int alturaVuelo();      // metros
}
