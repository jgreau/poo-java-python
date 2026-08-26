/*
 * DEMO 08 - TODO JUNTO: MUNDO 1-1
 *
 * Compilar y ejecutar:
 *     javac *.java
 *     java Demo08
 *
 * Esta demo integra las siete anteriores en un solo ejemplo:
 *   objetos e instancias (demo 1)      encapsulamiento (demo 2)
 *   herencia y super (demo 3)          abstractas y polimorfismo (demo 4)
 *   composicion (demo 5)               interfaces (demo 7)
 *
 * LA JERARQUIA
 *     Entidad
 *     |- Personaje  -> Mario, Luigi, Toad, Peach
 *     |- Enemigo    -> Goomba, Koopa -> Paratroopa, Spiny, CheepCheep, BillBala
 *     \- Objeto     -> Moneda, Hongo, Estrella, Bloque
 *
 * LOS CONTRATOS (interfaces), que cruzan las tres ramas
 *     Volador       Peach (Personaje) + Paratroopa y BillBala (Enemigos)
 *     Nadador       Mario (Personaje) + CheepCheep (Enemigo)
 *     Aplastable    Goomba, Koopa, Paratroopa    (Spiny y BillBala NO)
 *     Recolectable  Moneda, Hongo, Estrella      (Bloque NO)
 */
public class Demo08 {
    public static void main(String[] args) {

        System.out.println("=== MUNDO 1-1 ===");

        // ---- Los cuatro personajes: misma clase padre, comportamientos distintos ----
        Mario mario = new Mario(0);
        Luigi luigi = new Luigi(0);
        Toad toad = new Toad(0);
        Peach peach = new Peach(2);

        // ---- Los enemigos ----
        Goomba goomba = new Goomba(12);
        Koopa koopa = new Koopa(18);
        Paratroopa paratroopa = new Paratroopa(24);
        Spiny spiny = new Spiny(30);
        CheepCheep cheep = new CheepCheep(36);
        BillBala bill = new BillBala(42);

        // ---- Los objetos ----
        Moneda moneda = new Moneda(8);
        Hongo hongo = new Hongo(15);
        Estrella estrella = new Estrella(27);
        Bloque bloque = new Bloque(10);

        // =====================================================================
        System.out.println("\n--- 1. UNA SOLA LISTA CON TODO EL NIVEL ---");
        // Un arreglo de Entidad guarda personajes, enemigos y objetos mezclados.
        // Todos responden a describir(), y cada rama dice su propio getTipo().
        Entidad[] nivel = {
            mario, peach, goomba, koopa, paratroopa, spiny, cheep, bill,
            moneda, hongo, estrella, bloque
        };
        for (Entidad e : nivel) {
            e.describir();
        }

        // =====================================================================
        System.out.println("\n--- 2. CADA PERSONAJE ES DISTINTO (polimorfismo) ---");
        // Mismo llamado, cuatro respuestas: cada subclase sobrescribe el metodo.
        Personaje[] jugables = { mario, luigi, toad, peach };
        for (Personaje p : jugables) {
            p.habilidadEspecial();
        }

        // =====================================================================
        System.out.println("\n--- 3. QUIEN SABE HACER QUE (los contratos) ---");
        System.out.printf("%-13s %-9s %-9s %-12s %s%n",
                          "Entidad", "Volador", "Nadador", "Aplastable", "Recolectable");
        for (Entidad e : nivel) {
            System.out.printf("%-13s %-9s %-9s %-12s %s%n",
                              e.getNombre(),
                              marca(e instanceof Volador),
                              marca(e instanceof Nadador),
                              marca(e instanceof Aplastable),
                              marca(e instanceof Recolectable));
        }

        // =====================================================================
        System.out.println("\n--- 4. LA INTERFAZ COMO TIPO ---");
        // Mira el tipo del arreglo: Volador. Adentro hay una princesa
        // (Personaje) y dos enemigos. Ninguna clase padre podria juntarlos.
        Volador[] voladores = { peach, paratroopa, bill };
        System.out.println("Un Volador[] con un Personaje y dos Enemigos adentro:");
        for (Volador v : voladores) {
            v.volar();
            System.out.println("      (altura " + v.alturaVuelo() + " m)");
        }

        System.out.println("Y lo mismo con Nadador, otra vez cruzando ramas:");
        Nadador[] nadadores = { mario, cheep };
        for (Nadador n : nadadores) {
            n.nadar();
        }

        // =====================================================================
        System.out.println("\n--- 5. MARIO RECORRE EL NIVEL ---");
        System.out.println("Mario empieza " + mario.getEstado() + " con "
                           + mario.getVidas() + " vidas.");

        System.out.println("Encuentra una " + moneda.getNombre() + ":");
        moneda.recolectar(mario);

        System.out.println("Encuentra un " + hongo.getNombre() + ":");
        hongo.recolectar(mario);

        System.out.println("Se topa con un Bloque:");
        bloque.golpear();
        // bloque.recolectar(mario);   // NO COMPILA: Bloque no es Recolectable

        System.out.println("Aparece un Goomba:");
        goomba.atacar();
        mario.pisar(goomba);

        System.out.println("Aparece un Koopa:");
        mario.pisar(koopa);

        System.out.println("Aparece un Paratroopa (que es un Koopa con alas):");
        mario.pisar(paratroopa);

        System.out.println("Encuentra una Estrella:");
        estrella.recolectar(mario);

        System.out.println("Aparece un Spiny (danio 1), y Mario esta "
                           + mario.getEstado() + ":");
        spiny.atacar();
        mario.pisar(spiny);          // no es Aplastable: Mario sale herido

        System.out.println("Aparece una BillBala (danio 2), y Mario esta "
                           + mario.getEstado() + ":");
        mario.pisar(bill);           // dos escalones de golpe

        // =====================================================================
        System.out.println("\n--- 6. ESTADO FINAL ---");
        System.out.printf("Mario -> %s | vidas: %d | monedas: %d | puntos: %d%n",
                          mario.getEstado(), mario.getVidas(),
                          mario.getMonedas(), mario.getPuntos());
        System.out.println("¿Sigue vivo? " + mario.estaVivo());

        // =====================================================================
        System.out.println("\n--- 6b. EL MISMO GOLPE, DOS RESULTADOS ---");
        // El estado del objeto decide como reacciona. Mismo enemigo,
        // mismo danio, dos personajes: lo unico que cambia es el estado.
        Luigi luigiPequeno = new Luigi(0);
        Toad toadGrande = new Toad(0);

        System.out.println("Luigi sigue PEQUENO. Toad comio un hongo:");
        hongo.recolectar(toadGrande);

        System.out.printf("%nLuigi (%s) pisa al Spiny:%n", luigiPequeno.getEstado());
        luigiPequeno.pisar(spiny);

        System.out.printf("%nToad (%s) pisa al mismo Spiny:%n", toadGrande.getEstado());
        toadGrande.pisar(spiny);

        System.out.println();
        System.out.printf("Luigi: %s, %d vidas%n", luigiPequeno.getEstado(), luigiPequeno.getVidas());
        System.out.printf("Toad:  %s, %d vidas%n", toadGrande.getEstado(), toadGrande.getVidas());
        System.out.println("Mismo enemigo, mismo danio. Lo unico distinto era el ESTADO.");

        // =====================================================================
        System.out.println("\n--- 7. POR QUE recibirPisoton() NO ESTA EN Enemigo ---");
        System.out.println("Spiny y BillBala son Enemigos pero NO son Aplastables.");
        System.out.println("Si el metodo viviera en la clase Enemigo, esas dos");
        System.out.println("clases tendrian que rellenarlo con una mentira.");
        // Estas dos lineas no compilan, y esta bien que no compilen:
        // Aplastable a = spiny;      // Spiny cannot be converted to Aplastable
        // Recolectable r = bloque;   // Bloque cannot be converted to Recolectable
    }

    static String marca(boolean condicion) {
        return condicion ? "si" : "-";
    }
}
