"""
triangulo.py

Hereda de Figura pero NO de Dibujable: no firmo ese contrato.
Compara la primera linea de la clase con la de circulo.py.
"""

from figura import Figura


class Triangulo(Figura):

    def __init__(self, base, altura):
        super().__init__("Triangulo")
        self._base = base
        self._altura = altura

    def area(self):
        return self._base * self._altura / 2

    def perimetro(self):
        return self._base * 3            # simplificacion: equilatero
