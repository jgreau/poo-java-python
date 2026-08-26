# POO en Java y su paralelo en Python
### Material de clase: 8 demos ejecutables + 60 ejercicios en 9 hojas

Cada demo es **el mismo programa escrito dos veces**, con la **misma salida por
pantalla**. La idea es que el alumno vea que el concepto es uno solo y lo que
cambia es la sintaxis: eso desarma la sensacion de "estoy aprendiendo dos cosas".

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

> **La demo 8 es solo Java**, sin par en Python. No es un olvido: es la demo
> de cierre del curso de Java, con 23 archivos, y duplicarla no aportaba nada
> que las siete anteriores no muestren ya.

---

## Las 8 demos

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

## Sugerencia de secuencia (8 sesiones)

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
8. **Proyecto integrador** (abajo).

## Tres trucos didacticos que funcionan con estas demos

- **Primero el dolor, despues el remedio.** El ejercicio E6.1 hace imprimir
  `Fraccion@1b6d3586` *antes* de enseñar `toString()`. El concepto se entiende solo.
- **Que rompan el codigo a proposito.** Los ejercicios E2.1, E3.5, E4.2 y E6.6
  piden provocar el error y leer el mensaje del compilador. Aprenden mas del
  error que del codigo que funciona.
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
