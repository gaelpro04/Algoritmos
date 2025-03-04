public class undoRedo {

    private Pila<String> undo;
    private Pila<String> redo;

    public undoRedo(int tope)
    {
        undo = new Pila<>(tope);
        redo = new Pila<>(tope);
    }

    public void escribir(String palabra)
    {
        if (!redo.pilaVacia()) {
            while (!redo.pilaVacia()) {
                redo.pop();
            }
            undo.push(palabra);
        } else {
            undo.push(palabra);
        }
    }

    public boolean undo()
    {
        if (undo.pilaVacia()) {
            return false;
        }
        redo.push(undo.pop());
        return true;
    }

    public boolean redo()
    {
        if (redo.pilaVacia()) {
            return false;
        }
        undo.push(redo.pop());
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Pila<String> pilaTemp = new Pila<>(10);

        while (!undo.pilaVacia()) {
            pilaTemp.push(undo.pop());
        }

        builder.append("[");
        while (!pilaTemp.pilaVacia()) {
            String variableTemp = pilaTemp.pop();
            undo.push(variableTemp);
            builder.append(", " + variableTemp);
        }
        builder.append("]");

        return builder.toString();
    }
}
