import java.time.LocalDate;

/**
 * Un alumno con sus notas.
 *
 * <p>Las notas se guardan como ENTEROS en decimas: un 5.5 se guarda como 55.
 * Asi lo hace cualquier sistema academico real, y ademas hace que el promedio
 * se calcule con division entera. Eso importa: una division entera por cero
 * lanza {@code ArithmeticException}, mientras que con {@code double} daria
 * {@code NaN} en silencio, que es mucho peor.</p>
 *
 * <p>El arreglo es de tamano FIJO ({@value #MAX_NOTAS}) a proposito: un
 * {@code ArrayList} crece solo y nunca se desborda, y aqui queremos que se
 * desborde.</p>
 */
public class Alumno {

    /** Cuantas notas caben. La quinta revienta. */
    public static final int MAX_NOTAS = 4;

    private final String rut;
    private final String nombre;
    private final int[] notas = new int[MAX_NOTAS];
    private int cantidad;
    private LocalDate fechaMatricula;

    /**
     * @param rut el RUT con guion y sin puntos, por ejemplo 12345678-5
     * @param nombre el nombre del alumno
     * @throws IllegalArgumentException si el RUT no tiene el formato correcto
     * @throws StringIndexOutOfBoundsException hoy, si el RUT no trae guion:
     *         {@code indexOf} devuelve -1 y {@code substring(0, -1)} revienta
     * @throws NumberFormatException hoy, si el cuerpo del RUT trae letras
     */
    public Alumno(String rut, String nombre) {
        int guion = rut.indexOf('-');

        // TODO E10.1: si guion es -1, lanzar IllegalArgumentException diciendo
        //             que falta el guion. Sin esto, la linea de abajo hace
        //             substring(0, -1) y revienta con un mensaje inentendible.

        String cuerpo = rut.substring(0, guion);
        Integer.parseInt(cuerpo);   // solo para comprobar que el cuerpo es numerico

        this.rut = rut;
        this.nombre = nombre;
    }

    /**
     * Registra una nota nueva.
     *
     * @param valor la nota en la escala 1.0 - 7.0
     * @throws NotaInvalidaException si la nota esta fuera de la escala
     * @throws IllegalStateException si el alumno ya tiene {@value #MAX_NOTAS} notas
     * @throws ArrayIndexOutOfBoundsException hoy, en la quinta nota
     */
    public void agregarNota(double valor) {
        int decimas = (int) Math.round(valor * 10);

        // TODO E10.2: si decimas es menor que 10 o mayor que 70, lanzar
        //             NotaInvalidaException. Hoy acepta un 9.5 SIN CHISTAR,
        //             que es el peor de los casos: nadie se entera.

        // TODO E10.3: si cantidad ya llego a MAX_NOTAS, lanzar
        //             IllegalStateException. Hoy revienta con
        //             ArrayIndexOutOfBoundsException, que no le dice nada
        //             al usuario.

        notas[cantidad] = decimas;
        cantidad++;
    }

    /**
     * El promedio de las notas.
     *
     * @return el promedio en la escala 1.0 - 7.0
     * @throws ArithmeticException hoy, si el alumno no tiene notas: division
     *         entera por cero
     */
    public double promedio() {
        // TODO E10.4: decidir que hacer cuando el alumno no tiene notas.
        //             Hay dos respuestas defendibles y hay que elegir UNA:
        //               a) lanzar IllegalStateException ("todavia no rinde")
        //               b) devolver 0.0
        //             La (b) es comoda y es MENTIRA: dice que reprobo alguien
        //             que no ha dado ninguna prueba. Discutanlo en clase.

        int suma = 0;
        for (int i = 0; i < cantidad; i++) {
            suma += notas[i];
        }
        return (suma / cantidad) / 10.0;
    }

    /**
     * Fija la fecha de matricula a partir de su texto.
     *
     * @param texto la fecha en formato ISO, "2026-03-10"
     * @throws java.time.format.DateTimeParseException si el texto no es una
     *         fecha valida. Es UNCHECKED: el compilador no obliga a nada, y
     *         por eso se olvida tan facil.
     */
    public void setFechaMatricula(String texto) {
        this.fechaMatricula = LocalDate.parse(texto);
    }

    /**
     * @return el RUT del alumno
     */
    public String getRut() {
        return rut;
    }

    /**
     * @return el nombre del alumno
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return cuantas notas tiene registradas
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @return la fecha de matricula, o null si no se ha fijado
     */
    public LocalDate getFechaMatricula() {
        return fechaMatricula;
    }

    @Override
    public String toString() {
        return rut + "  " + nombre + "  (" + cantidad + " notas)";
    }
}
