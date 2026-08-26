"""
pinguino.py - EL ARGUMENTO CENTRAL DE TODA LA DEMO

Es un Ave. Nada mejor que muchos peces. Y NO VUELA.

Si volar() estuviera dentro de la clase Ave, el pinguino estaria
obligado a heredarlo, y habria que rellenarlo con algo falso
("no hago nada", lanzar un error, devolver 0...).

Al estar en la interfaz Volador, el pinguino simplemente NO LA FIRMA.
Compara la primera linea de la clase con la de pato.py.
"""

from ave import Ave
from nadador import Nadador


class Pinguino(Ave, Nadador):

    def __init__(self, nombre, edad):
        super().__init__(nombre, edad, 5000)

    def sonido(self):
        return "Kua"

    # --- contrato Nadador ---
    def nadar(self):
        print(f"   {self._nombre} se desliza bajo el hielo")

    def velocidad_en_agua(self):
        return 12.0
