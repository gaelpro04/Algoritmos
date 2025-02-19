public class Main {
    public static void main(String[] args) {
        Recursivo aja = new Recursivo();

        System.out.println(aja.verificarValor(1, new int[]{2, 3, 4, 5, 1}, 0));
        System.out.println(aja.valorMasGrande(new int[]{2,3,4,5,6}, 0, 0));
        System.out.println(aja.conejitos(3,0));
        System.out.println(aja.indicarCaracterAnterior("hola",'l','s',0));
        System.out.println(aja.sumaNumeros("when tu 23 aja si2mon wey9", 0,0));
    }
}