"""
dibujable.py - LA "INTERFAZ"

Python NO tiene la palabra "interface". El equivalente es otra clase
abstracta que solo declara metodos, sin datos ni constructor.

Se usa poniendola como clase base extra:
    class Circulo(Figura, Dibujable):
que es el equivalente de:
    class Circulo extends Figura implements Dibujable
"""

from abc import ABC, abstractmethod


class Dibujable(ABC):

    @abstractmethod
    def dibujar(self):
        """Contrato: quien herede esto, sabe dibujarse."""
