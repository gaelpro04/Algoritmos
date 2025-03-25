public class ListSimple<T> {

    private Nodo<T> inicio;

    public ListSimple()
    {
        inicio = new Nodo<>();
    }


    public void insertarInicio(T dato)
    {
        Nodo<T> nodo = new Nodo<>(dato);
        nodo.setSig(inicio);
        inicio = nodo;
    }

    public void insertarFin(T dato)
    {
        Nodo<T> nodo = new Nodo<>(dato);
        if (inicio == null) {
            nodo.setSig(inicio);
            inicio = nodo;
        } else {
            Nodo<T> r = inicio;
            while (r.getSig() != null) {
                r = r.getSig();
            }
            r.setSig(nodo);
            nodo.setSig(null);
        }
    }

    public T eliminarInicio()
    {
        T objeto = null;
        if (inicio == null) {
            System.out.println("Lista vacia");
        } else {
            objeto = inicio.getInfo();
            inicio = inicio.getSig();
        }

        return objeto;
    }

    public T eliminarFin()
    {
        T objeto = null;

        if (inicio == null) {
            System.out.println("Lista vacia");
        } else if (inicio.getSig() == null) {
            objeto = inicio.getInfo();
            inicio = null;
        } else {

        }
    }
}
