"""
DEMO 06 - "SOBRECARGA", __str__ Y __eq__
Ejecutar:  python3 demo06.py

ESTO ES LO QUE MAS CONFUNDE AL CAMBIAR DE LENGUAJE:
    Java:    ==  compara referencias  |  equals() compara contenido
    Python:  is  compara referencias  |  ==       compara contenido

Dos archivos:
    fraccion.py   la clase
    demo06.py     el programa   <- estas aqui
"""

from fraccion import Fraccion


if __name__ == "__main__":

    a = Fraccion(1, 2)
    b = Fraccion(3, 4)

    print("--- __str__: como se ve el objeto al imprimirlo ---")
    print(f"a = {a}")
    print(f"b = {b}")
    print("(sin __str__ saldria algo como <fraccion.Fraccion object at 0x7f...>)")

    print("--- 'Sobrecarga': un metodo que revisa el tipo ---")
    print(f"a.sumar(b)  = {a.sumar(b)}")
    print(f"a.sumar(2)  = {a.sumar(2)}")
    print("Python elige con isinstance(), en tiempo de EJECUCION.")

    print("--- is vs == ---")
    x = Fraccion(1, 2)
    y = Fraccion(1, 2)

    print(f"x is y        -> {x is y}")
    print("   (compara si son EL MISMO objeto: el '==' de Java)")
    print(f"x == y        -> {x == y}")
    print("   (compara el CONTENIDO: el 'equals()' de Java)")

    z = x
    print(f"x is z        -> {x is z}   (misma referencia)")

    print("--- __eq__ con fracciones equivalentes ---")
    print(f"1/2 == 2/4    -> {Fraccion(1, 2) == Fraccion(2, 4)}")

    print("--- LO QUE JAVA NO PUEDE HACER: el operador + ---")
    print(f"a + b = {a + b}")
    print(f"a + 2 = {a + 2}")
    print("En Java tendrias que escribir a.sumar(b): no se puede redefinir '+'.")

    print("--- __repr__ vs __str__ ---")
    print(f"str(a)  -> {str(a)}      (para el usuario)")
    print(f"repr(a) -> {repr(a)}   (para el programador)")
    print(f"Dentro de una lista Python usa __repr__: {[a, b]}")
