"""
circulo.py - Figura + Dibujable

La herencia multiple de Python hace en una linea lo que Java separa
en "extends" (una sola clase) e "implements" (muchas interfaces).
"""

import math

from dibujable import Dibujable
from figura import Figura


class Circulo(Figura, Dibujable):

    def __init__(self, radio):
        super().__init__("Circulo")
        self._radio = radio

    def area(self):
        return math.pi * self._radio ** 2

    def perimetro(self):
        return 2 * math.pi * self._radio

    def dibujar(self):
        print(f"Dibujando un circulo de radio {self._radio}  ( O )")
