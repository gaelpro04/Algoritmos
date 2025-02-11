import java.util.Arrays;

public class Test {

    public String invertirCadena(String cadena)
    {
        Pila<String> pila = new Pila<>(cadena.length());
        String[] nuevaCadena = new String[cadena.length()];

        for (int i = 0; i < cadena.length(); i++) {
            nuevaCadena[i] = String.valueOf(cadena.charAt(i));
        }
        for (int i = 0; i < nuevaCadena.length ; i++) {
            pila.push(nuevaCadena[(i)]);
        }

        StringBuilder cadenita = new StringBuilder(cadena.length());
        for (int i = 0; i < nuevaCadena.length; i++) {
            cadenita.append(pila.pop());
        }
        return cadenita.toString();
    }
}
