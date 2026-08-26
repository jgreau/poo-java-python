"""
submarino.py - EL INTRUSO

Un submarino NO es un animal. No hereda de Animal, ni de Nadador,
ni de nada. Ni siquiera sabe que NadadorProtocol existe.

Pero tiene los dos metodos que el protocolo pide, asi que sirve
igual en cualquier funcion que trabaje con nadadores.
"""


class Submarino:

    def __init__(self, nombre):
        self._nombre = nombre

    def nadar(self):
        print(f"   {self._nombre} desciende en silencio")

    def velocidad_en_agua(self):
        return 45.0
