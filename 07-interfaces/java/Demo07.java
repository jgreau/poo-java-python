/*
 * DEMO 07 - INTERFACES
 *
 * Compilar y ejecutar:
 *     javac *.java
 *     java Demo07
 *
 * Diez archivos:
 *     Animal.java     clase abstracta: lo que un animal ES
 *     Ave.java        rama 1 de la jerarquia
 *     Mamifero.java   rama 2 de la jerarquia
 *     Nadador.java    INTERFAZ: lo que algo SABE HACER
 *     Volador.java    INTERFAZ
 *     Pato.java       Ave + Nadador + Volador
 *     Pinguino.java   Ave + Nadador          (no vuela!)
 *     Aguila.java     Ave + Volador          (no nada)
 *     Delfin.java     Mamifero + Nadador     (otra jerarquia)
 *     Demo07.java     el programa   <- estas aqui
 *
 * LA PREGUNTA QUE RESPONDE ESTA DEMO:
 *     si ya tenemos herencia, ¿para que sirven las interfaces?
 */
public class Demo07 {
    public static void main(String[] args) {

        Pato donald = new Pato("Donald", 3);
        Pinguino pingu = new Pinguino("Pingu", 5);
        Aguila pedro = new Aguila("Pedro", 7);
        Delfin flipper = new Delfin("Flipper", 10);

        System.out.println("--- Lo que cada uno ES (herencia) ---");
        Animal[] animales = { donald, pingu, pedro, flipper };
        for (Animal a : animales) {
            a.presentarse();
        }

        System.out.println("--- Lo que cada uno SABE HACER (interfaces) ---");
        System.out.printf("%-20s %-9s %s%n", "", "Nadador", "Volador");
        for (Animal a : animales) {
            String etiqueta = a.getNombre() + " (" + a.getClass().getSimpleName() + ")";
            System.out.printf("%-20s %-9s %s%n",
                              etiqueta,
                              (a instanceof Nadador) ? "si" : "no",
                              (a instanceof Volador) ? "si" : "no");
        }

        System.out.println("--- LA INTERFAZ COMO TIPO ---");
        // Fijate en el tipo del arreglo: Nadador, no Animal ni Ave.
        // Adentro hay un Ave y un Mamifero, que no comparten ancestro
        // salvo Animal. La interfaz los junta; la herencia no podria.
        Nadador[] nadadores = { donald, pingu, flipper };
        System.out.println("Un arreglo de Nadador con un Ave y un Mamifero adentro:");
        for (Nadador n : nadadores) {
            n.nadar();
        }

        System.out.println("--- Un metodo que solo pide el contrato ---");
        Nadador ganador = elMasRapido(nadadores);
        System.out.printf("Gana la competencia: %.1f km/h%n", ganador.velocidadEnAgua());
        // Ojo: la variable es de tipo Nadador, asi que solo conoce nadar()
        // y velocidadEnAgua(). Para volver a tratarlo como Animal hay que castear:
        System.out.println("Y es: " + ((Animal) ganador).getNombre());

        System.out.println("--- Otro contrato, otros participantes ---");
        Volador[] voladores = { donald, pedro };
        for (Volador v : voladores) {
            v.volar();
            System.out.println("      (hasta " + v.alturaMaxima() + " m)");
        }

        System.out.println("--- POR QUE volar() NO PUEDE ESTAR EN LA CLASE Ave ---");
        System.out.println("Pingu es un Ave, pero no implementa Volador.");
        System.out.println("Si volar() viviera en Ave, el pinguino estaria obligado");
        System.out.println("a heredar un metodo que no tiene ningun sentido para el.");
        // Esto no compila, y esta bien que no compile:
        // Volador v = pingu;   // error: Pinguino cannot be converted to Volador
    }

    // Este metodo no sabe de patos ni de delfines. Solo exige el contrato.
    static Nadador elMasRapido(Nadador[] participantes) {
        Nadador mejor = participantes[0];
        for (Nadador n : participantes) {
            if (n.velocidadEnAgua() > mejor.velocidadEnAgua()) {
                mejor = n;
            }
        }
        return mejor;
    }
}
