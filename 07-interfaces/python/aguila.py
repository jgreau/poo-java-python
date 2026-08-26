"""
aguila.py - Ave que vuela pero NO nada

Junto con el pinguino demuestra que las dos capacidades son
independientes entre si, e independientes de la jerarquia.
"""

from ave import Ave
from volador import Volador


class Aguila(Ave, Volador):

    def __init__(self, nombre, edad):
        super().__init__(nombre, edad, 7000)

    def sonido(self):
        return "Screech"

    # --- contrato Volador ---
    def volar(self):
        print(f"   {self._nombre} planea sobre la cordillera")

    def altura_maxima(self):
        return 6000
