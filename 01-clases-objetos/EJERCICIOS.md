# Demo 01 - Clases y Objetos | Ejercicios

Trabaja sobre `java/Perro.java` + `java/Demo01.java` y
`python/perro.py` + `python/demo01.py`.

**Recuerda:** la clase se modifica en SU archivo; el programa que la usa,
en el suyo. Si agregas un atributo en `Perro.java`, tienes que recompilar
los dos: `javac *.java`.
Haz **el mismo ejercicio en los dos lenguajes** y compara cuanto codigo cambia.

---

### E1.1 - Crear una nueva instancia
Agrega un tercer perro llamado `rocky`, raza "Bulldog", de 7 anios.
Haz que se presente y que ladre.

> Fijate: no tocaste la clase `Perro` para nada. El molde ya servia.

---

### E1.2 - Agregar un atributo
Agrega el atributo `color` a la clase `Perro`.

1. En Java: declaralo arriba (`public String color;`) y agregalo al constructor.
2. En Python: solo agregalo al `__init__`.
3. Actualiza `presentarse()` para que lo muestre.
4. **Corrige todos los `new Perro(...)` de `Demo01.java`**, porque ahora
   piden un dato mas. Son 2 (o 3 si ya hiciste E1.1).

> Pregunta de clase: en Java el compilador te obliga a corregirlos.
> En Python, ¿que pasa si te olvidas de uno? Prueba y mira el error.

---

### E1.3 - Agregar un metodo
Agrega un metodo `esCachorro()` / `es_cachorro()` que **devuelva** `true`
si la edad es menor a 2, y `false` si no.

```java
public boolean esCachorro() {
    return this.edad < 2;
}
```
> Va en `Perro.java`, no en `Demo01.java`: es algo que el perro sabe de si mismo.

Usalo asi:
```java
if (firulais.esCachorro()) { System.out.println("Es cachorro"); }
```

> Ojo con la diferencia: `ladrar()` es `void` (hace algo).
> `esCachorro()` **retorna** un valor (responde algo).

---

### E1.4 - Metodo con parametro
Agrega `public void pasear(int minutos)` que imprima:
`"Firulais paseo 30 minutos y quedo feliz"`.
Si son mas de 60 minutos, que diga `"...y quedo agotado"`.

---

### E1.5 - Sobrecarga del constructor (solo Java)
Agrega un segundo constructor que reciba **solo el nombre**, y ponga
raza `"Desconocida"` y edad `0`.

```java
public Perro(String nombre) {
    this(nombre, "Desconocida", 0);   // llama al otro constructor
}
```

Ahora crea `Perro anonimo = new Perro("Sin Nombre");`

**En Python NO existe la sobrecarga.** El equivalente son valores por defecto:
```python
def __init__(self, nombre, raza="Desconocida", edad=0):
```
Crea `anonimo = Perro("Sin Nombre")` y comprueba que funciona igual.

> Este es uno de los contrastes mas utiles de toda la unidad:
> Java resuelve con **muchos constructores**, Python con **un constructor flexible**.

---

### E1.6 - Desafio: dos variables, un solo objeto
Escribe:
```java
Perro a = new Perro("Toby", "Beagle", 2);
Perro b = a;              // NO es una copia
b.nombre = "Cambiado";
System.out.println(a.nombre);
```
¿Que imprime? Explica por que. Repitelo en Python: pasa exactamente lo mismo.

> Concepto: la variable guarda una **referencia** al objeto, no el objeto.
