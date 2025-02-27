import java.util.Arrays;

public class Main extends Test {
    public static void main(String[] args) {

        Test test = new Test();
        int[] arregloNumeros = {1,2,3,3,6,1};
        System.out.println(Arrays.toString(arregloNumeros));
        Pila<Integer> numerosOrdenados = test.ordenadoNumeros(arregloNumeros);
        for (int i = 0; i < arregloNumeros.length; ++i) {
            System.out.print(numerosOrdenados.pop() + " ");
        }
    }
}