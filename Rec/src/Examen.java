public class Examen {

    public int factorial(int n)
    {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n-1);
    }

    public String serieN0(int n)
    {
        StringBuilder builder = new StringBuilder();
        if (n == 0) {
            return builder.append("0").toString();
        }
        return builder.append(n + " " + serieN0(n-1)).toString();
    }

    private boolean esPrimo(int numero, int division) {

        if (numero == 0 || numero == 1) {
            return false;
        } else if (numero == 2 || numero == 3) {
            return true;
        }

        if (division > numero / 2) {
            return true;
        }

        if (numero % division == 0) {
            return false;
        }

        return esPrimo(numero, division+1);
    }

    public boolean esPrimoString(int numero) {
        return esPrimo(numero, 2);
    }

    private int fibonacciNumero(int n)
    {
        if (n == 0 || n == 1) {
            return n;
        }

        return fibonacciNumero(n-1) + fibonacciNumero(n-2);
    }

    public String fibonacciString(int n)
    {
        StringBuilder fibo = new StringBuilder();
        if (n == 0) {
            return fibo.append("0").toString();
        }
        return fibo.append(fibonacciString(n-1) + " " +fibonacciNumero(n)).toString();
    }

    public int sumaNumeros(int n)
    {
        if (n==0) {
            return n;
        }
        return n + sumaNumeros(n-1);
    }

    public int contarCaracteres(String s, char c, int cont, int acum)
    {
        if (cont == s.length()) {
            return acum;
        }
        if (s.charAt(cont) == c) {
            ++acum;
        }

        return contarCaracteres(s,c,cont+1,acum);
    }

    public int contarDigitos(int n, int acumulador)
    {
        if (n == 0) {
            return acumulador;
        }
        n = n / 10;
        return contarDigitos(n,acumulador+1);
    }
}
