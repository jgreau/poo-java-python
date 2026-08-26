"""
DEMO 05 - COMPOSICION Y MIEMBROS DE CLASE
Ejecutar:  python3 demo05.py

Tres archivos:
    alumno.py   con atributos de objeto Y de clase
    curso.py    contiene alumnos (composicion)
    demo05.py   el programa   <- estas aqui
"""

from alumno import Alumno
from curso import Curso


if __name__ == "__main__":

    print(f"Alumnos creados hasta ahora: {Alumno.get_total_creados()}")

    a1 = Alumno("Camila", 6.5)
    a2 = Alumno("Benjamin", 4.2)
    a3 = Alumno("Sofia", 5.8)

    print(f"Alumnos creados hasta ahora: {Alumno.get_total_creados()}")
    print("El contador es UNO SOLO, compartido por todos los objetos.")

    print("--- COMPOSICION: el curso CONTIENE alumnos ---")
    poo = Curso("Programacion Orientada a Objetos", "Sala 204")
    poo.inscribir(a1)
    poo.inscribir(a2)
    poo.inscribir(a3)
    poo.listar()

    print(f"Promedio del curso: {poo.promedio():.2f}")
    print(f"Cantidad inscritos: {poo.cantidad_alumnos()}")

    print("--- Un metodo del curso que recorre sus alumnos ---")
    poo.mostrar_aprobados(4.0)

    print("--- CONSTANTE de clase ---")
    print(f"Colegio: {Alumno.COLEGIO}")
    print("En Python NADA impide hacer Alumno.COLEGIO = 'otro'. Java si lo impide (final).")

    print("--- METODO ESTATICO: se llama sin crear objeto ---")
    print(f"¿4.0 aprueba? {Alumno.aprueba(4.0)}")
    print(f"¿3.9 aprueba? {Alumno.aprueba(3.9)}")

    print("--- LA TRAMPA CLASICA DE PYTHON ---")
    # El atributo de clase es COMPARTIDO. Si el alumno le "asigna" encima,
    # se crea uno de instancia que TAPA al de la clase.
    a1.total_creados = 999
    print(f"a1.total_creados  = {a1.total_creados}   <- atributo de INSTANCIA nuevo")
    print(f"a2.total_creados  = {a2.total_creados}     <- sigue viendo el de CLASE")
    print(f"Alumno.total_creados = {Alumno.total_creados}  <- el real no cambio")
    print("En Java esto no puede pasar: el static se accede como Alumno.totalCreados.")
