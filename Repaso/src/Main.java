import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void mai1n(String[] args) {

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
                    String tipo;
                    do {
                        tipo = sc.nextLine();
                        tipo = tipo.toLowerCase();
                        if (!tipo.equals("identificacion") && !tipo.equals("manejo")) {
                            System.out.println("Debes ingresar alguna de las dos opciones del tipo");
                        }
                    } while (!tipo.equals("identificacion") && !tipo.equals("manejo"));

                    System.out.println("¿La evaluación tiene validez y confiabilidad?");
                    String conf;
                    boolean evaluacion = false;
                    do {
                        conf = sc.nextLine();
                        if (!conf.equals("si") && !conf.equals("no")) {
                            System.out.println("Debe ser \"si\" o \"no\"");
                        } else {
                            conf = conf.toLowerCase();
                            evaluacion = conf.equals("si");
                        }
                    } while (!conf.equals("si") && !conf.equals("no"));

                    int referencia;
                    String salida;
                    while (true) {
                        System.out.println("Ingresa la fecha de referencia(año)");
                        salida = sc.next();

                        try {
                            referencia = Integer.parseInt(salida);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("No ingresaste un año");
                        }
                    }

                    System.out.println("Ingrese el problema a tratar(Estres/Ansiedad)");
                    String problema;
                    do {
                        problema = sc.nextLine();
                        problema = problema.toLowerCase();
                        if (!problema.equals("estres") && !problema.equals("ansiedad")) {
                            System.out.println("Debes ingresar alguno de los dos problemas");
                        }
                    } while (!problema.equals("estres") && !problema.equals("ansiedad"));

                    sistema.registrarInstrumento(nombre, tipo, evaluacion, String.valueOf(referencia), problema);
                    System.out.println("Registrado exitosamente");
                    break;
                case "c":
                    System.out.println("Ingresa la clave");
                    int clave;
                    do {
                        clave = sc.nextInt();
                        if (clave < 0 || clave > sistema.getSize()) {
                            System.out.println("Escoge una clave valida");
                        }
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
                        String opcion;
                        do {
                            opcion = sc.nextLine();
                            if (opcion.equals("si")) {
                                sistema.eliminarTodo();
                            }
                        } while (!opcion.equals("si") && !opcion.equals("no"));
                        sistema.leerArchivo(nombreArchivo1);

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
                            System.out.println(sistema.buscarPorInstrumento(nombreInstrumento));
                            break;
                        case "b":
                            System.out.println("Ingresa el nombre de un autor o el autor");
                            String nombreAutor = sc.nextLine();
                            System.out.println(sistema.buscarPorAutor(nombreAutor));
                            break;
                        case "c":
                            System.out.println("Ingresa si la evaluación tiene confiabilidad y validez");
                            String conf1;
                            do {
                                conf1 = sc.next().toLowerCase();
                            } while (!conf1.equals("si") && !conf1.equals("no"));
                            boolean evaluacion1 = conf1.equals("si");
                            System.out.println(sistema.buscarPorEvaluacion(evaluacion1));
                            break;
                        case "d":
                            System.out.println("Ingresa la cita de referencia");

                            String salida1;
                            int referencia1;
                            while (true) {
                                salida1 = sc.next();
                                try {
                                     referencia1 = Integer.parseInt(salida1);
                                     break;
                                } catch (NumberFormatException e) {
                                    System.out.println("No es un numero");
                                }
                            }
                            System.out.println(sistema.buscarPorReferecnia(String.valueOf(referencia1)));
                            break;
                        case "e":
                            System.out.println("Ingresa el problema");
                            String problema1;
                            do {
                                problema1 = sc.nextLine();
                                if (!problema1.equals("ansiedad") && !problema1.equals("estres")) {
                                    System.out.println("Debes ingresar un problema valido");
                                }
                            } while (!problema1.equals("ansiedad") && !problema1.equals("estres"));
                            System.out.println(sistema.buscarPorProblema(problema1));
                            break;
                        case "f":
                            System.out.println("Ingrese el tipo de instrumento(Identificacion/manejo)");
                            String identificacion1;
                            do {
                                identificacion1 = sc.next();
                                if (!identificacion1.equals("identificacion") && !identificacion1.equals("manejo")) {
                                    System.out.println("Debes ingresar un tipo valido");
                                }
                            } while (!identificacion1.equals("identificacion") && !identificacion1.equals("manejo"));
                            System.out.println(sistema.buscarPorTipo(identificacion1));
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