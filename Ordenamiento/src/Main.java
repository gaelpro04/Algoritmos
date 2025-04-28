public class Main {
    public static void main(String[] args) {
        int[] elementos = {2,4,7,3,8,2,1};

        Ordenamiento1 ordenar = new Ordenamiento1();

        ordenar.quickSort(elementos, 7);

        for (int elemento : elementos) {
            System.out.println(elemento);
        }
    }
}