"""
fraccion.py

EQUIVALENCIAS CON JAVA
  toString()          ->  __str__      (lo que ve el usuario)
                          __repr__     (lo que ve el programador, en la consola)
  equals(Object o)    ->  __eq__(self, otro)
  hashCode()          ->  __hash__

Los metodos con doble guion bajo se llaman "dunder" (double underscore).
No los llamas tu: los llama Python cuando usas print(), == o +.
"""


class Fraccion:

    def __init__(self, numerador, denominador):
        if denominador == 0:
            raise ValueError("El denominador no puede ser 0")
        self._numerador = numerador
        self._denominador = denominador

    # ---------- El equivalente de toString() ----------
    def __str__(self):
        return f"{self._numerador}/{self._denominador}"

    def __repr__(self):
        return f"Fraccion({self._numerador}, {self._denominador})"

    # ---------- "SOBRECARGA" a la Python ----------
    # Python NO permite dos metodos con el mismo nombre: el segundo pisa al primero.
    # El equivalente es UN metodo que revisa el tipo del argumento.
    def sumar(self, otro):
        if isinstance(otro, Fraccion):
            n = self._numerador * otro._denominador + otro._numerador * self._denominador
            d = self._denominador * otro._denominador
            return Fraccion(n, d)
        if isinstance(otro, int):
            return Fraccion(self._numerador + otro * self._denominador, self._denominador)
        raise TypeError(f"No se puede sumar una Fraccion con {type(otro).__name__}")

    # ---------- SOBRECARGA DE OPERADORES: esto Java no lo tiene ----------
    def __add__(self, otro):
        return self.sumar(otro)      # ahora "a + b" funciona

    # ---------- El equivalente de equals() ----------
    def __eq__(self, otro):
        if not isinstance(otro, Fraccion):
            return NotImplemented
        return self._numerador * otro._denominador == otro._numerador * self._denominador

    # Igual que en Java: si defines __eq__, define __hash__
    def __hash__(self):
        return hash(self._numerador / self._denominador)
