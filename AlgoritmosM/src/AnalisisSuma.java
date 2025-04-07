public class AnalisisSuma {

    public long sumatoria0N(long n)
    {
        long sumatoria = 0;
        for (int i = 0; i <= n; i++) {
            sumatoria += i;
        }

        return sumatoria;
    }

    public long sumatoriaGauss(long n)
    {
        return n*(n + 1)/2;
    }

    public long sumatoriaRecursiva(long n)
    {
        if (n == 0) {
            return 0;
        }
        return n + sumatoriaRecursiva(n - 1);
    }
}
