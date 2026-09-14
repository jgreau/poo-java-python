# 00 - Base: Java desde cero

Repaso de lo básico de Java, para hacer antes de entrar a clases y objetos.

Empieza aquí: **[PASO-A-PASO.md](PASO-A-PASO.md)**. Son 13 pasos, cada uno con
su propio programa: el `main`, imprimir, variables, `Scanner`, decidir,
repetir, arreglos, métodos, tus propias clases, validaciones y sobrecarga. El
último paso junta todo en una calculadora de notas.

## Qué hay en esta carpeta

Todo está organizado **por paso**: cada `pasoNN/` trae junto lo que necesitas
para ese paso.

```
00-base/
├── PASO-A-PASO.md      la guía completa: empieza aquí
└── paso01/ ... paso13/  una carpeta por paso, todas con la misma forma:
    ├── referencia/          el código terminado del paso, para comparar
    ├── ejercicios.md        el enunciado de los ejercicios de este paso
    ├── plantillas/          un .java por ejercicio, con // TODO donde escribes tú
    └── soluciones/
        ├── soluciones.md        el código resuelto, la salida real y la explicación
        └── *.java               los .java ya resueltos, listos para ejecutar
```

Por ejemplo, todo el paso 4 vive en `paso04/`:

```
paso04/
├── referencia/Paso04Teclado.java
├── ejercicios.md              B4.1 a B4.5
├── plantillas/                B4_1_Calculadora.java ... B4_5_Vuelto.java
└── soluciones/
    ├── soluciones.md
    └── B4_1_Calculadora.java ... B4_5_Vuelto.java
```

## Cómo trabajar

1. **Sigue `PASO-A-PASO.md` paso a paso.** Escribe el código tú, sin copiar y
   pegar: equivocarte y leer el error de `javac` es parte de cómo se aprende.
   Compila después de cada bloque, no al final. Si te pierdes, compara tu
   código con el de `referencia/` en el paso correspondiente, línea por línea.
2. **Al terminar cada paso, resuelve `pasoNN/ejercicios.md`.** Cada hoja trae
   entre 5 y 6 ejercicios, de menos a más difícil, y el último siempre es un
   desafío. Cada ejercicio dice qué vas a practicar y trae la salida esperada,
   para que sepas solo si te quedó bien.
3. **Si prefieres no escribir el esqueleto de cada programa**, usa la
   plantilla `.java` del ejercicio, en `pasoNN/plantillas/`: ya trae la clase,
   el enunciado en un comentario y los `// TODO` numerados donde va tu código.
   Compilan y corren desde el primer minuto: puedes ejecutar el programa
   incompleto, ver que no hace nada todavía, y completarlo TODO por TODO,
   recompilando después de cada uno.
4. **Si te atascas**, abre `pasoNN/soluciones/soluciones.md`. Ábrelo
   *después* de intentarlo: ahí está el código completo, la salida real de
   ejecutarlo y una explicación de por qué se resuelve así.

Trabaja siempre en tu propia carpeta, no dentro de `referencia/` ni de
`soluciones/`: esas dos son la versión terminada, para comparar después de
haberlo intentado tú.

Ningún ejercicio depende de que haya alguien más al lado. Cada uno trae todo
lo necesario para resolverlo y para comprobar que te quedó bien, solo con tu
computador.

### Dos casos especiales

**`paso01/plantillas/Practica.java` no compila, y es a propósito**: es el
ejercicio B1.3, la caza de los cuatro errores. Ahí no sirve `javac *.java`
hasta que lo arregles.

**Desde el paso 10, algunos ejercicios necesitan una clase que ya escribiste
en un paso anterior** (`Notas`, `Validador`, `Geometria`). El comentario de
arriba de cada plantilla que la necesita lo dice, y da la ruta de rescate a
`referencia/` por si perdiste la tuya. Por ejemplo, para el primer ejercicio
del paso 10:

```bash
cd paso10/plantillas
cp ../referencia/Notas.java .
javac Notas.java B10_1_MasNotas.java
java B10_1_MasNotas
```

## Qué mirar en cada solucionario, aunque te haya salido bien

| Paso | Lo que conviene mirar |
|---|---|
| [01](paso01/soluciones/soluciones.md) | Las **cinco rondas** de `javac` del B1.3: por qué el error de la mayúscula no aparece hasta que las llaves están bien |
| [02](paso02/soluciones/soluciones.md) | Las seis líneas del B2.1, explicadas una por una |
| [03](paso03/soluciones/soluciones.md) | Por qué el promedio del B3.4 daba bien con unos datos y mal con otros |
| [04](paso04/soluciones/soluciones.md) | El `sc.nextLine()` de relleno, y por qué el IMC sin paréntesis devuelve el peso |
| [05](paso05/soluciones/soluciones.md) | Por qué el `-3` da impar pero `% 2 == 1` lo habría dado par |
| [06](paso06/soluciones/soluciones.md) | El caso del `0` como primer dato: `0 / 0` contra `NaN` |
| [07](paso07/soluciones/soluciones.md) | El factorial que se desborda en el 13 **sin avisar** |
| [08](paso08/soluciones/soluciones.md) | Por qué invertir un arreglo recorre solo la mitad |
| [09](paso09/soluciones/soluciones.md) | El `return false` que reemplaza a la bandera y al `break` |
| [10](paso10/soluciones/soluciones.md) | Las cuatro respuestas del B10.5, incluida la de `Math` contra `Scanner` |
| [11](paso11/soluciones/soluciones.md) | El dígito verificador del RUT, paso a paso |
| [12](paso12/soluciones/soluciones.md) | Cuál versión elige Java en `sumar(2, 3.5)`, y qué error da si la borras |
| [13](paso13/soluciones/soluciones.md) | Dónde va el redondeo, y por qué los arreglos paralelos piden a gritos un objeto |

---

Cuando termines los 13 pasos, sigue con:

1. **[`EJERCICIOS-00-ARCHIVOS.md`](../EJERCICIOS-00-ARCHIVOS.md)**: la regla
   de que un archivo `.java` contiene una clase.
2. **[Demo 1](../01-clases-objetos/)**: tus primeras clases y objetos.

---

Verificado con OpenJDK 17: todo el código de esta carpeta —los 13 pasos, las
68 plantillas y las 68 soluciones— compila y se ejecuta tal como se muestra.
