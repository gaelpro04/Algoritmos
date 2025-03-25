public class ListaDoble<T> {

    Nodo<T> inicio;

    public ListaDoble()
    {
        inicio = null;
    }

    public void insertarInicio(T objeto)
    {
        Nodo<T> n = new Nodo<>();
        n.setInfo(objeto);
        n.setSiguiente(inicio);
        n.setAnterior(null);

        if (inicio != null) {
            inicio.setAnterior(n);
        }
        inicio = n;
    }

    public void insertarFin(T objeto)
    {
        Nodo<T> n = new Nodo<>();
        n.setInfo(objeto);
        n.setSiguiente(null);

        if (inicio.getSiguiente() == null) {
            inicio.setSiguiente(n);
            n.setAnterior(inicio);
        } else {
            Nodo<T> r = inicio;
            while (r.getSiguiente() != null) {
                r = r.getSiguiente();
            }
            r.setSiguiente(n);
            n.setAnterior(r);
        }
    }

    public Nodo<T> eliminarInicio()
    {
        Nodo<T> nodo = null;
        if (inicio == null) {
            System.out.println("Lista vacia");
        } else {
            nodo = inicio;
            if (inicio.getSiguiente() == null) {
                inicio = null;
            } else {
                inicio = inicio.getSiguiente();
                inicio.setAnterior(null);
            }
        }

        return nodo;
    }

    public Nodo<T> eliminarFinal()
    {
        Nodo<T> nodo = null;
        Nodo<T> r = new Nodo<>();

        if (inicio == null) {
            System.out.println("Lista vacia");
        } else {
            if (inicio.getSiguiente() == null) {
                inicio = null;
            } else {
                r = inicio;

                while (r.getSiguiente() != null) {
                    r = r.getSiguiente();
                }
                nodo = r;
                r.getAnterior().setSiguiente(null);
            }
        }
        return nodo;
    }

    public String regresarLista()
    {
        StringBuilder builder = new StringBuilder();
        Nodo<T> nodo = inicio;

        if (inicio == null) {
            System.out.println("lista vacia");
        } else {
            int n = 1;
            while(nodo != null) {
                builder.append("Nodo " + n + ": " + nodo.getInfo() + "\n");
                ++n;
                nodo = nodo.getSiguiente();
            }
        }

        return builder.toString();
    }
}
