import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {

        int op = 1;

        Scanner ans = new Scanner(System.in);

        System.out.println("Ingresa la cantidad máxima de almacenamiento de instrumentos");
        SistemaSaludMentalArreglo sistema = new SistemaSaludMentalArreglo(ans.nextInt());

        System.out.println("1) Registrar instrumento");
        System.out.println("2) Dar de baja un instrumento");
        System.out.println("3) Consulta general");
        System.out.println("4) Buscar por clave");
        System.out.println("5) Salir");

        do {
            System.out.println("Ingresa una opcion");
            op = ans.nextInt();
            ans.nextLine();
            switch (op) {
                case 1:
                    System.out.println("Ingresa el nombre del instrumento: ");
                    String nombreInstrumento = ans.nextLine();
                    System.out.println("Ingresa el tipo de instrumento (Identificacion o manejo)");
                    String tipo = ans.next();
                    System.out.println("¿Su instrumento tiene confiabilidad y validez?(si/no)");
                    String evaluacion = ans.next();
                    System.out.println("Ingrese el año de referencia del instrumento");
                    int referencia = ans.nextInt();
                    System.out.println("Ingrese el problema mental(Estres/Ansiedad)");
                    String problema = ans.next();
                    System.out.println("¿Cuántos autores son?");
                    int numeroAutores = ans.nextInt();
                    ans.nextLine();
                    ArrayList<String> autores = new ArrayList<>(numeroAutores);
                    String autor;
                    for (int i = 0;i < numeroAutores; ++i) {
                        System.out.println("Ingresa el nombre del autor numero " + (i+1));
                        autor = ans.nextLine();
                        autores.add(autor);
                    }
                    sistema.registrar(nombreInstrumento,tipo, evaluacion.equals("si"), String.valueOf(referencia), problema, autores);
                    System.out.println("Registrado exitosamente");
                    break;
                case 2:
                    System.out.println("Ingresa el indice del instrumento");
                    int indice = ans.nextInt();
                    sistema.instrumentoBaja(indice);
                    System.out.println("Eliminado exitosamente");
                    break;
                case 3:
                    System.out.println(sistema.consultaGeneral());
                    break;
                case 4:
                    System.out.println("Ingresa la clave del instrumento");
                    int clave = ans.nextInt();
                    ans.nextLine();
                    System.out.println(sistema.buscarPorClave(clave));
                default:
                    System.out.println("Ingresa una opción valida");
            }
        } while (op != 5);
    }
}
