public class Main {
    public static void main(String[] args) throws InterruptedException {
        
        ColaSimple<String> hola = new ColaSimple<>(10);

        hola.offer("hola");
        hola.offer("hola1");
        hola.offer("hola2");

        hola.mostrar();

        ColaBlocking simon = new ColaBlocking(3);
        simon.put("hola");
        simon.put("hola1");
        simon.put("hola2");

        System.out.println(simon);

        simon.put("hola3");


    }
}