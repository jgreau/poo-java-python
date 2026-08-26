# Demo 02 - Encapsulamiento | Ejercicios

---

### E2.1 - Cambiar la privacidad de un atributo (el ejercicio estrella)

**Java.** En `CuentaBancaria`, cambia:
```java
private int saldo;   ->   public int saldo;
```
Ahora, en `Demo02.java`, descomenta la linea que ya esta preparada y agrega
un `mostrar()` debajo:
```java
cuenta.saldo = 999999999;   // <- esta linea esta comentada en el archivo
cuenta.mostrar();           // <- esta la escribes tu
```
1. Compila. Ahora **si** funciona. ¿Es eso bueno?
2. Acabas de hacerte millonario sin depositar. Toda la validacion de
   `depositar()` y `girar()` quedo inutil.
3. Vuelvelo a `private` y comprueba que el error regresa.

**Python.** Haz el recorrido inverso, en tres pasos, probando cada uno:
```python
self.saldo   = ...    # publico:  cuenta.saldo = 999 funciona
self._saldo  = ...    # "privado" por convencion: TAMBIEN funciona (solo avisa)
self.__saldo = ...    # name mangling: cuenta.__saldo = 999 crea un atributo NUEVO
```
> El tercer caso es traicionero y hay que mostrarlo en clase:
> `cuenta.__saldo = 999` **no da error**, pero no cambia el saldo real.
> Imprime `cuenta.__dict__` para ver que quedaron dos atributos distintos.

**Pregunta para cerrar:** ¿en cual de los dos lenguajes el compilador es tu aliado?

---

### E2.2 - Agregar un atributo privado
Agrega `private String documento;` / `self._documento` (el numero de
documento de identidad), pedido en el constructor.
Ponle **getter pero NO setter**: un documento de identidad no se cambia.
Muestralo en `mostrar()`.

---

### E2.3 - Agregar un metodo con validacion
Agrega `transferir(CuentaBancaria destino, int monto)`:
- si el monto supera el saldo -> error y no hace nada
- si no -> resta aqui y suma alla

```java
public void transferir(CuentaBancaria destino, int monto) {
    if (monto > this.saldo) { System.out.println("ERROR: fondos insuficientes"); return; }
    this.girar(monto);
    destino.depositar(monto);
}
```

**Ahora el detalle que sorprende a todos.** Escribe esta segunda version,
que toca los atributos directamente:
```java
public void transferirDirecto(CuentaBancaria destino, int monto) {
    this.saldo -= monto;
    destino.saldo += monto;   // el saldo PRIVADO de OTRO objeto
}
```
Compila. Y funciona.

> `private` es **por clase**, no **por objeto**: dentro de `CuentaBancaria`
> puedes tocar los atributos privados de cualquier `CuentaBancaria`, no solo
> los tuyos. En Python pasa lo mismo: dentro de la clase, `destino.__saldo`
> tambien funciona.
>
> Pregunta de diseno: aunque compile, ¿cual de las dos versiones prefieres?
> La primera respeta las validaciones de `girar()` y `depositar()`;
> la segunda se las salta.

---

### E2.4 - Crear una nueva instancia y probar la transferencia
```java
CuentaBancaria cuenta2 = new CuentaBancaria("Luis Soto", 20000);
cuenta.transferir(cuenta2, 45000);
cuenta.mostrar();
cuenta2.mostrar();
```

---

### E2.5 - Agregar un setter con regla (Java) / @property (Python)
Agrega el atributo privado `limiteGiro` (por defecto 500000) con:
- getter
- setter que **rechace** valores negativos o mayores a 1.000.000

En Python hazlo con `@property` + `@limite_giro.setter` y comprueba que
`cuenta.limite_giro = -5` imprime el error, pero se escribe como un atributo normal.

> Moraleja de la demo: **Java protege con el compilador; Python protege con
> convenciones y @property.** El objetivo es el mismo, el mecanismo no.
