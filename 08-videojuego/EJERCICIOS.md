# Demo 08 - Mundo 1-1 | Ejercicios

Esta demo integra todo el curso, asi que la hoja recorre los cuatro
movimientos de siempre, se detiene en el **estado del objeto** y termina
con ejercicios de **diseno**: no solo escribir codigo, sino decidir donde
va cada cosa.

Recuerda: `javac *.java` y despues `java Demo08`.

---

### E8.1 - Crear una nueva instancia
En `Demo08.java`, agrega un segundo Goomba en `x=20` y una segunda Moneda
en `x=5`. Metelos en el arreglo `nivel` y vuelve a correr.

La tabla de contratos y la lista del nivel se completan solas.

> No tocaste ninguna clase. El molde ya servia.

---

### E8.2 - Leer la maquina de estados antes de tocarla
Abre `Personaje.java` y busca `recibirDanio()`. Ahi esta la regla del juego:

```
PEQUENO --(hongo)--> GRANDE
GRANDE  --(danio)--> PEQUENO      no pierde vida
PEQUENO --(danio)--> muere        pierde una vida
```

Responde **leyendo el codigo**, sin ejecutarlo:

1. Mario esta GRANDE con 3 vidas y pisa un Spiny (danio 1). ¿Como queda?
2. El mismo Mario GRANDE recibe a la BillBala (danio 2). ¿Como queda?
3. Mario esta PEQUENO con 1 vida y toca un Goomba. ¿Que se imprime?
4. ¿Por que hay un `return` dentro del `else`, y no un `break`?

Ahora corre la demo y comprueba. La seccion **6b** hace justo esto: Luigi
PEQUENO y Toad GRANDE reciben **el mismo golpe del mismo Spiny** y terminan
distinto. Uno pierde una vida, el otro solo encoge.

> El concepto: un objeto no es una bolsa de datos. Tiene un **estado** que
> decide como reacciona. El mismo mensaje (`recibirDanio(1)`) produce dos
> resultados distintos, y no hay ningun `if` en quien lo llama.

---

### E8.3 - Agregar un atributo
Agrega `puntosDeVida` a la clase `Enemigo` (Goomba 1, Koopa 2, BillBala 5),
con su getter, y muestralo en la tabla de la seccion 3.

Como lo agregas al **padre**, todos los constructores de los hijos se rompen.
Arreglalos: son seis clases.

> Es la misma leccion de E3.3, pero ahora con seis hijos en vez de dos.
> Cuenta cuantos archivos tuviste que abrir. **La herencia acopla.**

---

### E8.4 - Agregar un metodo que use el estado
Agrega a `Personaje` el metodo `puedeRomperBloques()`, que devuelva `true`
solo si el personaje esta GRANDE (en el juego, Mario pequeno no rompe los
ladrillos: solo los golpea desde abajo).

Usalo en `Bloque.golpear(Personaje quien)`:
- si el personaje esta GRANDE, el bloque se rompe
- si esta PEQUENO, solo suelta una moneda

```java
public void golpear(Personaje quien) {
    if (quien.puedeRomperBloques()) {
        System.out.println("      El bloque se rompe en pedazos");
    } else {
        System.out.println("      El bloque suelta una moneda");
    }
}
```

**Ojo:** al cambiarle la firma a `golpear()`, la llamada que ya existe en
`Demo08.java` deja de compilar (`method golpear cannot be applied to given
types`). Actualizala a `bloque.golpear(mario)`.

Pruebalo con Mario antes y despues de comerse el hongo.

> Fijate en lo que **no** hiciste: no preguntaste `if (mario.esGrande)` desde
> afuera. Le preguntaste al objeto. El personaje es el unico que decide que
> significa su propio estado.

---

### E8.5 - Un segundo estado: la invencibilidad
La `Estrella` da puntos pero no hace nada mas, y el comentario del archivo
lo dice sin disimulo. Implementala:

1. Agrega a `Personaje` un `protected int golpesInvencible;`
2. Agrega `activarInvencibilidad(int golpes)`
3. Al principio de `recibirDanio()`, si `golpesInvencible > 0`, que baje el
   contador, imprima que el golpe rebota y **salga sin hacer nada mas**
4. Haz que `Estrella.recolectar()` llame a `activarInvencibilidad(2)`
5. Borra el comentario de `Estrella.java`, que ya no corresponde

Prueba: Mario recoge la estrella y despues pisa al Spiny. No deberia pasarle nada.

> Ahora el personaje tiene **dos estados a la vez**: tamano e invencibilidad.
> ¿Se te ocurre un tercero que exista en el juego? (Pista: la flor de fuego.)

---

### E8.6 - Cuando el boolean se queda corto
Agrega el estado **FUEGO**: un personaje que come una Flor puede lanzar
bolas de fuego, y al recibir danio baja a GRANDE en vez de a PEQUENO.

```
PEQUENO --(hongo)--> GRANDE --(flor)--> FUEGO
FUEGO --(danio)--> GRANDE --(danio)--> PEQUENO --(danio)--> muere
```

1. Intenta hacerlo **con el boolean que ya existe**. No se puede: un boolean
   tiene dos valores y ahora hacen falta tres.
2. Intenta con dos booleans (`esGrande` y `tieneFuego`). Funciona, pero
   ahora existe la combinacion imposible `!esGrande && tieneFuego`.
   ¿Que pasa si alguien la produce?
3. La solucion buena es un **enum**:

```java
public enum Estado { PEQUENO, GRANDE, FUEGO }
```
Va en su **propio archivo** `Estado.java`: un `enum` publico sigue la misma
regla que una clase publica (hoja 00).

Reemplaza el boolean por `protected Estado estado;`, reescribe
`recibirDanio()` con los tres casos, y crea `Flor.java` (un `Objeto` que
implementa `Recolectable` y llama a `tomarFlor()`).

Comprueba la cadena completa con un personaje: `crecer()`, `tomarFlor()`,
y despues tres golpes seguidos de danio 1. Deberia recorrer
FUEGO -> GRANDE -> PEQUENO -> muere.

> Esta es la leccion de diseno mas util de toda la hoja: **un boolean sirve
> mientras haya exactamente dos estados**. Al aparecer el tercero, el boolean
> deja de representar la realidad y empiezan a existir combinaciones que no
> deberian poder ocurrir. El enum hace imposible el estado invalido.

---

### E8.7 - Crear un personaje nuevo (subclase)
Crea `Wario.java`: `extends Personaje`, lento (velocidad 3) pero fuerte,
y que **implemente `Recolectable`**... no, espera. Piensa antes de escribir:

1. ¿Tiene sentido que un personaje sea `Recolectable`? ¿Que significaria?
2. ¿Que interfaz **si** le calzaria a Wario? (Pista: en los juegos, Wario
   tiene un ataque de embestida y puede caer con fuerza.)
3. Si ninguna de las cuatro le sirve, **crea una interfaz nueva**
   `Embestidor` con `embestir()` y `fuerzaEmbestida()`, y hazla firmar
   tambien por el `BillBala`.

> El punto del ejercicio no es escribir Wario. Es que **una interfaz no se
> implementa porque exista, sino porque el contrato tiene sentido**.

---

### E8.8 - Crear un enemigo volador que lanza otros enemigos
Crea `Lakitu.java`: `extends Enemigo implements Volador`, que ademas
tenga un metodo `lanzarSpiny()` que **devuelva un `Spiny` nuevo**.

```java
public Spiny lanzarSpiny() {
    System.out.println("   Lakitu lanza un Spiny desde su nube");
    return new Spiny(this.x);
}
```

En `Demo08.java`:
```java
Lakitu lakitu = new Lakitu(50);
Spiny caido = lakitu.lanzarSpiny();
mario.pisar(caido);
```

> Aqui hay dos conceptos juntos: un metodo que **crea y devuelve objetos**,
> y una clase que **contiene** a otra (composicion, demo 5).

---

### E8.9 - Agregar un metodo a una interfaz
Agrega `String sonidoAlMorir();` a la interfaz `Aplastable`.

Compila y **cuenta los errores antes de leer la respuesta**. ¿Cuantas clases
se rompen?

```
Goomba.java:7: error: Goomba is not abstract and does not override
               abstract method sonidoAlMorir() in Aplastable
Koopa.java:8:  error: Koopa is not abstract and does not override
               abstract method sonidoAlMorir() in Aplastable
```

**Dos, no tres.** Y la pregunta interesante es: ¿por que `Paratroopa` no
aparece en la lista, si tambien es `Aplastable`?

> Porque `Paratroopa extends Koopa`. Cuando arregles `Koopa`, el Paratroopa
> **hereda la implementacion** y queda cumplido sin escribir nada.
> Solo lo sobrescribiria si quisiera un sonido distinto.

1. Implementalo en `Goomba` y `Koopa`, y usalo dentro de `Personaje.pisar()`.
2. Ahora sobrescribelo tambien en `Paratroopa`, para que suene distinto.
3. Fijate en quienes **no** se rompieron: Spiny, BillBala, Mario, la Moneda...
   Ninguno firmo ese contrato, asi que ninguno se entero del cambio.

> Compara con E8.3. Tocar el **padre** rompe a todos los descendientes,
> quieran o no. Tocar una **interfaz** rompe solo a quienes la firmaron.
> Esa es una de las razones para preferir interfaces cuando se puede.

---

### E8.10 - Cambiar la privacidad
En `Personaje`, los atributos son `protected`. Cambia `vidas` a `private`.

1. Compila. **No se rompe nada.** ¿Por que? Busca quien usa `vidas`:
   solo `recibirDanio()` y `estaVivo()`, y las dos estan dentro de la
   propia clase `Personaje`. Ningun hijo la toca.
2. Ahora cambia tambien `velocidad` a `private` y compila de nuevo:
   ```
   Toad.java:12: error: velocidad has private access in Personaje
   ```
   Falla solo en `Toad`, que es el unico hijo que la usa.
3. Prueba lo mismo con `salto`: ahora el que se rompe es `Luigi`.
4. Arreglalo de las dos formas de E3.5 (volver a `protected`, o dejar
   `private` y agregar `getVelocidad()`). ¿Cual prefieres aqui?

**Y el caso importante:** cambia `esGrande` a `public` y escribe esto en
`Demo08.java`:
```java
mario.esGrande = true;
```
Compila y funciona: Mario se hizo grande **sin comerse el hongo**, y toda
la maquina de estados de `recibirDanio()` quedo inutil.

> Esta es la mejor demostracion de para que sirve `private` en todo el curso.
> No se trata de esconder datos por esconderlos: se trata de que las **reglas**
> que escribiste sean las unicas formas de cambiar el estado.
> Devuelvelo a `protected` y respira tranquilo.

---

### E8.11 - El ejercicio de diseno (el mas importante)

Para cada cosa nueva, decide **donde va** y justifica en una linea.
Las opciones son: en `Entidad`, en `Personaje`, en `Enemigo`, en `Objeto`,
en una interfaz nueva, o en una sola clase concreta.

| # | Que hay que agregar | ¿Donde? |
|---|---|---|
| 1 | La posicion `y` (altura en el mapa) | |
| 2 | `lanzarBolaDeFuego()`, solo cuando Mario tiene la flor | |
| 3 | `puntosQueDa()`, que ya tienen los aplastables, para monedas tambien | |
| 4 | `congelar()`, que necesitan un enemigo de hielo y un item de hielo | |
| 5 | `getNombre()` | |
| 6 | `serPisadoDesdeAbajo()`, para los bloques y los Koopas colgantes | |

> Respuestas y por que:
> **1** en `Entidad` (lo tienen todos, sin excepcion).
> **2** en `Mario` (una sola clase lo hace; si despues Luigi tambien,
> recien ahi sube a `Personaje`).
> **3** interfaz nueva `DaPuntos`, y que `Aplastable` y `Recolectable`
> la usen: cruza dos ramas distintas.
> **4** interfaz nueva `Congelable`: un enemigo y un objeto no comparten
> padre, solo la capacidad.
> **5** en `Entidad`, y ya esta ahi.
> **6** interfaz nueva: un `Objeto` y un `Enemigo`, otra vez cruzando ramas.
>
> **El patron:** si lo tienen TODOS los de una rama, va en la clase de esa
> rama. Si lo tienen ALGUNOS de ramas distintas, va en una interfaz.
> Si lo tiene UNO SOLO, va en esa clase y punto.

---

### E8.12 - Desafio: el Mundo 1-2
Crea un nivel nuevo, submarino, en un `Demo08Agua.java`:

- Reutiliza `Mario` y `CheepCheep` (los dos ya son `Nadador`)
- Crea `Blooper` (el calamar): `extends Enemigo implements Nadador`
- Crea `Alga`: `extends Objeto`, que no es `Recolectable`
- Arma un `Nadador[]` y recorrelo

Todo lo que reutilices **no lo escribas de nuevo**. Ese es el premio de
haber repartido bien las responsabilidades: para el nivel de agua solo
tuviste que escribir dos clases.
