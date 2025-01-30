import java.util.ArrayList;
import java.util.Scanner;

public class Instrumento {

    private String nombre;
    private String tipo;
    private ArrayList<String> autores;
    private boolean evaluacion;
    private int clave;
    private static int claveActual = 0;
    private String referencia;

    public Instrumento(String nombre, String tipo, boolean evaluacion, String referencia) {
        Scanner sc = new Scanner(System.in);

        this.nombre = nombre;
        this.tipo = tipo;
        this.evaluacion = evaluacion;
        this.referencia = referencia;

        claveActual++;
        clave = claveActual;

        System.out.println("Ingresa la cantidad de autores");
        int cantidadAutores = sc.nextInt();
        autores = new ArrayList<>(cantidadAutores);

        for (int i = 0; i < cantidadAutores; i++) {
            System.out.println("Ingresa el autor numero " + (i + 1));
            autores.add(sc.next());
        }
    }

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

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        for (String nombres : autores) {
            builder.append(nombres).append(" ");
        }
        String nombres = builder.toString();

        return "Nombre: " + nombre + "Tipo: " + nombres + "Evaluacion: " + (evaluacion ? "certificado" : "no certificado")  + "Clave: " + clave + "Referencia: " + referencia;
    }
}
