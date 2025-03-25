public class ListaCircular<T> {

    Nodo<T> inicio;
    Nodo<T> fin;

    public ListaCircular()
    {
        inicio = null;
        fin = null;
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

    public String mostrar() {
        StringBuilder builder = new StringBuilder();
        Nodo<T> nodo = inicio;

        // Si la lista está vacía
        if (nodo == null) {
            return "Lista vacía";
        }

        // Recorremos la lista
        do {
            builder.append(nodo.getInfo().toString()).append(" ");  // Agrega el dato del nodo
            nodo = nodo.getSiguiente();  // Mueve al siguiente nodo
        } while (nodo != inicio);  // Termina cuando se vuelve al inicio (en lista circular)

        return builder.toString();  // Elimina el espacio final extra
    }
}
