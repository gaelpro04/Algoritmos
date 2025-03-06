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
}
