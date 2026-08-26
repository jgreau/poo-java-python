# Demo 04 - Polimorfismo, Abstraccion e Interfaces | Ejercicios

---

### E4.1 - Crear una nueva instancia y sumarla al polimorfismo
Agrega un `Circulo(1)` mas al arreglo/lista y vuelve a correr.
No cambies **ninguna** otra linea: el `for` y `sumarAreas()` ya funcionan.

> Ese es el premio del polimorfismo: agregar casos sin tocar el codigo que los usa.

---

### E4.2 - Agregar una clase nueva que cumpla el contrato
- **Java:** crea el archivo `Cuadrado.java` con
  `public class Cuadrado extends Figura implements Dibujable`, un atributo
  `lado`, y los metodos `area()`, `perimetro()` y `dibujar()`.
- **Python:** crea el archivo `cuadrado_formal.py` con
  `class Cuadrado(Figura, Dibujable)` y lo mismo.

> ¿Por que en Python un nombre distinto? Porque `cuadrado.py` **ya existe** y
> contiene el "intruso" sin herencia que necesitas intacto para E4.6.
> Al terminar tendras las dos versiones del mismo cuadrado, una que hereda y
> otra que no, y las podras comparar.

Agrega el nuevo cuadrado al arreglo/lista de `Demo04` y vuelve a correr.

**En Java**, prueba a propósito a NO escribir `area()`. El compilador dice:
`Cuadrado is not abstract and does not override abstract method area() in Figura`.
**En Python**, omite `area()` y mira el `TypeError` al instanciar.

> Este es EL ejemplo para explicar para que sirve una clase abstracta:
> el error llega temprano y es claro.

---

### E4.3 - Agregar un metodo abstracto al padre
Agrega `public abstract String describirse();` /
`@abstractmethod def describirse(self)` a `Figura`.

Todas las clases hijas se rompen a la vez. Implementalo en cada una,
que devuelva algo como `"Circulo de radio 3"`.

---

### E4.4 - Hacer que Triangulo implemente la interfaz
Haz que `Triangulo` implemente `Dibujable` y dibuje `/\`.
Vuelve a correr: la ultima linea ya no dice "no sabe dibujarse".

Fijate que **no tocaste el bucle** que usa `instanceof` / `isinstance`.

---

### E4.5 - Agregar una segunda interfaz (solo Java tiene esto explicito)
Crea `interface Redimensionable { void escalar(double factor); }`
e implementala en `Circulo` y `Rectangulo`:
```java
public class Circulo extends Figura implements Dibujable, Redimensionable { ... }
```
> Concepto: **una sola clase padre, muchas interfaces.** Java no permite
> herencia multiple de clases, pero si de contratos.
> En Python simplemente agregas otra clase base: `class Circulo(Figura, Dibujable, Redimensionable)`.

Prueba `circulo.escalar(2)` y verifica que el area se cuadruplica.

---

### E4.6 - Duck typing (solo Python)
La clase `Cuadrado` de `cuadrado.py` funciona **sin heredar de nada**:
abre el archivo y comprueba que no importa ni a `Figura` ni a `Dibujable`.

1. Quitale el metodo `perimetro()`. ¿Cuando explota: al crear el objeto,
   o recien al llamar `perimetro()`?
2. Compara con Java, donde el error habria aparecido al compilar.
3. Si hiciste E4.2, abre `cuadrado.py` y `cuadrado_formal.py` uno al lado del
   otro. Los dos funcionan en el mismo bucle. ¿Que gana el que hereda?
   (Pista: quitale `area()` a cada uno y mira **cuando** avisa cada version.)

**Pregunta de cierre para el curso:**
¿Cual enfoque prefieres para un equipo de 10 personas y por que?
- Java: el contrato es obligatorio y se revisa antes de ejecutar.
- Python: el contrato es implicito y se descubre al ejecutar.
