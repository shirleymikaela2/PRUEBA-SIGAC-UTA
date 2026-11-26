package app;

import java.util.Scanner;

import modelo.Estudiante;
import modelo.Equipo;
import modelo.Solicitud;

import servicios.ServicioEstudiantes;
import servicios.ServicioAtencion;
import servicios.ServicioLaboratorios;
import servicios.ServicioSocial;

public class Main {

    private static final Scanner teclado =
            new Scanner(System.in);

    private static final ServicioEstudiantes estudiantes =
            new ServicioEstudiantes(100);

    private static final ServicioAtencion atencion =
            new ServicioAtencion(estudiantes);

    private static final ServicioLaboratorios laboratorios =
            new ServicioLaboratorios();

    private static final ServicioSocial social =
            new ServicioSocial();

    private static boolean datosCargados = false;

    public static void main(String[] args) {

        int opcion;

        do {

            System.out.println("\n==========================");
            System.out.println("       SIGAC - UTA");
            System.out.println("==========================");
            System.out.println("1. Gestion de estudiantes");
            System.out.println("2. Solicitudes e historial");
            System.out.println("3. Organizacion academica");
            System.out.println("4. Red de laboratorios");
            System.out.println("5. Red social");
            System.out.println("6. Cargar datos de prueba");
            System.out.println("0. Salir");

            opcion = leerEntero("Seleccione: ");

            switch (opcion) {

                case 1:
                    menuEstudiantes();
                    break;

                case 2:
                    menuAtencion();
                    break;

                case 3:
                    menuArboles();
                    break;

                case 4:
                    menuLaboratorios();
                    break;

                case 5:
                    menuSocial();
                    break;

                case 6:

                    if (datosCargados) {
                        System.out.println(
                                "Los datos ya fueron cargados.");
                    } else {

                        DatosPrueba.cargarTodo(
                                estudiantes, atencion,
                                laboratorios, social);

                        datosCargados = true;

                        System.out.println(
                                "Datos de prueba cargados.");
                    }

                    break;

                case 0:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opcion incorrecta.");
            }

        } while (opcion != 0);

        teclado.close();
    }

    // M1 - ESTUDIANTES
    private static void menuEstudiantes() {

        int opcion;

        do {

            System.out.println("\n=== ESTUDIANTES ===");
            System.out.println("1. Registrar");
            System.out.println("2. Listar vector");
            System.out.println("3. Listar lista enlazada");
            System.out.println("4. Buscar");
            System.out.println("5. Modificar");
            System.out.println("6. Eliminar");
            System.out.println("7. Comparar busquedas");
            System.out.println("0. Regresar");

            opcion = leerEntero("Seleccione: ");

            switch (opcion) {

                case 1:

                    Estudiante nuevo = new Estudiante(
                            leerEntero("Matricula: "),
                            leerTexto("Nombre: "),
                            leerEntero("Edad: "),
                            leerDecimal("Promedio: "));

                    mostrarResultado(
                            estudiantes.registrar(nuevo));

                    break;

                case 2:
                    estudiantes.listarVector();
                    break;

                case 3:
                    estudiantes.listarLista();
                    break;

                case 4:

                    Estudiante encontrado =
                            estudiantes.buscar(
                                    leerEntero("Matricula: "));

                    System.out.println(
                            encontrado == null
                                    ? "Estudiante inexistente."
                                    : encontrado);

                    break;

                case 5:

                    mostrarResultado(
                            estudiantes.modificar(
                                    leerEntero("Matricula: "),
                                    leerTexto("Nuevo nombre: "),
                                    leerEntero("Nueva edad: "),
                                    leerDecimal("Nuevo promedio: ")));

                    break;

                case 6:

                    int matricula =
                            leerEntero("Matricula: ");

                    if (atencion.tieneSolicitudes(matricula)) {

                        System.out.println(
                                "El estudiante tiene solicitudes asociadas.");

                    } else {

                        mostrarResultado(
                                estudiantes.eliminar(matricula));
                    }

                    break;

                case 7:

                    estudiantes.compararBusquedas(
                            leerEntero("Matricula: "));

                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opcion incorrecta.");
            }

        } while (opcion != 0);
    }

    // M2 - PILA Y COLA
    private static void menuAtencion() {

        int opcion;

        do {

            System.out.println("\n=== ATENCION ===");
            System.out.println("1. Registrar solicitud");
            System.out.println("2. Atender solicitud FIFO");
            System.out.println("3. Deshacer atencion LIFO");
            System.out.println("4. Mostrar pendientes");
            System.out.println("5. Mostrar historial");
            System.out.println("0. Regresar");

            opcion = leerEntero("Seleccione: ");

            switch (opcion) {

                case 1:

                    Solicitud solicitud = new Solicitud(
                            leerEntero("ID solicitud: "),
                            leerEntero("Matricula: "),
                            leerTexto("Descripcion: "));

                    mostrarResultado(
                            atencion.registrarSolicitud(solicitud));

                    break;

                case 2:

                    Solicitud atendida =
                            atencion.atenderSolicitud();

                    System.out.println(
                            atendida == null
                                    ? "No hay solicitud disponible."
                                    : "Atendida: " + atendida);

                    break;

                case 3:

                    Solicitud recuperada =
                            atencion.deshacerAtencion();

                    System.out.println(
                            recuperada == null
                                    ? "No hay operacion reversible."
                                    : "Recuperada: " + recuperada);

                    break;

                case 4:
                    atencion.mostrarPendientes();
                    break;

                case 5:
                    atencion.mostrarHistorial();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opcion incorrecta.");
            }

        } while (opcion != 0);
    }

    // M3 - ARBOLES
    private static void menuArboles() {

        int opcion;

        do {

            System.out.println("\n=== ORGANIZACION ACADEMICA ===");
            System.out.println("1. Mostrar jerarquia");
            System.out.println("2. Mostrar recorridos ABB");
            System.out.println("3. Buscar mediante ABB");
            System.out.println("4. Validar ABB");
            System.out.println("0. Regresar");

            opcion = leerEntero("Seleccione: ");

            switch (opcion) {

                case 1:
                    estudiantes.mostrarJerarquia();
                    break;

                case 2:
                    estudiantes.mostrarRecorridos();
                    break;

                case 3:

                    Estudiante encontrado =
                            estudiantes.buscarABB(
                                    leerEntero("Matricula: "));

                    System.out.println(
                            encontrado == null
                                    ? "Estudiante inexistente."
                                    : encontrado);

                    break;

                case 4:

                    System.out.println(
                            "ABB valido: "
                                    + estudiantes.validarABB());

                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opcion incorrecta.");
            }

        } while (opcion != 0);
    }

    // M4 - GRAFO DE LABORATORIOS
    private static void menuLaboratorios() {

        int opcion;

        do {

            System.out.println("\n=== LABORATORIOS ===");
            System.out.println("1. Registrar equipo");
            System.out.println("2. Crear conexion");
            System.out.println("3. Eliminar conexion");
            System.out.println("4. Mostrar red");
            System.out.println("5. Recorrido BFS");
            System.out.println("6. Recorrido DFS");
            System.out.println("7. Equipos no alcanzables");
            System.out.println("8. Eliminar equipo");
            System.out.println("0. Regresar");

            opcion = leerEntero("Seleccione: ");

            switch (opcion) {

                case 1:

                    Equipo equipo = new Equipo(
                            leerTexto("Codigo: "),
                            leerTexto("Tipo: "));

                    mostrarResultado(
                            laboratorios.registrarEquipo(equipo));

                    break;

                case 2:

                    mostrarResultado(
                            laboratorios.conectar(
                                    leerTexto("Origen: "),
                                    leerTexto("Destino: "),
                                    leerEntero("Peso: ")));

                    break;

                case 3:

                    mostrarResultado(
                            laboratorios.desconectar(
                                    leerTexto("Origen: "),
                                    leerTexto("Destino: ")));

                    break;

                case 4:
                    laboratorios.mostrarRed();
                    break;

                case 5:

                    System.out.println(
                            laboratorios.bfs(
                                    leerTexto("Inicio: ")));

                    break;

                case 6:

                    System.out.println(
                            laboratorios.dfs(
                                    leerTexto("Inicio: ")));

                    break;

                case 7:

                    System.out.println(
                            laboratorios.noAlcanzables(
                                    leerTexto("Inicio: ")));

                    break;

                case 8:

                    mostrarResultado(
                            laboratorios.eliminarEquipo(
                                    leerTexto("Codigo: ")));

                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opcion incorrecta.");
            }

        } while (opcion != 0);
    }

    // M5 - RED SOCIAL
    private static void menuSocial() {

        int opcion;

        do {

            System.out.println("\n=== RED SOCIAL ===");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Agregar amistad");
            System.out.println("3. Eliminar amistad");
            System.out.println("4. Mostrar red");
            System.out.println("5. Recomendar contactos");
            System.out.println("6. Eliminar usuario");
            System.out.println("0. Regresar");

            opcion = leerEntero("Seleccione: ");

            switch (opcion) {

                case 1:

                    mostrarResultado(
                            social.registrarUsuario(
                                    leerTexto("Nombre: ")));

                    break;

                case 2:

                    mostrarResultado(
                            social.agregarAmistad(
                                    leerTexto("Usuario 1: "),
                                    leerTexto("Usuario 2: ")));

                    break;

                case 3:

                    mostrarResultado(
                            social.eliminarAmistad(
                                    leerTexto("Usuario 1: "),
                                    leerTexto("Usuario 2: ")));

                    break;

                case 4:
                    social.mostrarRed();
                    break;

                case 5:

                    System.out.println(
                            social.recomendar(
                                    leerTexto("Usuario: ")));

                    break;

                case 6:

                    mostrarResultado(
                            social.eliminarUsuario(
                                    leerTexto("Usuario: ")));

                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opcion incorrecta.");
            }

        } while (opcion != 0);
    }

    // VALIDACIONES
    private static int leerEntero(String mensaje) {

        while (true) {

            System.out.print(mensaje);

            try {

                return Integer.parseInt(
                        teclado.nextLine().trim());

            } catch (NumberFormatException error) {

                System.out.println(
                        "Ingrese un numero entero valido.");
            }
        }
    }

    private static double leerDecimal(String mensaje) {

        while (true) {

            System.out.print(mensaje);

            try {

                double valor = Double.parseDouble(
                        teclado.nextLine().trim()
                                .replace(',', '.'));

                if (Double.isFinite(valor)) {
                    return valor;
                }

            } catch (NumberFormatException error) {
                // Se solicita nuevamente el dato
            }

            System.out.println(
                    "Ingrese un numero decimal valido.");
        }
    }

    private static String leerTexto(String mensaje) {

        System.out.print(mensaje);

        return teclado.nextLine().trim();
    }

    private static void mostrarResultado(boolean resultado) {

        if (resultado) {
            System.out.println("Operacion exitosa.");
        } else {
            System.out.println(
                    "Operacion rechazada. Verifique los datos.");
        }
    }
}