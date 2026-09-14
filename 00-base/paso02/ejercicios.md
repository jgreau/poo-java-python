# Paso 2 - Imprimir | Ejercicios

Todo lo de esta hoja se hace **sin variables**: todavía no las vimos.
Solo `System.out.println`, `System.out.print`, `System.out.printf` y los
caracteres especiales (`\n`, `\t`, `\"`).

▶ **Plantillas:** [plantillas/](plantillas/) — un `.java` por ejercicio, con el enunciado, la salida esperada y los `// TODO` donde va tu código.
Si las usas, el archivo ya viene creado (`B2_1_Adivina.java`) y **ese** nombre manda sobre el
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

### B2.1 - Adivina la salida

**Qué practicas:** cómo Java evalúa el operador `+` de izquierda a derecha entre textos y números, y la conversión de un `char` a su código numérico.

Antes de escribir nada, **anota en un papel** qué crees que imprime cada línea.
Después crea `Adivina.java`, pégalas y compruébalo.

```java
        System.out.println("" + 1 + 2);
        System.out.println(1 + 2 + "");
        System.out.println("Total: " + 10 + 5);
        System.out.println("Total: " + (10 + 5));
        System.out.println(10 + 5 + " pesos");
        System.out.println('a' + 1);
```

Acertaste... ¿cuántas de seis?

> La última es la más rara: un `char` sumado a un número se convierte en su
> **código numérico**. La `a` es el 97.

---

### B2.2 - La boleta

**Qué practicas:** alinear texto y números con `printf`, usando `%-Ns` y `%Nd`.

Escribe `Boleta.java` que imprima exactamente esto, usando `printf`:

```
Completo      2500
Bebida        1200
Papas fritas  1800
--------------------
TOTAL         5500
```

> Pistas: `%-14s` escribe un texto rellenando hasta 14 caracteres **a la
> izquierda**; `%4d` escribe un entero ocupando 4 espacios, alineado a la
> derecha. La línea de guiones son 20. El total lo sumas tú y lo escribes a
> mano: todavía no hay variables.

---

### B2.3 - La tarjeta

**Qué practicas:** usar los caracteres de escape que saltan de línea y tabulan
dentro de un mismo `println`.

Escribe `Tarjeta.java` que dibuje esto. Son **tres** `println` como máximo, así
que vas a necesitar `\n` y `\t`.

```
+----------------------+
| DUOC UC              |
|                      |
| Ana Perez            |
| Seccion 003D         |
+----------------------+
```

---

### B2.4 - Las comillas

**Qué practicas:** los caracteres de escape para comillas, barra invertida y
tabulación dentro de un texto.

Escribe `Cita.java` que imprima:

```
El profesor dijo: "Java obliga, Python avisa"
La ruta es C:\duoc\java
Fin	del	ejercicio
```

> La segunda línea tiene truco: `\` es el carácter de escape, así que para
> imprimir **una** barra hay que escribir dos. La tercera usa tabulaciones.

---

### B2.5 - Desafío: la tabla alineada

**Qué practicas:** por qué alinear con espacios a mano se rompe apenas cambian los datos, y cómo `%N.Mf` lo resuelve.

Imprime esta tabla con **un solo** `printf` por línea, separando las columnas
con espacios a mano. Te va a quedar más o menos así, con la última fila
descuadrada:

```
Producto         Precio    IVA
Completo         2500.0  475.0
Bebida           1200.0  228.0
Torta            12500.0 2375.0
```

Ahora arréglala para que quede **exactamente** así, con los números alineados a
la derecha:

```
Producto          Precio     IVA
Completo          2500.0   475.0
Bebida            1200.0   228.0
Torta            12500.0  2375.0
```

> Pista: `%8.1f` reserva 8 espacios en total, con 1 decimal.

---

Cuando termines, sigue con el [paso 3](../PASO-A-PASO.md#paso-3---variables-y-operaciones).
