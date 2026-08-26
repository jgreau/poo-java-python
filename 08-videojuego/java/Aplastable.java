/*
 * Aplastable.java - INTERFAZ
 *
 * AQUI ESTA LA LECCION MAS IMPORTANTE DE LA DEMO.
 *
 * Parece obvio poner recibirPisoton() dentro de la clase Enemigo:
 * al fin y al cabo, "a los enemigos se les salta encima".
 *
 * Pero al Spiny (el erizo con puas) NO se le puede saltar encima, y a
 * la Bill Bala tampoco. Si el metodo viviera en Enemigo, esas dos clases
 * estarian obligadas a heredarlo y habria que rellenarlo con una mentira:
 * un metodo vacio, un error lanzado, un "no hago nada".
 *
 * Al estar en una interfaz, simplemente NO LA FIRMAN.
 */
public interface Aplastable {

    void recibirPisoton();

    int puntosQueDa();
}
