# Demo 03 - Herencia | Ejercicios

---

### E3.1 - Crear una nueva instancia de cada hijo
En `Demo03.java` / `demo03.py`, crea un `Auto` y una `Moto` mas (los datos que
quieras) y llama a `describir()` en cada uno.

> Fijate que no tocaste ningun archivo de clase: solo el del programa.
> Para crear un `Camion` si habria que crear una clase nueva, y eso es E3.2.

---

### E3.2 - Agregar una clase hija nueva
Crea el archivo **`Bicicleta.java`** / **`bicicleta.py`** (una clase, un archivo)
con `Bicicleta extends Vehiculo` / `class Bicicleta(Vehiculo):` y dentro:
- atributo propio `tipo` ("urbana", "montana", ...)
- `describir()` sobrescrito
- metodo propio `tocarTimbre()`

No olvides: en Java el archivo se llama **exactamente** igual que la clase, y
hay que volver a correr `javac *.java`. En Python hay que agregar el import
en `demo03.py`: `from bicicleta import Bicicleta`.

**Trampa a proposito:** la bicicleta hereda `acelerar()`, que suma 20 km/h.
Poco realista. Sobrescribela para que sume solo 5.

---

### E3.3 - Agregar un atributo al PADRE
Agrega `protected String placa;` / `self._placa` a `Vehiculo`,
pedido en su constructor.

Ahora **todos los hijos se rompen**: sus `super(...)` ya no calzan. Arreglalos.

> Esto es una leccion de diseno, no solo de sintaxis: tocar el padre
> obliga a revisar a todos los hijos. La herencia acopla.

---

### E3.4 - Usar super() DENTRO de un metodo sobrescrito
Haz que `Auto.describir()` primero llame a la version del padre y despues
agregue lo suyo:

```java
@Override
public void describir() {          // OJO: public, igual que en el padre
    super.describir();
    System.out.println("   ...y tiene " + puertas + " puertas");
}
```
```python
def describir(self):
    super().describir()                                 # Python
    print(f"   ...y tiene {self._puertas} puertas")
```
> Concepto: sobrescribir no siempre significa *reemplazar*; puede ser *ampliar*.

> **Ojo con el `public` del ejemplo Java.** Si se lo quitas, no compila:
> `attempting to assign weaker access privileges; was public`.
> Un metodo sobrescrito nunca puede ser **menos** visible que el del padre.
> Provocalo una vez: es una regla que no se olvida.

---

### E3.5 - Cambiar la privacidad y ver el efecto en la herencia
En Java, en `Vehiculo`, cambia:
```java
protected String modelo;   ->   private String modelo;
```
Compila. Los hijos **dejan de compilar**: `modelo has private access in Vehiculo`.

1. Explica por que `protected` existe.
2. Arreglalo de dos maneras distintas y comenta cual prefieres:
   - volviendo a `protected`
   - dejandolo `private` y agregando `getModelo()` en el padre

En Python haz el paralelo en **dos pasos** (si haces solo el primero, el error
que sale es otro y no ensena nada):

1. En `vehiculo.py`, cambia `self._modelo` por `self.__modelo` (doble guion).
2. En `auto.py`, intenta usar `self.__modelo` dentro de `describir()`.

```
AttributeError: 'Auto' object has no attribute '_Auto__modelo'
```

> El mensaje delata el *name mangling*: dentro de `Auto`, el `__modelo` que
> escribiste se convirtio en `_Auto__modelo`, pero el que existe se llama
> `_Vehiculo__modelo`. Por eso el doble guion bajo **no se usa** cuando quieres
> que los hijos hereden el atributo: para eso esta el guion bajo simple.

---

### E3.6 - Agregar un metodo abstracto de facto
Agrega en `Vehiculo` el metodo `sonarBocina()` que imprima "Beep".
Sobrescribelo en `Moto` para que imprima "Piii" y **no** lo sobrescribas en `Auto`.

Llama `sonarBocina()` en los dos objetos. ¿De donde sale cada mensaje?

> Esto conecta directo con la Demo 04: ¿que pasa si el padre NO deberia
> tener una implementacion por defecto?
