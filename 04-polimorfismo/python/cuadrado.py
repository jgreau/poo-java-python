"""
cuadrado.py - EL INTRUSO (duck typing)

Esta clase NO hereda de Figura. No hereda de nada.
Y aun asi va a funcionar en el mismo bucle que las demas, porque
tiene los metodos que ese bucle necesita.

  "Si camina como pato y grazna como pato, es un pato."

En Java esto NO compila: el arreglo es de tipo Figura[] y un Cuadrado
que no extienda Figura simplemente no cabe ahi.
"""


class Cuadrado:

    def get_nombre(self):
        return "Cuadrado"

    def area(self):
        return 16

    def perimetro(self):
        return 16
