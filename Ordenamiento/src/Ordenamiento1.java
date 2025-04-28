import java.util.Collections;

public class Ordenamiento1 {

    public void insercion(int[] a,int n)
    {
        for (int i = 1; i < n; ++i) {
            int k = i-1;
            int aux = a[i];
            while (k>= 0 && aux < a[k]) {
                a[k+1] = a[k];
                --k;
            }
            a[k+1] = aux;
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
            }
            a[k] = a[i];
            a[i] = menor;
        }
    }

    public void shell(int[] a, int n)
    {
        int inter = n + 1;
        while (inter > 1) {
            inter = inter / 2;
            boolean bandera = true;
            while (bandera) {
                bandera = false;
                int i = 0;
                while ((i + inter) <= n) {
                    if (a[i] > a[i + inter]) {
                        int aux = a[i];
                        a[i] = a[i + inter];
                        a[i + inter] = aux;
                        bandera = true;
                    }
                    ++i;
                }
            }
        }
    }

    public void quickSort(int[] a, int n)
    {
        --n;
        recursivo(0,n,a);
    }

    /**
     * Metodo interno utilizando por quickSort donde se desarrolla el ordenamiento
     * @param inicio
     * @param fin
     * @param a
     */
    private void recursivo(int inicio, int fin, int[] a)
    {
        int izq = inicio;
        int der = fin;
        int pos = inicio;
        boolean bandera = true;

        while (bandera) {
            bandera = false;
            while (a[pos] <= a[der] && pos != der) {
                --der;
            }

            if (pos != der) {
                int aux = a[pos];
                a[pos] = a[der];
                a[der] = aux;
                pos = der;

                while (a[pos] >= a[izq] && pos != izq) {
                    ++izq;
                }

                if (pos != izq) {
                    bandera = true;
                    aux = a[pos];
                    a[pos] = a[izq];
                    a[izq] = aux;
                    pos = izq;
                }
            }
        }

        if ((pos-1) > inicio) {
            recursivo(inicio, pos-1, a);
        }
        if (fin > (pos+1)) {
            recursivo(pos+1, fin, a);
        }
    }

    public void binaria(int[] v, int n, int x)
    {
        int izq = 0;
        int der = n;
        boolean b = false;
        
    }
}
