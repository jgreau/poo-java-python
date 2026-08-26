"""
ave.py - PRIMERA RAMA de la jerarquia

OJO A LO QUE NO ESTA AQUI: no hay ningun metodo volar().
Parece el lugar obvio para ponerlo... hasta que aparece el pinguino.
"""

from animal import Animal


class Ave(Animal):

    def __init__(self, nombre, edad, cantidad_plumas):
        super().__init__(nombre, edad)
        self._cantidad_plumas = cantidad_plumas

    def get_grupo(self):
        return "Ave"
