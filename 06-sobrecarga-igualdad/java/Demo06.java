/*
 * DEMO 06 - SOBRECARGA, toString() Y equals()
 *
 * Compilar y ejecutar:
 *     javac *.java
 *     java Demo06
 *
 * Dos archivos:
 *     Fraccion.java   la clase
 *     Demo06.java     el programa   <- estas aqui
 */
public class Demo06 {
    public static void main(String[] args) {

        Fraccion a = new Fraccion(1, 2);
        Fraccion b = new Fraccion(3, 4);

        System.out.println("--- toString(): como se ve el objeto al imprimirlo ---");
        System.out.println("a = " + a);          // Java llama a toString() solito
        System.out.println("b = " + b);
        System.out.println("(sin toString saldria algo como Fraccion@1b6d3586)");

        System.out.println("--- SOBRECARGA: mismo nombre, distintos parametros ---");
        System.out.println("a.sumar(b)  = " + a.sumar(b));    // version con Fraccion
        System.out.println("a.sumar(2)  = " + a.sumar(2));    // version con int
        System.out.println("Java elige el metodo segun el TIPO del argumento.");

        System.out.println("--- == vs equals() ---");
        Fraccion x = new Fraccion(1, 2);
        Fraccion y = new Fraccion(1, 2);

        System.out.println("x == y        -> " + (x == y));
        System.out.println("   (compara si son EL MISMO objeto en memoria: no lo son)");
        System.out.println("x.equals(y)   -> " + x.equals(y));
        System.out.println("   (compara el CONTENIDO, porque escribimos equals())");

        Fraccion z = x;
        System.out.println("x == z        -> " + (x == z) + "   (misma referencia)");

        System.out.println("--- equals() con fracciones equivalentes ---");
        Fraccion mitad = new Fraccion(1, 2);
        Fraccion dosCuartos = new Fraccion(2, 4);
        System.out.println("1/2 equals 2/4 -> " + mitad.equals(dosCuartos)
                           + "   (comparamos en cruz: 1*4 == 2*2)");
    }
}
