"""
DEMO 04 - POLIMORFISMO, CLASES ABSTRACTAS E INTERFACES
Ejecutar:  python3 demo04.py

Siete archivos:
    figura.py      la idea abstracta
    dibujable.py   el contrato
    circulo.py     Figura + Dibujable
    rectangulo.py  Figura + Dibujable
    triangulo.py   solo Figura
    cuadrado.py    NADA (duck typing)
    demo04.py      el programa   <- estas aqui

  f instanceof Dibujable  ->  isinstance(f, Dibujable)
"""

from circulo import Circulo
from cuadrado import Cuadrado
from dibujable import Dibujable
from figura import Figura
from rectangulo import Rectangulo
from triangulo import Triangulo


def sumar_areas(figuras):
    """No sabe ni le importa que figuras le pasen. Solo que responden a area()."""
    return sum(f.area() for f in figuras)


if __name__ == "__main__":

    figuras = [Circulo(3.0), Rectangulo(4.0, 5.0), Triangulo(6.0, 2.0)]

    print("--- POLIMORFISMO: el mismo llamado, distinta respuesta ---")
    for f in figuras:
        print(f"{f.get_nombre():<12} area = {f.area():6.2f} | perimetro = {f.perimetro():6.2f}")

    print("--- Un metodo que sirve para cualquier Figura ---")
    print(f"Area total: {sumar_areas(figuras):.2f}")

    print("--- INTERFAZ: un contrato aparte de la herencia ---")
    for f in figuras:
        if isinstance(f, Dibujable):
            f.dibujar()
        else:
            print(f"{f.get_nombre()} no sabe dibujarse.")

    print("--- La clase abstracta no se puede instanciar ---")
    try:
        f = Figura("fantasma")
    except TypeError as e:
        print(f"Error esperado -> {e}")

    print("--- DUCK TYPING: lo que Java NO permite ---")
    patito = Cuadrado()          # no hereda de Figura. De nada.
    print(f"{patito.get_nombre():<12} area = {patito.area():6.2f}")
    print(f"Area total con el intruso: {sumar_areas(figuras + [patito]):.2f}")
    print("Funciono sin heredar de Figura. En Java esto NO compila.")
