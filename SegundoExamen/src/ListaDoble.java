public class ListaDoble<T> {

    private NodoDoble<T> inicio;

    public ListaDoble()
    {
        inicio = null;
    }

    public void insertarInicio(T dato)
    {
        NodoDoble<T> nodo = new NodoDoble<>(dato);
        nodo.setSiguiente(inicio);
        nodo.setAnterior(null);
        if (inicio != null) {
            inicio.setAnterior(null);
        }
        inicio = nodo;
    }

    public void insertarFinal(T dato)
    {
        NodoDoble<T> nodo = new NodoDoble<>(dato);
        nodo.setSiguiente(null);

        if (inicio.getSiguiente() == null) {
            inicio.setSiguiente(nodo);
            nodo.setAnterior(inicio);
        } else {
            NodoDoble<T> recorrer = inicio;

            while (recorrer.getSiguiente() != null) {
                recorrer = recorrer.getSiguiente();
            }
            recorrer.setSiguiente(nodo);
            nodo.setAnterior(recorrer);
        }
    }

    public T eliminarIncio()
    {
        T dato = null;

        if (inicio == null) {
            System.out.println("Lista vacia");
        } else {
            if (inicio.getSiguiente() == null) {
                dato = inicio.getInfo();
                inicio = null;
            } else {
                dato = inicio.getInfo();
                inicio = inicio.getSiguiente();
                inicio.setAnterior(null);
            }
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
            inicio = null;
        } else {
            NodoDoble<T> recorrer = inicio;

            while (recorrer.getSiguiente() != null) {
                recorrer = recorrer.getSiguiente();
            }
            dato = recorrer.getInfo();
            recorrer.getAnterior().setSiguiente(null);
        }
        return dato;
    }

    public String recorrerLista()
    {
        StringBuilder builder = new StringBuilder();
        if (inicio == null) {
            System.out.println("Lista vacia");
        } else {
            NodoDoble<T> recorrer = inicio;
            while (recorrer != null) {
                builder.append(recorrer.getInfo() + " ");
                recorrer = recorrer.getSiguiente();
            }
        }
        return builder.toString();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Primer ejercicio mostrar lista recursiva

    public String mostrarRecursivo()
    {
        return mostrarRecursivo(inicio);
    }

    private String mostrarRecursivo(NodoDoble<T> nodo)
    {
        StringBuilder builder = new StringBuilder();

        if (nodo == null) {
            return builder.toString();
        }

        return builder.append(nodo.getInfo() + " " + mostrarRecursivo(nodo.getSiguiente())).toString();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Segundo ejercicio eliminar elemento x en la lista

    public T eliminarX(T dato)
    {
        T datoComp = null;
        if (inicio == null) {
            System.out.println("Lista vacia");
            return null;
        } else if (inicio.getSiguiente().getInfo().equals(dato)){
            datoComp = dato;
            inicio = inicio.getSiguiente();
            inicio.setAnterior(null);
        } else {
            NodoDoble<T> recorrer = inicio;

            while (recorrer.getSiguiente() != null) {

                if (recorrer.getInfo().equals(dato)) {
                    datoComp = dato;
                    recorrer.getAnterior().setSiguiente(recorrer.getSiguiente());
                    recorrer.getSiguiente().setAnterior(recorrer.getAnterior());
                    break;
                }
                recorrer = recorrer.getSiguiente();
            }
        }
        return datoComp;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Tercer ejercicio buscar dato y regresar posición

    public int buscar(T dato) {
        int contador;

        if (inicio == null) {
            System.out.println("Lista vacia");
        } else if (inicio.getInfo().equals(dato)) {
            return 0;
        } else {
            NodoDoble<T> recorrer = inicio;
            contador = 1;

            while (recorrer.getSiguiente() != null) {

                if (recorrer.getSiguiente().getInfo().equals(dato)) {
                    return contador;
                } else {
                    ++contador;
                    recorrer = recorrer.getSiguiente();
                }
            }
        }

        return -1;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Cuarto ejercicio eliminar mediante posicion

    public T eliminarPosicion(int posicion) {
        int contador;
        T dato = null;

        if (inicio == null) {
            System.out.println("Lista vacia");
        } else if (posicion == 0) {
            dato = inicio.getInfo();
            inicio = inicio.getSiguiente();
            if (inicio != null) {
                inicio.setAnterior(null);
            }
        } else {
            contador = 0;
            NodoDoble<T> recorrer = inicio;

            while (recorrer != null) {

                if (contador == posicion) {
                    dato = recorrer.getInfo();
                    if (recorrer.getAnterior() != null) {
                        recorrer.getAnterior().setSiguiente(recorrer.getSiguiente());
                    }

                    // Si hay un nodo siguiente, enlazarlo con el anterior
                    if (recorrer.getSiguiente() != null) {
                        recorrer.getSiguiente().setAnterior(recorrer.getAnterior());
                    }
                }
                ++contador;
                recorrer = recorrer.getSiguiente();
            }
        }

        return dato;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Quinto ejercicio ordenar lista

    public void ordenarLista() {

        if (inicio == null || inicio.getSiguiente() == null) {
            System.out.println("Lista vacia o con un elemento");
            return;
        } else {
           boolean ordenado;
           do {
               ordenado = true;
               NodoDoble<T> nodoDoble = inicio;

               while (nodoDoble.getSiguiente() != null) {

                   if (((Comparable<T>) nodoDoble.getInfo()).compareTo(nodoDoble.getSiguiente().getInfo()) > 0) {
                       T datoTemp = nodoDoble.getInfo();
                       nodoDoble.setInfo(nodoDoble.getSiguiente().getInfo());
                       nodoDoble.getSiguiente().setInfo(datoTemp);
                       ordenado = false;
                   }
                   nodoDoble = nodoDoble.getSiguiente();
               }

           } while (!ordenado);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Sexto ejercicio insertar en posición

    public void insertarEnPosicion(T dato, int posicion)
    {
        NodoDoble<T> nodoDoble = new NodoDoble<>(dato);
        if (posicion == 0) {
            if (inicio == null) {
                inicio = nodoDoble;
            } else {
                nodoDoble.setSiguiente(inicio);
                inicio.setAnterior(nodoDoble);
                inicio = nodoDoble;
            }
        } else {
            int contador = 0;
            NodoDoble<T> recorrer = inicio;

            while (recorrer != null) {
                if (contador == (posicion-1)) {
                    nodoDoble.setSiguiente(recorrer.getSiguiente());
                    nodoDoble.setAnterior(recorrer);

                    if (recorrer.getSiguiente() != null) {
                        recorrer.getSiguiente().setAnterior(nodoDoble);
                    }

                    recorrer.setSiguiente(nodoDoble);
                }
                recorrer = recorrer.getSiguiente();
                ++contador;
            }

            if (contador == posicion) {
                recorrer.setSiguiente(nodoDoble);
                nodoDoble.setAnterior(recorrer);
                nodoDoble.setSiguiente(null);

            }
        }
    }
}
