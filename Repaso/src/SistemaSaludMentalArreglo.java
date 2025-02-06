import java.util.ArrayList;

//Clase que modela el control de instrumentos solamente en arreglos
public class SistemaSaludMentalArreglo {

    //Atributo
    private Instrumento[] instrumentos;
    //Contador será utilizado para controlar la entrada y salida de datos
    private int contador;
    private static int clave = 0;

    /**
     * Constructor preterminado donde solamente inicializa el arreglo y contador
     * @param numeroInstrumentos
     */
    public SistemaSaludMentalArreglo(int numeroInstrumentos)
    {
        instrumentos = new Instrumento[numeroInstrumentos];
        contador = 0;
    }

    /**
     * Aquí se registra un nuevo instrumento
     * @param nombre
     * @param tipo
     * @param evaluacion
     * @param referencia
     * @param problemaMental
     * @param autores
     */
    public void registrar(String nombre, String tipo, boolean evaluacion, String referencia, String problemaMental, ArrayList<String> autores)
    {
        //Si el contador es menor al tamaño del arreglo, entonces aún hay más espacio
        if (contador < instrumentos.length) {

            //Se crea un StrinBuildaer para poder almacenar en un mismo String todos los autores
            StringBuilder autoresString = new StringBuilder();

            //Por cada String que esté en la colección de autores, se agregará a la lista
            for (String autor : autores) {
                autoresString.append(autor + " ");
            }

            //Ya por ultimo se almacena
            instrumentos[contador] = new Instrumento( nombre,  tipo, evaluacion, Integer.parseInt(referencia), problemaMental, autoresString.toString(), clave);
        }
        ++contador;
    }

    /**
     * Eliminar un instrumento
     * @param indice
     */
    public void instrumentoBaja(int indice) {

        //Como no tenemos un método explícito para eliminar se procede a usar ciclos.
        //Como punto de partida iniciamos donde queremos borrar el elemento y terminará un elemento antes del tamaño del arreglo
        //Esto para que no haya errores en el bucle a la hora de asignar algo en un indice fuera del tamaño en indice + 1
        for (int i = indice; i < contador - 1; i++) {

            //Simplemente tomamos el elemento posterior al elemento actual
            instrumentos[indice] = instrumentos[indice + 1];
        }
        //Ya después como nos queda un valor repetido al ultimo simplemente le asignamos un null.
        //Habrá veces que el contador esté en 10 y cuando queramos acceder al ultimo valor repetido no dará error, por
        //esto mismo la validación
        --contador;
    }

    /**
     * Método para obtener todo el listado de insturmentos regresado como String
     * @return
     */
    public String consultaGeneral()
    {
        StringBuilder consulta = new StringBuilder();
        for (int i = 0; i < contador; i++) {
            consulta.append(i + " " + instrumentos[i].toString() + "\n");
        }
        return consulta.toString();
    }

    /**
     * Método para obtener un instrumento específico de acuerdo a la clave
     * @param clave
     * @return
     */
    public String buscarPorClave(int clave)
    {
        String instrumento = "";
        for (int i = 0; i < contador; i++) {
            if (instrumentos[i].getClave() == clave) {
                instrumento = instrumentos[i].toString();
            }
        }
        return instrumento;
    }
}
