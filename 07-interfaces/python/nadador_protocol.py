"""
nadador_protocol.py - LO QUE JAVA NO TIENE

Un Protocol es una interfaz que NO hay que firmar.

  Con la ABC `Nadador`:      hay que escribir  class Delfin(Mamifero, Nadador)
  Con este Protocol:         basta con TENER los metodos nadar() y
                             velocidad_en_agua(). Nadie tiene que declarar nada.

Es el duck typing de la demo 4, pero escrito: en vez de quedar en un
acuerdo tacito, el contrato queda documentado en un archivo, y
@runtime_checkable permite comprobarlo con isinstance().

Java no tiene equivalente: alla el contrato SIEMPRE hay que firmarlo.
"""

from typing import Protocol, runtime_checkable


@runtime_checkable
class NadadorProtocol(Protocol):

    def nadar(self) -> None: ...

    def velocidad_en_agua(self) -> float: ...
