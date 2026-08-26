"""
vehiculo.py - LA CLASE PADRE

En Python no existe "protected" de verdad. El guion bajo (self._modelo)
es solo una senal para el programador: "esto es interno, no lo uses
desde afuera". Los hijos lo usan igual, y el mundo exterior tambien
podria, aunque no deberia.
"""


class Vehiculo:

    def __init__(self, modelo, anio):
        self._modelo = modelo
        self._anio = anio
        self._velocidad = 0

    def acelerar(self):
        self._velocidad += 20
        print(f"{self._modelo} acelera a {self._velocidad} km/h")

    def describir(self):
        print(f"Vehiculo generico: {self._modelo} ({self._anio})")
