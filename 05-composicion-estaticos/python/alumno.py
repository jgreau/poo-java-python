"""
alumno.py

REGLA DE ORO PARA DISTINGUIR, mirando este archivo:
  ¿va en __init__ con self.?  -> es de cada objeto
  ¿va suelto dentro de class? -> es de la clase, compartido por todos

  static int totalCreados = 0;   ->  total_creados = 0   (DENTRO de la clase,
                                                          FUERA de __init__)
  static boolean aprueba(...)    ->  @staticmethod
  static int getTotalCreados()   ->  @classmethod  (recibe cls = la clase)
  static final String COLEGIO    ->  COLEGIO = "..."  (Python no tiene constantes
                                                       reales: MAYUSCULAS = "no tocar")
"""


class Alumno:

    # ---- ATRIBUTOS DE CLASE (el "static" de Java) ----
    total_creados = 0
    COLEGIO = "Colegio Central"
    NOTA_MINIMA = 4.0

    def __init__(self, nombre, nota):
        # ---- ATRIBUTOS DE INSTANCIA: uno por objeto ----
        self._nombre = nombre
        self._nota = nota
        # Ojo: se incrementa en la CLASE, no en self
        Alumno.total_creados += 1

    def get_nombre(self):
        return self._nombre

    def get_nota(self):
        return self._nota

    @staticmethod
    def aprueba(nota):
        """No usa self ni cls: es una funcion util que vive dentro de la clase."""
        return nota >= Alumno.NOTA_MINIMA

    @classmethod
    def get_total_creados(cls):
        """Recibe la CLASE (cls), no el objeto."""
        return cls.total_creados
