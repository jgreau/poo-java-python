// Figuras.java
class Figura {
    String nombre;

    Figura(String nombre) {
        this.nombre = nombre;
    }

    double area() {
        return 0;                       // ¿que area tiene una "figura" a secas?
    }

    void describir() {
        System.out.println(nombre + " tiene area " + area());
    }
}

class Circulo extends Figura {          // un Circulo ES UNA Figura
    double radio;

    Circulo(double radio) {
        super("Circulo");
        this.radio = radio;
    }

    @Override
    double area() {
        return Math.PI * radio * radio;
    }
}

class Rectangulo extends Figura {
    double base, altura;

    Rectangulo(double base, double altura) {
        super("Rectangulo");
        this.base = base;
        this.altura = altura;
    }

    @Override
    double area() {
        return base * altura;
    }
}

public class Figuras {
    public static void main(String[] args) {
        Figura[] figuras = { new Circulo(1), new Rectangulo(3, 4), new Figura("Figura generica") };
        for (Figura f : figuras) {
            f.describir();              // misma orden, cada una responde a su manera
        }
    }
}
