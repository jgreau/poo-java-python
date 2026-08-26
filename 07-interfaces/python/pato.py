"""
pato.py - hereda de UNA clase, firma DOS contratos
"""

from ave import Ave
from nadador import Nadador
from volador import Volador


class Pato(Ave, Nadador, Volador):

    def __init__(self, nombre, edad):
        super().__init__(nombre, edad, 3000)

    def sonido(self):
        return "Cuac"

    # --- contrato Nadador ---
    def nadar(self):
        print(f"   {self._nombre} chapotea en la laguna")

    def velocidad_en_agua(self):
        return 8.0

    # --- contrato Volador ---
    def volar(self):
        print(f"   {self._nombre} levanta vuelo")

    def altura_maxima(self):
        return 1000
