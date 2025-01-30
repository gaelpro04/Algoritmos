import java.util.ArrayList;
import java.util.Comparator;

public class SistemaSaludMental {

    private ArrayList<Instrumento> instrumentos;

    public SistemaSaludMental()
    {
        instrumentos = new ArrayList<>();
    }

    /**
     * Método para consultar todos los datos de cada instrumento
     */
    public void consultarAtributos()
    {
        int contador = 0;
        for (Instrumento instrumento : instrumentos) {

            contador++;
            System.out.println(contador + "]" + instrumento.toString());
        }
    }

    /**
     * Método para registrar un instrumento
     */
    public void registrarInstrumento(String nombre, String tipo, boolean evaluacion, String referencia)
    {
        instrumentos.add(new Instrumento(nombre, tipo, evaluacion, referencia));
    }

    /**
     * Método para eliminar un dato por la clave
     */
    public void eliminarPorClave(int clave)
    {
        instrumentos.stream().filter(instrumento -> clave == instrumento.getClave()).forEach(instrumento -> instrumentos.remove(instrumento));
    }

    /**
     * Método para guardar los datos en un archivo
     */
    public void guardarEnArchivo(String nombreArchivo)
    {
        System.out.println("Simon");
    }

    public void ordenarPorClave()
    {
        instrumentos.sort(new Comparator<Instrumento>() {
            @Override
            public int compare(Instrumento o1, Instrumento o2) {
                return 0;
            }
        });
    }

}
