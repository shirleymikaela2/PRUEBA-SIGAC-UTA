package pruebas;

import app.DatosPrueba;
import modelo.Estudiante;
import modelo.Solicitud;
import estructuras.VectorEstudiantes;

import servicios.ServicioEstudiantes;
import servicios.ServicioAtencion;
import servicios.ServicioLaboratorios;
import servicios.ServicioSocial;

public class PruebasSIGAC {

    private static int correctas = 0;
    private static int fallidas = 0;

    public static void main(String[] args) {

        ServicioEstudiantes estudiantes =
                new ServicioEstudiantes(100);

        ServicioAtencion atencion =
                new ServicioAtencion(estudiantes);

        ServicioLaboratorios laboratorios =
                new ServicioLaboratorios();

        ServicioSocial social =
                new ServicioSocial();

        DatosPrueba.cargarTodo(
                estudiantes, atencion,
                laboratorios, social);

        System.out.println("=== PRUEBAS SIGAC-UTA ===");

        // M1 - ESTUDIANTES
        System.out.println("\n--- M1 ---");

        verificar("Registrar siete estudiantes",
                estudiantes.getCantidad() == 7);

        verificar("Busqueda secuencial",
                estudiantes.buscar(50) != null);

        verificar("Rechazar matricula duplicada",
                !estudiantes.registrar(
                        new Estudiante(50, "Duplicado", 20, 8)));

        verificar("Rechazar estudiante nulo",
                !estudiantes.registrar(null));

        verificar("Buscar matricula inexistente",
                estudiantes.buscar(999) == null);

        verificar("Modificar estudiante",
                estudiantes.modificar(
                        50, "Ana", 21, 9.5));

        verificar("Datos sincronizados con ABB",
                estudiantes.buscarABB(50).getEdad() == 21);

        verificar("Eliminar matricula inexistente",
                !estudiantes.eliminar(999));

        VectorEstudiantes vector =
                new VectorEstudiantes(1);

        vector.registrar(
                new Estudiante(1, "Prueba", 20, 8));

        verificar("Control de vector lleno",
                !vector.registrar(
                        new Estudiante(2, "Prueba", 20, 8)));

        // M2 - PILAS Y COLAS
        System.out.println("\n--- M2 ---");

        verificar("Tres solicitudes pendientes",
                atencion.getCantidadPendientes() == 3);

        verificar("Rechazar solicitud duplicada",
                !atencion.registrarSolicitud(
                        new Solicitud(1, 50, "Duplicada")));

        verificar("Rechazar estudiante inexistente",
                !atencion.registrarSolicitud(
                        new Solicitud(4, 999, "Laboratorio")));

        verificar("FIFO: primera solicitud",
                tieneId(atencion.atenderSolicitud(), 1));

        verificar("FIFO: segunda solicitud",
                tieneId(atencion.atenderSolicitud(), 2));

        verificar("FIFO: tercera solicitud",
                tieneId(atencion.atenderSolicitud(), 3));

        verificar("Atender cola vacia",
                atencion.atenderSolicitud() == null);

        verificar("LIFO: recuperar solicitud 3",
                tieneId(atencion.deshacerAtencion(), 3));

        verificar("LIFO: recuperar solicitud 2",
                tieneId(atencion.deshacerAtencion(), 2));

        verificar("Dos solicitudes recuperadas",
                atencion.getCantidadPendientes() == 2);

        verificar("Detectar estudiante con solicitudes",
                atencion.tieneSolicitudes(50));

        // M3 - ARBOLES
        System.out.println("\n--- M3 ---");

        verificar("Busqueda mediante ABB",
                estudiantes.buscarABB(70) != null);

        verificar("ABB inicialmente valido",
                estudiantes.validarABB());

        System.out.println("Recorridos iniciales:");
        estudiantes.mostrarRecorridos();

        verificar("Eliminar nodo 30 con dos hijos",
                estudiantes.eliminar(30));

        verificar("Nodo eliminado del ABB",
                estudiantes.buscarABB(30) == null);

        verificar("Nodo eliminado del vector",
                estudiantes.buscar(30) == null);

        verificar("ABB valido tras eliminar",
                estudiantes.validarABB());

        System.out.println("Recorridos finales:");
        estudiantes.mostrarRecorridos();

        // M4 - GRAFOS
        System.out.println("\n--- M4 ---");

        verificar("Seis equipos registrados",
                laboratorios.getCantidadEquipos() == 6);

        verificar("Recorrido BFS",
                laboratorios.bfs("PC1").equals(
                        "PC1 SW1 PC3 SRV1 PC2"));

        verificar("Recorrido DFS",
                laboratorios.dfs("PC1").equals(
                        "PC1 SW1 SRV1 PC2 PC3"));

        verificar("PC4 no alcanzable",
                laboratorios.noAlcanzables("PC1")
                        .equals("PC4"));

        verificar("Rechazar arista duplicada",
                !laboratorios.conectar("PC1", "SW1", 5));

        verificar("Rechazar equipo inexistente",
                !laboratorios.conectar("PC1", "PC9", 5));

        verificar("Eliminar arista",
                laboratorios.desconectar("SW1", "SRV1"));

        verificar("Conectividad actualizada",
                laboratorios.noAlcanzables("PC1")
                        .equals("SRV1 PC2 PC4"));

        // M5 - RECOMENDACIONES
        System.out.println("\n--- M5 ---");

        String recomendaciones =
                social.recomendar("Ana");

        System.out.println(recomendaciones);

        verificar("Recomendar Diego con dos amigos",
                recomendaciones.contains(
                        "Diego | Amigos en comun: 2"));

        verificar("Recomendar Elena con un amigo",
                recomendaciones.contains(
                        "Elena | Amigos en comun: 1"));

        verificar("Orden correcto de recomendaciones",
                recomendaciones.indexOf("Diego") >= 0
                        && recomendaciones.indexOf("Elena")
                        > recomendaciones.indexOf("Diego"));

        verificar("Excluir amigos directos y usuario",
                !recomendaciones.contains("Beto")
                        && !recomendaciones.contains("Carla")
                        && !recomendaciones.contains(
                                "Ana | Amigos"));

        verificar("Rechazar amistad duplicada",
                !social.agregarAmistad("Ana", "Beto"));

        verificar("Usuario inexistente",
                social.recomendar("Pedro")
                        .equals("Usuario inexistente."));

        // RESULTADOS
        System.out.println("\n==========================");
        System.out.println("RESULTADOS FINALES");
        System.out.println("Correctas: " + correctas);
        System.out.println("Fallidas: " + fallidas);
        System.out.println("==========================");

        if (fallidas > 0) {
            System.exit(1);
        }
    }

    private static boolean tieneId(
            Solicitud solicitud, int id) {

        return solicitud != null
                && solicitud.getId() == id;
    }

    private static void verificar(
            String nombre, boolean resultado) {

        if (resultado) {

            correctas++;
            System.out.println("[OK] " + nombre);

        } else {

            fallidas++;
            System.out.println("[ERROR] " + nombre);
        }
    }
}