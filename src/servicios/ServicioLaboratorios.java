package servicios;

import modelo.Equipo;
import estructuras.GrafoDinamico;
import estructuras.RecorridosGrafo;

public class ServicioLaboratorios {

    private final GrafoDinamico red;

    public ServicioLaboratorios() {
        red = new GrafoDinamico(true);
    }

    // Registrar equipo
    public boolean registrarEquipo(Equipo equipo) {

        if (equipo == null
                || equipo.getTipo() == null
                || equipo.getTipo().trim().isEmpty()) {
            return false;
        }

        return red.insertarVertice(equipo.getCodigo());
    }

    // Crear conexion ponderada
    public boolean conectar(String origen,
                            String destino,
                            int peso) {

        return red.crearConexion(origen, destino, peso);
    }

    // Eliminar conexion
    public boolean desconectar(String origen,
                               String destino) {

        return red.eliminarConexion(origen, destino);
    }

    // Eliminar equipo
    public boolean eliminarEquipo(String codigo) {
        return red.eliminarVertice(codigo);
    }

    // Recorrido BFS
    public String bfs(String inicio) {
        return RecorridosGrafo.bfs(red, inicio);
    }

    // Recorrido DFS
    public String dfs(String inicio) {
        return RecorridosGrafo.dfs(red, inicio);
    }

    // Equipos no alcanzables
    public String noAlcanzables(String inicio) {
        return RecorridosGrafo.noAlcanzables(red, inicio);
    }

    // Mostrar red
    public void mostrarRed() {
        red.mostrar();
    }

    public int getCantidadEquipos() {
        return red.getCantidadVertices();
    }

    // Cargar datos del caso obligatorio
    public void cargarDatos() {

        registrarEquipo(new Equipo("PC1", "Computador"));
        registrarEquipo(new Equipo("SW1", "Switch"));
        registrarEquipo(new Equipo("SRV1", "Servidor"));
        registrarEquipo(new Equipo("PC2", "Computador"));
        registrarEquipo(new Equipo("PC3", "Computador"));
        registrarEquipo(new Equipo("PC4", "Computador"));

        conectar("PC1", "SW1", 5);
        conectar("SW1", "SRV1", 3);
        conectar("SRV1", "PC2", 4);
        conectar("PC1", "PC3", 2);
    }
}