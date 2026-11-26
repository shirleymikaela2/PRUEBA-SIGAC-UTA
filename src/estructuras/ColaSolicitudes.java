package estructuras;

import modelo.Solicitud;

public class ColaSolicitudes {

    private NodoCola inicio;
    private NodoCola fin;
    private int cantidad;

    public ColaSolicitudes() {
        inicio = null;
        fin = null;
        cantidad = 0;
    }

    public boolean estaVacia() {
        return inicio == null;
    }

    // Agregar solicitud al final de la cola
    public boolean encolar(Solicitud solicitud) {

        if (solicitud == null) {
            return false;
        }

        NodoCola nuevo = new NodoCola(solicitud);

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

    // Atender la primera solicitud
    public Solicitud desencolar() {

        if (estaVacia()) {
            return null;
        }

        Solicitud solicitud = inicio.dato;

        inicio = inicio.siguiente;

        if (inicio == null) {
            fin = null;
        }

        cantidad--;

        return solicitud;
    }

    // Consultar la primera solicitud
    public Solicitud consultar() {

        if (estaVacia()) {
            return null;
        }

        return inicio.dato;
    }

    // Recuperar una solicitud atendida
    public boolean agregarAlInicio(Solicitud solicitud) {

        if (solicitud == null) {
            return false;
        }

        NodoCola nuevo = new NodoCola(solicitud);

        if (estaVacia()) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            nuevo.siguiente = inicio;
            inicio = nuevo;
        }

        cantidad++;
        return true;
    }

    // Buscar una solicitud por ID
    public boolean existe(int id) {

        NodoCola actual = inicio;

        while (actual != null) {

            if (actual.dato.getId() == id) {
                return true;
            }

            actual = actual.siguiente;
        }

        return false;
    }

    // Mostrar solicitudes pendientes
    public void mostrar() {

        if (estaVacia()) {
            System.out.println("No hay solicitudes pendientes.");
            return;
        }

        NodoCola actual = inicio;

        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
    }

    public int getCantidad() {
        return cantidad;
    }

        public boolean contieneMatricula(int matricula) {

        NodoCola actual = inicio;

        while (actual != null) {

            if (actual.dato.getMatricula() == matricula) {
                return true;
            }

            actual = actual.siguiente;
        }

        return false;
    }
}