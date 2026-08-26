/*
 * Personaje.java - RAMA 1 de la jerarquia
 *
 * Aqui vive el ESTADO que todo personaje jugable tiene: vidas, monedas,
 * puntos, velocidad y salto. Como es estado compartido, esto TIENE que
 * ser una clase abstracta y no una interfaz: una interfaz no guarda datos.
 *
 * Y como cada personaje se distingue por algo que HACE, no solo por sus
 * numeros, habilidadEspecial() es abstracto: cada hijo esta obligado a
 * decir en que es distinto.
 */
public abstract class Personaje extends Entidad {

    protected int vidas;
    protected int monedas;
    protected int puntos;
    protected int velocidad;
    protected int salto;

    /*
     * EL ESTADO DEL PERSONAJE.
     *
     * Un objeto no es solo una bolsa de datos: tambien tiene un ESTADO que
     * cambia con el tiempo y que decide como reacciona a lo que le pasa.
     *
     *    PEQUENO --(hongo)--> GRANDE
     *    GRANDE  --(danio)--> PEQUENO      (no pierde vida)
     *    PEQUENO --(danio)--> muere        (pierde una vida)
     *
     * El mismo golpe produce dos resultados distintos segun el estado.
     * Por eso esGrande es "protected" y no "public": si cualquiera pudiera
     * escribirlo desde afuera, estas reglas no valdrian nada.
     */
    protected boolean esGrande;

    public Personaje(String nombre, int x, int velocidad, int salto) {
        super(nombre, x);
        this.velocidad = velocidad;
        this.salto = salto;
        this.vidas = 3;
        this.monedas = 0;
        this.puntos = 0;
        this.esGrande = false;      // todos parten PEQUENOS
    }

    @Override
    public String getTipo() { return "Personaje"; }

    // Lo que hace distinto a cada personaje
    public abstract void habilidadEspecial();

    // ---- Comportamiento comun a todos ----
    public void avanzar(int pasos) {
        this.x += pasos * this.velocidad;
    }

    /*
     * CRECER: la unica forma de pasar a GRANDE.
     */
    public void crecer() {
        if (this.esGrande) {
            System.out.println("      " + nombre + " ya estaba GRANDE");
            return;
        }
        this.esGrande = true;
        System.out.println("      " + nombre + ": PEQUENO -> GRANDE");
    }

    /*
     * RECIBIR DANIO: aqui esta la maquina de estados.
     *
     * Cada punto de danio baja UN escalon. Por eso la BillBala, que hace 2,
     * mata a un personaje GRANDE de un solo encuentro: lo encoge y lo remata.
     */
    public void recibirDanio(int danio) {
        System.out.println("   " + nombre + " recibe " + danio + " de danio");
        for (int golpe = 1; golpe <= danio; golpe++) {
            if (this.esGrande) {
                this.esGrande = false;
                System.out.println("      estaba GRANDE -> encoge a PEQUENO (no pierde vida)");
            } else {
                this.vidas--;
                System.out.println("      estaba PEQUENO -> muere y pierde una vida"
                                   + " (le quedan " + vidas + ")");
                if (this.vidas <= 0) {
                    System.out.println("      *** GAME OVER ***");
                } else {
                    System.out.println("      revive PEQUENO en el ultimo checkpoint");
                }
                return;    // ya murio: el danio que sobra no se aplica
            }
        }
    }

    public boolean estaVivo() {
        return this.vidas > 0;
    }

    public boolean esGrande() {
        return this.esGrande;
    }

    public String getEstado() {
        return this.esGrande ? "GRANDE" : "PEQUENO";
    }

    public void sumarMonedas(int cantidad) {
        this.monedas += cantidad;
    }

    public void sumarPuntos(int cantidad) {
        this.puntos += cantidad;
    }

    /*
     * PISAR: aqui se ve el polimorfismo trabajando de verdad.
     *
     * Mario no sabe si el enemigo que tiene enfrente es un Goomba o un
     * Spiny. Solo pregunta: ¿firmaste el contrato Aplastable?
     */
    public void pisar(Enemigo enemigo) {
        if (enemigo instanceof Aplastable) {
            Aplastable victima = (Aplastable) enemigo;
            System.out.println("   " + nombre + " salta sobre " + enemigo.getNombre() + ":");
            victima.recibirPisoton();
            sumarPuntos(victima.puntosQueDa());
            System.out.println("      +" + victima.puntosQueDa() + " puntos");
        } else {
            System.out.println("   " + nombre + " salta sobre " + enemigo.getNombre()
                               + "... pero NO es Aplastable!");
            recibirDanio(enemigo.getDanio());
        }
    }

    public int getVidas()   { return vidas; }
    public int getMonedas() { return monedas; }
    public int getPuntos()  { return puntos; }
}
