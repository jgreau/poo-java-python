# Demo 07 - Interfaces | Ejercicios

Los cuatro movimientos de siempre, aplicados a interfaces, mas los dos
temas propios: **la interfaz como tipo** y **interfaz vs clase abstracta**.

---

### E7.1 - Crear una nueva instancia
Crea un segundo pato y un segundo delfin, agregalos al arreglo/lista
`animales` y vuelve a correr. La tabla de capacidades se completa sola.

> No tocaste ninguna clase ni ninguna interfaz. Solo el programa.

---

### E7.2 - Agregar una clase que firme un contrato
Crea `Tortuga`: es un **Reptil** (clase nueva, hermana de `Ave` y
`Mamifero`) y sabe nadar.

Archivos nuevos: `Reptil.java` + `Tortuga.java` / `reptil.py` + `tortuga.py`.

```java
public abstract class Reptil extends Animal {
    public Reptil(String nombre, int edad) { super(nombre, edad); }
    @Override public String getGrupo() { return "Reptil"; }
}

public class Tortuga extends Reptil implements Nadador { ... }
```

Agregala al arreglo `animales` **y** al arreglo `nadadores`.

> Ahora `Nadador[]` contiene un Ave, un Mamifero y un Reptil.
> Tres jerarquias distintas en una sola lista. Pregunta para la clase:
> ¿que clase padre comun habria que inventar para lograr esto sin interfaces?
> (Y si la inventas, ¿donde queda el aguila, que no nada?)

---

### E7.3 - La interfaz como TIPO de variable
Escribe estas cuatro lineas en `Demo07.java` y predice cual falla:

```java
Animal  a = new Pato("Lucas", 1);
Ave     b = new Pato("Lucas", 1);
Nadador c = new Pato("Lucas", 1);
Volador d = new Pinguino("Tuca", 2);
```

Compila y comprueba. La ultima da:
`incompatible types: Pinguino cannot be converted to Volador`

Ahora, sobre la variable que SI funciono:
```java
c.nadar();            // OK
c.velocidadEnAgua();  // OK
c.volar();            // ¿compila? ¿por que?
c.presentarse();      // ¿compila? ¿por que?
```

> **El concepto clave de este ejercicio:** el tipo de la variable decide
> QUE PUEDES PEDIRLE, aunque el objeto adentro sepa hacer mucho mas.
> `c` es un Pato completo, pero declarado como `Nadador` solo expone el
> contrato Nadador. Para acceder al resto hay que castear:
> `((Pato) c).volar();`

En Python no existe esta restriccion: `c` puede hacer todo lo que el objeto
sepa hacer, porque el tipo de la variable no limita nada. Pruebalo y comenta
que se gana y que se pierde en cada lenguaje.

---

### E7.4 - Agregar un metodo a la interfaz
Agrega `boolean respiraBajoElAgua();` a la interfaz `Nadador`.

**Todos los implementadores se rompen de golpe.** Arreglalos: `false` para
pato, pinguino y tortuga; `false` tambien para el delfin (es mamifero!).

En Java el error es inmediato y por clase:
`Pato is not abstract and does not override abstract method respiraBajoElAgua() in Nadador`

En Python el error aparece **al instanciar**, y solo del primero que falle.

> Compara con E3.3 (agregar un atributo al padre). En los dos casos tocar
> algo compartido rompe a todos los que dependen de el. Con una diferencia:
> el padre te obliga a heredar su estado; la interfaz solo te exige metodos.

---

### E7.5 - Cambiar la privacidad... en una interfaz
En `Nadador.java`, intenta esto:

```java
public interface Nadador {
    private void nadar();          // ¿compila?
    protected double velocidadEnAgua();
}
```

Falla, y con dos errores **distintos**:

```
error: modifier protected not allowed here
error: missing method body, or declare abstract     (por el private)
```

1. `protected` esta prohibido de plano en una interfaz.
2. `private` da otro error, y el motivo es fino: desde Java 9 una interfaz
   **si** admite metodos privados, pero solo **con cuerpo** (metodos
   auxiliares internos). Lo que no puede existir es un metodo privado
   **abstracto**: seria un contrato que nadie puede ver ni implementar.
3. ¿Por que? Porque una interfaz existe justamente para que otros la usen
   desde afuera. Un contrato secreto no es un contrato.
Despues comprueba las dos caras de la moneda:

4. En `Nadador.java` los metodos **no llevan** `public` y aun asi son
   publicos: en una interfaz es automatico.
5. En las clases que la implementan, en cambio, `public` es **obligatorio**.
   Quitaselo a `Pato.nadar()`:

```
error: nadar() in Pato cannot implement nadar() in Nadador
  attempting to assign weaker access privileges; was public
```

> En Python nada de esto aplica: en una ABC los metodos son publicos porque
> todo es publico. Es una diferencia real, no solo de sintaxis.

---

### E7.6 - Interfaz o clase abstracta: decidir

La regla practica:

| | Clase abstracta | Interfaz |
|---|---|---|
| Responde a | **ES UN** | **SABE HACER** |
| Guarda estado (atributos) | si | no |
| Constructor | si | no |
| Cuantas por clase | **una** | las que sean |
| Sirve para | una jerarquia | cruzar jerarquias |

Para cada caso, decide **interfaz o clase abstracta** y justifica en una linea:

1. `Empleado`, con `nombre`, `sueldoBase` y un `calcularSueldo()` distinto
   para cada tipo de empleado.
2. `Imprimible`, para que un `Informe`, una `Boleta` y un `Grafico` se
   puedan mandar a la impresora.
3. `Vehiculo`, con `marca`, `placa` y `arrancar()`.
4. `Buscable`, que necesitan tanto un `Producto` como un `Cliente`
   (que no tienen ningun ancestro comun).
5. `Figura`, con `nombre` y un `area()` que cada figura calcula a su modo.

> Respuestas: 1 abstracta, 2 interfaz, 3 abstracta, 4 interfaz, 5 abstracta.
> El patron: si hay **atributos que compartir**, es clase abstracta.
> Si solo hay **capacidades que exigir** y aparecen en clases sin parentesco,
> es interfaz.

**Y el caso interesante:** `Figura` de la demo 4 es abstracta y `Dibujable`
es interfaz. Ve a mirar ese codigo con lo que sabes ahora y explica por que
esa reparticion es correcta.

---

### E7.7 - Convertir una abstracta en interfaz (y ver que se pierde)
Toma `Ave` y conviertela en interfaz:

```java
public interface Ave {
    String getGrupo();
}
```

Ahora `Pato`, `Pinguino` y `Aguila` no compilan.

1. ¿Que se perdio exactamente? (Pista: `cantidadPlumas` y el constructor.)
2. ¿Donde tendria que ir ahora ese atributo?
3. Deshaz el cambio.

> Este ejercicio deja clarisimo el criterio: **el estado compartido es lo que
> obliga a usar una clase abstracta.** Una interfaz no puede guardarlo.

---

### E7.8 - Protocol: la interfaz que no hay que firmar (solo Python)
Corre la ultima seccion de `demo07.py`. El `Submarino` no hereda de nada
y aun asi gana la competencia.

1. Abre `submarino.py` y borrale el metodo `velocidad_en_agua()`.
   Ahora `isinstance(sub, NadadorProtocol)` da `False`: el protocolo
   comprueba que **existan los metodos**.
2. Devuelvele el metodo, pero haz que reciba un parametro de mas:
   `def velocidad_en_agua(self, unidad):`.
   ¿Sigue dando `True` el `isinstance`? Pruebalo.

> Lo que descubres en el punto 2: `runtime_checkable` comprueba que el
> metodo **este**, no que su firma calce. El contrato es mas debil que en Java.
> Es el mismo tema de E4.6, pero ahora escrito en un archivo en vez de
> quedar en un acuerdo tacito.

**Cierre de la unidad:** con `Protocol`, ¿Python tiene interfaces de verdad?
Argumenta usando las tres cosas que Java garantiza y Python no:
el compilador las revisa, la firma tiene que calzar, y el contrato es
obligatorio declararlo.
