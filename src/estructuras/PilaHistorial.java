package estructuras;

import modelo.Operacion;

public class PilaHistorial {

    private NodoPila cima;
    private int cantidad;

    public PilaHistorial() {
        cima = null;
        cantidad = 0;
    }

    // Verificar si la pila esta vacia
    public boolean estaVacia() {
        return cima == null;
    }

    // Agregar operacion a la pila
    public boolean apilar(Operacion operacion) {

        if (operacion == null) {
            return false;
        }

        NodoPila nuevo = new NodoPila(operacion);

        nuevo.siguiente = cima;
        cima = nuevo;

        cantidad++;
        return true;
    }

    // Recuperar la ultima operacion
    public Operacion desapilar() {

        if (estaVacia()) {
            return null;
        }

        Operacion operacion = cima.dato;

        cima = cima.siguiente;
        cantidad--;

        return operacion;
    }

    // Consultar la ultima operacion
    public Operacion consultar() {

        if (estaVacia()) {
            return null;
        }

        return cima.dato;
    }

    // Buscar una solicitud en el historial
    public boolean existeSolicitud(int id) {

        NodoPila actual = cima;

        while (actual != null) {

            if (actual.dato.getSolicitud() != null
                    && actual.dato.getSolicitud().getId() == id) {
                return true;
            }

            actual = actual.siguiente;
        }

        return false;
    }

    // Mostrar historial de operaciones
    public void mostrar() {

        if (estaVacia()) {
            System.out.println("El historial esta vacio.");
            return;
        }

        NodoPila actual = cima;

        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
    }

    public int getCantidad() {
        return cantidad;
    }

        public boolean contieneMatricula(int matricula) {

        NodoPila actual = cima;

        while (actual != null) {

            if (actual.dato.getSolicitud() != null
                    && actual.dato.getSolicitud()
                            .getMatricula() == matricula) {

                return true;
            }

            actual = actual.siguiente;
        }

        return false;
    }
}
