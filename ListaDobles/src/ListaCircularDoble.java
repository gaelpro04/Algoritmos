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
        return mostrarRecursivo(inicio, new StringBuilder());  // Iniciamos la recursión pasando el nodo de inicio
    }

    // Método recursivo privado que recorre la lista y construye la cadena de salida
    private String mostrarRecursivo(Nodo<T> nodo, StringBuilder builder) {
        builder.append(nodo.getInfo()).append(" ");  // Agregamos la información del nodo actual

        // Si el siguiente nodo es el inicio, hemos recorrido toda la lista circular
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

        // Recorrer la lista circular
        do {
            // Verificamos si el nodo contiene el valor x
            if (actual.getInfo().equals(x)) {
                T valorEliminado = actual.getInfo();

                // Si solo hay un nodo en la lista
                if (inicio == fin && actual == inicio) {
                    inicio = fin = null;
                }
                // Si el nodo a eliminar es el primero
                else if (actual == inicio) {
                    inicio = inicio.getSiguiente();
                    inicio.setAnterior(fin);
                    fin.setSiguiente(inicio);
                }
                // Si el nodo a eliminar es el último
                else if (actual == fin) {
                    fin = fin.getAnterior();
                    fin.setSiguiente(inicio);
                    inicio.setAnterior(fin);
                }
                // Si el nodo está en el medio
                else {
                    Nodo<T> anterior = actual.getAnterior();
                    Nodo<T> siguiente = actual.getSiguiente();
                    anterior.setSiguiente(siguiente);
                    siguiente.setAnterior(anterior);
                }

                return valorEliminado;  // Retornamos el valor del nodo eliminado
            }

            actual = actual.getSiguiente();  // Avanzamos al siguiente nodo

        } while (actual != inicio);  // Nos detenemos cuando llegamos al nodo de inicio

        System.out.println("Elemento no encontrado");
        return null;  // Si no encontramos el valor x
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Tercer método buscar elemento X y regresar posicion

    public int buscar(T x) {
        if (inicio == null) {
            return -1;  // Lista vacía
        }

        Nodo<T> actual = inicio;
        int posicion = 0;

        // Recorremos la lista circular
        do {
            if (actual.getInfo().equals(x)) {
                return posicion;  // Si encontramos el valor, retornamos la posición
            }
            actual = actual.getSiguiente();
            posicion++;
        } while (actual != inicio);  // Se detiene cuando llegamos al nodo de inicio nuevamente

        return -1;  // Si no encontramos el valor, retornamos -1
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Cuarto método eliminar posicion

    public T eliminarPosicion(int posicion) {
        if (inicio == null) {
            System.out.println("Lista vacía");
            return null;  // Si la lista está vacía, no podemos eliminar nada
        }

        Nodo<T> actual = inicio;
        int indice = 0;

        // Caso especial: eliminar el primer nodo
        if (posicion == 0) {
            T valorEliminado = inicio.getInfo();
            if (inicio == fin) {  // Solo hay un nodo en la lista
                inicio = fin = null;
            } else {
                inicio = inicio.getSiguiente();
                inicio.setAnterior(fin);
                fin.setSiguiente(inicio);
            }
            return valorEliminado;
        }

        // Recorrer la lista circular hasta llegar a la posición indicada
        do {
            if (indice == posicion) {
                T valorEliminado = actual.getInfo();

                // Caso: eliminar un nodo intermedio o el último
                Nodo<T> anterior = actual.getAnterior();
                Nodo<T> siguiente = actual.getSiguiente();

                // Si el nodo a eliminar es el último
                if (actual == fin) {
                    fin = anterior;
                    fin.setSiguiente(inicio);
                    inicio.setAnterior(fin);
                } else {  // Eliminar un nodo intermedio
                    anterior.setSiguiente(siguiente);
                    siguiente.setAnterior(anterior);
                }

                return valorEliminado;  // Devolver el valor del nodo eliminado
            }

            actual = actual.getSiguiente();
            indice++;
        } while (actual != inicio);  // Si llegamos al nodo de inicio, terminamos

        System.out.println("Posición fuera de rango");
        return null;  // Si la posición es inválida
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Quinto método ordenar lista

    public void ordenarLista() {
        if (inicio == null || inicio == fin) {
            return;  // Si la lista está vacía o tiene solo un nodo, no se necesita ordenar
        }

        boolean swapped;
        do {
            swapped = false;
            Nodo<T> actual = inicio;

            // Recorremos la lista y comparamos los elementos adyacentes
            do {
                Nodo<T> siguiente = actual.getSiguiente();
                if (((Comparable<T>) actual.getInfo()).compareTo(siguiente.getInfo()) > 0) {
                    // Intercambiamos los valores de los nodos
                    T temp = actual.getInfo();
                    actual.setInfo(siguiente.getInfo());
                    siguiente.setInfo(temp);

                    swapped = true;  // Se hizo un intercambio, por lo que seguimos iterando
                }
                actual = siguiente;
            } while (actual != fin);  // Continuamos hasta el último nodo

        } while (swapped);  // Si hubo un intercambio, repetimos el proceso
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Sexto método insertar en posicion el dato

    public void insertarEnPosicion(T dato, int posicion) {
        if (posicion < 0) {
            System.out.println("Posición inválida");
            return;  // No podemos insertar en una posición negativa
        }

        Nodo<T> nuevoNodo = new Nodo<>();
        nuevoNodo.setInfo(dato);

        if (inicio == null) {  // Caso cuando la lista está vacía
            if (posicion == 0) {
                inicio = fin = nuevoNodo;
                nuevoNodo.setSiguiente(nuevoNodo);
                nuevoNodo.setAnterior(nuevoNodo);
            } else {
                System.out.println("Posición fuera de rango");
            }
            return;
        }

        // Insertar en la posición 0 (al principio)
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

        // Recorremos la lista para encontrar la posición
        do {
            if (indice == posicion - 1) {
                // Insertamos el nuevo nodo después de "actual"
                Nodo<T> siguiente = actual.getSiguiente();
                actual.setSiguiente(nuevoNodo);
                siguiente.setAnterior(nuevoNodo);
                nuevoNodo.setSiguiente(siguiente);
                nuevoNodo.setAnterior(actual);
                return;
            }
            actual = actual.getSiguiente();
            indice++;
        } while (actual != inicio);  // Si llegamos al inicio nuevamente, significa que la posición es inválida

        // Si llegamos aquí, la posición está fuera del rango de la lista
        System.out.println("Posición fuera de rango");
    }
}
