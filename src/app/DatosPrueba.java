package app;

import modelo.Estudiante;
import modelo.Solicitud;
import servicios.ServicioEstudiantes;
import servicios.ServicioAtencion;
import servicios.ServicioLaboratorios;
import servicios.ServicioSocial;

public class DatosPrueba {

    public static void cargarEstudiantes(
            ServicioEstudiantes estudiantes) {

        estudiantes.registrar(
                new Estudiante(50, "Ana", 20, 9.0));

        estudiantes.registrar(
                new Estudiante(30, "Beto", 21, 8.5));

        estudiantes.registrar(
                new Estudiante(70, "Carla", 20, 9.5));

        estudiantes.registrar(
                new Estudiante(20, "Diego", 19, 8.0));

        estudiantes.registrar(
                new Estudiante(40, "Elena", 21, 9.0));

        estudiantes.registrar(
                new Estudiante(60, "Luis", 20, 8.7));

        estudiantes.registrar(
                new Estudiante(80, "Maria", 22, 9.2));
    }

    public static void cargarSolicitudes(
            ServicioAtencion atencion) {

        atencion.registrarSolicitud(
                new Solicitud(1, 50, "Uso de computador"));

        atencion.registrarSolicitud(
                new Solicitud(2, 70, "Acceso al servidor"));

        atencion.registrarSolicitud(
                new Solicitud(3, 20, "Uso del laboratorio"));
    }

    public static void cargarTodo(
            ServicioEstudiantes estudiantes,
            ServicioAtencion atencion,
            ServicioLaboratorios laboratorios,
            ServicioSocial social) {

        cargarEstudiantes(estudiantes);
        cargarSolicitudes(atencion);
        laboratorios.cargarDatos();
        social.cargarDatos();
    }
}