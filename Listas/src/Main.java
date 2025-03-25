public class Main {
    public static void main(String[] args) {

        ListSimple<Integer> listaSimple = new ListSimple<>();

        System.out.println("Lista simple");

        listaSimple.insertarFin(10);
        listaSimple.insertarFin(20);
        listaSimple.insertarFin(30);
        listaSimple.insertarFin(40);

        System.out.println(listaSimple.mostrar());

        listaSimple.eliminarFin();

        System.out.println(listaSimple.mostrar());

        listaSimple.eliminarInicio();

        System.out.println(listaSimple.mostrar());
    }
}