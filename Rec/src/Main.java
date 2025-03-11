public class Main {
    public static void main(String[] args) {

        Examen examen = new Examen();

        System.out.println(examen.factorial(10));
        System.out.println(examen.serieN0(3));

        System.out.println(examen.esPrimoString(5));
        System.out.println(examen.fibonacciString(6));
        System.out.println(examen.sumaNumeros(5));
        System.out.println(examen.contarCaracteres("como estas", 'o',0,0));
        System.out.println(examen.contarDigitos(3450,0));
    }
}