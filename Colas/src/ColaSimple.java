import java.util.AbstractQueue;
import java.util.Iterator;

public class ColaSimple<T> extends AbstractQueue {

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

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public int size() {
        return colaSimple.length;
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


    @Override
    public boolean offer(Object o) {
        if (fin < colaSimple.length - 1) {
            ++fin;
            colaSimple[fin] = (T) o;
            if (fin == 0) {
                inicio = 0;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object poll() {
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

    @Override
    public Object peek() {
        T dato = null;
        if (inicio != -1) {
            dato = colaSimple[inicio];
        } else {
            return null;
        }
        return dato;
    }


}
