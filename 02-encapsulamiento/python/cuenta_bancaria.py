"""
cuenta_bancaria.py - LA CLASE

Nombre del archivo en minusculas con guion bajo, clase en CamelCase.
Al importarla se vera asi:
    from cuenta_bancaria import CuentaBancaria

LA GRAN DIFERENCIA CON JAVA
  Java tiene privacidad REAL: el compilador te impide tocar un private.
  Python tiene privacidad POR ACUERDO: se avisa, no se prohibe.

  Convenciones de Python:
    saldo      -> publico
    _saldo     -> "no lo toques, es interno" (solo una senal, nada lo impide)
    __saldo    -> name mangling: se renombra a _Clase__saldo, molesta de verdad
                  pero sigue siendo accesible si te empenas

  Y en vez de getSaldo()/setSaldo(), Python usa @property: se escribe como
  un atributo pero por dentro ejecuta un metodo con validacion.
"""


class CuentaBancaria:

    def __init__(self, titular, saldo_inicial):
        self._titular = titular
        self.__saldo = max(saldo_inicial, 0)   # __ = lo mas parecido a private

    # ---------- GETTER estilo Python ----------
    # Se usa como cuenta.saldo (SIN parentesis), pero ejecuta este metodo.
    @property
    def saldo(self):
        return self.__saldo

    # No definimos un setter para saldo -> queda de SOLO LECTURA.

    @property
    def titular(self):
        return self._titular

    # ---------- SETTER estilo Python, con validacion ----------
    @titular.setter
    def titular(self, nuevo_titular):
        if not nuevo_titular:
            print("ERROR: el titular no puede estar vacio.")
            return
        self._titular = nuevo_titular

    # ---------- Reglas de negocio ----------
    def depositar(self, monto):
        if monto <= 0:
            print("ERROR: el deposito debe ser positivo.")
            return
        self.__saldo += monto
        print(f"Deposito de {monto} OK.")

    def girar(self, monto):
        if monto > self.__saldo:
            print(f"ERROR: saldo insuficiente para girar {monto}")
            return
        self.__saldo -= monto
        print(f"Giro de {monto} OK.")

    def mostrar(self):
        print(f"[Cuenta] {self._titular} | saldo: ${self.__saldo}")
