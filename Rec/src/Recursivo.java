
//Clase que modela métodos recursivos
public class Recursivo {

    /**
     * Método que regresa una cadena de numeros consecutivos de N hasta 0
     * @param n
     * @return
     */
    public String serieN0(int n)
    {
        //Se crea un StrinBuilder para poder almacenar cada String
        StringBuilder builder = new StringBuilder();

        //Si n es igual a cero quiere decir que llegó al límite entonces solamente se agrega 0 y se regresa
        if (n==0) {
            builder.append('0');
            return builder.toString();

            //Si no se cumple, aún quedan números, por esto mismo se sigue regresando la misma función
        } else {

            //Cada vez que imprima el número actual, guarda además un espacio en blanco entre números y se invoca
            //de nuevo el método que hará exactamente lo mismo solamente que el parametro lo disminuimos una unidad
            //para que se cree el efecto de disminución en secuencia, ya por ultimo lo pasamos a toString() ya que
            //StringBuilder no es intrinsecamente String.
            return builder.append(n + " " + serieN0(n-1)).toString();
        }

    }

    /**
     * Método que regresa una cadena String de numeros consecutivos de 0 a N
     * @param n
     * @return
     */
    public String serie0N(int n) {

        //Se crea un StrinBuilder para poder almacenar cada String
        StringBuilder builder = new StringBuilder();

        //Si n es igual a 0, solamente se imprime este ultimo número y se pasa a String(
        if (n==0) {
            return builder.append(n + " ").toString();

            //Si no se cumple entonces aún quedan números por poner en el StrinBuilder, esto se logra
            // "casi de la misma manera" que el método anterior. Simplemente lo hacemos como si usaramos un bucle
            //for pero que empiece desde el ultimo indice, entonces se va disminuyendo invocando el mimso método de
            // lado izquierdo, creando la ilusión de números consecutivos de izquierda a derecha. Por ultimo lo pasamos a String
        } else {
            return builder.append(serie0N(n-1) + n + " ").toString();
        }
    }

    /**
     * Método
     * @param n
     * @return
     */
    public int factorial(int n)
    {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }


    public boolean esPrimo(int n)
    {
        return primoRecursivo(n,2);
    }

    public boolean primoRecursivo(int n, int division)
    {
        if (n <= 1) {
            return false;
        }
        if (division > n / 2) {
            return true;
        }
        if (n % division == 0) {
            return false;
        }
        return primoRecursivo(n,division+1);
    }

    /**
     * Método recursivo para saber si un valor se encuentra en un arreglo
     * @param x
     * @param arreglo
     * @param cont
     * @return
     */
    public int verificarValor(int x, int[] arreglo, int cont)
    {
        //Primero se compara si la longitud del contador es igual, si lo es, quiere decir que no se ha hallado,
        //ebntonces para dejar claro eso se regresa un menos uno
        if (arreglo.length == cont) {
            return -1;
        }

        //Si no se cumplió la condición anterior, entonces quiere decir que aun hay espacio, por lo mismo se compara el
        //elemento en el indice cont si es igual al valor que estamos buscando. Si se cumple se regresa el número
        if (arreglo[cont] == x) {
            return cont;
        }

        //En dado caso que no se cumpla ninguna condición quiere decir que aun no se haya el número y aún quedan espacios
        //buscar en el arreglo, por lo mismo se invoca la misma función, solamente aumentando más uno al contador
        return verificarValor(x,arreglo,cont+1);
    }

    /**
     * Método recursivo que entrega el valor más grande de un arreglo
     * @param arreglo
     * @param cont
     * @param indiceMasAlto
     * @return
     */
    public int valorMasGrande(int[]arreglo, int cont, int indiceMasAlto)
    {
        //Primero, con ayuda de algunos parametros, como lo es indiceMasAlto, le asignamos un valor a valorAlto de
        //el indice indiceMasAlto de arreglo
        int valorAlto = arreglo[indiceMasAlto];

        //Se compara si el contador es igual al tamaño del arreglo, si lo es entonces se regresa el ultimo valorMasAlto
        //asignado
        if (arreglo.length == cont) {
            return valorAlto;
        }

        //Si no se cumple la condición anterior, comparamos si el valor alto asignado es menor al elemento en el indice cont
        //del arreglo, quiere decir que ya hay un nuevo número más alto, entonces se asigna el indice de ese numero alto al
        //indice más alto
        if (valorAlto < arreglo[cont]) {
            indiceMasAlto = cont;
        }

        //Si no se cumple ninguna, se llama otra vesz al método y se aumenta más uno al contador
        return valorMasGrande(arreglo, cont+1,indiceMasAlto);
    }

    /**
     * Método recursivo que cuenta las orejas de cada conejo
     * @param cantidadConejos
     * @param cont
     * @return
     */
    public int conejitos(int cantidadConejos, int cont)
    {
        //Primero se multiplica el contador actual por dos(dos orejas por conejo) y se asigna a valor
        int valor = cont * 2;

        //Ahora si contador es igual al la cantidad de conejos(quiere decir que ya se contaron todos los conejos)
        //entonces se regresa el valor actual
        if (cont == cantidadConejos) {
            return valor;
        }

        //Si no se cumple simplemente se llama de nuevo y se aumenta más uno al contador
        return conejitos(cantidadConejos, cont+1);
    }

    /**
     * Método recursivo que indica si c1 esta inmediatamente antes del c2
     * @param cad
     * @param c1
     * @param c2
     * @param cont
     * @return
     */
    public boolean indicarCaracterAnterior(String cad, char c1, char c2, int cont)
    {
        //Si el contador es a la longitud de la cadena menos uno(en este método, en cada iteración también se analiza un
        // elemento después del actual por eso mismo la aclaración del menos uno), se regresa false, ya que la ultima iteración
        //Recursiva analizó si los dos chars están seguidos y cuando se suma uno más por ultima vez y entra a esta condición
        //se regresará false
        if (cont == cad.length() - 1) {
            return false;
        }

        //Si no se complió la condición anterior, se hace el análisis base, donde comparamos si el elemento actual del
        //contador y el elemento contador +1 si son iguales a los caracteres especificados, si lo son quiere decir que si
        //son consecutivos, por lo tanto se regresa true
        if (cad.charAt(cont) == c1 && cad.charAt(cont+1) == c2) {
            return true;
        }

        //Si no se cumple, se regresa la invocación del mismo método solamente sumando +1 al contador
        return indicarCaracterAnterior(cad,c1,c2,cont+1);
    }

    /**
     * Método que suma los numeros que se encuentra en una cadena
     * @param cad
     * @param acumulador
     * @param cont
     * @return
     */
    public int sumaNumeros(String cad, int acumulador, int cont)
    {
        //Primero se compara si la longitud de la cadena es igual al contador, si lo son se regresa el acomulador actual
        if (cad.length() == cont) {
            return acumulador;
        }

        //Luego se compara el actual en la cadena utiliznado del método IsDigit de la clase Character, y especificamos
        //el caracter en la posición cont, comparamos si es un digito, si lo es acumulamos con ayuda otro metodo de
        // Character getNumericValue en la posición de cont.
        if (Character.isDigit(cad.charAt(cont))) {
            acumulador = acumulador + Character.getNumericValue(cad.charAt(cont));
        }

        //Una vez terminado la ultima comparación, regresamos la invocación del método y somamos más uno al contador
        return sumaNumeros(cad,acumulador,cont+1);
    }

    public int sumaNumeros(Pila<Integer> pila) {

        int valor = pila.pop();
        if (!pila.pilaVacia()) {
            valor = valor + pila.pop();
            pila.push(valor);
        } else {
            return valor;
        }
        return sumaNumeros(pila);
    }


}
