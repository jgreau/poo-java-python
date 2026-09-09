/**
 * Un curso con cupo limitado.
 *
 * <p>Los inscritos viven en un arreglo cuyo tamano ES el cupo. Matricular a
 * uno de mas revienta, y crear un curso con cupo negativo revienta antes
 * todavia.</p>
 */
public class Curso {

    private final String codigo;
    private final String nombre;
    private final Alumno[] inscritos;
    private int cantidad;

    /**
     * @param codigo el codigo del curso, por ejemplo PRO101
     * @param nombre el nombre del curso
     * @param cupo cuantos alumnos caben; debe ser mayor que cero
     * @throws IllegalArgumentException si el cupo no es positivo
     * @throws NegativeArraySizeException hoy, con cupo negativo, porque nadie
     *         valida antes de crear el arreglo
     */
    public Curso(String codigo, String nombre, int cupo) {
        // TODO E10.5: si cupo es menor o igual a cero, lanzar
        //             IllegalArgumentException ANTES de crear el arreglo.

        this.codigo = codigo;
        this.nombre = nombre;
        this.inscritos = new Alumno[cupo];
    }

    /**
     * Matricula un alumno en este curso.
     *
     * @param a el alumno a matricular
     * @throws CupoLlenoException si el curso ya completo su cupo
     * @throws ArrayIndexOutOfBoundsException hoy, cuando se pasa del cupo
     */
    public void matricular(Alumno a) throws CupoLlenoException {
        // TODO E10.6: si cantidad ya llego al largo del arreglo, lanzar
        //             CupoLlenoException con el codigo y el cupo.
        //
        //             Compara los dos mensajes, antes y despues:
        //               "Index 2 out of bounds for length 2"
        //               "El curso PRO101 ya completo su cupo de 2 alumnos"
        //             Es la misma falla. Solo cambia quien se hace cargo.

        inscritos[cantidad] = a;
        cantidad++;
    }

    /**
     * @return el codigo del curso
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @return el nombre del curso
     */
    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return codigo + "  " + nombre + "  (" + cantidad + "/" + inscritos.length + ")";
    }
}
