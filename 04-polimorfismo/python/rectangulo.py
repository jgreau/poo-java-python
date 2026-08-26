from dibujable import Dibujable
from figura import Figura


class Rectangulo(Figura, Dibujable):

    def __init__(self, ancho, alto):
        super().__init__("Rectangulo")
        self._ancho = ancho
        self._alto = alto

    def area(self):
        return self._ancho * self._alto

    def perimetro(self):
        return 2 * (self._ancho + self._alto)

    def dibujar(self):
        print(f"Dibujando un rectangulo {self._ancho}x{self._alto}  [ ]")
