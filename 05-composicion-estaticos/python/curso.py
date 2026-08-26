"""
curso.py - COMPOSICION

Un Curso TIENE alumnos. No "es un" alumno: por eso no hay herencia,
sino un atributo que guarda otros objetos.

CUIDADO con el error mas comun de quien viene de Java:
    class Curso:
        alumnos = []        # <- MAL: atributo de CLASE, se comparte
                            #    entre TODOS los cursos del programa
La lista tiene que crearse DENTRO de __init__, como esta abajo.
"""


class Curso:

    def __init__(self, nombre, sala):
        self._nombre = nombre
        self._sala = sala
        # COMPOSICION: este atributo guarda OTROS OBJETOS
        self._alumnos = []          # nace vacia, no None

    def inscribir(self, alumno):
        self._alumnos.append(alumno)
        print(f"{alumno.get_nombre()} inscrito en {self._nombre}")

    def cantidad_alumnos(self):
        return len(self._alumnos)

    def promedio(self):
        if not self._alumnos:
            return 0
        return sum(a.get_nota() for a in self._alumnos) / len(self._alumnos)

    def listar(self):
        print(f"Curso: {self._nombre} ({self._sala})")
        for a in self._alumnos:
            print(f"   - {a.get_nombre():<10} {a.get_nota():.1f}")

    def mostrar_aprobados(self, minimo):
        for a in self._alumnos:
            if a.get_nota() >= minimo:
                print(f"   APROBADO: {a.get_nombre()}")
            else:
                print(f"   reprobado: {a.get_nombre()}")
