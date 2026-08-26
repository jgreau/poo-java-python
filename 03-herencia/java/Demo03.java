/*
 * DEMO 03 - HERENCIA (extends, super, @Override, protected)
 *
 * Compilar y ejecutar:
 *     javac *.java
 *     java Demo03
 *
 * Cuatro archivos, tres clases y un programa:
 *     Vehiculo.java   el padre
 *     Auto.java       hijo
 *     Moto.java       hijo
 *     Demo03.java     el programa que los usa   <- estas aqui
 */
public class Demo03 {
    public static void main(String[] args) {

        Auto auto = new Auto("Toyota Yaris", 2020, 4);
        Moto moto = new Moto("Honda CB190", 2022, true);

        System.out.println("--- Metodos heredados del padre ---");
        auto.acelerar();     // definido en Vehiculo.java, nadie lo reescribio
        moto.acelerar();

        System.out.println("--- Metodo sobrescrito en cada hijo ---");
        auto.describir();    // cada clase lo hace a su manera
        moto.describir();

        System.out.println("--- Metodos propios de cada hijo ---");
        auto.abrirMaletero();
        moto.hacerCaballito();

        System.out.println("--- Un hijo puede usarse como si fuera el padre ---");
        Vehiculo v = new Auto("Ford Fiesta", 1998, 4);
        v.describir();       // ejecuta la version de Auto, no la de Vehiculo
        v.acelerar();
        // v.abrirMaletero();  // ERROR: la variable es Vehiculo, no conoce ese metodo
    }
}
