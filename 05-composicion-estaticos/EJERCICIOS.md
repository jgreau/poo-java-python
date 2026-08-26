# Demo 05 - Composicion y Miembros Estaticos | Ejercicios

---

### E5.1 - Crear una nueva instancia y ver el contador
Crea un cuarto alumno e imprime el total **antes y despues**.
Luego crea un segundo `Curso` ("Bases de Datos", "Sala 110") e inscribe ahi
a dos de los alumnos que ya existen.

> Pregunta: ¿un mismo objeto `Alumno` puede estar en dos cursos a la vez?
> Pruebalo. Si, porque ambos cursos guardan una **referencia** al mismo alumno.

Para comprobarlo hay que poder cambiarle la nota, y `Alumno` **no tiene
setter** (a proposito: mira la demo 2). Agregalo tu:

```java
public void setNota(double nota) { this.nota = nota; }
```
```python
def set_nota(self, nota):
    self._nota = nota
```
Ahora cambia la nota **una sola vez** y llama a `listar()` en los dos cursos.
La nota cambio en ambos: hay un solo objeto `Alumno`, referenciado dos veces.

---

### E5.2 - Agregar un atributo de instancia
Agrega `edad` al `Alumno`, con su getter. Muestrala en `listar()`.

---

### E5.3 - Agregar un atributo estatico / de clase
Agrega un contador `totalAprobados` que suba cada vez que se crea un alumno
**con nota >= 4.0**.

```java
private static int totalAprobados = 0;

// en el constructor:
if (nota >= NOTA_MINIMA) { totalAprobados++; }

// y el getter, que tambien tiene que ser static:
public static int getTotalAprobados() { return totalAprobados; }
```
En Python: un atributo de clase `total_aprobados = 0` y un `@classmethod`.

Imprime `Alumno.getTotalAprobados()` / `Alumno.get_total_aprobados()` al final.

> Prueba clave para entender static: si creas 3 alumnos, ¿hay 3 contadores o 1?

---

### E5.4 - Agregar un metodo al Curso
Agrega `mejorAlumno()` que recorra la lista y devuelva el `Alumno` con la
nota mas alta (devuelve el **objeto**, no el nombre).

```java
public Alumno mejorAlumno() {
    if (alumnos.isEmpty()) return null;
    Alumno mejor = alumnos.get(0);
    for (Alumno a : alumnos) {
        if (a.getNota() > mejor.getNota()) { mejor = a; }
    }
    return mejor;
}
```
Usalo asi: `System.out.println(poo.mejorAlumno().getNombre());`

En Python: `return max(self._alumnos, key=lambda a: a.get_nota())`

---

### E5.5 - Agregar un metodo que quite un alumno
`retirar(String nombre)`: busca al alumno por nombre y lo saca de la lista.
Si no existe, avisa. Vuelve a imprimir `cantidadAlumnos()`.

---

### E5.6 - Cambiar la privacidad de la lista (importante)
En Java, la lista `alumnos` es `private`. Agrega este getter:
```java
public ArrayList<Alumno> getAlumnos() { return this.alumnos; }
```
Ahora, desde el `main`:
```java
poo.getAlumnos().clear();     // vaciaste el curso desde afuera
poo.listar();
```
1. El atributo era `private`... ¿y aun asi lo rompimos? ¿Por que?
2. Arreglalo devolviendo una **copia**:
   `return new ArrayList<>(this.alumnos);`
3. Vuelve a probar el `.clear()` y comprueba que ahora el curso no se vacia.

> Leccion avanzada pero valiosa: `private` protege la **referencia**,
> no el contenido del objeto al que apunta.
> En Python el paralelo exacto es `return list(self._alumnos)`.

---

### E5.7 - La trampa de Python (solo Python)
Corre la ultima seccion de `demo05.py` (la del contador tapado). Luego viene
la otra cara de la misma moneda.

En `curso.py`, saca `self._alumnos = []` de `__init__` y ponlo suelto en la
clase. **Tiene que llamarse igual** (`_alumnos`, con guion bajo), o los metodos
no lo encontraran:

```python
class Curso:
    _alumnos = []               # MAL: atributo de CLASE, uno solo para TODOS

    def __init__(self, nombre, sala):
        self._nombre = nombre
        self._sala = sala
        # ya no se crea la lista aqui
```
Ahora prueba:
```python
c1 = Curso("POO", "Sala 204")
c2 = Curso("Bases de Datos", "Sala 110")
c1.inscribir(Alumno("Camila", 6.5))
print(c2.cantidad_alumnos())     # imprime 1 !!
```
El alumno que inscribiste en `c1` aparece en `c2`: **la lista es una sola**.
Es uno de los bugs mas comunes de quien viene de Java.
Arreglalo devolviendo `self._alumnos = []` a `__init__`.

> Si por error lo escribes sin guion bajo (`alumnos = []`), no veras este bug
> sino un `AttributeError: 'Curso' object has no attribute '_alumnos'`,
> porque los metodos siguen buscando `self._alumnos`. Tambien vale la pena
> mostrarlo: son dos errores distintos y se confunden.
