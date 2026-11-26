package estructuras;

public class NodoAdyacencia {

    NodoVertice destino;
    int peso;
    NodoAdyacencia siguiente;

    public NodoAdyacencia(NodoVertice destino, int peso) {

        this.destino = destino;
        this.peso = peso;
        siguiente = null;
    }
}