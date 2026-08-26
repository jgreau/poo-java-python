"""
DEMO 01 - CLASES Y OBJETOS
Ejecutar:  python3 demo01.py

Mismo programa que Demo01.java, linea por linea.

EQUIVALENCIAS CON JAVA
  (nada, estan en la misma carpeta)  ->  from perro import Perro
  class Perro { }                    ->  class Perro:
  Perro(String n, ...) {}            ->  def __init__(self, n, ...):
  this.nombre                        ->  self.nombre
  new Perro("Firulais", ...)         ->  Perro("Firulais", ...)   (sin "new")
  void ladrar() { }                  ->  def ladrar(self):        (self explicito)

OJO CON EL IMPORT: se lee "del archivo perro.py, traeme la clase Perro".
  from perro import Perro
       ^^^^^             archivo (minuscula, sin .py)
              ^^^^^^^^^^ clase   (CamelCase)

En Java no hace falta importar nada porque las dos clases estan en la
misma carpeta (el mismo "paquete"). En Python el import SIEMPRE es necesario.
"""

from perro import Perro


# Este "if" es el equivalente de public static void main(String[] args)
if __name__ == "__main__":

    # CREAR INSTANCIAS: sin "new", solo se llama a la clase
    firulais = Perro("Firulais", "Mestizo", 3)
    laika = Perro("Laika", "Husky", 5)

    firulais.presentarse()
    laika.presentarse()

    print("---")

    firulais.ladrar()
    firulais.cumplir_anios()

    # Laika NO cambio: son objetos distintos
    laika.presentarse()

    print("---")

    # Los atributos se leen y se escriben con el punto, igual que en Java
    print(f"La raza de laika es: {laika.raza}")
    laika.raza = "Husky Siberiano"
    laika.presentarse()
