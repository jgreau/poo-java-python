public class B9_2_Clasificar {

    static String clasificar(double nota) {
        if (nota < 1.0 || nota > 7.0) {
            return "Esa nota no existe";
        } else if (nota >= 6.5) {
            return "Excelente";
        } else if (nota >= 5.5) {
            return "Muy buena";
        } else if (nota >= 4.0) {
            return "Suficiente";
        } else {
            return "Insuficiente";
        }
    }

    public static void main(String[] args) {
        double[] notas = {5.5, 3.2, 6.8, 4.0};

        for (double nota : notas) {
            System.out.println(nota + " -> " + clasificar(nota));
        }
    }
}
