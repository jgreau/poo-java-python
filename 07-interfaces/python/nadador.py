"""
nadador.py - "INTERFAZ"

Python no tiene la palabra `interface`. El equivalente mas cercano es
una clase abstracta que SOLO declara metodos: sin atributos, sin
constructor, sin estado.

  interface Nadador { }   ->   class Nadador(ABC):
  implements Nadador      ->   se agrega como clase base extra

  Animal   -> ES UN        (herencia)
  Nadador  -> SABE NADAR   (interfaz)
"""

from abc import ABC, abstractmethod


class Nadador(ABC):

    @abstractmethod
    def nadar(self):
        """Contrato: quien firme esto, sabe nadar."""

    @abstractmethod
    def velocidad_en_agua(self):
        """km/h"""
