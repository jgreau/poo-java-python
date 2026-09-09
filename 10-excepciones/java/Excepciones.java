/*
 * LAS TRES EXCEPCIONES PROPIAS, EN UN SOLO ARCHIVO.
 *
 * Ojo con esto, porque contradice la regla de la hoja 00 ("una clase, un
 * archivo"): un archivo .java puede contener VARIAS clases, siempre que
 * ninguna de las extra sea public. Solo la clase public obliga a que el
 * archivo se llame igual que ella, y aqui no hay ninguna public.
 *
 * Lo hacemos asi para que la demo quepa en 5 archivos. En un proyecto de
 * verdad cada excepcion va en su propio archivo y es public, como en el
 * taller 09.
 *
 * Las tres muestran los tres casos que hay que saber distinguir:
 *
 *   CupoLlenoException          CHECKED    hay que declararla y capturarla
 *   AlumnoNoEncontradoException CHECKED    ademas lleva un dato adentro
 *   NotaInvalidaException       UNCHECKED  el compilador no dice nada
 */

/**
 * Se lanza al matricular a alguien en un curso que ya no tiene cupo.
 *
 * <p>CHECKED: extiende {@code Exception}. Todo metodo que la lance esta
 * obligado a declararla con {@code throws}, y quien lo llame esta obligado a
 * capturarla o a declararla de nuevo. El compilador no deja pasar.</p>
 *
 * <p>Es checked porque quien llama PUEDE hacer algo: ofrecer otro curso. No
 * es un error de programacion, es una situacion normal del negocio.</p>
 */
class CupoLlenoException extends Exception {

    /**
     * @param codigo el curso que ya no tiene cupo
     * @param cupo cuantos alumnos caben en ese curso
     */
    public CupoLlenoException(String codigo, int cupo) {
        super("El curso " + codigo + " ya completo su cupo de " + cupo + " alumnos");
    }
}

/**
 * Se lanza al buscar un alumno por RUT y no encontrarlo.
 *
 * <p>CHECKED tambien. Y ademas guarda el RUT: una excepcion no es solo un
 * mensaje de texto, puede llevar DATOS que le sirvan a quien la capture.</p>
 */
class AlumnoNoEncontradoException extends Exception {

    private final String rut;

    /**
     * @param rut el RUT que se busco sin exito
     */
    public AlumnoNoEncontradoException(String rut) {
        super("No existe ningun alumno con RUT " + rut);
        this.rut = rut;
    }

    /**
     * @return el RUT que no se encontro
     */
    public String getRut() {
        return rut;
    }
}

/**
 * Se lanza al registrar una nota fuera de la escala 1.0 - 7.0.
 *
 * <p>UNCHECKED: extiende {@code IllegalArgumentException}, que a su vez
 * extiende {@code RuntimeException}. Nadie esta obligado a declararla ni a
 * capturarla, y el programa compila igual aunque nadie la maneje.</p>
 *
 * <p>Es unchecked porque una nota 9.5 no es una situacion del negocio: es un
 * dato malo o un bug. Y fijate que no hereda de {@code RuntimeException}
 * directamente sino de {@code IllegalArgumentException}: una excepcion propia
 * puede colgarse de cualquier punto de la jerarquia del JDK. Por lo mismo, un
 * {@code catch (IllegalArgumentException e)} tambien la atrapa.</p>
 */
class NotaInvalidaException extends IllegalArgumentException {

    /**
     * @param valor la nota rechazada
     */
    public NotaInvalidaException(double valor) {
        super("La nota " + valor + " esta fuera de la escala 1.0 - 7.0");
    }
}
