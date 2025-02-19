public class Recursivo {

    public String serieN0(int n)
    {
        StringBuilder builder = new StringBuilder();

        if (n==0) {
            builder.append('0');
            return builder.toString();
        } else {
            return builder.append(n + " " + serieN0(n-1)).toString();
        }

    }

    public String serie0N(int n) {
        StringBuilder builder = new StringBuilder();

        if (n==0) {
            return builder.append(n + " ").toString();
        } else {
            return builder.append(serie0N(n-1) + n + " ").toString();
        }
    }

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
        if (arreglo.length == cont) {
            return -1;
        }

        if (arreglo[cont] == x) {
            return cont;
        }

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
        int valorAlto = arreglo[indiceMasAlto];
        if (arreglo.length == cont) {
            return valorAlto;
        }

        if (valorAlto < arreglo[cont]) {
            indiceMasAlto = cont;
        }

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
        int valor = cont * 2;
        if (cont == cantidadConejos) {
            return valor;
        }
        return conejitos(cantidadConejos, cont+1);
    }

    /**
     * Método recursivo que indica si c1 esta inmediatamente previo del c2
     * @param cad
     * @param c1
     * @param c2
     * @param cont
     * @return
     */
    public boolean indicarCaracterAnterior(String cad, char c1, char c2, int cont)
    {
        if (cont == cad.length() - 1) {
            return false;
        }
        if (cad.charAt(cont) == c1 && cad.charAt(cont+1) == c2) {
            return true;
        }
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
        if (cad.length() == cont) {
            return acumulador;
        }

        if (Character.isDigit(cad.charAt(cont))) {
            acumulador = acumulador + Character.getNumericValue(cad.charAt(cont));
        }
        return sumaNumeros(cad,acumulador,cont+1);
    }
}
