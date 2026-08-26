"""
delfin.py - LA OTRA JERARQUIA

Es un Mamifero, no un Ave. No comparte NINGUN ancestro con el pato
salvo Animal. Y aun asi cabe en la misma lista de Nadador que el pato.

Eso es lo que la herencia sola no puede hacer.
"""

from mamifero import Mamifero
from nadador import Nadador


class Delfin(Mamifero, Nadador):

    def __init__(self, nombre, edad):
        super().__init__(nombre, edad, False)

    def sonido(self):
        return "Click click"

    # --- contrato Nadador ---
    def nadar(self):
        print(f"   {self._nombre} cruza la bahia a toda velocidad")

    def velocidad_en_agua(self):
        return 40.0
