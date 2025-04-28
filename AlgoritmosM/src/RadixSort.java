import java.util.Arrays;

public class RadixSort {

    /**
     * Metodo para obtener el numero con mas digitos del array
     * @param arr
     * @param n
     * @return
     */
    private int obtenerMax(int[] arr, int n)
    {
        int max = arr[0];
        for (int i = 1; i < n; ++i) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    /**
     *
     * @param arr
     * @param n
     * @param exp
     */
    private void countSort(int[] arr, int n, int exp)
    {
        int[] salida = new int[n];
        int[] contador = new int[10];
        Arrays.fill(contador, 0);

        //Ciclo que en base al digito obtenido, contar las veces que
        //se encuentra en la lista, por ejemplo si se repite el digito dos
        //en la lista esta lista tendra dos por que se encuentra dos veces
        //el digito dos
        for (int j = 0; j < n; j++) {
            //dentro del indice de contador, se obtiene el digito y se almacena
            //el contador ahi.
            ++contador[arr[j] / exp % 10];
        }

        //Ciclo que acumula las veces en la que cada digito tiene valores menores
        //iguales a el
        for (int j = 1; j < 10; j++) {
            contador[j] += contador[j-1];
        }

        //Ciclo que hace el acomodo en la salida, basicamente en base al digito actual
        //que se esta actualizando, se va metiendo a la salida ascendentemente.
        for (int j = n - 1; j >= 0; j--) {
            salida[contador[(arr[j] / exp) % 10] - 1] = arr[j];
            --contador[(arr[j] / exp) % 10];
        }

        //Ciclo que actualiza el array original con el array ordenado en base al
        // digito actual
        for (int j = 0; j < n; j++) {
            arr[j] = salida[j];
        }
    }

    /**
     * Metodo de ordenamiento radixSort
     * @param arr
     * @param n
     */
    public void radixSort(int[] arr, int n)
    {
        //Se obtiene el valor maximo del arreglo
        int max = obtenerMax(arr, n);

        //En base al valor maximo se puede determinar la cantidad de veces que se ocupara ordenar la
        // lista(es en base a la maxima cantidad de digitos)
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, n, exp);
        }
    }

    public static void main(String[] args) {

        RadixSort radix = new RadixSort();
        int[] elementos = {9,2,100,10};

        radix.radixSort(elementos, elementos.length);

        System.out.println(Arrays.toString(elementos));
    }
}
