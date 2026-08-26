/*
 * Circulo.java
 *
 * "extends Figura implements Dibujable" se lee:
 *    ES UNA Figura   (herencia: hereda nombre y getNombre)
 *    y ademas FIRMA el contrato Dibujable
 */
public class Circulo extends Figura implements Dibujable {

    private double radio;

    public Circulo(double radio) {
        super("Circulo");
        this.radio = radio;
    }

    @Override
    public double area() {
        return Math.PI * radio * radio;
    }

    @Override
    public double perimetro() {
        return 2 * Math.PI * radio;
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando un circulo de radio " + radio + "  ( O )");
    }
}
