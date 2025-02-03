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
                //Por ultimo cada variable del instrumento, se guardará en el archivo separadas por comas, justamente declarando los getters de la clase Instrumento
                writer.write(instrumento.getNombre() + "," + instrumento.getTipo() + "," + instrumento.isEvaluacion() + "," + instrumento.getReferencia() + "," + instrumento.getProblemaMental() + "," + autores + "," + instrumento.getClave());
                //nueva linea para el siguiente instrumento
                writer.newLine();
            }
            //Se cierra el vinculo del archivo
            writer.close();

            //En caso de tener un error, se dirje aquí en este caso por si hubo un error al crear el archivo
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Método para leer datos de un archivo
     */
    public void leerArchivo(String nombreArchivo)
    {
        //Se crea una variable tipo strin para poder guardar los datos leidos
        String linea;
        try {
            //Se crea el vínculo para lectura que es con BufferedReader
            BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));

            //Esta línea es fundamental para la lectura, básicamente parará de leer del archivo hasta que sea null
            //que en este contexto es cuando haya nada más que leer
            while ((linea = reader.readLine()) != null) {

                //Una vez leída la línea, se separa con el método split de String. Lo separamos con comas.
                String[] contenido = linea.split(",");

                //Una vez separada, es importante saber como inicia el constructor de instrumentos para poder repartir la información verdadera en la nueva instancia
                instrumentos.add(new Instrumento(contenido[0], contenido[1], (contenido[2].equals("true")), Integer.parseInt(contenido[3]), contenido[4], contenido[5], Integer.parseInt(contenido[6])));
            }
            //Se cierra el vinculo de lectura
            reader.close();

            //En dado caso que no se encuentre el libro simplemente arroja un error
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
            //En tal caso que hubiera otro error
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Método para ordenar los datos por clave
     */
    public void ordenarPorClave()
    {
        //Utilizamos del método sort para poder usar un lambda y ordenar los datos por clave, en el parametro arrojamos
        //un nuevo comparador
        instrumentos.sort(new Comparator<Instrumento>() {
            @Override
            //Se compara, los dos atributos seleccionados(clave) para poder determinar cual se acomodará primero
            public int compare(Instrumento o1, Instrumento o2) {
                //método comparativo y el retorno
                return Integer.compare(o1.getClave(), o2.getClave());
            }
        });
    }

    /**
     * Método para ordenar los instrumentos por autor
     */
    public void ordenarPorAutor()
    {
        //Al igual que con clave, es lo mismo con autor solamente que aquí se acomoda diferente por que ha que tener en
        //cuenta que tenemos que ordenar también los datos que están dentro la colección de autores
        instrumentos.sort(new Comparator<Instrumento>() {
            @Override
            public int compare(Instrumento o1, Instrumento o2) {

                //Lo que se hace en un método aparte, regresar en String los autores ya ordenados y nuevamente compararlos
                String autoresO1 = getString(o1);
                String autoresO2 = getString(o2);

                //Por ultimo retornamos la comparación entre los dos Strings(autores)
                return autoresO1.compareToIgnoreCase(autoresO2);
            }
        });
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Métodos buscadores, es decir que de acuerdo a lo que decida el usuario se mostrarán los instrumentos con tal dato
    //solicitado por el usuario. Los método constan de un ciclo for each, que pasan por una condición(dato solicitado) y
    //si es justamente lo que quieren visualizar los usuarios se imprimirá. Cabe mencionar que los datos pueden ser
    //varios y no solamente un dato especifico.

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

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Método para dejar todos los autores en una misma variable String
     * @param o1
     * @return
     */
    //Como se mencionó en el método para ordenar por autores, se necesita de otro método
    private String getString(Instrumento o1) {

        //Creamos una variable donde almacenar los autores y condicionamos si hay más de un autor
        String autoresO1;
        if (o1.getAutores().size() > 1) {

            //Creamos el Strin builder donde se estará agregando cada autor
            StringBuilder builder = new StringBuilder();

            //Por cada autor de la colección se agregará en el StringBuilder
            for (String nombres : o1.getAutores()) {
                builder.append(nombres).append(" and ");
            }
            //Ya por ultimo guardamos el builder final en la variable creada anteriormente
            autoresO1 = builder.toString();

            //Si solo es un autor simplemente el dato se guarda directamente a la variable creada
        } else {
            autoresO1 = o1.getAutores().getFirst();
        }
        //regresamos el String
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
