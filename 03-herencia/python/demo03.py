"""
DEMO 03 - HERENCIA
Ejecutar:  python3 demo03.py

Cuatro archivos, igual que en Java:
    vehiculo.py   el padre
    auto.py       hijo
    moto.py       hijo
    demo03.py     el programa que los usa   <- estas aqui
"""

from auto import Auto
from moto import Moto
from vehiculo import Vehiculo


if __name__ == "__main__":

    auto = Auto("Toyota Yaris", 2020, 4)
    moto = Moto("Honda CB190", 2022, True)

    print("--- Metodos heredados del padre ---")
    auto.acelerar()
    moto.acelerar()

    print("--- Metodo sobrescrito en cada hijo ---")
    auto.describir()
    moto.describir()

    print("--- Metodos propios de cada hijo ---")
    auto.abrir_maletero()
    moto.hacer_caballito()

    print("--- Un hijo puede usarse como si fuera el padre ---")
    v = Auto("Ford Fiesta", 1998, 4)
    v.describir()
    v.acelerar()

    print("--- Lo que Python tiene y Java no ---")
    # En Python se puede preguntar el parentesco en tiempo de ejecucion
    print("¿auto es un Auto?    ", isinstance(auto, Auto))
    print("¿auto es un Vehiculo?", isinstance(auto, Vehiculo))
    print("¿auto es una Moto?   ", isinstance(auto, Moto))
    print("Cadena de herencia:  ", [c.__name__ for c in Auto.__mro__])
