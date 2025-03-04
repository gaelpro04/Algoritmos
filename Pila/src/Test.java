import java.util.Arrays;

//Clase donde ponemos a prueba la pila
public class Test extends Pila {

    /**
     * Método que invierte una cadena tipo String
     * @param cadena
     * @return
     */
    public String invertirCadena(String cadena)
    {
        //Se crea la pila donde se almacenará todo la cadena String y un arreglo
        //tipo String done extrae el parametro cadena
        Pila<String> pila = new Pila<>(cadena.length());
        String[] nuevaCadena = new String[cadena.length()];

        //Se extrae cada character de la cadena al nuevo arreglo
        for (int i = 0; i < cadena.length(); i++) {
            nuevaCadena[i] = String.valueOf(cadena.charAt(i));
        }

        //Luego se mete cada dato del arreglo a la pila con push
        for (int i = 0; i < nuevaCadena.length ; i++) {
            pila.push(nuevaCadena[(i)]);
        }

        //Por ultimo creamos un StrinBuilder donde se pondrá la cadena invertida
        StringBuilder cadenita = new StringBuilder(cadena.length());

        //Por ultimo extraemos los datos de la pila con pop, como el ultimo elemento puesto
        //fue el ultimo character de la cadena, será el primero en almacenarce en el StringBuilder
        for (int i = 0; i < nuevaCadena.length; i++) {
            cadenita.append(pila.pop());
        }

        //Retorna cadenita a string
        return cadenita.toString();
    }

    /**
     * Método que revisa la sintaxis de operaciones con parentesis, corchetes y llaves
     * @param cadena
     * @return
     */
    public boolean revisarSintaxis(String cadena)
    {
        //Pila donde se almacenarán los parentesis
        Pila<Character> arre = new Pila<>(cadena.length());

        //Ciclo que recorré todo elemento de la cadena
        for (int i = 0; i < cadena.length(); i++) {

            //Al principio de recorres, se localiza el lado izquierdo de los parentesis y si
            //se encuentra se almacena
            if (cadena.charAt(i) == '{' || cadena.charAt(i) == '[' || cadena.charAt(i) == '(') {
                arre.push(cadena.charAt(i));

                //Si no cumple la condición anterior entonces encapsulamos los de lado derecho aquí
            } else if (cadena.charAt(i) == '}' || cadena.charAt(i) == ']' || cadena.charAt(i) == ')') {

                //Primero verificamos si está vacia. Si entro aquí y esta vacia quiere decir que está mal
                //su sintaxis. Se regresa false
                if (arre.pilaVacia()) {
                    return false;

                    //Si no esta vacio empezamos a comparar si son validos
                } else {

                    //Sacamos el ultimo elemento de la pila y comparamos con cada escenario
                    char pop = arre.pop();

                    //Si coinciden, entonces es un parentesis valida y seguimos con el ciclo
                    //aquí lo importante es cuando no coincide uno
                    if (pop == '{' && cadena.charAt(i) == '}') {
                        continue;
                    } else if (pop == '[' && cadena.charAt(i) == ']' ) {
                        continue;
                    } else if (pop == '(' && cadena.charAt(i) == ')') {
                        continue;

                        //Si ni uno coincide regresamos false
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
