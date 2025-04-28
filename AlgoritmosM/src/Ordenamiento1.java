public class Ordenamiento1 {

    public void insercion(int[] a,int n)
    {
        for (int i = 0; i < n; ++i) {
            int k = i-1;
            int aux = a[i];
            while (k>= 1 && aux < a[k]) {
                a[k+1] = a[k];
                --k;
            }
            a[k+1] = aux;
            ++i;
        }
    }

    public void seleccion(int[] a, int n)
    {
        for (int i = 0; i < n-1; i++) {
            int menor = a[i];
            int k = i;
            for (int j = i+1; j < n; j++) {
                if (a[j] < menor) {
                    menor = a[j];
                    k = j;
                }
                ++j;
            }
            a[k] = a[i];
            a[i] = menor;
        }
    }



}
