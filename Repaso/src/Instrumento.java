import java.util.ArrayList;
import java.util.Scanner;

//Clase que modela un instrumento para valorar la salud mental de un paciente
public class Instrumento {

    //Atributos de la clase
    private String nombre;
    private String tipo;
    private String problemaMental;
    private ArrayList<String> autores;
    private boolean evaluacion;
    private int clave;
    private static int claveActual = 0;
    private int referencia;

    /**
     * Constructor para la creación de un nuevo instrumento
     * @param nombre
     * @param tipo
     * @param evaluacion
     * @param referencia
     * @param problemaMental
     */
    public Instrumento(String nombre, String tipo, boolean evaluacion, int referencia, String problemaMental) {
        Scanner sc = new Scanner(System.in);

        this.nombre = nombre;
        this.tipo = tipo;
        this.problemaMental = problemaMental;
        this.evaluacion = evaluacion;
        this.referencia = referencia;

        claveActual++;
        clave = claveActual;

        System.out.println("Ingresa la cantidad de autores");
        int cantidadAutores = sc.nextInt();
        sc.nextLine();
        autores = new ArrayList<>(cantidadAutores);

        for (int i = 0; i < cantidadAutores; i++) {
            System.out.println("Ingresa el autor numero " + (i + 1));
            autores.add(sc.nextLine());
        }
    }

    /**
     * Constructor para la lectura de un instrumento ya hecho
     * @param nombre
     * @param tipo
     * @param evaluacion
     * @param referencia
     * @param problemaMental
     * @param autores
     * @param clave
     */
    public Instrumento(String nombre, String tipo, boolean evaluacion, int referencia, String problemaMental, String autores, int clave) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.problemaMental = problemaMental;
        this.evaluacion = evaluacion;
        this.referencia = referencia;
        this.autores = new ArrayList<>();
        this.clave = clave;
        String[] nombres = autores.split(" ");
        for (int i = 0; i < nombres.length; i++) {
            this.autores.add(nombres[i]);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Getters y setters de la clase

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<String> autores) {
        this.autores = autores;
    }

    public boolean isEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(boolean evaluacion) {
        this.evaluacion = evaluacion;
    }

    public int getClave() {
        return clave;
    }

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public String getProblemaMental() {
        return problemaMental;
    }

    public void setProblemaMental(String problemaMental) {
        this.problemaMental = problemaMental;
    }

    /**
     * Método que devuelve la información de la clase en String
     * @return
     */
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        for (String nombres : autores) {
            builder.append(nombres).append(" ");
        }
        String nombres = builder.toString();

        return "Nombre: " + nombre + " Tipo: " + tipo + " Autores: " + nombres + " Evaluacion: " + (evaluacion ? " certificado" : " no certificado")  + " Clave: " + clave + " Referencia: " + referencia + " Problema: " + problemaMental;
    }
}
