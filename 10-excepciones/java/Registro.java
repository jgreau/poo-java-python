import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * El registro completo: los alumnos, los cursos y la carga desde archivo.
 *
 * <p>Aqui estan las dos busquedas del sistema, y las dos estan mal hechas de
 * la misma forma: cuando no encuentran, devuelven {@code null}. Ese null se
 * propaga en silencio y revienta despues, en OTRA clase, con un
 * {@code NullPointerException} que no dice ni que se buscaba ni donde.</p>
 */
public class Registro {

    private final List<Alumno> alumnos = new ArrayList<>();
    private final List<Curso> cursos = new ArrayList<>();

    /**
     * @param a el alumno a incorporar
     */
    public void agregar(Alumno a) {
        alumnos.add(a);
    }

    /**
     * @param c el curso a incorporar
     */
    public void agregar(Curso c) {
        cursos.add(c);
    }

    /**
     * Busca un alumno por su RUT.
     *
     * @param rut el RUT a buscar
     * @return el alumno correspondiente
     * @throws AlumnoNoEncontradoException si no existe un alumno con ese RUT
     */
    public Alumno buscarAlumno(String rut) throws AlumnoNoEncontradoException {
        for (Alumno a : alumnos) {
            if (a.getRut().equals(rut)) {
                return a;
            }
        }
        // TODO E10.7: lanzar AlumnoNoEncontradoException en vez de devolver null.
        //
        //             Fijate en que la firma YA declara el throws: por eso el
        //             programa compila aunque el throw todavia no exista.
        //             Declarar una excepcion que nunca lanzas es legal en Java.
        return null;
    }

    /**
     * Busca un curso por su codigo.
     *
     * @param codigo el codigo a buscar
     * @return el curso correspondiente, o null si no existe
     */
    public Curso buscarCurso(String codigo) {
        for (Curso c : cursos) {
            if (c.getCodigo().equals(codigo)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Carga notas desde un archivo con lineas {@code rut;nota}.
     *
     * <p>Esta es la unica excepcion CHECKED del JDK en toda la demo:
     * {@code new Scanner(new File(...))} declara {@code FileNotFoundException}.
     * Sin manejarla, esta clase NO COMPILA. Prueba a borrar el {@code throws}
     * de la firma y mira lo que dice javac.</p>
     *
     * @param ruta la ruta del archivo
     * @return cuantas notas se cargaron
     * @throws FileNotFoundException si el archivo no existe
     * @throws AlumnoNoEncontradoException si una linea apunta a un RUT que no existe
     * @throws NumberFormatException hoy, si una nota no es un numero
     */
    public int cargarNotas(String ruta)
            throws FileNotFoundException, AlumnoNoEncontradoException {

        Scanner archivo = new Scanner(new File(ruta));
        int cargadas = 0;

        while (archivo.hasNextLine()) {
            String linea = archivo.nextLine();
            if (linea.isBlank() || linea.startsWith("#")) {
                continue;
            }

            String[] partes = linea.split(";");
            double valor = Double.parseDouble(partes[1]);

            // TODO E10.8: envolver ese parseDouble en un try-catch y relanzar
            //             un IllegalArgumentException que diga QUE LINEA fallo.
            //             El mensaje de hoy, 'For input string: "cinco"', no
            //             dice ni el archivo ni la linea: no le sirve a nadie.

            Alumno a = buscarAlumno(partes[0]);
            a.agregarNota(valor);
            cargadas++;
        }

        // TODO E10.9: este close() solo corre si NADA fallo antes. Si una
        //             linea revienta, el archivo queda abierto. Va en un
        //             finally, o mejor: usa try-with-resources.
        archivo.close();

        return cargadas;
    }

    /**
     * Imprime un informe recorriendo alumnos y cursos mezclados.
     *
     * <p>El arreglo es {@code Object[]}, asi que acepta cualquier cosa. El
     * compilador no puede saber que hay adentro y el cast lo hacemos nosotros
     * a ciegas.</p>
     *
     * @throws ClassCastException al llegar al Curso colado entre los alumnos
     */
    public void informe() {
        Object[] items = new Object[3];
        items[0] = alumnos.get(0);
        items[1] = cursos.get(0);
        items[2] = alumnos.get(1);

        for (Object o : items) {
            // TODO E10.10: protege el cast con instanceof en vez de capturar
            //              el ClassCastException. En Java 17 se escribe
            //              'if (o instanceof Alumno a)' y el cast desaparece.
            //              Capturar excepciones para controlar el flujo normal
            //              es mala practica: la excepcion es para lo EXCEPCIONAL.
            Alumno a = (Alumno) o;
            System.out.println("   " + a.getNombre());
        }
    }

    /**
     * @return la lista de alumnos
     */
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    /**
     * @return la lista de cursos
     */
    public List<Curso> getCursos() {
        return cursos;
    }
}
