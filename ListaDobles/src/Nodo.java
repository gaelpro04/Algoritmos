public class Nodo<T> {

    private T info;
    private Nodo<T> siguiente;
    private Nodo<T> anterior;

    public Nodo()
    {
        info = null;
        siguiente = null;
        anterior = null;
    }

    public Nodo(T info, Nodo<T> siguiente, Nodo<T> anterior)
    {
        this.info = info;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo<T> anterior) {
        this.anterior = anterior;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public String toString()
    {
        return "Anterior: " + (anterior != null ? anterior.getInfo() : "null") +
                " | Info: " + info +
                " | Siguiente: " + (siguiente != null ? siguiente.getInfo() : "null");
    }
}
