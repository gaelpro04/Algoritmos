public class ListSimple<T> {

    private Nodo<T> inicio;

    public ListSimple(Nodo inicio)
    {
        this.inicio = inicio;
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
        
    }
}
