/*
 * Figura.java - CLASE ABSTRACTA
 *
 * No se puede instanciar: "new Figura()" es error de compilacion.
 * Define QUE debe saber hacer toda figura, sin decir COMO.
 *
 * Es un archivo que describe una idea, no una cosa concreta.
 */
public abstract class Figura {

    protected String nombre;

    public Figura(String nombre) {
        this.nombre = nombre;
    }

    // METODOS ABSTRACTOS: sin cuerpo. Cada hijo esta OBLIGADO a implementarlos.
    public abstract double area();
    public abstract double perimetro();

    // Una clase abstracta SI puede tener metodos normales, compartidos por todos
    public String getNombre() {
        return this.nombre;
    }
}
