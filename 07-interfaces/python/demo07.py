"""
DEMO 07 - INTERFACES
Ejecutar:  python3 demo07.py

Doce archivos:
    animal.py            clase abstracta: lo que un animal ES
    ave.py               rama 1 de la jerarquia
    mamifero.py          rama 2 de la jerarquia
    nadador.py           "INTERFAZ": lo que algo SABE HACER
    volador.py           "INTERFAZ"
    pato.py              Ave + Nadador + Volador
    pinguino.py          Ave + Nadador          (no vuela!)
    aguila.py            Ave + Volador          (no nada)
    delfin.py            Mamifero + Nadador     (otra jerarquia)
    nadador_protocol.py  la interfaz que no hay que firmar (solo Python)
    submarino.py         el intruso que la cumple sin saberlo
    demo07.py            el programa   <- estas aqui

LA PREGUNTA QUE RESPONDE ESTA DEMO:
    si ya tenemos herencia, ¿para que sirven las interfaces?
"""

from aguila import Aguila
from animal import Animal
from delfin import Delfin
from nadador import Nadador
from nadador_protocol import NadadorProtocol
from pato import Pato
from pinguino import Pinguino
from submarino import Submarino
from volador import Volador


def el_mas_rapido(participantes):
    """No sabe de patos ni de delfines. Solo exige el contrato."""
    return max(participantes, key=lambda n: n.velocidad_en_agua())


if __name__ == "__main__":

    donald = Pato("Donald", 3)
    pingu = Pinguino("Pingu", 5)
    pedro = Aguila("Pedro", 7)
    flipper = Delfin("Flipper", 10)

    print("--- Lo que cada uno ES (herencia) ---")
    animales = [donald, pingu, pedro, flipper]
    for a in animales:
        a.presentarse()

    print("--- Lo que cada uno SABE HACER (interfaces) ---")
    print(f"{'':<20} {'Nadador':<9} Volador")
    for a in animales:
        etiqueta = f"{a.get_nombre()} ({type(a).__name__})"
        nada = "si" if isinstance(a, Nadador) else "no"
        vuela = "si" if isinstance(a, Volador) else "no"
        print(f"{etiqueta:<20} {nada:<9} {vuela}")

    print("--- LA INTERFAZ COMO TIPO ---")
    # La lista junta un Ave y un Mamifero, que no comparten ancestro
    # salvo Animal. La interfaz los junta; la herencia no podria.
    nadadores = [donald, pingu, flipper]
    print("Un arreglo de Nadador con un Ave y un Mamifero adentro:")
    for n in nadadores:
        n.nadar()

    print("--- Un metodo que solo pide el contrato ---")
    ganador = el_mas_rapido(nadadores)
    print(f"Gana la competencia: {ganador.velocidad_en_agua():.1f} km/h")
    print(f"Y es: {ganador.get_nombre()}")

    print("--- Otro contrato, otros participantes ---")
    voladores = [donald, pedro]
    for v in voladores:
        v.volar()
        print(f"      (hasta {v.altura_maxima()} m)")

    print("--- POR QUE volar() NO PUEDE ESTAR EN LA CLASE Ave ---")
    print("Pingu es un Ave, pero no implementa Volador.")
    print("Si volar() viviera en Ave, el pinguino estaria obligado")
    print("a heredar un metodo que no tiene ningun sentido para el.")

    print("--- SOLO PYTHON: el contrato que no hay que firmar ---")
    sub = Submarino("Nautilus")
    print(f"¿El submarino hereda de Nadador?      {isinstance(sub, Nadador)}")
    print(f"¿Cumple el NadadorProtocol?           {isinstance(sub, NadadorProtocol)}")
    print("Tiene los metodos, y con eso basta:")
    sub.nadar()
    campeon = el_mas_rapido([donald, pingu, flipper, sub])
    print(f"Nuevo ganador: {type(campeon).__name__} a {campeon.velocidad_en_agua():.1f} km/h")
    print("En Java el submarino tendria que declarar 'implements Nadador' o no entra.")
