package estructuras;

import modelo.Estudiante;

public class NodoABB {

    Estudiante dato;
    NodoABB izquierdo;
    NodoABB derecho;

    public NodoABB(Estudiante dato) {
        this.dato = dato;
        izquierdo = null;
        derecho = null;
    }
}