package estructuras;

import modelo.Estudiante;

public class VectorEstudiantes {

    private final Estudiante[] estudiantes;
    private int cantidad;

    public VectorEstudiantes(int capacidad) {
        estudiantes = new Estudiante[capacidad];
        cantidad = 0;
    }

    // Registrar estudiante
    public boolean registrar(Estudiante estudiante) {

        if (estudiante == null) {
            return false;
        }

        if (cantidad == estudiantes.length) {
            return false;
        }

        if (buscarPorMatricula(
                estudiante.getMatricula()) != null) {
            return false;
        }

        estudiantes[cantidad] = estudiante;
        cantidad++;

        return true;
    }

    // Busqueda secuencial
    public Estudiante buscarPorMatricula(int matricula) {

        for (int i = 0; i < cantidad; i++) {

            if (estudiantes[i].getMatricula() == matricula) {
                return estudiantes[i];
            }
        }

        return null;
    }

    // Cantidad de estudiantes
    public int getCantidad() {
        return cantidad;
    }

    // Capacidad del vector
    public int getCapacidad() {
        return estudiantes.length;
    }

    // Listar estudiantes
    public void listar() {

        for (int i = 0; i < cantidad; i++) {
            System.out.println(estudiantes[i]);
        }
    }

        // Buscar posicion dentro del vector
    private int buscarPosicionPorMatricula(int matricula) {

        for (int i = 0; i < cantidad; i++) {

            if (estudiantes[i].getMatricula() == matricula) {
                return i;
            }
        }

        return -1;
    }

    // Eliminar estudiante del vector
    public boolean eliminar(int matricula) {

        int posicion = buscarPosicionPorMatricula(matricula);

        if (posicion == -1) {
            return false;
        }

        for (int i = posicion; i < cantidad - 1; i++) {
            estudiantes[i] = estudiantes[i + 1];
        }

        cantidad--;
        estudiantes[cantidad] = null;

        return true;
    }

        public int contarComparaciones(int matricula) {

        int comparaciones = 0;

        for (int i = 0; i < cantidad; i++) {

            comparaciones++;

            if (estudiantes[i].getMatricula() == matricula) {
                break;
            }
        }

        return comparaciones;
    }
}