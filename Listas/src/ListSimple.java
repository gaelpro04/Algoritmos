public class ListSimple<T> {

    private Nodo<T> inicio;

    public ListSimple()
    {
        inicio = null;
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
            inicio = nodo;
        } else {
            Nodo<T> r = inicio;
            while (r.getSig() != null) {
                r = r.getSig();
            }
            r.setSig(nodo);
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
            Nodo<T> r;
            Nodo<T> a;
            r = inicio;
            a = r;

            while (r.getSig() != null) {
                a = r;
                r = r.getSig();
            }

            a.setSig(null);
            objeto = r.getInfo();
        }
        return objeto;
    }

    public String mostrar()
    {
        Nodo<T> r = inicio;
        StringBuilder builder = new StringBuilder();

        while (r != null) {
            builder.append(r.getInfo() + " -> ");
            r = r.getSig();
        }
        return builder.append("null").toString();
    }
}
