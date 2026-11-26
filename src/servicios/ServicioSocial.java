package servicios;

import estructuras.GrafoDinamico;
import estructuras.Recomendador;

public class ServicioSocial {

    private final GrafoDinamico redSocial;

    public ServicioSocial() {

        // Grafo no dirigido
        redSocial = new GrafoDinamico(false);
    }

    // Registrar usuario
    public boolean registrarUsuario(String nombre) {
        return redSocial.insertarVertice(nombre);
    }

    // Registrar amistad
    public boolean agregarAmistad(String usuario1,
                                  String usuario2) {

        return redSocial.crearConexion(
                usuario1, usuario2, 1);
    }

    // Eliminar amistad
    public boolean eliminarAmistad(String usuario1,
                                   String usuario2) {

        return redSocial.eliminarConexion(
                usuario1, usuario2);
    }

    // Eliminar usuario
    public boolean eliminarUsuario(String nombre) {
        return redSocial.eliminarVertice(nombre);
    }

    // Recomendar contactos
    public String recomendar(String usuario) {

        return Recomendador.recomendar(
                redSocial, usuario);
    }

    // Mostrar amistades
    public void mostrarRed() {
        redSocial.mostrar();
    }

    // Cargar datos del caso integrador
    public void cargarDatos() {

        registrarUsuario("Ana");
        registrarUsuario("Beto");
        registrarUsuario("Carla");
        registrarUsuario("Diego");
        registrarUsuario("Elena");

        agregarAmistad("Ana", "Beto");
        agregarAmistad("Ana", "Carla");
        agregarAmistad("Beto", "Diego");
        agregarAmistad("Carla", "Diego");
        agregarAmistad("Carla", "Elena");
    }
}