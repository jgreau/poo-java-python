# Demo 06 - Sobrecarga, toString y equals | Ejercicios

---

### E6.1 - Ver el problema antes de la solucion (hazlo primero en clase)
Comenta el metodo `toString()` en `Fraccion.java` y corre `Demo06`:

```
a = Fraccion@1b6d3586
```

En Python **hay que comentar los dos**, `__str__` y `__repr__`, en `fraccion.py`:

```
a = <fraccion.Fraccion object at 0x7fcf74317450>
```

> Paso intermedio que vale oro: comenta **solo** `__str__` y corre.
> No sale la direccion de memoria, sale `Fraccion(1, 2)`.
> ¿Por que? Porque cuando falta `__str__`, Python usa `__repr__` como
> reemplazo. Java no tiene ese plan B.
>
> (Y fijate que dice `fraccion.Fraccion`: el primer `fraccion` es el
> **archivo**. Antes de separar las clases decia `__main__`.)

Ahora descomenta todo. **Primero el dolor, despues el remedio**: asi el
concepto se entiende solo.

---

### E6.2 - Agregar mas sobrecargas (Java)
Agrega a `Fraccion`:
- `Fraccion multiplicar(Fraccion otra)`
- `Fraccion multiplicar(int entero)`
- `double aDecimal()`

En Python hazlo con un solo `multiplicar(self, otro)` + `isinstance`,
y ademas define `__mul__` para que `a * b` funcione.

---

### E6.3 - Crear nuevas instancias y probar la igualdad
```java
Fraccion f1 = new Fraccion(3, 6);
Fraccion f2 = new Fraccion(1, 2);
Fraccion f3 = new Fraccion(2, 3);
```
Predice **antes de correr** el resultado de:
`f1.equals(f2)`, `f1.equals(f3)`, `f1 == f2`.
Luego comprueba. En Python: `f1 == f2`, `f1 == f3`, `f1 is f2`.

---

### E6.4 - Agregar un metodo simplificar()
Agrega `simplificar()` que reduzca la fraccion usando el maximo comun divisor.

```java
private int mcd(int a, int b) {
    return (b == 0) ? Math.abs(a) : mcd(b, a % b);
}
```
```python
from math import gcd
```
Comprueba que `a.sumar(b)` ahora da `5/4` en vez de `10/8`.

---

### E6.5 - Cambiar la privacidad y romper equals()
En Java, `equals()` accede a `otra.numerador` aunque sea `private`.
1. ¿Por que compila? (pista: `private` es **por clase**, no por objeto)
2. Cambia los atributos a `public`. ¿Cambia algo en el funcionamiento?
3. ¿Cual version prefieres y por que?

---

### E6.6 - El bug clasico de equals()
En Java, escribe **a proposito** esta firma incorrecta:
```java
public boolean equals(Fraccion otra) { ... }   // recibe Fraccion, no Object
```
Quita el `@Override`. Compila igual (es una **sobrecarga**, no una sobrescritura).
Ahora prueba:
```java
Object o = new Fraccion(1, 2);
System.out.println(new Fraccion(1, 2).equals(o));   // false!
```
> Moraleja: `@Override` no es decoracion. Es el compilador cuidandote.
> Ponlo SIEMPRE. Con `@Override` este error no compila.

---

### E6.7 - Desafio: la clase Punto
Crea desde cero, en los dos lenguajes, una clase `Punto` con `x`, `y` privados:
- constructor
- `toString()` / `__str__` que muestre `(3, 4)`
- `equals()` / `__eq__` por contenido
- `distanciaA(Punto otro)`
- **Java:** sobrecarga `mover(int dx, int dy)` y `mover(Punto delta)`
- **Python:** `__add__` para que `p1 + p2` devuelva un `Punto` nuevo
