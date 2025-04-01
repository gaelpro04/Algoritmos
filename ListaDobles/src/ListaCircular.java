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

        if (nodo == null) {
            return "Lista vacía";
        }

        // Recorremos la lista
        do {
            builder.append(nodo.getInfo().toString()).append(" ");
            nodo = nodo.getSiguiente();
        } while (nodo != inicio);

        return builder.toString();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Primer ejercicio mostrar recursivo

    public String mostrarRecursivo() {
        return mostrarRecursivoAux(inicio);
    }

    private String mostrarRecursivoAux(Nodo<T> nodo) {
        StringBuilder builder = new StringBuilder();

        if (nodo == fin) {
            return builder.append(nodo.getInfo()).toString();
        }

        return builder.append(nodo.getInfo() + " " + mostrarRecursivoAux(nodo.getSiguiente())).toString();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Segundo ejercicio eliminar X

    public T eliminarX(T x) {
        if (inicio == null) {
            System.out.println("Lista vacía");
            return null;
        }

        Nodo<T> actual = inicio;
        Nodo<T> anterior = fin;
        T objetoEliminado = null;

        do {
            if (actual.getInfo().equals(x)) {
                objetoEliminado = actual.getInfo();

                if (inicio == fin && actual == inicio) {
                    inicio = fin = null;
                } else {
                    if (actual == inicio) {
                        inicio = actual.getSiguiente();
                        fin.setSiguiente(inicio);
                    } else if (actual == fin) {
                        fin = anterior;
                        fin.setSiguiente(inicio);
                    } else {
                        anterior.setSiguiente(actual.getSiguiente());
                    }
                }
                break;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        } while (actual != inicio);

        if (objetoEliminado == null) {
            System.out.println("Elemento no encontrado");
        }

        return objetoEliminado;
    }

    /**
     * Método que busca X y regresa la posicion
     * @param x
     * @return
     */
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

    public T eliminaPosicion(int posicion) {
        if (inicio == null) {
            System.out.println("Lista vacía");
            return null;
        }

        Nodo<T> actual = inicio;
        Nodo<T> anterior = fin;
        T objetoEliminado = null;
        int i = 0;

        if (posicion == 0) {
            objetoEliminado = inicio.getInfo();
            if (inicio == fin) {
                inicio = fin = null;
            } else {
                inicio = inicio.getSiguiente();
                fin.setSiguiente(inicio);
            }
            return objetoEliminado;
        }

        do {
            if (i == posicion) {
                objetoEliminado = actual.getInfo();
                if (actual == fin) {
                    fin = anterior;
                    fin.setSiguiente(inicio);
                } else {
                    anterior.setSiguiente(actual.getSiguiente());
                }
                break;
            }
            anterior = actual;
            actual = actual.getSiguiente();
            i++;
        } while (actual != inicio);

        if (objetoEliminado == null) {
            System.out.println("Posición no válida");
        }

        return objetoEliminado;
    }

    public void ordenarLista() {
        if (inicio == null || inicio.getSiguiente() == null) {
            System.out.println("Lista vacía o solo un dato");
        } else {
            boolean intercambiado;
            do {
                Nodo<T> nodo = inicio;
                intercambiado = false;
                do {
                    if (((Comparable<T>) nodo.getInfo()).compareTo(nodo.getSiguiente().getInfo()) > 0) {
                        T temp = nodo.getInfo();
                        nodo.setInfo(nodo.getSiguiente().getInfo());
                        nodo.getSiguiente().setInfo(temp);
                        intercambiado = true;
                    }
                    nodo = nodo.getSiguiente();
                } while (nodo.getSiguiente() != inicio);

            } while (intercambiado);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Sexto método

    public void insertarEnPosicion(T dato, int posicion)
    {
        if (posicion < 0) {
            System.out.println("Posición inválida");
            return;
        }

        Nodo<T> nuevoNodo = new Nodo<>();
        nuevoNodo.setInfo(dato);


        if (inicio == null || posicion == 0) {
            insertarInicio(dato);
            return;
        }

        Nodo<T> nodo = inicio;
        int i = 0;

        while (nodo.getSiguiente() != inicio && i < posicion - 1) {
            nodo = nodo.getSiguiente();
            i++;
        }

        if (i == posicion - 1) {
            nuevoNodo.setSiguiente(nodo.getSiguiente());
            nodo.setSiguiente(nuevoNodo);

            if (nodo == fin) {
                fin = nuevoNodo;
            }
        } else {
            System.out.println("Posición fuera de rango");
        }
    }
}
