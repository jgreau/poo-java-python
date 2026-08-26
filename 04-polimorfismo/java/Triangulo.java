/*
 * Triangulo.java
 *
 * Esta clase hereda de Figura, pero NO implementa Dibujable:
 * no firmo ese contrato. Compara el encabezado con el de Circulo.java.
 */
public class Triangulo extends Figura {

    private double base, altura;

    public Triangulo(double base, double altura) {
        super("Triangulo");
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double area() {
        return base * altura / 2;
    }

    @Override
    public double perimetro() {
        return base * 3;   // simplificacion: lo tratamos como equilatero
    }
}
