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
}
