public class Main {
    public static void main(String[] args) {

        undoRedo hola = new undoRedo(10);

        hola.escribir("hola");
        hola.escribir("que");
        hola.escribir("tal");

        System.out.println(hola);

        hola.undo();

        System.out.println(hola);

        hola.undo();

        System.out.println(hola);

        hola.redo();

        System.out.println(hola);

        hola.escribir("simon");

        System.out.println(hola.redo());

        System.out.println(hola);

        Examen examen = new Examen();

        System.out.println(examen.esPalindromo("anita lava la tina"));
    }
}