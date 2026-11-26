package servicios;

import modelo.Solicitud;
import modelo.Operacion;
import estructuras.ColaSolicitudes;
import estructuras.PilaHistorial;

public class ServicioAtencion {

    private final ColaSolicitudes cola;
    private final PilaHistorial historial;
    private final ServicioEstudiantes estudiantes;

    public ServicioAtencion(ServicioEstudiantes estudiantes) {

        this.estudiantes = estudiantes;
        cola = new ColaSolicitudes();
        historial = new PilaHistorial();
    }

    // Registrar solicitud de laboratorio
    public boolean registrarSolicitud(Solicitud solicitud) {

        if (solicitud == null) {
            return false;
        }

        if (solicitud.getId() <= 0) {
            return false;
        }

        if (solicitud.getDescripcion() == null
                || solicitud.getDescripcion().trim().isEmpty()) {
            return false;
        }

        // Verificar que el estudiante exista
        if (estudiantes.buscar(solicitud.getMatricula()) == null) {
            return false;
        }

        // Evitar solicitudes duplicadas
        if (cola.existe(solicitud.getId())
                || historial.existeSolicitud(solicitud.getId())) {
            return false;
        }

        return cola.encolar(solicitud);
    }

    // Atender solicitud en orden FIFO
    public Solicitud atenderSolicitud() {

        if (cola.estaVacia()) {
            return null;
        }

        Solicitud solicitud = cola.consultar();

        if (estudiantes.buscar(solicitud.getMatricula()) == null) {
            return null;
        }

        solicitud = cola.desencolar();

        Operacion operacion = new Operacion(
                "ATENCION", solicitud);

        historial.apilar(operacion);

        return solicitud;
    }

    // Deshacer ultima atencion en orden LIFO
    public Solicitud deshacerAtencion() {

        if (historial.estaVacia()) {
            return null;
        }

        Operacion operacion = historial.consultar();

        Solicitud solicitud = operacion.getSolicitud();

        if (estudiantes.buscar(solicitud.getMatricula()) == null) {
            return null;
        }

        if (!cola.agregarAlInicio(solicitud)) {
            return null;
        }

        historial.desapilar();

        return solicitud;
    }

    // Mostrar solicitudes pendientes
    public void mostrarPendientes() {

        System.out.println("\n=== SOLICITUDES PENDIENTES ===");

        cola.mostrar();
    }

    // Mostrar historial
    public void mostrarHistorial() {

        System.out.println("\n=== HISTORIAL DE ATENCIONES ===");

        historial.mostrar();
    }

    public int getCantidadPendientes() {
        return cola.getCantidad();
    }

    public int getCantidadAtendidas() {
        return historial.getCantidad();
    }

        public boolean tieneSolicitudes(int matricula) {

        return cola.contieneMatricula(matricula)
                || historial.contieneMatricula(matricula);
    }
}