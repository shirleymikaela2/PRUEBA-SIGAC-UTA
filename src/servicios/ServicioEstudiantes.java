package servicios;

import modelo.Estudiante;
import estructuras.VectorEstudiantes;
import estructuras.ListaEstudiantes;
import estructuras.ArbolABB;
import estructuras.ArbolGeneral;

public class ServicioEstudiantes {

    private final VectorEstudiantes vector;
    private final ListaEstudiantes lista;
    private final ArbolABB abb;
    private final ArbolGeneral jerarquia;

    public ServicioEstudiantes(int capacidad) {
        vector = new VectorEstudiantes(capacidad);
        lista = new ListaEstudiantes();
        abb = new ArbolABB();
        jerarquia = new ArbolGeneral();
    }

    public boolean registrar(Estudiante estudiante) {

        if (estudiante == null
                || estudiante.getMatricula() <= 0) {
            return false;
        }

        if (!datosValidos(estudiante.getNombre(),
                estudiante.getEdad(),
                estudiante.getPromedio())) {
            return false;
        }

        int matricula = estudiante.getMatricula();

        if (!vector.registrar(estudiante)) {
            return false;
        }

        if (!lista.registrar(estudiante)) {
            vector.eliminar(matricula);
            return false;
        }

        if (!abb.insertar(estudiante)) {
            vector.eliminar(matricula);
            lista.eliminar(matricula);
            return false;
        }

        if (!jerarquia.agregarEstudiante(
                "SOFTWARE", estudiante)) {

            vector.eliminar(matricula);
            lista.eliminar(matricula);
            abb.eliminar(matricula);

            return false;
        }

        return true;
    }

    public Estudiante buscar(int matricula) {
        return vector.buscarPorMatricula(matricula);
    }

    public Estudiante buscarABB(int matricula) {
        return abb.buscar(matricula);
    }

    public boolean modificar(int matricula,
                             String nombre,
                             int edad,
                             double promedio) {

        Estudiante estudiante = buscar(matricula);

        if (estudiante == null
                || !datosValidos(nombre, edad, promedio)) {
            return false;
        }

        estudiante.setNombre(nombre);
        estudiante.setEdad(edad);
        estudiante.setPromedio(promedio);

        return true;
    }

    public boolean eliminar(int matricula) {

        if (vector.buscarPorMatricula(matricula) == null
                || lista.buscarPorMatricula(matricula) == null
                || abb.buscar(matricula) == null
                || jerarquia.buscar("EST-" + matricula) == null) {
            return false;
        }

        vector.eliminar(matricula);
        lista.eliminar(matricula);
        abb.eliminar(matricula);
        jerarquia.eliminarEstudiante(matricula);

        return true;
    }

    public void listarVector() {
        System.out.println("\n=== VECTOR ===");
        vector.listar();
    }

    public void listarLista() {
        System.out.println("\n=== LISTA ENLAZADA ===");
        lista.listar();
    }

    public void mostrarJerarquia() {
        jerarquia.mostrar();
    }

    public void mostrarRecorridos() {

        System.out.print("Preorden: ");
        abb.preorden();

        System.out.print("Inorden: ");
        abb.inorden();

        System.out.print("Posorden: ");
        abb.posorden();
    }

    public void compararBusquedas(int matricula) {

        System.out.println("Busqueda secuencial: "
                + vector.contarComparaciones(matricula)
                + " estudiantes examinados.");

        System.out.println("Busqueda ABB: "
                + abb.contarComparaciones(matricula)
                + " nodos examinados.");
    }

    public boolean validarABB() {
        return abb.esABBValido();
    }

    public int getCantidad() {
        return vector.getCantidad();
    }

    private boolean datosValidos(String nombre,
                                 int edad,
                                 double promedio) {

        return nombre != null
                && !nombre.trim().isEmpty()
                && edad >= 15
                && edad <= 100
                && promedio >= 0
                && promedio <= 10;
    }
}