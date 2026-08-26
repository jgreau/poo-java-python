"""
moto.py - OTRA CLASE HIJA

OJO: en Python no existe @Override. Si escribes "descrivir" en vez de
"describir", Python crea un metodo NUEVO en silencio y nunca te enteras:
el objeto seguira usando el describir() del padre.
En Java, @Override hace que eso no compile.
"""

from vehiculo import Vehiculo


class Moto(Vehiculo):

    def __init__(self, modelo, anio, tiene_carenado):
        super().__init__(modelo, anio)
        self._tiene_carenado = tiene_carenado

    def describir(self):
        extra = "con carenado" if self._tiene_carenado else "sin carenado"
        print(f"Moto {self._modelo} ({self._anio}), {extra}")

    def hacer_caballito(self):
        print(f"{self._modelo}: caballito!")
