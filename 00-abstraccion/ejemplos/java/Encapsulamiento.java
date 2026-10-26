// Encapsulamiento.java
class Billetera {
    private int saldo;                  // nadie de afuera lo toca directo

    void depositar(int monto) {
        if (monto <= 0) {
            System.out.println("Monto invalido: " + monto);
            return;
        }
        saldo += monto;
    }

    void gastar(int monto) {
        if (monto > saldo) {
            System.out.println("Saldo insuficiente para gastar " + monto);
            return;
        }
        saldo -= monto;
    }

    int getSaldo() {
        return saldo;
    }
}

public class Encapsulamiento {
    public static void main(String[] args) {
        Billetera b = new Billetera();
        b.depositar(5000);
        b.gastar(8000);                 // la clase se defiende sola
        b.depositar(-300);
        // b.saldo = 999999;            // ERROR: saldo es private
        System.out.println("Saldo: " + b.getSaldo());
    }
}
