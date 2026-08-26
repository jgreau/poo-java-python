/*
 * Fraccion.java
 *
 * Esta clase responde las tres preguntas que todo alumno hace:
 *   1) ¿Por que al imprimir mi objeto sale "Fraccion@1b6d3586"?   -> toString()
 *   2) ¿Por que dos objetos iguales dan false con "=="?           -> equals()
 *   3) ¿Puedo tener dos metodos con el mismo nombre?              -> sobrecarga
 */
public class Fraccion {

    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        if (denominador == 0) {
            throw new IllegalArgumentException("El denominador no puede ser 0");
        }
        this.numerador = numerador;
        this.denominador = denominador;
    }

    // ---------- SOBRECARGA: dos metodos "sumar" distintos ----------
    // Mismo nombre, distinta LISTA DE PARAMETROS. Eso es sobrecarga.
    public Fraccion sumar(Fraccion otra) {
        int n = this.numerador * otra.denominador + otra.numerador * this.denominador;
        int d = this.denominador * otra.denominador;
        return new Fraccion(n, d);
    }

    public Fraccion sumar(int entero) {
        return new Fraccion(this.numerador + entero * this.denominador,
                            this.denominador);
    }

    // ---------- toString(): como se representa el objeto como texto ----------
    // Sin esto, System.out.println(objeto) imprime la direccion de memoria.
    @Override
    public String toString() {
        return this.numerador + "/" + this.denominador;
    }

    // ---------- equals(): que significa "iguales" para ESTA clase ----------
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;                  // es el mismo objeto
        if (obj == null) return false;
        if (!(obj instanceof Fraccion)) return false;  // ni siquiera es una Fraccion

        Fraccion otra = (Fraccion) obj;
        // 1/2 y 2/4 son la misma fraccion: comparamos en cruz
        // (podemos leer otra.numerador aunque sea private: private es POR CLASE)
        return this.numerador * otra.denominador == otra.numerador * this.denominador;
    }

    // Regla de oro de Java: si sobrescribes equals(), sobrescribe hashCode().
    @Override
    public int hashCode() {
        double valor = (double) numerador / denominador;
        return Double.hashCode(valor);
    }
}
