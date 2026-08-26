/*
 * CuentaBancaria.java - LA CLASE
 *
 * Ahora que la clase vive en su PROPIO archivo se ve mejor de que sirve
 * "private": es la frontera entre lo que este archivo controla y lo que
 * el resto del programa puede tocar.
 *
 * Un atributo public es como dejar la caja registradora abierta.
 * Un atributo private obliga a pasar por el cajero (los metodos).
 */
public class CuentaBancaria {

    // PRIVATE = solo el codigo de ESTE archivo puede tocar estos atributos
    private String titular;
    private int saldo;

    public CuentaBancaria(String titular, int saldoInicial) {
        this.titular = titular;
        this.saldo = Math.max(saldoInicial, 0);   // nunca nace negativa
    }

    // ---------- GETTERS: dejan LEER ----------
    public String getTitular() {
        return this.titular;
    }

    public int getSaldo() {
        return this.saldo;
    }

    // ---------- SETTER: deja ESCRIBIR, pero con reglas ----------
    public void setTitular(String nuevoTitular) {
        if (nuevoTitular == null || nuevoTitular.isEmpty()) {
            System.out.println("ERROR: el titular no puede estar vacio.");
            return;
        }
        this.titular = nuevoTitular;
    }

    // Fijate que NO existe setSaldo(). El saldo solo cambia con reglas
    // de negocio: depositar y girar. Eso es encapsular de verdad.

    public void depositar(int monto) {
        if (monto <= 0) {
            System.out.println("ERROR: el deposito debe ser positivo.");
            return;
        }
        this.saldo += monto;
        System.out.println("Deposito de " + monto + " OK.");
    }

    public void girar(int monto) {
        if (monto > this.saldo) {
            System.out.println("ERROR: saldo insuficiente para girar " + monto);
            return;
        }
        this.saldo -= monto;
        System.out.println("Giro de " + monto + " OK.");
    }

    public void mostrar() {
        System.out.println("[Cuenta] " + this.titular + " | saldo: $" + this.saldo);
    }
}
