public class ColaCircular<T> {

    private T[] colarCircular;
    private int inicio, fin;

    public ColaCircular()
    {
        colarCircular = (T[]) new Object[10];
        inicio = -1;
        fin = -1;
    }

    public ColaCircular(int MAX)
    {
        colarCircular = (T[]) new Object[MAX];
        inicio = 1;
        fin = -1;
    }

    public void insertar(T object)
    {
        if (fin == colarCircular.length - 1 && inicio == 0 || (fin+1) == inicio) {
            System.out.println("Desbordamiento");
        } else {
            if (fin == colarCircular.length - 1) {
                fin = 0;
            } else {
                ++fin;
            }
            colarCircular[fin] = object;
            if (inicio == -1) {
                inicio = 0;
            }
        }
    }

    public T eliminar()
    {
        T dato = null;
        if (inicio == -1) {
            System.out.println("Subdesbordamiento");
        } else {
            dato = colarCircular[inicio];
            if (inicio == fin) {
                inicio = -1;
                fin = -1;
            } else {
                if (inicio == colarCircular.length -1) {
                    inicio = 0;
                } else {
                    ++inicio;
                }
            }
        }
        return dato;
    }

    public void mostrar()
    {
        if (inicio == -1) {
            System.out.println("Está vacia");
        } else {
            for (int i = inicio; i <= fin; ++i) {
                System.out.print(colarCircular[i] + " ");
            }
            System.out.println();
        }
    }
}
