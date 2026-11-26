package estructuras;

import modelo.Estudiante;

public class NodoEstudiante {

    Estudiante dato;
    NodoEstudiante siguiente;

    public NodoEstudiante(Estudiante dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}