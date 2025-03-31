public class NodoBasico<T> {
    private T dato;
    private NodoBasico<T> siguiente;

    public NodoBasico(T dato)
    {
        this.dato = dato;
        siguiente = null;
    }

    public NodoBasico()
    {
        this.dato = null;
        siguiente = null;
    }

    public void setDato(T dato)
    {
        this.dato = dato;
    }

    public T getDato()
    {
        return dato;
    }

    public void setSiguiente(NodoBasico<T> siguiente)
    {
        this.siguiente = siguiente;
    }

    public NodoBasico<T> getSiguiente()
    {
        return siguiente;
    }

    public String toString()
    {
        return "[" + dato + "]";
    }
}
