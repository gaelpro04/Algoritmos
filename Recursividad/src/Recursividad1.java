public class Recursividad1 {



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

    public String fibonacci(int n) {
        if (n == 0) {
            return "0";  // Caso base: si n es 0, solo devolvemos "0"
        } else if (n == 1) {
            return "0 1";  // Caso base: si n es 1, devolvemos "0 1"
        } else {
            String secuencia = fibonacci(n - 1);
            int a = Integer.parseInt(secuencia.split(" ")[n - 1]);
            int b = Integer.parseInt(secuencia.split(" ")[n - 2]);
            return secuencia + " " + (a + b);
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
        } else if (n % division == 0) {
            return true;
        } else {
           return primoRecursivo(n, division+1);
        }
    }
}
