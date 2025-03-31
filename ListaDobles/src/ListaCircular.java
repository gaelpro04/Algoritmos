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

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Primer ejercicio mostrar recursivo

    public String mostrarRecursivo() {
        return mostrarRecursivoAux(inicio);  // Llama al método recursivo desde el inicio
    }

    private String mostrarRecursivoAux(Nodo<T> nodo) {
        StringBuilder builder = new StringBuilder();

        if (nodo == fin) {
            return builder.append(nodo.getInfo()).toString();
        }

        // Llamada recursiva para el siguiente nodo
        return builder.append(nodo.getInfo() + " " + mostrarRecursivoAux(nodo.getSiguiente())).toString();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Segundo ejercicio eliminar X

    public T eliminarX(T x) {
        if (inicio == null) {
            System.out.println("Lista vacía");
            return null;  // Si la lista está vacía, no hay nada que eliminar
        }

        Nodo<T> actual = inicio;
        Nodo<T> anterior = fin;  // Esto es importante para la lista circular
        T objetoEliminado = null;

        // Recorremos la lista circular buscando el nodo con el valor 'x'
        do {
            if (actual.getInfo().equals(x)) {  // Si encontramos el valor
                objetoEliminado = actual.getInfo();  // Guardamos el valor para devolverlo

                // Si el nodo es el único en la lista
                if (inicio == fin && actual == inicio) {
                    inicio = fin = null;
                } else {
                    // Si el nodo a eliminar es el primero
                    if (actual == inicio) {
                        inicio = actual.getSiguiente();
                        fin.setSiguiente(inicio);
                    } else if (actual == fin) {
                        // Si el nodo a eliminar es el último
                        fin = anterior;
                        fin.setSiguiente(inicio);
                    } else {
                        // Si el nodo a eliminar está en medio
                        anterior.setSiguiente(actual.getSiguiente());
                    }
                }
                break;  // Terminamos el bucle una vez eliminamos el nodo
            }
            anterior = actual;  // Mantenemos la referencia al nodo anterior
            actual = actual.getSiguiente();  // Pasamos al siguiente nodo
        } while (actual != inicio);  // Termina cuando hemos recorrido toda la lista

        if (objetoEliminado == null) {
            System.out.println("Elemento no encontrado");
        }

        return objetoEliminado;  // Devolvemos el valor del nodo eliminado
    }

    /**
     * Método que busca X y regresa la posicion
     * @param x
     * @return
     */
    public int buscar(T x) {
        if (inicio == null) {
            return -1;  // Si la lista está vacía, retornamos -1
        }

        Nodo<T> actual = inicio;
        int posicion = 0;

        // Recorremos la lista circular
        do {
            if (actual.getInfo().equals(x)) {  // Si encontramos el valor
                return posicion;  // Retornamos la posición donde se encuentra el valor
            }
            actual = actual.getSiguiente();  // Vamos al siguiente nodo
            posicion++;  // Aumentamos la posición
        } while (actual != inicio);  // Terminamos cuando volvemos al inicio

        return -1;  // Si no encontramos el valor, retornamos -1
    }

    public T eliminaPosicion(int posicion) {
        if (inicio == null) {
            System.out.println("Lista vacía");
            return null;  // Si la lista está vacía, no hay nada que eliminar
        }

        Nodo<T> actual = inicio;
        Nodo<T> anterior = fin;  // Esto es importante para la lista circular
        T objetoEliminado = null;
        int i = 0;

        // Si la posición es 0, eliminamos el nodo en el inicio
        if (posicion == 0) {
            objetoEliminado = inicio.getInfo();
            if (inicio == fin) {  // Si hay solo un nodo
                inicio = fin = null;
            } else {
                inicio = inicio.getSiguiente();
                fin.setSiguiente(inicio);  // Mantenemos la circularidad
            }
            return objetoEliminado;
        }

        // Recorremos la lista circular hasta la posición indicada
        do {
            if (i == posicion) {  // Si hemos llegado a la posición
                objetoEliminado = actual.getInfo();  // Guardamos el valor del nodo a eliminar
                // Si el nodo a eliminar es el último
                if (actual == fin) {
                    fin = anterior;
                    fin.setSiguiente(inicio);  // Mantenemos la circularidad
                } else {
                    anterior.setSiguiente(actual.getSiguiente());  // Ajustamos las referencias
                }
                break;  // Terminamos el bucle una vez eliminamos el nodo
            }
            anterior = actual;  // Mantenemos la referencia al nodo anterior
            actual = actual.getSiguiente();  // Pasamos al siguiente nodo
            i++;
        } while (actual != inicio);  // Terminamos cuando volvemos al inicio

        if (objetoEliminado == null) {
            System.out.println("Posición no válida");
        }

        return objetoEliminado;  // Devolvemos el valor del nodo eliminado
    }

    public void ordenarLista() {
        if (inicio == null || inicio.getSiguiente() == null) {
            System.out.println("Lista vacía o solo un dato");
        } else {
            boolean intercambiado;
            do {
                Nodo<T> nodo = inicio;
                intercambiado = false;
                // Recorremos la lista circular
                do {
                    // Comparamos el nodo actual con el siguiente
                    if (((Comparable<T>) nodo.getInfo()).compareTo(nodo.getSiguiente().getInfo()) > 0) {
                        // Intercambiamos los valores de los nodos
                        T temp = nodo.getInfo();
                        nodo.setInfo(nodo.getSiguiente().getInfo());
                        nodo.getSiguiente().setInfo(temp);
                        intercambiado = true;  // Indicamos que hubo un intercambio
                    }
                    nodo = nodo.getSiguiente();
                } while (nodo.getSiguiente() != inicio); // Volver al inicio para circular

            } while (intercambiado);  // Repetimos si hubo intercambios
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

        // Si la lista está vacía o la posición es 0 (insertar al inicio)
        if (inicio == null || posicion == 0) {
            insertarInicio(dato);  // Reutilizamos el método de insertar al inicio
            return;
        }

        Nodo<T> nodo = inicio;
        int i = 0;

        // Recorrer la lista hasta la posición deseada
        while (nodo.getSiguiente() != inicio && i < posicion - 1) {
            nodo = nodo.getSiguiente();
            i++;
        }

        // Si llegamos a la posición y es válida
        if (i == posicion - 1) {
            nuevoNodo.setSiguiente(nodo.getSiguiente());
            nodo.setSiguiente(nuevoNodo);

            // Si estamos insertando al final, actualizar el fin
            if (nodo == fin) {
                fin = nuevoNodo;
            }
        } else {
            System.out.println("Posición fuera de rango");
        }
    }
}
