public class Main {
    public static void main(String[] args) {

        Test ajasi = new Test();
        String simon = "puto";
        System.out.println(simon);
        System.out.println(ajasi.invertirCadena(simon));

        String mijadondevan = "2-{32+2(2/2)}";
        System.out.println(mijadondevan);
        System.out.println(ajasi.revisarSintaxis(mijadondevan));

        int[] si = {3,4,5,1,9};
        Pila<Integer> when = ajasi.ordenadoNumeros(si);

        for (int i : si) {
            System.out.println(when.pop());
        }
    }
}