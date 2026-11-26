package estructuras;

import modelo.Solicitud;

public class NodoCola {

    Solicitud dato;
    NodoCola siguiente;

    public NodoCola(Solicitud dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}