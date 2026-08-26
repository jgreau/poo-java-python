"""
perro.py - LA CLASE (el molde)

DIFERENCIA CON JAVA:
  Java OBLIGA a que el archivo se llame igual que la clase publica.
  Python NO obliga a nada: el archivo puede llamarse como quieras y
  puede contener varias clases.

  Pero la costumbre (PEP 8) es:
      archivo  ->  minusculas_con_guion_bajo   perro.py, cuenta_bancaria.py
      clase    ->  CamelCase                   Perro,   CuentaBancaria

Este archivo no se ejecuta solo: solo define el molde.
"""


class Perro:

    # CONSTRUCTOR: se ejecuta al crear cada objeto
    # En Python los ATRIBUTOS no se declaran arriba: nacen aqui, con self.
    def __init__(self, nombre, raza, edad):
        self.nombre = nombre
        self.raza = raza
        self.edad = edad

    # METODOS: siempre reciben "self" como primer parametro
    def ladrar(self):
        print(f"{self.nombre} dice: Guau!")

    def cumplir_anios(self):
        self.edad = self.edad + 1
        print(f"{self.nombre} ahora tiene {self.edad} anios.")

    def presentarse(self):
        print(f"Soy {self.nombre}, un {self.raza} de {self.edad} anios.")
