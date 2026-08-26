"""
volador.py - OTRA "INTERFAZ"

En Java una clase hereda de UNA sola clase pero implementa TODAS las
interfaces que quiera. En Python la herencia multiple ya lo permite,
asi que la distincion es de INTENCION, no de sintaxis:

    class Pato(Ave, Nadador, Volador)
          ^^^^ lo que ES   ^^^^^^^^^^^^^^ lo que SABE HACER

La primera clase base es la jerarquia real; las demas son contratos.
"""

from abc import ABC, abstractmethod


class Volador(ABC):

    @abstractmethod
    def volar(self):
        """Contrato: quien firme esto, sabe volar."""

    @abstractmethod
    def altura_maxima(self):
        """metros"""
