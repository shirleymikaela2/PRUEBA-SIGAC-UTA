package estructuras;

import modelo.Operacion;

public class NodoPila {

    Operacion dato;
    NodoPila siguiente;

    public NodoPila(Operacion dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}