# Paso 3 - Variables y operaciones | Ejercicios

Sigue sin haber teclado: los datos se escriben en el código, dentro de las
variables. Lo que se practica aquí es el **tipo**, las **operaciones** y las
dos trampas de la división.

▶ **Plantillas:** [plantillas/](plantillas/) — un `.java` por ejercicio, con el enunciado, la salida esperada y los `// TODO` donde va tu código.
Si las usas, el archivo ya viene creado (`B3_1_Iva.java`) y **ese** nombre manda sobre el
que diga el enunciado.

✅ **Solucionario:** [soluciones/](soluciones/soluciones.md) — el código de cada
ejercicio, la salida real y por qué se resuelve así. Ábrelo **después** de intentarlo.

> **Cómo se lee cada ejercicio:** el título dice qué hay que lograr; el bloque
> de abajo es la **salida esperada**, o sea lo que tiene que aparecer en tu
> pantalla (en los programas que preguntan cosas, lo que va después de la
> pregunta es lo que **escribe el usuario**); las citas como esta son pistas.
> Si no sabes por dónde partir, abre la plantilla: los `// TODO` numerados son
> los pasos, en orden. Compila y ejecuta después de cada uno.

---

### B3.1 - El IVA

**Qué practicas:** declarar variables y una constante con `final`, y calcular valores en vez de escribirlos a mano.

Escribe `Iva.java`. Declara el precio neto (10000) y la constante
`final double IVA = 0.19;`. Imprime:

```
Neto:  10000
IVA:    1900
Total: 11900
```

> Los tres números salen de la misma operación, no los escribas a mano.
> Imprime sin decimales con `%.0f`, o convierte a `int` con un cast.

---

### B3.2 - La película

**Qué practicas:** usar la división entera (`/`) y el resto (`%`) juntos para convertir minutos en horas y minutos.

Una película dura 135 minutos. Con `/` y `%`, imprime:

```
Dura 2 horas y 15 minutos
```

Después hazlo con 200 minutos y con 59, sin cambiar nada más que el número.

---

### B3.3 - Los tres dígitos

**Qué practicas:** separar los dígitos de un número usando `/` y `%` repetidamente.

Declara `int numero = 573;` y, usando **solo** `/` y `%`, imprime:

```
Centenas: 5
Decenas:  7
Unidades: 3
Suma de los digitos: 15
```

> Pista: `573 % 10` te da el 3. `573 / 10` te deja 57. Repite.

---

### B3.4 - El promedio mal calculado

**Qué practicas:** detectar una división entera escondida en una expresión, y corregirla con un cast o con un divisor decimal.

Este código está mal y compila igual:

```java
        int nota1 = 5;
        int nota2 = 6;
        int nota3 = 4;
        double promedio = (nota1 + nota2 + nota3) / 3;
        System.out.println("Promedio: " + promedio);
```

1. Ejecútalo. Imprime `5.0` y el promedio de verdad es 5.0, así que parece
   correcto. Cambia la `nota3` a 5 y vuelve a correrlo: debería dar 5.33 y da
   **5.0**.
2. Arréglalo de **dos** formas distintas: una con un cast, otra sin cast.
3. Explica en un comentario por qué el error se escondía con las notas
   originales.

---

### B3.5 - Intercambiar dos variables

**Qué practicas:** intercambiar el valor de dos variables usando una tercera, y por qué una asignación copia un valor en vez de relacionarlo.

Declara `int a = 3;` y `int b = 8;`. Haz que terminen al revés (`a` valiendo 8
y `b` valiendo 3) **sin** escribir los números otra vez.

```
Antes:    a = 3, b = 8
Despues:  a = 8, b = 3
```

> Pista: necesitas una tercera variable. Si intentas `a = b; b = a;` se pierde
> un valor: pruébalo y mira qué queda.

---

### B3.6 - Desafío: la calculadora de propinas

**Qué practicas:** calcular con decimales y elegir, con criterio, entre `Math.ceil` y `Math.round` según lo que representa el resultado.

Declara la cuenta (`double cuenta = 23400;`) y la cantidad de personas
(`int personas = 3;`). Con la propina sugerida del 10%, imprime:

```
Cuenta:            23400
Propina (10%):      2340
Total:             25740
Cada uno paga:      8580
```

Ahora prueba con **7** personas: la división ya no es exacta y aparece
`3677.1428571428573`. ¿Conviene redondear hacia arriba o hacia abajo lo que
paga cada uno? Usa `Math.ceil` o `Math.round`, y justifica tu elección en un
comentario.

---

Cuando termines, sigue con el [paso 4](../PASO-A-PASO.md#paso-4---leer-del-teclado-con-scanner).
