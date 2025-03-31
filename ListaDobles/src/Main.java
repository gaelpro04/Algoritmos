public class Main {
    public static void main(String[] args) {

        System.out.println("LISTA SIMPLE CIRCULAR===============");
        ListaCircular<Integer> listaCircular = new ListaCircular<>();
        listaCircular.insertarInicio(0);
        listaCircular.insertarFin(1);
        listaCircular.insertarFin(2);
        listaCircular.insertarFin(3);
        listaCircular.insertarFin(4);

        System.out.println("Método recursivo");
        System.out.println(listaCircular.mostrarRecursivo());

        System.out.println("Método que eliminar elemento X de la lista");
        listaCircular.eliminarX(3);
        System.out.println(listaCircular.mostrarRecursivo());

        System.out.println("Método que busca X y regresa la posicion");
        System.out.println(listaCircular.mostrarRecursivo());
        System.out.println(listaCircular.buscar(4));

        System.out.println("Método que elimina la posición seleccionada");
        System.out.println(listaCircular.eliminaPosicion(3));
        System.out.println(listaCircular.mostrarRecursivo());

        System.out.println("Método que ordena la lista");
        listaCircular.insertarInicio(3);
        System.out.println(listaCircular.mostrarRecursivo());
        listaCircular.ordenarLista();
        System.out.println(listaCircular.mostrarRecursivo());

        System.out.println("Insertar en posicion");
        listaCircular.insertarEnPosicion(5,3);
        System.out.println(listaCircular.mostrarRecursivo());

        System.out.println("LISTA DOBLE CIRCULAR===============");
        ListaCircularDoble<Integer> listaCircularDoble = new ListaCircularDoble<>();
        listaCircularDoble.insertarInicio(0);
        listaCircularDoble.insertarFin(1);
        listaCircularDoble.insertarFin(5);
        listaCircularDoble.insertarFin(7);
        listaCircularDoble.insertarFin(9);
        System.out.println("Método recursivo");
        System.out.println(listaCircularDoble.mostrarRecursivo());

        System.out.println("Eliminar elemento X");
        listaCircularDoble.eliminaX(7);
        System.out.println(listaCircularDoble.mostrarRecursivo());

        System.out.println("Buscar elemento X y regresar posicion");
        System.out.println(listaCircularDoble.mostrarRecursivo());
        System.out.println(listaCircularDoble.buscar(5));

        System.out.println("Eliminar posicion");
        listaCircularDoble.eliminarPosicion(2);
        System.out.println(listaCircularDoble.mostrarRecursivo());

        System.out.println("Ordenar Lista");
        listaCircularDoble.insertarInicio(10);
        System.out.println(listaCircularDoble.mostrarRecursivo());
        listaCircularDoble.ordenarLista();
        System.out.println(listaCircularDoble.mostrarRecursivo());

        System.out.println("Insertar en Posicion...");
        listaCircularDoble.insertarEnPosicion(8,2);
        System.out.println(listaCircularDoble.mostrarRecursivo());









    }
}