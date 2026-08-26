"""
DEMO 02 - ENCAPSULAMIENTO
Ejecutar:  python3 demo02.py

Este archivo es "el mundo exterior": desde aqui se prueba que deja pasar
la clase y que no.
"""

from cuenta_bancaria import CuentaBancaria


if __name__ == "__main__":

    cuenta = CuentaBancaria("Ana Perez", 100000)
    cuenta.mostrar()

    print("--- Operaciones validas ---")
    cuenta.depositar(50000)
    cuenta.girar(30000)
    cuenta.mostrar()

    print("--- Operaciones invalidas (el objeto se defiende) ---")
    cuenta.girar(999999)
    cuenta.depositar(-5000)
    cuenta.mostrar()

    print("--- Acceso a los datos ---")
    # Se lee como atributo, pero por dentro corre el @property
    print(f"Saldo leido con getter: {cuenta.saldo}")

    # Asignar el saldo falla, porque el @property no tiene setter
    try:
        cuenta.saldo = 999999999
    except AttributeError as e:
        print(f"No se pudo asignar el saldo -> {type(e).__name__}")

    # El setter con validacion si funciona
    cuenta.titular = "Ana Maria Perez"
    cuenta.titular = ""          # rechazado
    cuenta.mostrar()

    print("--- La verdad incomoda de Python ---")
    # El __saldo se renombro internamente. Esto lo demuestra:
    print("Atributos reales del objeto:", list(cuenta.__dict__.keys()))
    # Y si alguien REALMENTE quiere romperlo, puede:
    cuenta._CuentaBancaria__saldo = 1
    cuenta.mostrar()
    print("Moraleja: en Python el encapsulamiento es un contrato, no una reja.")
