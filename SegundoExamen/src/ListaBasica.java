public class ListaBasica<T> {

    //Atributo para saber donde inicia la lista, básicamente con ella podremos recorrer
    //Toda la lista
    NodoBasico<T> inicio;

    /**
     * Constructor preterminado que solamente inicializa dejando la lista vacia
     */
    public ListaBasica()
    {
        //Como el ultimo nodo siempre apunta a null, y la lista al principio esta vacia, entonces
        //se apunta a null
        inicio = null;
    }

    /**
     * Método par insertar un nodo al principio
     * @param dato
     */
    public void insertarDatoInicio(T dato)
    {
        //Se inicializa un nuevo dodo donde se guardará el nuevo dato
        //y se meterá a la lista
        NodoBasico<T> nodoBasico = new NodoBasico<>(dato);

        //Ahora inicio es igual al nuevo dato creado(ya que como se meterá al inicio entonces
        // debe apuntar a ese dato)
        nodoBasico.setSiguiente(inicio);
        inicio = nodoBasico;

    }

    /**
     * Método para insertar un dato al final de la lista
     * @param dato
     */
    public void insertarDatoFinal(T dato)
    {
        //Se crea el dato donde se guardar y posteriormente se meterá a la lista
        NodoBasico<T> nodoBasico = new NodoBasico<>(dato);

        //Si iniicio es igual a null quiere decir que está vacia
        if (inicio == null) {
            //Simplemente se iguala, como no hay algún dato dentro de la lista, simplemente se mete
            //con inicio
            inicio = nodoBasico;

            //En dado caso que no sean iguales entonces ya hay elementos en la lista
        } else {
            //Se crea una instancia de un nodo que tomará el valor de inicio para recorrerlo

            NodoBasico<T> nodoRecorredor = inicio;

            //El ciclo que recorre todos los nodos hasta que no sea null, si es null quiere decir que ya se llegó
            //al final
            while (nodoRecorredor.getSiguiente() != null) {

                //Se usa el método de tomar el siguiente y este mismo nodo lo obtiene para estar
                //recorriendo
                nodoRecorredor = nodoRecorredor.getSiguiente();
            }

            //ya por ultimo que se llego al ultimo se mete el nuevo nodo al ultimo nodo llegado
            //y el nodo nuevo su setSiguiente le apuntamos a null, para que se pueda saber donde es el nuevo final
            nodoRecorredor.setSiguiente(nodoBasico);
            nodoBasico.setSiguiente(null);
        }
    }

    /**
     * Método para eliminar un dato del inicio
     * @return
     */
    public T eliminarInicio()
    {
        //Se inicializa el dato donde guardará el dato
        T dato = null;

        //Si inicio es igual a null, quiere decir que está vacía
        if (inicio == null) {
            System.out.println("Lista vacia");

            //En dado caso que no este vacía, simplemente obtenemos el dato de inicio
            //y ahora el inicio apunto al siguiente nodo
        } else {
            dato = inicio.getDato();
            inicio = inicio.getSiguiente();
        }

        //Para finalizar se regresa el dato
        return dato;
    }

    /**
     * Método para eliminar un elemento del final de la lista
     * @return
     */
    public T eliminarFinal()
    {
        //Se inicializa el dato donde se guardara el ultimo elemento
        T dato = null;

        //Si inicio es igual a null quiere decir que la lista está vacia
        if (inicio == null) {
            System.out.println("Lista vacia");


            //En dadocaso que el siguiente nodo sea nulo, quiere decir que solo hay un elemento en la lista
            //Por esto mismo se obtiene el dato del nodo actual e inicio se iguala a null
        } else if (inicio.getSiguiente() == null) {

            dato = inicio.getDato();
            inicio = null;

            //En dado caso que no, se procede a recorrer a lista hasta llegar al ultimo elemento
        } else {

            //Se inicializan dos nodos, uno que va recorrer toda la lista y el otro que se quedará
            //con el elemtno anterio al elemento final.
            NodoBasico<T> nodoRecorredor = inicio;
            NodoBasico<T> nodoRecorredorAnterior = nodoRecorredor;

            //El ciclo recorre cada nodo con getSiguiente y si es null, quiere decir que se llegó
            //al final
            while (nodoRecorredor.getSiguiente() != null) {

                //El nodo anterior primero toma el ultimo para que el nodo ultimo pueda recorrer
                //el siguiente nodo y el nodo anterior se queda con ese mismo anterior
                nodoRecorredorAnterior = nodoRecorredor;
                nodoRecorredor = nodoRecorredor.getSiguiente();
            }

            //Ya por ultimo que se llegó, el nodo anterior ahora apunta a null y así se elimina el nodo ultimo
            // y se obtiene el dato del ultimo nodo para regresarlo
            nodoRecorredorAnterior.setSiguiente(null);
            dato = nodoRecorredor.getDato();
        }

        //Se regresa el dato
        return dato;
    }

    public String mostrarLista()
    {
        StringBuilder builder = new StringBuilder();

        NodoBasico<T> recorrer = inicio;

        while (recorrer != null) {
            builder.append(recorrer.getDato() + " ");
            recorrer = recorrer.getSiguiente();
        }

        return builder.toString();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Primer ejercicio mostrar recursivo

    public String mostrarRecurisvo()
    {
        return mostrarRecursivo(inicio);
    }

    private String mostrarRecursivo(NodoBasico<T> nodo)
    {
        StringBuilder builder = new StringBuilder();

        if (nodo == null) {
            return builder.toString();
        }

        return builder.append(nodo.getDato() + " " + mostrarRecursivo(nodo.getSiguiente())).toString();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Segundo ejercicio eliminar dato

    public T eliminarX(T dato)
    {
        T datoComp = null;
        if (inicio == null) {
            System.out.println("Lista vacia");
            return null;
        } else if (inicio.getDato().equals(dato)) {
            datoComp = inicio.getDato();
            inicio = inicio.getSiguiente();
        } else {
            NodoBasico<T> nodo = inicio;

            while (nodo.getSiguiente() != null) {

                if (nodo.getSiguiente().getDato().equals(dato)) {
                    datoComp = nodo.getSiguiente().getDato();
                    nodo.setSiguiente(nodo.getSiguiente().getSiguiente());
                    break;
                }
                nodo = nodo.getSiguiente();
            }
        }

        return datoComp;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Tercer ejercicio regresar indice mediante objeto

    public int buscar(T dato) {

        int contador;
        if (inicio == null) {
            System.out.println("Lista vacia");
            return -1;
        } else if (inicio.getDato().equals(dato)) {
            return 0;
        } else {
            contador = 1;
            NodoBasico<T> nodoBasico = inicio;

            while(nodoBasico.getSiguiente() != null) {

                if (nodoBasico.getSiguiente().getDato().equals(dato)) {
                    return contador;
                } else {
                    ++contador;
                    nodoBasico = nodoBasico.getSiguiente();
                }
            }
        }

        return -1;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Quarto ejercicio eliminar posicion

    public T eliminarPosicion(int posicion)
    {
        T dato = null;
        if (inicio == null) {
            System.out.println("Lista vacia");
        } else if (posicion == 0) {
            dato = inicio.getDato();
            inicio = inicio.getSiguiente();
        } else {
            int contador = 0;
            NodoBasico<T> recorrer = inicio;
            NodoBasico<T> anterior = null;

            while (recorrer != null && contador < posicion) {

                anterior = recorrer;
                recorrer = recorrer.getSiguiente();
                contador++;
            }
            if (recorrer == null) {
                System.out.println("Posición fuera de rango");
                return null;
            }
            dato= recorrer.getDato();
            anterior.setSiguiente(recorrer.getSiguiente());
        }

        return dato;
    }



    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Quinto ejercicio ordenar lista

    public void ordenarLista()
    {
        if (inicio == null || inicio.getSiguiente() == null) {
            System.out.println("Lista vacia o con un elemento");
            return;
        } else {
            boolean ordenado;
            do {
                ordenado = true;
                NodoBasico<T> nodoBasico = inicio;

                while (nodoBasico.getSiguiente() != null) {

                    if (((Comparable<T>) nodoBasico.getDato()).compareTo(nodoBasico.getSiguiente().getDato()) > 0) {
                        T datoTemp = nodoBasico.getDato();
                        nodoBasico.setDato(nodoBasico.getSiguiente().getDato());
                        nodoBasico.getSiguiente().setDato(datoTemp);
                        ordenado = false;
                    }
                    nodoBasico = nodoBasico.getSiguiente();
                }

            } while (!ordenado);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Sexto ejercicio insertar elemento

    public void insertarElementoX(T dato, int posicion)
    {
        NodoBasico<T> nodoNuevo = new NodoBasico<>(dato);
        NodoBasico<T> nodo = inicio;
        int contador = 0;

        while (nodo.getSiguiente() != null) {

            if (contador == (posicion-1)) {
                nodoNuevo.setSiguiente(nodo.getSiguiente());
                nodo.setSiguiente(nodoNuevo);
                break;
            } else {
                ++contador;
                nodo = nodo.getSiguiente();
            }
        }
    }

    public int tamanio()
    {
        int contador = 0;

        NodoBasico<T> nodo = inicio;
        while (nodo != null) {
            nodo = nodo.getSiguiente();
            ++contador;
        }

        return contador;
    }

}
