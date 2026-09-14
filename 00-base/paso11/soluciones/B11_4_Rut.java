public class B11_4_Rut {
    public static void main(String[] args) {
        String[] pruebas = {"12345678-5", "12345678-k", "12345678", "1234a678-5",
                            "12345678-9", "123-4", "12345678--5"};

        System.out.printf("%-14s %-9s %s%n", "rut", "formato", "dv correcto");
        for (String rut : pruebas) {
            System.out.printf("%-14s %-9s %s%n", rut,
                    Validador.esRutValido(rut),
                    Validador.tieneDvCorrecto(rut));
        }
    }
}
