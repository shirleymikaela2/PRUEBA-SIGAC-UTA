package estructuras;

public class NodoVertice {

    String nombre;
    int indice;

    NodoVertice siguiente;
    NodoAdyacencia primerAdyacente;

    public NodoVertice(String nombre, int indice) {

        this.nombre = nombre;
        this.indice = indice;

        siguiente = null;
        primerAdyacente = null;
    }
}