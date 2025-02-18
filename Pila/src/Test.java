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

    /**
     * Método que ordena los números de menor a mayor
     * @param vectorNumeros
     * @return
     */
    public Pila<Integer> ordenadoNumeros(int[] vectorNumeros)
    {
        //Dos pilas para poder hacer la comparación e intercambio, en este caso una nos servirá para almacenar todos los datos
        //del arreglo y el otro para almacenar los datos mayores
        Pila<Integer> pilasTemporal = new Pila<>(vectorNumeros.length);
        Pila<Integer> pilaEntrada = new Pila<>(vectorNumeros.length);

        //Primero llenamos la pilaEntrada con todos los datos del arreglo
        for (int i = 0; i < vectorNumeros.length; ++i) {
            pilaEntrada.push(vectorNumeros[i]);
        }

        //Utilizamos de una variable auxiliar que nos ayudará a comparar con la pilaTemporal
        int popEnt;

        //Seguirá hasta que la pilaEntrada esté vacia
        while (!pilaEntrada.pilaVacia()) {

            //popEnt saca el primer valor de la pilaEntrada
            popEnt = pilaEntrada.pop();

            //Si la pilaTemp está vacia, se mete uno para poder comparar
            if (pilasTemporal.pilaVacia()) {
                pilasTemporal.push(popEnt);

                //Sino, quiere decir que podemos comenzar a comparar
            } else {

                //Terminará hasta que el valor sacado de la pilaEntrada sea menor al ultimo valor de pilaTemporal, además
                //está acompañado con la verificación de que no esté vacio la pilaTemp
                while (!pilasTemporal.pilaVacia() && popEnt > pilasTemporal.peek()) {

                    //Si se cumple quiere decir que debemos sacar datos de pilaTemp y meterlos a pilaEntrada hasta que haya
                    //un valor mayor o no haya nada en la pilaTemp
                    pilaEntrada.push(pilasTemporal.pop());
                }

                //Una vez se deje de cumplir quiere decir que pila temporal está vacia o el popEntrada era menor al ultimo dato
                //de pilaTempolal, en tal caso se almacena ese popEnt a la pilaTemp.
                pilasTemporal.push(popEnt);
            }
        }

        //Al terminar se regresa
        return pilasTemporal;
    }
}
