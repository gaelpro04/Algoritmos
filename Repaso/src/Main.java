import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String op = "a";
        SistemaSaludMental sistema = new SistemaSaludMental();
        System.out.println("SISTEMA DE SALUD MENTAL\n");

        System.out.println("a) Consultar datos");
        System.out.println("b) Registrar");
        System.out.println("c) Eliminar por clave");
        System.out.println("d) Guardar en archivo");
        System.out.println("e) Leer archivo");
        System.out.println("f) Ordenar por clave");
        System.out.println("g) Ordenar por autor");
        System.out.println("h) Consultar datos especificos");
        System.out.println("i) Salir");

        while (!op.equals("i")) {
            System.out.println("Ingresa una opcion");
            Scanner sc = new Scanner(System.in);
            op = sc.nextLine();

            switch (op) {
                case "a":
                    if (sistema.isEmpty()) {
                        System.out.println("No se encontraron datos");
                    } else {
                        sistema.consultarTodos();
                    }
                    break;
                case "b":
                    System.out.println("Ingrese el nombre del instrumento");
                    String nombre = sc.nextLine();
                    nombre = nombre.toUpperCase();
                    System.out.println("Ingrese el tipo de instrumento(Identificación/manejo)");
                    String tipo = sc.nextLine();
                    tipo = tipo.toUpperCase();
                    System.out.println("¿La evaluación tiene validez y confiabilidad?");
                    String conf = sc.nextLine();
                    conf = conf.toLowerCase();
                    boolean evaluacion = conf.equals("si");
                    System.out.println("¿Cuando fue la cita de referencia?");
                    String referencia = sc.nextLine();
                    referencia = referencia.toLowerCase();
                    System.out.println("Ingrese el problema a tratar(Estres/Ansiedad)");
                    String problema = sc.nextLine();
                    problema = problema.toLowerCase();

                    sistema.registrarInstrumento(nombre, tipo, evaluacion, referencia, problema);
                    System.out.println("Registrado exitosamente");
                    break;
                case "c":
                    System.out.println("Ingresa la clave");
                    int clave;
                    do {
                        clave = sc.nextInt();
                    } while (clave < 0 || clave > sistema.getSize());

                    sistema.eliminarPorClave(clave);
                    System.out.println("Eliminado exitosamente");
                    break;
                case "d":
                    System.out.println("Ingresa el nombre del archivo para guardarlo");
                    String nombreArchivo = sc.nextLine();
                    sistema.guardarEnArchivo(nombreArchivo);
                    System.out.println("Guardado exitosamente");
                    break;
                case "e":
                    System.out.println("Ingresa el nombre del archivo a leer");
                    String nombreArchivo1 = sc.nextLine();
                    if (!sistema.isEmpty()) {
                        System.out.println("¿Deseas sobreescribir los datos actuales del sistema?");
                        String opcion = sc.nextLine();
                        if (opcion.equals("si")) {
                            sistema.eliminarTodo();
                        } else {
                            sistema.leerArchivo(nombreArchivo1);
                        }
                    } else {
                        sistema.leerArchivo(nombreArchivo1);
                    }
                    break;
                case "f":
                    sistema.ordenarPorClave();
                    break;
                case "g":
                    sistema.ordenarPorAutor();
                    break;
                case "h":
                    System.out.println("Ingrese por que dato quiere consultar los datos");
                    System.out.println("a) Nombre");
                    System.out.println("b) Autores");
                    System.out.println("c) Evaluacion");
                    System.out.println("d) Referencia");
                    System.out.println("e) Problema");
                    System.out.println("f) Tipo");
                    System.out.println("g) Regresar");

                    String op2 = sc.nextLine();
                    op2 = op2.toLowerCase();

                    switch (op2) {
                        case "a":
                            System.out.println("Ingresa el nombre del instrumento");
                            String nombreInstrumento = sc.nextLine();
                            sistema.buscarPorInstrumento(nombreInstrumento);
                            break;
                        case "b":
                            System.out.println("Ingresa el nombre de un autor o el autor");
                            String nombreAutor = sc.nextLine();
                            sistema.buscarPorAutor(nombreAutor);
                            break;
                        case "c":
                            System.out.println("Ingresa si la evaluación tiene confiabilidad y validez");
                            boolean evaluacion1 = sc.nextLine().toLowerCase().equals("si");
                            sistema.buscarPorEvaluacion(evaluacion1);
                            break;
                        case "d":
                            System.out.println("Ingresa la cita de referencia");
                            String referencia1 = sc.nextLine();
                            sistema.buscarPorReferecnia(referencia1);
                            break;
                        case "e":
                            System.out.println("Ingresa el problema");
                            String problema1 = sc.nextLine();
                            sistema.buscarPorProblema(problema1);
                            break;
                        case "f":
                            System.out.println("Ingrese el tipo de instrumento(Identificacion/ansiedad)");
                            String identificacion = sc.next();
                            sistema.buscarPorTipo(identificacion);
                            break;
                        case "g":
                            break;
                        default:
                            System.out.println("debes ingresar una opción valida");

                    }
            }
        }


    }
}