public class Main {
    public static void main(String[] args) {

        ListaDoble<Integer> listaDoble = new ListaDoble<>();

        System.out.println("Lista doble");

        listaDoble.insertarInicio(10);
        listaDoble.insertarFin(20);

        listaDoble.insertarInicio(0);
        listaDoble.insertarFin(30);

        System.out.println(listaDoble.regresarLista());

        listaDoble.eliminarInicio();

        System.out.println(listaDoble.regresarLista());

        listaDoble.eliminarInicio();
        System.out.println(listaDoble.regresarLista());

        ListaCircular<Integer> listaCircular = new ListaCircular<>();

        System.out.println("Lista circular");

        listaCircular.insertarFin(0);
        listaCircular.insertarFin(10);
        listaCircular.insertarInicio(-1);

        System.out.println(listaCircular.mostrar());

        listaCircular.eliminarInicio();

        System.out.println(listaCircular.mostrar());
    }
}