"""
animal.py - CLASE ABSTRACTA (la jerarquia)

Esto es lo que un animal ES. Tiene ESTADO compartido (nombre, edad)
y comportamiento comun (presentarse). Por eso es una clase abstracta
y no una interfaz.
"""

from abc import ABC, abstractmethod


class Animal(ABC):

    def __init__(self, nombre, edad):
        self._nombre = nombre
        self._edad = edad

    @abstractmethod
    def sonido(self):
        """Cada especie hace su ruido."""

    @abstractmethod
    def get_grupo(self):
        """Cada rama de la jerarquia dice a que grupo pertenece."""

    def get_nombre(self):
        return self._nombre

    def presentarse(self):
        # type(self).__name__ es el equivalente de getClass().getSimpleName()
        print(f"{type(self).__name__} {self._nombre} "
              f"es un {self.get_grupo()}, dice: {self.sonido()}")
