/*
 * Alumno.java
 *
 * Ojo a la mezcla que hay en este archivo:
 *
 *   static  -> pertenece a la CLASE. Existe UNA sola copia para todo el
 *              programa, aunque crees mil alumnos.
 *   normal  -> pertenece a cada OBJETO. Cada alumno tiene el suyo.
 *
 * Regla practica: si al leerlo piensas "esto es de Camila", va sin static.
 * Si piensas "esto es de los alumnos en general", va con static.
 */
public class Alumno {

    // STATIC = pertenece a la CLASE. Una sola copia para todo el programa.
    private static int totalCreados = 0;

    // STATIC FINAL = constante de clase (se escribe en MAYUSCULAS por convencion)
    public static final String COLEGIO = "Colegio Central";
    public static final double NOTA_MINIMA = 4.0;

    // Atributos de INSTANCIA: cada alumno tiene los suyos
    private String nombre;
    private double nota;

    public Alumno(String nombre, double nota) {
        this.nombre = nombre;
        this.nota = nota;
        totalCreados++;            // sin "this": no es de este objeto, es de la clase
    }

    public String getNombre() { return this.nombre; }
    public double getNota()   { return this.nota; }

    // Metodo estatico: no usa "this", no necesita un objeto para funcionar
    public static boolean aprueba(double nota) {
        return nota >= NOTA_MINIMA;
    }

    public static int getTotalCreados() {
        return totalCreados;
    }
}
