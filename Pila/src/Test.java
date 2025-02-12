import java.util.Arrays;

//Método donde ponemos a prueba la pila
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

    public boolean revisarSintaxis(String cadena)
    {
        Pila<Character> arre = new Pila<>(cadena.length());
        System.out.println(cadena.length());
        int contador = 0;

        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == '{' || cadena.charAt(i) == '[' || cadena.charAt(i) == '(') {
                arre.push(cadena.charAt(i));
            } else if (cadena.charAt(i) == '}' || cadena.charAt(i) == ']' || cadena.charAt(i) == ')') {
                if (arre.pilaVacia()) {
                    return false;
                } else {
                    char pop = arre.pop();
                    if (pop == '{' && cadena.charAt(i) == '}') {
                        continue;
                    } else if (pop == '[' && cadena.charAt(i) == ']' ) {
                        continue;
                    } else if (pop == '(' && cadena.charAt(i) == ')') {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }
        return arre.pilaVacia();
    }
}
