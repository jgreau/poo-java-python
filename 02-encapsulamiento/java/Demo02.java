/*
 * DEMO 02 - ENCAPSULAMIENTO (private, getters y setters)
 *
 * Compilar y ejecutar:
 *     javac *.java
 *     java Demo02
 *
 * Idea clave: el objeto protege sus propios datos. Nadie de afuera puede
 * dejar la cuenta en un estado imposible (por ejemplo, saldo negativo).
 *
 * Este archivo es "el mundo exterior": desde aqui se ve exactamente
 * que deja pasar CuentaBancaria y que no.
 */
public class Demo02 {
    public static void main(String[] args) {

        CuentaBancaria cuenta = new CuentaBancaria("Ana Perez", 100000);
        cuenta.mostrar();

        System.out.println("--- Operaciones validas ---");
        cuenta.depositar(50000);
        cuenta.girar(30000);
        cuenta.mostrar();

        System.out.println("--- Operaciones invalidas (el objeto se defiende) ---");
        cuenta.girar(999999);      // no tiene tanto saldo
        cuenta.depositar(-5000);   // deposito negativo: no tiene sentido
        cuenta.mostrar();

        System.out.println("--- Acceso a los datos ---");
        // LEER si se puede, porque hay un getter:
        System.out.println("Saldo leido con getter: " + cuenta.getSaldo());

        // ESCRIBIR directamente NO se puede. Descomenta la linea siguiente
        // y mira el error del compilador:
        //     saldo has private access in CuentaBancaria
        // cuenta.saldo = 999999999;

        // El titular tiene setter CON VALIDACION:
        cuenta.setTitular("Ana Maria Perez");
        cuenta.setTitular("");     // rechazado
        cuenta.mostrar();
    }
}
