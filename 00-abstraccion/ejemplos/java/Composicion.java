// Composicion.java
class Motor {
    void encender() {
        System.out.println("Motor: brrrum");
    }
}

class Auto {                            // un Auto TIENE UN Motor (no ES un motor)
    private Motor motor = new Motor();

    void partir() {
        System.out.println("Auto: girando la llave");
        motor.encender();
    }
}

public class Composicion {
    public static void main(String[] args) {
        new Auto().partir();
    }
}
