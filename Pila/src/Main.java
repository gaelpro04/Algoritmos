public class Main {
    public static void main(String[] args) {

        Test ajasi = new Test();
        String simon = "puto";
        System.out.println(simon);
        System.out.println(ajasi.invertirCadena(simon));

        String mijadondevan = "2-{32+2(2/2)}";
        System.out.println(mijadondevan);
        System.out.println(ajasi.revisarSintaxis(mijadondevan));
    }
}