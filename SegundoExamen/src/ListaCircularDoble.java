public class ListaCircularDoble<T> {
    private NodoDoble<T> inicio;
    private NodoDoble<T> fin;

    public ListaCircularDoble() {
        inicio = fin = null;
    }

    public void insertarInicio(T dato)
    {
        NodoDoble<T> nodo = new NodoDoble<>(dato);

        if (inicio == null) {
            inicio = fin = nodo;
            nodo.setSiguiente(inicio);
            nodo.setAnterior(inicio);
        } else {
            nodo.setSiguiente(inicio);
            nodo.setAnterior(fin);
            inicio = nodo;
            fin.setSiguiente(inicio);
        }
    }

    public void insertarFinal(T dato)
    {
        NodoDoble<T> nodo = new NodoDoble<>(dato);
        if (inicio == null) {
            inicio = fin = nodo;
            nodo.setSiguiente(inicio);
            nodo.setAnterior(inicio);
        } else {
            nodo.setSiguiente(inicio);
            nodo.setAnterior(fin);
            fin.setSiguiente(nodo);
            fin = nodo;
            inicio.setAnterior(nodo);
        }
    }

    public T eliminarIncio()
    {
        T dato = null;
        if (inicio == null) {
            System.out.println("Lista vacia");
        } else if (inicio == fin) {
            dato = inicio.getInfo();
            inicio = fin = null;
        } else {
            dato = inicio.getInfo();
            inicio = inicio.getSiguiente();
            inicio.setAnterior(fin);
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
            dato = inicio.getInfo();
            inicio = fin = null;
        } else {
            NodoDoble<T> recorrer = fin.getSiguiente();
            recorrer.setSiguiente(inicio);
            inicio.setAnterior(recorrer);
            fin = recorrer;
        }
        return dato;
    }
}
