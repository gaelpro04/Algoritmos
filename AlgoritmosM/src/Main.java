import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        AnalisisSuma ajasidime = new AnalisisSuma();
        ArrayList<ArrayList<Long>> resultadosTiempo = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            resultadosTiempo.add(new ArrayList<>());
        }
        int N = 2;
        long MAX = 100000000 * 10*N;
        int corrida = 0;

        for (long i = 100; i <= MAX; i*= 10) {

            long startTime = System.nanoTime();
            ajasidime.sumatoria0N(i);
            long endTime = System.nanoTime();
            resultadosTiempo.getFirst().add(endTime - startTime);
        }

        for (long i = 100; i <= MAX; i*= 10) {
            long startTime = System.nanoTime();
            ajasidime.sumatoriaGauss(i);
            long endTime = System.nanoTime();
            resultadosTiempo.get(1).add(endTime - startTime);
        }

        for (long i = 100; i <= MAX; i*= 10) {
            long startTime = System.nanoTime();
            ajasidime.sumatoriaGauss(i);
            long endTime = System.nanoTime();
            resultadosTiempo.get(2).add(endTime - startTime);
        }

        for (int i = 0; i < resultadosTiempo.size(); i++) {
            System.out.println(resultadosTiempo.get(i));
        }

    }
}