import java.util.ArrayList;
import java.util.Comparator;
import java.io.*;

public class SistemaSaludMental {

    private ArrayList<Instrumento> instrumentos;

    public SistemaSaludMental()
    {
        instrumentos = new ArrayList<>();
    }

    /**
     * Método para consultar todos los datos de cada instrumento
     */
    public void consultarTodos()
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
    public void registrarInstrumento(String nombre, String tipo, boolean evaluacion, String referencia, String problemaMental)
    {
        instrumentos.add(new Instrumento(nombre, tipo, evaluacion, Integer.parseInt(referencia), problemaMental));
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
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo,false));

            StringBuilder builder = new StringBuilder();
            for (Instrumento instrumento : instrumentos) {
                for (String autor : instrumento.getAutores()) {
                    builder.append(autor).append(" ");
                }
                String autores = builder.toString();
                writer.write(instrumento.getNombre() + "," + instrumento.getTipo() + "," + instrumento.isEvaluacion() + "," + instrumento.getReferencia() + "," + instrumento.getProblemaMental() + "," + autores + "," + instrumento.getClave());
                writer.newLine();
            }
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Método para leer datos de un archivo
     */
    public void leerArchivo(String nombreArchivo)
    {
        String linea;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));

            while ((linea = reader.readLine()) != null) {

                String[] contenido = linea.split(",");

                instrumentos.add(new Instrumento(contenido[0], contenido[1], (contenido[2].equals("true")), Integer.parseInt(contenido[3]), contenido[4], contenido[5], Integer.parseInt(contenido[6])));
            }
            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Método para ordenar los datos por clave
     */
    public void ordenarPorClave()
    {
        instrumentos.sort(new Comparator<Instrumento>() {
            @Override
            public int compare(Instrumento o1, Instrumento o2) {
                return Integer.compare(o1.getClave(), o2.getClave());
            }
        });
    }

    /**
     * Método para ordenar los instrumentos por autor
     */
    public void ordenarPorAutor()
    {
        instrumentos.sort(new Comparator<Instrumento>() {
            @Override
            public int compare(Instrumento o1, Instrumento o2) {

                String autoresO1 = getString(o1);
                String autoresO2 = getString(o2);

                return autoresO1.compareToIgnoreCase(autoresO2);
            }
        });
    }

    /**
     * Método que busca todos los instrumentos mediante el nombre del mismo instrumento
     */
    public String buscarPorInstrumento(String instrumentoNombre)
    {
        StringBuilder instrumentos1 = new StringBuilder();
        instrumentos.stream().filter(instrumento -> instrumento.getNombre().equals(instrumentoNombre)).forEach(instrumento -> instrumentos1.append(toString() + "\n"));
        return instrumentos1.toString();


    }

    /**
     * Método que busca todo los instrumentos por el nombre del autor
     * @param autor
     */
    public String buscarPorAutor(String autor)
    {
        StringBuilder instrumento1 = new StringBuilder();
        instrumentos.stream().filter(instrumento -> instrumento.getAutores().stream().filter(autores -> autores.equals(autor)).isParallel()).forEach(autores -> instrumento1.append(toString()));
        return instrumento1.toString();


    }

    /**
     * Método para buscar datos mediante el tipo
     * @param tipo
     */
    public String buscarPorTipo(String tipo)
    {
        StringBuilder instrumento1 = new StringBuilder();
        instrumentos.stream().filter(instrumento -> instrumento.getTipo().equals(tipo)).forEach(instrumento -> instrumento1.append(toString() + "\n"));
        return instrumento1.toString();

    }

    /**
     * Método para buscar datos mediante el problema
     */
    public String buscarPorProblema(String problema)
    {

        StringBuilder instrumento1 = new StringBuilder();
        instrumentos.stream().filter(instrumento -> instrumento.getProblemaMental().equals(problema)).forEach(instrumento -> instrumento1.append(toString() + "\n"));
        return instrumento1.toString();

    }

    /**
     * Método para buscar datos mediante la evaluación
     * @param evaluacion
     */
    public String buscarPorEvaluacion(boolean evaluacion)
    {
        StringBuilder instrumento1 = new StringBuilder();
        instrumentos.stream().filter(instrumento -> instrumento.isEvaluacion() == evaluacion).forEach(instrumento -> instrumento1.append(toString()));
        return instrumento1.toString();


    }


    /**
     * Método para buscar por referencia
     */
    public String buscarPorReferecnia(String referencia)
    {
        StringBuilder instrumento1 = new StringBuilder();
        instrumentos.stream().filter(instrumento -> instrumento.getReferencia() == Integer.parseInt(referencia)).forEach(instrumento -> instrumento1.append(toString()).append("\n"));
        return instrumento1.toString();

    }

    /**
     * Método para dejar todos los autores en una misma variable String
     * @param o1
     * @return
     */
    private String getString(Instrumento o1) {
        String autoresO1;
        if (o1.getAutores().size() > 1) {

            StringBuilder builder = new StringBuilder();
            for (String nombres : o1.getAutores()) {
                builder.append(nombres).append(" and ");
            }
            autoresO1 = builder.toString();

        } else {
            autoresO1 = o1.getAutores().getFirst();
        }
        return autoresO1;
    }

    /**
     * Método para saber si está vacio la colección
     * @return
     */
    public boolean isEmpty()
    {
        if (instrumentos.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * Método para saber el tamaño de la colección
     * @return
     */
    public int getSize()
    {
        return instrumentos.size();
    }

    /**
     * Método para saber si se encuentra tal objeto en la colección
     */
    public boolean contains()
    {
        return instrumentos.contains(null);
    }

    /**
     * Método para eliminar toda la colección
     */
    public void eliminarTodo()
    {
        instrumentos.clear();
    }
}
