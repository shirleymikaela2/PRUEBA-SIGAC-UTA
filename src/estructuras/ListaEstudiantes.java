package estructuras;

import modelo.Estudiante;

public class ListaEstudiantes {

    private NodoEstudiante inicio;
    private NodoEstudiante fin;
    private int cantidad;

    public ListaEstudiantes() {
        inicio = null;
        fin = null;
        cantidad = 0;
    }

    // Verificar si la lista esta vacia
    public boolean estaVacia() {
        return inicio == null;
    }

    // Registrar estudiante al final
    public boolean registrar(Estudiante estudiante) {

        if (estudiante == null) {
            return false;
        }

        if (buscarPorMatricula(
                estudiante.getMatricula()) != null) {
            return false;
        }

        NodoEstudiante nuevo = new NodoEstudiante(estudiante);

        if (estaVacia()) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }

        cantidad++;
        return true;
    }

    // Buscar estudiante por matricula
    public Estudiante buscarPorMatricula(int matricula) {

        NodoEstudiante actual = inicio;

        while (actual != null) {

            if (actual.dato.getMatricula() == matricula) {
                return actual.dato;
            }

            actual = actual.siguiente;
        }

        return null;
    }

    // Eliminar estudiante por matricula
    public boolean eliminar(int matricula) {

        NodoEstudiante actual = inicio;
        NodoEstudiante anterior = null;

        while (actual != null) {

            if (actual.dato.getMatricula() == matricula) {

                if (anterior == null) {
                    inicio = actual.siguiente;
                } else {
                    anterior.siguiente = actual.siguiente;
                }

                if (actual == fin) {
                    fin = anterior;
                }

                cantidad--;
                return true;
            }

            anterior = actual;
            actual = actual.siguiente;
        }

        return false;
    }

    // Mostrar estudiantes
    public void listar() {

        if (estaVacia()) {
            System.out.println("Lista vacia.");
            return;
        }

        NodoEstudiante actual = inicio;

        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
    }

    public int getCantidad() {
        return cantidad;
    }
}