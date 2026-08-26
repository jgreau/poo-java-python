# Ejercicio 00 - Una clase, un archivo

Hoja previa a la demo 1. Toma 15 minutos y evita la mitad de las dudas
de todo el semestre. Se trabaja sobre `01-clases-objetos/`.

---

### E0.1 - Ver la regla de Java en accion
Abre `java/Perro.java` y renombra la clase **y su constructor** (los dos
tienen que llamarse igual), dejando el archivo con su nombre original:
```java
public class Perro          ->   public class Perrito
public Perro(String nombre  ->   public Perrito(String nombre
```
Compila con `javac Perro.java`. El error es literal:

```
Perro.java:11: error: class Perrito is public, should be declared
in a file named Perrito.java
```

> Si te olvidas de renombrar el constructor, el error que sale es otro
> (`invalid method declaration; return type required`) y despista.
> Vale la pena provocar ese tambien: le ensena al alumno que el constructor
> se llama igual que la clase **por obligacion**, no por costumbre.

> **La regla:** en Java, un archivo `.java` contiene UNA clase publica y el
> archivo tiene que llamarse exactamente igual que ella. Mayusculas incluidas.

Ahora renombra el archivo a `Perrito.java` y compila **la carpeta completa**
con `javac *.java`. Falla otra vez, pero por un motivo distinto: `Demo01.java`
sigue diciendo `new Perro(...)`.

(Si compilas solo `javac Perrito.java` no falla, porque `Demo01.java` ni
siquiera entra. Es una buena ocasion para explicar que `javac *.java`
compila **todo** lo de la carpeta.)
Arreglalo y observa que **un cambio de nombre toca dos archivos**.

Deja todo como estaba antes de seguir.

---

### E0.2 - Comprobar que Python no tiene esa regla
En Python, renombra la clase de `perro.py` a `Perrito` (el archivo se queda
igual). Ajusta el import en `demo01.py`:
```python
from perro import Perrito
```
Funciona. El archivo se llama `perro.py` y la clase `Perrito`, y a Python
no le molesta.

> Python **no obliga**, pero la costumbre (PEP 8) si dice:
> archivo en `minusculas_con_guion_bajo`, clase en `CamelCase`.
> `cuenta_bancaria.py` contiene `class CuentaBancaria`.

Deja todo como estaba.

---

### E0.3 - Descubrir por que Java no necesita import
En `Demo01.java` no hay ni un `import`, y aun asi usa `Perro`.
En `demo01.py` el `from perro import Perro` es obligatorio.

Prueba a borrar esa linea de `demo01.py` y corre. El error es:
```
NameError: name 'Perro' is not defined
```

> **La diferencia:** Java ve automaticamente todas las clases de la misma
> carpeta (el mismo *paquete*). Python necesita que le digas explicitamente
> de que archivo sacar cada cosa.

---

### E0.4 - Que hace realmente javac
Borra los `.class` de `01-clases-objetos/java/` y corre paso a paso:

```bash
ls                 # solo hay .java
javac *.java
ls                 # aparecieron Perro.class y Demo01.class
java Demo01
```

1. ¿Cuantos `.class` se generaron y por que?
2. Fijate que a `java` se le pasa **`Demo01`**, sin extension: es el nombre
   de la clase, no el del archivo.
3. En Python no hay paso de compilacion: `python3 demo01.py` y listo.
   (Aunque si te fijas, aparece una carpeta `__pycache__/`. Python tambien
   compila, solo que lo hace solo y no te lo cuenta.)

---

### E0.5 - Mover una clase a su propio archivo
En `06-sobrecarga-igualdad/java/`, la clase `Fraccion` ya esta separada.
Haz el ejercicio inverso para entender que se gana:

1. Copia el contenido de `Fraccion.java` dentro de `Demo06.java`, al final,
   **quitandole el `public`** (`class Fraccion {`, sin `public`).
2. Borra `Fraccion.java` y compila. Funciona.
3. Pregunta: ¿por que hubo que quitarle el `public`?
4. Vuelve a separarlo.

> Java permite varias clases en un archivo, pero solo UNA puede ser publica.
> Por eso la convencion real, la que veran en cualquier proyecto, es
> **una clase = un archivo**.

---

### E0.6 - Limpiar
Los `.class` no se entregan nunca (se regeneran con `javac`).
Para dejar una carpeta limpia:

```bash
rm *.class              # Java
rm -rf __pycache__      # Python
```
