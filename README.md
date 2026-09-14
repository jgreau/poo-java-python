# POO en Java y su paralelo en Python
### Material de clase: 9 demos ejecutables + 76 ejercicios en 10 hojas

Cada demo es **el mismo programa escrito dos veces**, con la **misma salida por
pantalla**. La idea es que el alumno vea que el concepto es uno solo y lo que
cambia es la sintaxis: eso desarma la sensacion de "estoy aprendiendo dos cosas".

---

## Antes de todo: `00-base`

Un repaso de **Java desde cero**, para hacer antes de la demo 1: el `main`,
`println` y `printf`, variables, `Scanner`, `if`/`switch`, `while`, `for`,
arreglos y metodos `static`. Despues, clases propias con metodos `static`
(como `Math`), validaciones que no dejan caer el programa, y sobrecarga como
primera forma de polimorfismo. Son **13 pasos**, y el ultimo junta todo en una
calculadora de notas.

El alumno sigue `00-base/PASO-A-PASO.md` y **escribe** el codigo, no lo copia;
cada paso trae errores para provocar a proposito y su equivalente en Python.
Todo esta organizado por paso, en `00-base/pasoNN/` (13 carpetas, **68
ejercicios** numerados B1.1 a B13.5): ahi conviven el codigo de referencia del
paso, el enunciado de sus ejercicios, la **plantilla `.java`** de cada uno
(con los `// TODO` donde va el codigo) y la **solucion explicada** con la
salida real del programa. Ningun ejercicio depende de otra persona: todo se
puede resolver y comprobar solo. El punto de entrada es `00-base/README.md`.

---

## Estructura: una clase, un archivo

Cada clase vive en su propio archivo, como en cualquier proyecto real.
Ejemplo de la demo 3:

```
03-herencia/
  java/                     python/
    Vehiculo.java             vehiculo.py       <- el padre
    Auto.java                 auto.py           <- hijo
    Moto.java                 moto.py           <- hijo
    Demo03.java               demo03.py         <- el programa con main()
  EJERCICIOS.md
```

Las dos reglas que conviene dejar claras el primer dia:

- **Java obliga.** Un archivo `.java` = una clase publica, y el archivo se
  llama **exactamente** igual que ella. `Perro.java` contiene `public class Perro`.
- **Python no obliga, pero la costumbre manda.** Archivo en
  `minusculas_con_guion_bajo`, clase en `CamelCase`:
  `cuenta_bancaria.py` contiene `class CuentaBancaria`.

Y la diferencia que mas los sorprende: **Java no necesita `import`** para ver
una clase de la misma carpeta; **Python si**, siempre.

La hoja `EJERCICIOS-00-ARCHIVOS.md` trabaja justamente esto en 15 minutos,
y conviene hacerla antes de la demo 1.

---

## Como ejecutar

**Java** &mdash; ahora hay que compilar, porque son varios archivos:
```bash
cd 01-clases-objetos/java
javac *.java      # compila TODOS los .java de la carpeta -> genera los .class
java Demo01       # se ejecuta la CLASE, sin extension
```

> `java Demo01.java` (sin compilar) ya **no** funciona: ese modo solo admite un
> archivo. El modo multi-archivo existe desde Java 22; con Java 17 se usa `javac`.
> No es una molestia: es la ocasion perfecta para mostrar que Java compila
> y Python no.

**Python** &mdash; sin paso de compilacion:
```bash
cd 01-clases-objetos/python
python3 demo01.py
```

Para limpiar: `rm *.class` y `rm -rf __pycache__`.

Verificado con OpenJDK 17 y Python 3.11. Las 15 demos corren sin errores.

> **Las demos 8 y 10 son solo Java**, sin par en Python. No es un olvido.
> La 8 es la demo de cierre del curso, con 23 archivos, y duplicarla no
> aportaba nada que las siete anteriores no muestren ya. La 10 depende de las
> excepciones **checked** y de la palabra `throws`, que en Python **no
> existen**: el paralelo enseñaría lo contrario de lo que hay que enseñar.

---

## Las 9 demos

| # | Carpeta | Concepto | El "momento ajá" de la clase |
|---|---------|----------|------------------------------|
| 1 | `01-clases-objetos` | Clase, objeto, atributo, metodo, constructor | Dos objetos del mismo molde son independientes |
| 2 | `02-encapsulamiento` | private, getters, setters, validacion | Java **prohibe**; Python solo **avisa** |
| 3 | `03-herencia` | extends, super, override, protected | Tocar al padre rompe a todos los hijos |
| 4 | `04-polimorfismo` | Abstractas, interfaces, polimorfismo | Un `for` que no sabe con que clase habla |
| 5 | `05-composicion-estaticos` | Composicion, static, atributos de clase | El contador es **uno solo** para todos |
| 6 | `06-sobrecarga-igualdad` | Sobrecarga, toString, equals | `==` no es `equals()` |
| 7 | `07-interfaces` | Interfaces, interfaz como tipo, interfaz vs abstracta | El pinguino que no vuela |
| 8 | `08-videojuego` | **Todo junto**: Mundo 1-1 de Mario | El Spiny que no se puede pisar |
| | | + estado del objeto (PEQUENO/GRANDE) | El mismo golpe, dos resultados |
| 10 | `10-excepciones` | **Excepciones**: try-catch, throw, throws, propias | Un programa que compila perfecto y se cae con todo |
| | | checked vs unchecked | El compilador solo te protege de la mitad |

Cada carpeta trae `java/`, `python/` y un `EJERCICIOS.md` con actividades
graduadas del tipo: **agregar un atributo, agregar un metodo, crear una nueva
instancia, cambiar la privacidad de un atributo**. Ahora que las clases estan
separadas, se suma un quinto movimiento: **crear una clase nueva** es crear un
archivo nuevo (y en Python, agregar su import).

Antes de la demo 1 esta `EJERCICIOS-00-ARCHIVOS.md`, sobre la estructura de
archivos en si.

---

## La demo 8 en una imagen

```
Entidad (abstracta)              nombre, x, describir()
|- Personaje (abstracta)         vidas, monedas, puntos, velocidad, salto
|   |- Mario         implements Nadador
|   |- Luigi
|   |- Toad
|   \- Peach         implements Volador
|- Enemigo (abstracta)           danio, atacar()
|   |- Goomba        implements Aplastable
|   |- Koopa         implements Aplastable
|   |   \- Paratroopa  implements Volador     <- cuarto nivel
|   |- Spiny                                   <- NO Aplastable
|   |- CheepCheep    implements Nadador
|   \- BillBala      implements Volador        <- NO Aplastable
\- Objeto (abstracta)
    |- Moneda        implements Recolectable
    |- Hongo         implements Recolectable
    |- Estrella      implements Recolectable
    \- Bloque                                  <- NO Recolectable
```

**Las cuatro interfaces cruzan las tres ramas**, que es lo que ninguna
herencia puede hacer:

| Interfaz | La firman |
|---|---|
| `Volador` | Peach (**Personaje**) + Paratroopa y BillBala (**Enemigos**) |
| `Nadador` | Mario (**Personaje**) + CheepCheep (**Enemigo**) |
| `Aplastable` | Goomba, Koopa, Paratroopa &mdash; pero **no** Spiny ni BillBala |
| `Recolectable` | Moneda, Hongo, Estrella &mdash; pero **no** Bloque |

### El estado del personaje

Los personajes nacen **PEQUENOS** y la clase `Personaje` implementa la regla
real del juego:

```
PEQUENO --(hongo)--> GRANDE
GRANDE  --(danio)--> PEQUENO      no pierde vida
PEQUENO --(danio)--> muere        pierde una vida
```

Como cada punto de danio baja un escalon, la `BillBala` (danio 2) mata de un
solo encuentro a un personaje GRANDE: lo encoge y lo remata.

La demo lo demuestra en la seccion **6b**: Luigi (PEQUENO) y Toad (GRANDE)
reciben **el mismo golpe del mismo Spiny** y terminan distinto, sin que
haya un solo `if` en quien llama al metodo. Es la mejor entrada al tema de
por que `private` importa: el ejercicio E8.10 hace publico el atributo del
estado y deja toda la maquina inutil en una linea.

El `Spiny` y el `Bloque` son el corazon del ejemplo: existen para demostrar
que si `recibirPisoton()` viviera en la clase `Enemigo`, o `recolectar()` en
la clase `Objeto`, esas dos clases tendrian que rellenarlos con una mentira.
Es el mismo argumento del pinguino de la demo 7, repetido en un dominio que
los alumnos conocen de memoria.

---

## Tabla de traduccion rapida (para proyectar en clase)

| Concepto | Java | Python |
|----------|------|--------|
| Definir clase | `class Perro { }` | `class Perro:` |
| Constructor | `Perro(String n) { }` | `def __init__(self, n):` |
| El objeto actual | `this` | `self` (siempre explicito) |
| Crear objeto | `new Perro("Fido")` | `Perro("Fido")` |
| Declarar atributo | `String nombre;` obligatorio | nace al asignarlo en `__init__` |
| Metodo | `void ladrar() { }` | `def ladrar(self):` |
| Publico | `public` | por defecto |
| Protegido | `protected` | `_nombre` (convencion) |
| Privado | `private` (real, lo impide el compilador) | `__nombre` (name mangling, esquivable) |
| Getter / Setter | `getX()` / `setX()` | `@property` / `@x.setter` |
| Heredar | `class Auto extends Vehiculo` | `class Auto(Vehiculo):` |
| Llamar al padre | `super(...)` / `super.metodo()` | `super().__init__(...)` / `super().metodo()` |
| Sobrescribir | `@Override` (verificado) | solo repetir el nombre (**no** verificado) |
| Clase abstracta | `abstract class` | `class X(ABC):` |
| Metodo abstracto | `abstract void area();` | `@abstractmethod` |
| Interfaz | `interface` + `implements` | otra `ABC` como base extra |
| Herencia multiple | no (solo de interfaces) | si |
| Firmar un contrato | `implements Nadador` | otra clase base: `class Pato(Ave, Nadador)` |
| Interfaz como tipo | `Nadador n = pato;` limita a lo del contrato | el tipo no limita nada |
| Contrato sin declararlo | **imposible** | `typing.Protocol` (estructural) |
| Estatico | `static` | atributo de clase / `@staticmethod` |
| Constante | `static final` (real) | `MAYUSCULAS` (convencion) |
| Texto del objeto | `toString()` | `__str__` / `__repr__` |
| Igualdad de contenido | `equals()` | `__eq__`, invocado por `==` |
| Misma referencia | `==` | `is` |
| Sobrecarga de metodos | si, por tipo de parametro | no; se usa `isinstance` o valores por defecto |
| Sobrecarga de operadores | **no existe** | si (`__add__`, `__mul__`, ...) |
| Punto de entrada | `public static void main(String[])` | `if __name__ == "__main__":` |

---

## Sugerencia de secuencia (9 sesiones)

Si el curso llega sin Java, antes de todo va `00-base`. Si ya lo vio, se puede
dejar como material de consulta.

0. **Hoja 00** — una clase, un archivo. 15 minutos, antes de todo lo demas.
1. **Demos 1 y 2** — la base. No avances hasta que distingan clase de objeto.
2. **Demo 3** — herencia. Aqui aparece el primer error de compilacion util.
3. **Demo 4** — la sesion mas conceptual. Empieza por el `for` polimorfico
   y recien despues explica que es una clase abstracta.
4. **Demo 5** — composicion vs herencia ("tiene un" vs "es un") y `static`.
5. **Demo 6** — cierra dudas acumuladas (`==`, imprimir objetos).
6. **Demo 7** — interfaces. En dificultad va justo despues de la 4, pero
   conviene dejarla al final: se entiende mucho mejor cuando ya vieron
   herencia, abstractas y polimorfismo funcionando. El pinguino que no vuela
   es el ejemplo que se les queda grabado.
7. **Demo 8** — el Mundo 1-1 de Mario. Integra todo lo anterior en un solo
   ejemplo y sirve de cierre: cuatro personajes, seis enemigos, cuatro
   objetos y cuatro interfaces que cruzan las tres ramas.
8. **Demo 10** — excepciones. Va al final a proposito: necesita clases,
   herencia (la jerarquia de `Exception`), interfaces (`AutoCloseable` en el
   try-with-resources) y sobre todo un programa lo bastante grande como para
   que romperlo tenga gracia. Es la unica demo que parte con el codigo roto.
9. **Proyecto integrador** (abajo).

## Tres trucos didacticos que funcionan con estas demos

- **Primero el dolor, despues el remedio.** El ejercicio E6.1 hace imprimir
  `Fraccion@1b6d3586` *antes* de enseñar `toString()`. El concepto se entiende solo.
- **Que rompan el codigo a proposito.** Los ejercicios E2.1, E3.5, E4.2 y E6.6
  piden provocar el error y leer el mensaje del compilador. Aprenden mas del
  error que del codigo que funciona. La demo 10 lleva esto al extremo: **todo
  el proyecto llega roto** y la primera media hora de la sesion es botarlo.
- **Corre las dos versiones lado a lado.** Dos terminales, misma salida.
  Es la demostracion mas directa de que el concepto es independiente del lenguaje.

## Proyecto integrador sugerido

Sistema de biblioteca que use **las 6 demos juntas**:
- `Material` abstracta con `Libro`, `Revista`, `DVD` (demos 3 y 4)
- atributos privados con validacion (demo 2)
- `Biblioteca` que **contiene** materiales y socios (demo 5)
- contador estatico de prestamos (demo 5)
- `toString()` y `equals()` por ISBN (demo 6)
- interfaz `Prestable` con `prestar()` y `devolver()`, implementada tambien
  por algo de otra jerarquia, como `SalaDeEstudio` (demos 4 y 7)

Se entrega en Java **y** en Python, y en la defensa el alumno explica
las tres diferencias mas importantes que encontro entre ambas versiones.

---

## Taller grupal: `09-taller-grupal`

Una sesion de **2 horas con 5 grupos** construyendo un solo programa en Java.
El profesor entrega la clase raiz abstracta y los dos `main`; cada grupo
escribe sus clases y es **dueno de una interfaz que otro grupo esta obligado
a implementar**. El grafo de contratos es un anillo cerrado: si un grupo no
entrega, no compila nadie.

```
Preparable (G1) -> G2   Descontable (G2) -> G3   Facturable (G3) -> G4
Cobrable (G4)   -> G5   Calificable (G5) -> G1
```

Trae `taller/` (lo que se copia a los PC: 9 archivos listos + 11 stubs con
`// TODO` que **no compilan** hasta que los rellenen), `solucion-profesor/`
(los 20 archivos terminados, 40 de 40 pruebas OK) y `fichas-imprimibles.html`
con las seis fichas de papel. El guion completo esta en su `README.md`.

Ademas de repasar las ocho demos, agrega dos cosas que las demos no cubren:
un **banco de pruebas** que imprime `[OK]/[FALLA]`, y la unica forma de
comprobar en tiempo de ejecucion que una clase es abstracta &mdash; por
reflexion, porque `new Producto(...)` no lanza una excepcion: **no compila**,
y ningun `try/catch` puede atrapar eso.

---

## Demo 10: `10-excepciones`

**Un programa que compila perfecto y se cae con todo.** **Cinco archivos**
Java, cero `try-catch`. El alumno lo corre, lo bota de las 12 formas posibles
que estan listadas en `TABLA-EXCEPCIONES.md`, y recien entonces lo arregla.
Esta pensada para resolverse **en una sola clase de 90 minutos**.

El gancho es el `throws Exception` del `main`: esa firma es lo unico que hace
que el proyecto compile sin manejar nada. Borrarla (ejercicio E10.0) hace
aparecer 6 errores de excepciones **checked** que antes no existian &mdash; y
deja a la vista que las **unchecked**, que siguen sin aparecer, son 11 de las
12 formas de botar el programa. El compilador solo te protege de la mitad.

Cubre **10 excepciones nativas** y **3 propias**, checked y unchecked
mezcladas a proposito. `FileNotFoundException` es la unica checked del JDK en
toda la demo: borrarle el `throws` al metodo que la lanza y ver a `javac`
plantarse es la mejor definicion de "checked" que se puede dar en clase.

Y la leccion que no esta en el titulo: de los 12 arreglos del ejercicio,
**solo dos son un `try-catch`**. El resto son validaciones puestas antes, una
busqueda que deja de devolver `null`, un `instanceof` en vez de un cast a
ciegas y un `try-with-resources`. El `try-catch` aparece recien en el segundo
bloque y solo en `Demo10`, que es el unico lugar donde alguien puede
**decidir que hacer** con el error. Un curso que parte por el `try-catch`
produce alumnos que envuelven todo en `catch (Exception e) { }` y siguen.

Una nota para la clase: `Excepciones.java` guarda las tres excepciones propias
en un solo archivo, rompiendo a proposito la regla de la hoja 00. Es legal
porque ninguna es `public`, y conviene decirlo en voz alta: es justo la
excepcion a una regla que el curso viene aplicando desde el primer dia.

Igual que el taller 09, la carpeta `solucion-profesor/` **no se publica**
(esta en el `.gitignore`): los alumnos tienen acceso a este repo.
