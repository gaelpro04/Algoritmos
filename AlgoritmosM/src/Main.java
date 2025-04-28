import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.*;

import javax.swing.*;
import java.util.ArrayList;


public class Main {
    public static void main1(String[] args) {

        //Se instancia el objeto de sumas
        AnalisisSuma ajasidime = new AnalisisSuma();

        //Se crean dos ArrayList que dentro de ellos contienen otro arraylist que guardara los datos de tiempo de ejecion
        // y numero de n veces que se generaron las operaciones
        ArrayList<ArrayList<Long>> resultadosTiempo = new ArrayList<>(3);
        ArrayList<ArrayList<Long>> nVeces = new ArrayList<>(3);



        //Se inician los constructores de cada array creado
        for (int i = 0; i < 3; i++) {
            resultadosTiempo.add(new ArrayList<>());
            nVeces.add(new ArrayList<>());
        }

        //Dos variables una sera un escalar del numero de veces que se va estar aumentado el valor maximo
        long N = 9;

        //Valor maximo
        long MAX = 100000000 * 10*N;

        //Ciclo que registra el tiempo de cada suma en cada iteracion, por ultimo registra las n veces que se multiplico
        //ademas del tiempo de ejecucion de la sumatoria en cada iteracion
        for (long i = 100; i <= MAX; i*= 10) {

            //Se inicia el tiempo en nano segundos
            long startTime = System.nanoTime();

            //Se hace la sumatoria actual
            ajasidime.sumatoria0N(i);

            //Termina el tiempo en nano segundos
            long endTime = System.nanoTime();

            //Se guarda en cada iteracion los valores obtenidos del tiempo y n veces
            resultadosTiempo.getFirst().add(endTime - startTime);
            nVeces.getFirst().add(i);
        }

        //Lo mismo se hace para la sumatoria de Gauss
        for (long i = 100; i <= MAX; i*= 10) {
            long startTime = System.nanoTime();
            ajasidime.sumatoriaGauss(i);
            long endTime = System.nanoTime();
            resultadosTiempo.get(1).add(endTime - startTime);
            nVeces.get(1).add(i);
        }

        //Sumatoria recursiva
        for (long i = 100; i <= MAX; i*= 10) {
            long startTime = System.nanoTime();
            ajasidime.sumatoriaGauss(i);
            long endTime = System.nanoTime();
            resultadosTiempo.get(2).add(endTime - startTime);
            nVeces.get(2).add(i);
        }

        for (int i = 0; i < resultadosTiempo.size(); i++) {
            System.out.println(resultadosTiempo.get(i));
        }

        for (int i = 0; i < nVeces.size(); i++) {
            System.out.println(nVeces.get(i));
        }

        //Graficado


        // Grafica ciclica
        XYSeries datos = new XYSeries("Datos");

        //Se almacenan los datos en la variable datos que guarda los datos del eje Z y eje Y
        for (int i = 0; i < resultadosTiempo.getFirst().size(); i++) {
            datos.add(nVeces.getFirst().get(i), resultadosTiempo.getFirst().get(i));
        }

        //Se guarda en otra varriable
        XYSeriesCollection dataSet = new XYSeriesCollection();
        dataSet.addSeries(datos);

        //Se crean los parametros de la grafica
        JFreeChart chart = ChartFactory.createXYLineChart("Sumatoria ciclica", "n veces", "Tiempo nS", dataSet);

        //Por ultimo se crea una instancia del graficado y se mete en el frame
        ChartPanel chartPanel = new ChartPanel(chart);
        JFrame frame = new JFrame("Sumatoria ciclica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(chartPanel);
        frame.setSize(800, 600);
        frame.setVisible(true);

        //Grafic de Gauss
        XYSeries seriesGauss = new XYSeries("Gauss");
        for (int i = 0; i < resultadosTiempo.get(1).size(); i++) {
            seriesGauss.add(nVeces.get(1).get(i), resultadosTiempo.get(1).get(i));
        }

        XYSeriesCollection datosGauss = new XYSeriesCollection();
        datosGauss.addSeries(seriesGauss);
        JFreeChart chartGauss = ChartFactory.createXYLineChart("Sumatoria de Gauss", "n veces", "Tiempo nS", datosGauss);

        JFrame frameGauss = new JFrame("Sumatoria de Gauss");
        frameGauss.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameGauss.add(new ChartPanel(chartGauss));
        frameGauss.setSize(800, 600);
        frameGauss.setVisible(true);

        //Grafica recursiva
        XYSeries seriesRecursiva = new XYSeries("Recursivo");
        for (int i = 0; i < resultadosTiempo.get(2).size(); i++) {
            seriesRecursiva.add(nVeces.get(2).get(i), resultadosTiempo.get(2).get(i));
        }

        XYSeriesCollection datosRecur = new XYSeriesCollection();
        datosRecur.addSeries(seriesRecursiva);
        JFreeChart chartRecur = ChartFactory.createXYLineChart("Sumatoria recursiva", "n veces", "Tiempo nS", datosRecur);

        JFrame frameRecur = new JFrame("Sumatoria recursiva");
        frameRecur.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameRecur.add(new ChartPanel(chartRecur));
        frameRecur.setSize(800, 600);
        frameRecur.setVisible(true);
    }
}