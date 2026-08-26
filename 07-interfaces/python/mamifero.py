"""
mamifero.py - SEGUNDA RAMA de la jerarquia

Un Mamifero y un Ave no tienen NADA en comun salvo ser Animal.
Y sin embargo, un delfin y un pato saben hacer lo mismo: nadar.
Ese "y sin embargo" es la razon de existir de las interfaces.
"""

from animal import Animal


class Mamifero(Animal):

    def __init__(self, nombre, edad, tiene_pelaje):
        super().__init__(nombre, edad)
        self._tiene_pelaje = tiene_pelaje

    def get_grupo(self):
        return "Mamifero"
