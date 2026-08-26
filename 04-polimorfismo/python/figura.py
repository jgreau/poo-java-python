"""
figura.py - CLASE ABSTRACTA

  abstract class Figura      ->  class Figura(ABC):
  abstract double area();    ->  @abstractmethod
                                 def area(self): ...

ABC = Abstract Base Class. Hay que importarla del modulo abc de la
libreria estandar: en Java "abstract" es una palabra del lenguaje,
en Python es una herramienta que se importa.
"""

from abc import ABC, abstractmethod


class Figura(ABC):

    def __init__(self, nombre):
        self._nombre = nombre

    @abstractmethod
    def area(self):
        """Cada hija esta OBLIGADA a implementarlo."""

    @abstractmethod
    def perimetro(self):
        """Idem."""

    def get_nombre(self):        # metodo normal, compartido por todas
        return self._nombre
