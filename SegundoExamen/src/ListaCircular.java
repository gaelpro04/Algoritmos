public class ListaCircular<T> {
    private NodoBasico<T> inicio;
    private NodoBasico<T> fin;

    public ListaCircular()
    {
        inicio = fin = null;
    }

    public void insertarInicio(T dato)
    {
        NodoBasico<T> nodo = new NodoBasico<>(dato);
        if (inicio == null) {
            inicio = fin = nodo;
            nodo.setSiguiente(inicio);
        } else {
            nodo.setSiguiente(inicio);
            inicio = nodo;
            fin.setSiguiente(inicio);
        }
    }

    public void insertarFinal(T dato)
    {
        NodoBasico<T> nodo = new NodoBasico<>(dato);
        if (inicio == null) {
            inicio = fin = nodo;
            nodo.setSiguiente(inicio);
        } else {
            nodo.setSiguiente(inicio);
            fin.setSiguiente(nodo);
            fin = nodo;
        }
    }

    public T eliminarInicio()
    {
        T dato = null;
        if (inicio == null) {
            System.out.println("Lista vacia");
        } else if (inicio.getSiguiente() == null) {
            dato = inicio.getDato();
            inicio = fin = null;
        } else {
            dato = inicio.getDato();
            inicio = inicio.getSiguiente();
            fin.setSiguiente(inicio);
        }
        return dato;
    }

    public T eliminarFinal()
    {
        T dato = null;
        if (inicio == null) {
            System.out.println("Lista vacia");
        } else if (inicio.getSiguiente() == null) {
            dato = inicio.getDato();
            inicio = fin = null;
        } else {
            NodoBasico<T> recorrer = inicio;

            while (recorrer.getSiguiente() != fin) {
                recorrer = recorrer.getSiguiente();
            }
            dato = fin.getDato();
            fin = recorrer;
            fin.setSiguiente(inicio);
        }
        return dato;
    }
}
