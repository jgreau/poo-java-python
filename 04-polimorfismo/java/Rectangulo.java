public class Rectangulo extends Figura implements Dibujable {

    private double ancho, alto;

    public Rectangulo(double ancho, double alto) {
        super("Rectangulo");
        this.ancho = ancho;
        this.alto = alto;
    }

    @Override
    public double area() {
        return ancho * alto;
    }

    @Override
    public double perimetro() {
        return 2 * (ancho + alto);
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando un rectangulo " + ancho + "x" + alto + "  [ ]");
    }
}
