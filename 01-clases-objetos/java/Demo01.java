/*
 * DEMO 01 - CLASES Y OBJETOS
 *
 * Compilar y ejecutar:
 *     javac *.java
 *     java Demo01
 *
 * Idea clave: una CLASE es el molde. Un OBJETO (o instancia) es cada
 * galleta que sale de ese molde. El molde no se come; las galletas si.
 *
 * Esta clase SI tiene main(): es la que se ejecuta.
 * No necesita "import" para ver a Perro porque estan en la misma carpeta.
 */
public class Demo01 {
    public static void main(String[] args) {

        // CREAR INSTANCIAS: cada "new" fabrica un objeto nuevo e independiente
        Perro firulais = new Perro("Firulais", "Mestizo", 3);
        Perro laika = new Perro("Laika", "Husky", 5);

        firulais.presentarse();
        laika.presentarse();

        System.out.println("---");

        firulais.ladrar();
        firulais.cumplirAnios();

        // Laika NO cambio: son objetos distintos, con memoria distinta
        laika.presentarse();

        System.out.println("---");

        // Los atributos se leen y se escriben con el punto
        System.out.println("La raza de laika es: " + laika.raza);
        laika.raza = "Husky Siberiano";
        laika.presentarse();
    }
}
