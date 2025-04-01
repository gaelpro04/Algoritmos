public class ListaCircularDoble<T> {

    Nodo<T> inicio;
    Nodo<T> fin;

    public ListaCircularDoble()
    {
        inicio = null;
        fin = null;
    }

    public void insertarInicio(T objeto)
    {
        Nodo<T> n = new Nodo<>();
        n.setInfo(objeto);

        if (inicio == null) {
            inicio = fin = n;
            n.setSiguiente(inicio);
            n.setAnterior(inicio);
        } else {
            n.setSiguiente(inicio);
            n.setAnterior(fin);
            inicio.setAnterior(n);
            inicio = n;
            fin.setSiguiente(inicio);

        }

    }

    public void insertarFin(T objeto)
    {
        Nodo<T> n = new Nodo<>();
        n.setInfo(objeto);

        if (inicio == null) {
            inicio = fin = n;
            n.setSiguiente(inicio);
            n.setAnterior(inicio);

        } else {
            n.setSiguiente(inicio);
            n.setAnterior(fin);
            fin.setSiguiente(n);
            fin = n;
            inicio.setAnterior(n);
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
            }  else {
                inicio = inicio.getSiguiente();
                inicio.setAnterior(fin);
                fin.setSiguiente(inicio);
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
                Nodo<T> r = fin.getSiguiente();
                r.setSiguiente(inicio);
                inicio.setAnterior(r);
                fin = r;
            }
        }

        return objeto;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Primer Método, método recursivo

    public String mostrarRecursivo() {
        if (inicio == null) {
            return "Lista vacía";
        }
        return mostrarRecursivo(inicio, new StringBuilder());
    }

    // Método recursivo privado que recorre la lista y construye la cadena de salida
    private String mostrarRecursivo(Nodo<T> nodo, StringBuilder builder) {
        builder.append(nodo.getInfo()).append(" ");

        if (nodo.getSiguiente() != inicio) {
            mostrarRecursivo(nodo.getSiguiente(), builder);
        }

        return builder.toString();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Segundo método eliminar elemento X

    public T eliminaX(T x) {
        if (inicio == null) {
            System.out.println("Lista vacía");
            return null;
        }

        Nodo<T> actual = inicio;

        do {
            if (actual.getInfo().equals(x)) {
                T valorEliminado = actual.getInfo();

                if (inicio == fin && actual == inicio) {
                    inicio = fin = null;
                }
                else if (actual == inicio) {
                    inicio = inicio.getSiguiente();
                    inicio.setAnterior(fin);
                    fin.setSiguiente(inicio);
                }
                else if (actual == fin) {
                    fin = fin.getAnterior();
                    fin.setSiguiente(inicio);
                    inicio.setAnterior(fin);
                }
                else {
                    Nodo<T> anterior = actual.getAnterior();
                    Nodo<T> siguiente = actual.getSiguiente();
                    anterior.setSiguiente(siguiente);
                    siguiente.setAnterior(anterior);
                }

                return valorEliminado;
            }

            actual = actual.getSiguiente();

        } while (actual != inicio);

        System.out.println("Elemento no encontrado");
        return null;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Tercer método buscar elemento X y regresar posicion

    public int buscar(T x) {
        if (inicio == null) {
            return -1;
        }

        Nodo<T> actual = inicio;
        int posicion = 0;

        do {
            if (actual.getInfo().equals(x)) {
                return posicion;
            }
            actual = actual.getSiguiente();
            posicion++;
        } while (actual != inicio);

        return -1;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Cuarto método eliminar posicion

    public T eliminarPosicion(int posicion) {
        if (inicio == null) {
            System.out.println("Lista vacía");
            return null;
        }

        Nodo<T> actual = inicio;
        int indice = 0;

        if (posicion == 0) {
            T valorEliminado = inicio.getInfo();
            if (inicio == fin) {
                inicio = fin = null;
            } else {
                inicio = inicio.getSiguiente();
                inicio.setAnterior(fin);
                fin.setSiguiente(inicio);
            }
            return valorEliminado;
        }

        do {
            if (indice == posicion) {
                T valorEliminado = actual.getInfo();

                Nodo<T> anterior = actual.getAnterior();
                Nodo<T> siguiente = actual.getSiguiente();

                if (actual == fin) {
                    fin = anterior;
                    fin.setSiguiente(inicio);
                    inicio.setAnterior(fin);
                } else {
                    anterior.setSiguiente(siguiente);
                    siguiente.setAnterior(anterior);
                }

                return valorEliminado;
            }

            actual = actual.getSiguiente();
            indice++;
        } while (actual != inicio);

        System.out.println("Posición fuera de rango");
        return null;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Quinto método ordenar lista

    public void ordenarLista() {
        if (inicio == null || inicio == fin) {
            return;
        }

        boolean swapped;
        do {
            swapped = false;
            Nodo<T> actual = inicio;

            do {
                Nodo<T> siguiente = actual.getSiguiente();
                if (((Comparable<T>) actual.getInfo()).compareTo(siguiente.getInfo()) > 0) {
                    T temp = actual.getInfo();
                    actual.setInfo(siguiente.getInfo());
                    siguiente.setInfo(temp);

                    swapped = true;
                }
                actual = siguiente;
            } while (actual != fin);
        } while (swapped);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Sexto método insertar en posicion el dato

    public void insertarEnPosicion(T dato, int posicion) {
        if (posicion < 0) {
            System.out.println("Posición inválida");
            return;
        }

        Nodo<T> nuevoNodo = new Nodo<>();
        nuevoNodo.setInfo(dato);

        if (inicio == null) {
            if (posicion == 0) {
                inicio = fin = nuevoNodo;
                nuevoNodo.setSiguiente(nuevoNodo);
                nuevoNodo.setAnterior(nuevoNodo);
            } else {
                System.out.println("Posición fuera de rango");
            }
            return;
        }


        if (posicion == 0) {
            nuevoNodo.setSiguiente(inicio);
            nuevoNodo.setAnterior(fin);
            inicio.setAnterior(nuevoNodo);
            fin.setSiguiente(nuevoNodo);
            inicio = nuevoNodo;
            return;
        }

        Nodo<T> actual = inicio;
        int indice = 0;

        do {
            if (indice == posicion - 1) {
                Nodo<T> siguiente = actual.getSiguiente();
                actual.setSiguiente(nuevoNodo);
                siguiente.setAnterior(nuevoNodo);
                nuevoNodo.setSiguiente(siguiente);
                nuevoNodo.setAnterior(actual);
                return;
            }
            actual = actual.getSiguiente();
            indice++;
        } while (actual != inicio);

        System.out.println("Posición fuera de rango");
    }
}
