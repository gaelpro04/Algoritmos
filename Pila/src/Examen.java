public class Examen {

    public String invertirCadena(String cadena)
    {
        StringBuilder builder = new StringBuilder();
        Pila pila = new Pila(cadena.length());

        for (int i = 0; i < cadena.length(); ++i) {
            pila.push(cadena.charAt(i));
        }
        for (int i = 0; i < cadena.length(); ++i) {
            builder.append(pila.pop());
        }

        return builder.toString();
    }

    public boolean revisarSintaxis(String cadena)
    {
        Pila<Character> pila = new Pila<>(6);

        for (int i = 0; i < cadena.length(); ++i) {
            if (cadena.charAt(i) == '{' || cadena.charAt(i) == '[' || cadena.charAt(i) == '(') {
                pila.push(cadena.charAt(i));
            } else if (cadena.charAt(i) == '}' || cadena.charAt(i) == ']' || cadena.charAt(i) == ')') {
                if (pila.pilaVacia()) {
                    return false;
                }

                if (cadena.charAt(i) == '}' && pila.peek() == '{') {
                    pila.pop();
                } else if (cadena.charAt(i) == ']' && pila.peek() == '[') {
                    pila.pop();
                } else if (cadena.charAt(i) == ')' && pila.peek() == '(') {
                    pila.pop();
                }
            }
        }
        return pila.pilaVacia();
    }

    public Pila<Integer> numerosOrdenados(int[] numeros) {

        Pila<Integer> pilaEntrada = new Pila<>(numeros.length);
        Pila<Integer> pilaSalida = new Pila<>(numeros.length);
        int variableTemp = 0;

        for (int i = 0; i < numeros.length; ++i) {
            pilaEntrada.push(numeros[i]);
        }

        while (!pilaEntrada.pilaVacia()) {

            variableTemp = pilaEntrada.pop();

            if (pilaSalida.pilaVacia()) {
                pilaSalida.push(variableTemp);
            } else if (variableTemp > pilaSalida.peek()) {
                pilaEntrada.push(pilaSalida.pop());
            } else {
                pilaSalida.push(variableTemp);
            }
        }

        return pilaSalida;
    }

    public String verificarBalanceado(String cadena) {
        Pila<Character> pila = new Pila<>(cadena.length());

        for (int i = 0; i < cadena.length(); ++i) {
            if (cadena.charAt(i) == '(') {
                pila.push(cadena.charAt(i));
            } else if (cadena.charAt(i) == ')') {
                if (pila.pilaVacia()) {
                    return "Desbalanceado";
                } else if (pila.peek() == '(') {
                    pila.pop();
                } else {
                    return "Desbalanceado";
                }
            }
        }
        return pila.pilaVacia() ? "Balanceado" : "Desbalanceado";
    }

    public int operacionPostFija(String operacion) {
        Pila<Integer> pila = new Pila<>(operacion.length());
        int variableTemp1 = 0;
        int variableTemp2 = 0;

        for (int i = 0; i < operacion.length(); ++i) {
            if (Character.isDigit(operacion.charAt(i))) {
                pila.push(Character.getNumericValue(operacion.charAt(i)));
            } else {
                if (pila.pilaVacia()) {
                    return -1;
                }

                variableTemp1 = pila.pop();
                if (pila.pilaVacia()) {
                    return -1;
                } else {
                    variableTemp2 = pila.pop();
                }

                switch (operacion.charAt(i)) {
                    case '+':
                        pila.push(variableTemp2 + variableTemp1);
                        break;
                    case '-':
                        pila.push(variableTemp2 - variableTemp1);
                        break;
                    case '*':
                        pila.push(variableTemp2 * variableTemp1);
                        break;
                    case '/':
                        pila.push(variableTemp2 / variableTemp1);
                        break;
                }

            }
        }
        return pila.pilaVacia() ? -1 : pila.pop();
    }

    public boolean esPalindromo(String cadena) {

        cadena = cadena.replace(" ", "");
        Pila<Character> palindromo = new Pila<>(cadena.length());

        for (int i = 0; i < cadena.length(); i++) {
            palindromo.push(cadena.charAt(i));
        }
        for (int i = 0; i < cadena.length(); i++) {
            if (palindromo.pop() != cadena.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
