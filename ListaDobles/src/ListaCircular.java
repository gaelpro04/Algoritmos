public class ListaCircular<T> {

    Nodo<T> inicio;
    Nodo<T> fin;

    public ListaCircular()
    {
        inicio = new Nodo<>();
        fin = new Nodo<>();
    }

    public void insertarInicio(T objeto)
    {
        Nodo<T> nodo = new Nodo<>();
        nodo.setInfo(objeto);

        if (inicio == null) {
            inicio = fin = nodo;
            nodo.setSiguiente(inicio);
        } else {
            nodo.setSiguiente(inicio);
            inicio = nodo;
            fin.setSiguiente(inicio);
        }
    }

    public void insertarFin(T objeto)
    {
        Nodo<T> nodo = new Nodo<>();
        nodo.setInfo(objeto);

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
        T objeto = null;

        if (inicio == null) {
            System.out.println("Lista vacia");
        } else {
            objeto = inicio.getInfo();
            if (inicio == fin) {
                inicio = fin = null;
            } else {
                fin.setSiguiente(inicio.getSiguiente());
                inicio = inicio.getSiguiente();
            }
        }

        return objeto;
    }

    public T eliminarFin()
    {
        T objeto = null;

        if (inicio == null) {
            System.out.println("Lista vacia");
        } else {
            objeto = fin.getInfo();
            if (inicio == fin) {
                inicio = fin = null;
            } else {

                Nodo<T> r = inicio;

                while (r.getSiguiente() != fin) {
                    r = r.getSiguiente();
                }
                fin = r;
                fin.setSiguiente(inicio);
            }
        }

        return objeto;
    }

    public String mostrar()
    {
        StringBuilder builder = new StringBuilder();
        Nodo<T> nodo = inicio;
        if (inicio == fin) {
            return builder.toString();
        }

        T dato = nodo.getInfo();
        nodo = nodo.getSiguiente();
        return builder.append(String.valueOf(dato)).toString();
    }

    public T eliminarX()
    {
        T objeto = null;


        return objeto;
    }
}
