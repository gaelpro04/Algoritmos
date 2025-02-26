public class ColaSimple<T> {

    private T[] colaSimple;
    private int inicio, fin;


    public ColaSimple(int MAX)
    {
        colaSimple = (T[]) new Object[MAX];
        inicio = -1;
        fin = -1;
    }

    public ColaSimple()
    {
       colaSimple = (T[]) new Object[10];
       inicio = -1;
       fin = -1;
    }

    public void insertar(T object)
    {
        if (fin < colaSimple.length - 1) {
            ++fin;
            colaSimple[fin] = object;
            if (fin == 0) {
                inicio = 0;
            }
        } else {
            System.out.println("Desbordamiento");
        }
    }

    public T eliminar()
    {
        T dato = null;
        if (inicio != -1) {
            dato = colaSimple[inicio];
            if (inicio == fin) {
                inicio = -1;
                fin = -1;
            } else {
                ++inicio;
            }
        } else {
            System.out.println("Subdesbordamiento");
        }
        return dato;
    }

    public void mostrar()
    {
        if (inicio == -1) {
            System.out.println("Está vacia");
        } else {
            for (int i = inicio; i <= fin; ++i) {
                System.out.print(colaSimple[i] + " ");
            }
            System.out.println();
        }
    }


}
