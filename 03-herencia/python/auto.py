"""
auto.py - CLASE HIJA

  class Auto extends Vehiculo   ->   class Auto(Vehiculo):

A diferencia de Java, aqui SI hay que importar al padre aunque este
en la misma carpeta.
"""

from vehiculo import Vehiculo


class Auto(Vehiculo):

    def __init__(self, modelo, anio, puertas):
        super().__init__(modelo, anio)     # llama al constructor del padre
        self._puertas = puertas

    def describir(self):                   # sobrescribe el del padre
        print(f"Auto {self._modelo} ({self._anio}), {self._puertas} puertas")

    def abrir_maletero(self):              # metodo exclusivo de Auto
        print(f"{self._modelo}: maletero abierto")
