import java.util.ArrayList;
import java.util.Comparator;
import java.io.*;

//Clase que modela el control de una colección de instrumentos
public class SistemaSaludMental {

    //Atributo
    private ArrayList<Instrumento> instrumentos;

    /**
     * Constructor para iniciar la coleccion
     */
    public SistemaSaludMental()
    {
        instrumentos = new ArrayList<>();
    }

    /**
     * Método para consultar todos los datos de cada instrumento
     */
    public void consultarTodos()
    {
        //Contador para enumerar cada impresión
        int contador = 0;

        //Por cada instrumento de la colección se imprimirá en consola con un numero especifico
        for (Instrumento instrumento : instrumentos) {

            contador++;
            System.out.println(contador + "]" + instrumento.toString());
        }
    }

    /**
     * Método para registrar un instrumento
     */
    public void registrarInstrumento(String nombre, String tipo, boolean evaluacion, int referencia, String problemaMental)
    {
        //Solo creamos una nueva instancia en la colección de un nuevo objeto tipo Instrumento
        instrumentos.add(new Instrumento(nombre, tipo, evaluacion, referencia, problemaMental));
    }

    /**
     * Método para eliminar un dato por la clave
     */
    public void eliminarPorClave(int clave)
    {
        //Se utiliza de lambdas para poder eliminar más facilmente el instrumento
        //Se guía por filtro, donde pedimos que información filtrar de la colección(la clave que estamos buscando) y aplicamos
        //el método forEach, que por cada elemento con tal filtro, se removerá de la lista
        instrumentos.stream().filter(instrumento -> clave == instrumento.getClave()).forEach(instrumento -> instrumentos.remove(instrumento));
    }

    /**
     * Método para guardar los datos en un archivo
     */
    public void guardarEnArchivo(String nombreArchivo)
    {
        //Comenzamos con un try en dado caso que haya un error de escritura
        try {
            //Iniciamos la instancia del flujo que podrá conectar el archivo con su escritura, además en el constructor de
            //FileWriter ponemos false para que no agregue en dado caso de que ya exista
            BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo,false));

            //El String builder es para poder crear una variable donde podamos ser valida la lectura posterior de un archivo del atributo autores
            StringBuilder builder = new StringBuilder();

            //Por cada Instrumento de la colección, se guardará cada autor de ese instrumento en el StringBuilder
            for (Instrumento instrumento : instrumentos) {
                for (String autor : instrumento.getAutores()) {
                    builder.append(autor).append(" ");
                }
                String autores = builder.toString();
                //Por ultimo cada variable del instrumento, se guardará en el archivo separadas por comas
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
    public void buscarPorInstrumento(String instrumentoNombre)
    {
        int cont = 0;
        for (Instrumento instrumento : instrumentos) {
            if (instrumento.getNombre().equals(instrumentoNombre)) {
                System.out.println(instrumento);
                ++cont;
            }
        }
        if (cont == 0) {
            System.out.println("No se encuentran instrumentos con esa especificación");
        }
    }

    /**
     * Método que busca todo los instrumentos por el nombre del autor
     * @param autor
     */
    public void buscarPorAutor(String autor)
    {
        int cont = 0;
        for (Instrumento instrumento : instrumentos) {
            for (String autores : instrumento.getAutores()) {
                if (autores.equals(autor)) {
                    System.out.println(instrumento);
                    ++cont;
                }
            }
        }

        if (cont == 0) {
            System.out.println("No se encuentran instrumentos con esa especificación");
        }
    }

    /**
     * Método para buscar datos mediante el tipo
     * @param tipo
     */
    public void buscarPorTipo(String tipo) {

        int cont = 0;
        for (Instrumento instrumento : instrumentos) {
            if (instrumento.getTipo().equals(tipo)) {
                System.out.println(instrumento);
                ++cont;
            }
        }

        if (cont == 0) {
            System.out.println("No se encuentran instrumentos con esa especificación");
        }
    }

    /**
     * Método para buscar datos mediante el problema
     */
    public void buscarPorProblema(String problema)
    {
        int cont = 0;
        for (Instrumento instrumento : instrumentos) {
            if (instrumento.getProblemaMental().equals(problema)) {
                System.out.println(instrumento);
                ++cont;
            }
        }

        if (cont == 0) {
            System.out.println("No se encuentran instrumentos con esa especificación");
        }
    }

    /**
     * Método para buscar datos mediante la evaluación
     * @param evaluacion
     */
    public void buscarPorEvaluacion(boolean evaluacion)
    {
        int cont = 0;
        for (Instrumento instrumento : instrumentos) {
            if (evaluacion == instrumento.isEvaluacion()) {
                System.out.println(instrumento);
                ++cont;
            }
        }

        if (cont == 0) {
            System.out.println("No se encuentran instrumentos con esa especificación");
        }
    }


    /**
     * Método para buscar por referencia
     */
    public void buscarPorReferecnia(int referencia)
    {
        int cont = 0;
        for (Instrumento instrumento : instrumentos) {
            if (instrumento.getReferencia() == referencia) {
                System.out.println(instrumento);
                ++cont;
            }
        }

        if (cont == 0) {
            System.out.println("No se encuentran instrumentos con esa especificación");
        }
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
