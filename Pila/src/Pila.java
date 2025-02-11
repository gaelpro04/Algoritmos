public class Pila<T> {
    private int tope;
    private T[] elemento;

    public Pila() {

        elemento = (T[]) new Object[10];
        tope = -1;
    }

    public Pila(int tope) {

        elemento = (T[]) new Object[tope];
        this.tope = -1;
    }

    public boolean pilaVacia() {

        return tope == -1;
    }

    public boolean pilaLlena()
    {
        return tope == elemento.length - 1;
    }

    public void push(T objeto)
    {
        if (pilaLlena()) {
            System.out.println("Desbordamiento");
        } else {
            ++tope;
            elemento[tope] = objeto;

        }
    }

    public T pop()
    {
        T objeto = null;
        if (pilaVacia()) {
            System.out.println("No se puede");
        } else {
            objeto = elemento[tope];
            --tope;
        }

        return objeto;
    }
}
