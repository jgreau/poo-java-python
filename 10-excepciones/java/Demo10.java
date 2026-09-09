import java.util.Scanner;

/*
 * DEMO 10 - EXCEPCIONES
 *
 * Compilar y ejecutar:
 *     javac *.java
 *     java Demo10
 *
 * ESTE PROGRAMA COMPILA PERFECTO Y SE CAE CON TODO.
 * No hay un solo try-catch en los cinco archivos. Esa es la tarea.
 *
 * ------------------------------------------------------------------------
 * EL TRUCO QUE HACE QUE ESTO COMPILE: el "throws Exception" del main.
 *
 * Exception es la clase padre de casi todas las excepciones. Declararla en
 * el main equivale a decir "cualquier cosa que pase, la dejo salir". Con
 * eso, las CHECKED dejan de ser un error de compilacion... y pasan a ser un
 * programa que se muere delante del usuario.
 *
 * PRIMER EJERCICIO (E10.0): borra el "throws Exception" de la linea del main
 * y compila. Aparecen de golpe los errores de las excepciones CHECKED.
 * Las UNCHECKED no aparecen ahi, y por eso son mas peligrosas: nadie te
 * avisa hasta que el programa ya reventó delante del usuario.
 * ------------------------------------------------------------------------
 *
 * Los cinco archivos:
 *     Demo10.java       el menu                        <- estas aqui
 *     Alumno.java       notas en arreglo fijo, promedio, RUT, fecha
 *     Curso.java        inscritos en arreglo fijo: el cupo
 *     Registro.java     las busquedas que devuelven null, y el archivo
 *     Excepciones.java  las tres excepciones propias, juntas
 *
 * Y un archivo de datos: notas.csv
 *
 * En TABLA-EXCEPCIONES.md esta que hay que tipear para hacer caer cada una.
 */
public class Demo10 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        Registro registro = new Registro();
        precargar(registro);

        System.out.println();
        System.out.println("=================================");
        System.out.println("  REGISTRO DUOC - demo 10");
        System.out.println("=================================");
        System.out.println("Sin un solo try-catch. Rompelo.");

        boolean salir = false;
        while (!salir) {
            menu();
            System.out.print("Opcion: ");

            // Escribe "abc" aqui: InputMismatchException.
            // Cierra la entrada con Ctrl-D: NoSuchElementException.
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1: listar(registro); break;
                case 2: crearAlumno(sc, registro); break;
                case 3: crearCurso(sc, registro); break;
                case 4: matricular(sc, registro); break;
                case 5: ponerNota(sc, registro); break;
                case 6: verPromedio(sc, registro); break;
                case 7: cargarArchivo(sc, registro); break;
                case 8: registro.informe(); break;
                case 9: fecha(sc, registro); break;
                case 0: salir = true; break;
                default:
                    // TODO E10.11: lanzar IllegalArgumentException con la opcion
                    //              recibida, y capturarla arriba para que el
                    //              menu siga vivo en vez de morirse.
                    System.out.println("   Opcion no valida.");
            }
        }

        // TODO E10.12: si algo revienta mas arriba, este close() nunca corre.
        //              Va en un finally, o mejor: try-with-resources.
        sc.close();
        System.out.println("Hasta la proxima.");
    }

    /**
     * Imprime el menu. Cada opcion es una excepcion esperando.
     */
    private static void menu() {
        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println(" 1) Listar todo");
        System.out.println(" 2) Crear alumno      (RUT 123456785 ?)");
        System.out.println(" 3) Crear curso       (cupo -3 ?)");
        System.out.println(" 4) Matricular        (llena el cupo)");
        System.out.println(" 5) Poner nota        (9.5 ? la 5a ?)");
        System.out.println(" 6) Ver promedio      (uno sin notas ?)");
        System.out.println(" 7) Cargar notas.csv  (un archivo que no existe ?)");
        System.out.println(" 8) Informe           (el cast a ciegas)");
        System.out.println(" 9) Fecha matricula   (2026-13-45 ?)");
        System.out.println(" 0) Salir");
        System.out.println("-----------------------------------------");
    }

    /**
     * Carga tres alumnos y dos cursos para tener con que jugar.
     *
     * @param registro el registro a poblar
     * @throws CupoLlenoException si el cupo precargado no alcanza
     */
    private static void precargar(Registro registro) throws CupoLlenoException {
        Alumno ana = new Alumno("11111111-1", "Ana Rojas");
        Alumno bruno = new Alumno("12345678-5", "Bruno Diaz");
        Alumno carla = new Alumno("18456321-5", "Carla Soto");

        bruno.agregarNota(5.5);
        bruno.agregarNota(6.2);
        carla.agregarNota(3.4);

        registro.agregar(ana);
        registro.agregar(bruno);
        registro.agregar(carla);

        Curso pro = new Curso("PRO101", "Programacion", 2);
        Curso poo = new Curso("POO303", "Orientada a Objetos", 3);
        pro.matricular(bruno);

        registro.agregar(pro);
        registro.agregar(poo);

        System.out.println("Precargados: 3 alumnos, 2 cursos.");
        System.out.println("Ana no tiene notas. PRO101 tiene cupo 2 y ya usa 1.");
    }

    /**
     * @param registro el registro a mostrar
     */
    private static void listar(Registro registro) {
        System.out.println("   ALUMNOS");
        for (Alumno a : registro.getAlumnos()) {
            System.out.println("   " + a);
        }
        System.out.println("   CURSOS");
        for (Curso c : registro.getCursos()) {
            System.out.println("   " + c);
        }
    }

    /**
     * @param sc la entrada por teclado
     * @param registro el registro donde crear el alumno
     */
    private static void crearAlumno(Scanner sc, Registro registro) {
        System.out.print("   RUT con guion, sin puntos: ");
        String rut = sc.nextLine();
        System.out.print("   Nombre: ");
        String nombre = sc.nextLine();

        registro.agregar(new Alumno(rut, nombre));
        System.out.println("   Alumno creado.");
    }

    /**
     * @param sc la entrada por teclado
     * @param registro el registro donde crear el curso
     */
    private static void crearCurso(Scanner sc, Registro registro) {
        System.out.print("   Codigo: ");
        String codigo = sc.nextLine();
        System.out.print("   Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("   Cupo: ");
        int cupo = sc.nextInt();
        sc.nextLine();

        registro.agregar(new Curso(codigo, nombre, cupo));
        System.out.println("   Curso creado.");
    }

    /**
     * @param sc la entrada por teclado
     * @param registro el registro donde buscar
     * @throws CupoLlenoException si el curso ya esta lleno
     * @throws AlumnoNoEncontradoException si el RUT no existe
     */
    private static void matricular(Scanner sc, Registro registro)
            throws CupoLlenoException, AlumnoNoEncontradoException {
        System.out.print("   RUT del alumno: ");
        String rut = sc.nextLine();
        System.out.print("   Codigo del curso: ");
        String codigo = sc.nextLine();

        Alumno a = registro.buscarAlumno(rut);
        Curso c = registro.buscarCurso(codigo);
        c.matricular(a);
        System.out.println("   " + a.getNombre() + " matriculado en " + c.getCodigo());
    }

    /**
     * @param sc la entrada por teclado
     * @param registro el registro donde buscar al alumno
     * @throws AlumnoNoEncontradoException si el RUT no existe
     */
    private static void ponerNota(Scanner sc, Registro registro)
            throws AlumnoNoEncontradoException {
        System.out.print("   RUT del alumno: ");
        String rut = sc.nextLine();
        System.out.print("   Nota: ");
        double valor = sc.nextDouble();
        sc.nextLine();

        Alumno a = registro.buscarAlumno(rut);
        a.agregarNota(valor);
        System.out.println("   Listo. Ahora tiene " + a.getCantidad() + " notas.");
    }

    /**
     * @param sc la entrada por teclado
     * @param registro el registro donde buscar al alumno
     * @throws AlumnoNoEncontradoException si el RUT no existe
     */
    private static void verPromedio(Scanner sc, Registro registro)
            throws AlumnoNoEncontradoException {
        System.out.print("   RUT del alumno: ");
        String rut = sc.nextLine();

        Alumno a = registro.buscarAlumno(rut);
        System.out.println("   Promedio de " + a.getNombre() + ": " + a.promedio());
    }

    /**
     * @param sc la entrada por teclado
     * @param registro el registro donde cargar las notas
     * @throws java.io.FileNotFoundException si el archivo no existe
     * @throws AlumnoNoEncontradoException si una linea apunta a un RUT inexistente
     */
    private static void cargarArchivo(Scanner sc, Registro registro)
            throws java.io.FileNotFoundException, AlumnoNoEncontradoException {
        System.out.print("   Archivo [notas.csv]: ");
        String ruta = sc.nextLine().trim();
        if (ruta.isEmpty()) {
            ruta = "notas.csv";
        }

        int cargadas = registro.cargarNotas(ruta);
        System.out.println("   " + cargadas + " notas cargadas.");
    }

    /**
     * @param sc la entrada por teclado
     * @param registro el registro donde buscar al alumno
     * @throws AlumnoNoEncontradoException si el RUT no existe
     */
    private static void fecha(Scanner sc, Registro registro)
            throws AlumnoNoEncontradoException {
        System.out.print("   RUT del alumno: ");
        String rut = sc.nextLine();
        System.out.print("   Fecha aaaa-mm-dd: ");
        String texto = sc.nextLine();

        Alumno a = registro.buscarAlumno(rut);
        a.setFechaMatricula(texto);
        System.out.println("   Matriculado el " + a.getFechaMatricula());
    }
}
