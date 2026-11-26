package estructuras;

import modelo.Estudiante;

public class ArbolABB {

    private NodoABB raiz;

    // Insertar estudiante
    public boolean insertar(Estudiante estudiante) {

        if (estudiante == null
                || estudiante.getMatricula() <= 0
                || buscar(estudiante.getMatricula()) != null) {
            return false;
        }

        raiz = insertar(raiz, estudiante);
        return true;
    }

    private NodoABB insertar(NodoABB nodo,
                             Estudiante estudiante) {

        if (nodo == null) {
            return new NodoABB(estudiante);
        }

        if (estudiante.getMatricula()
                < nodo.dato.getMatricula()) {

            nodo.izquierdo = insertar(
                    nodo.izquierdo, estudiante);

        } else {

            nodo.derecho = insertar(
                    nodo.derecho, estudiante);
        }

        return nodo;
    }

    // Buscar por matricula
    public Estudiante buscar(int matricula) {
        return buscar(raiz, matricula);
    }

    private Estudiante buscar(NodoABB nodo, int matricula) {

        if (nodo == null) {
            return null;
        }

        if (matricula == nodo.dato.getMatricula()) {
            return nodo.dato;
        }

        if (matricula < nodo.dato.getMatricula()) {
            return buscar(nodo.izquierdo, matricula);
        }

        return buscar(nodo.derecho, matricula);
    }

    // Eliminar estudiante
    public boolean eliminar(int matricula) {

        if (buscar(matricula) == null) {
            return false;
        }

        raiz = eliminar(raiz, matricula);
        return true;
    }

    private NodoABB eliminar(NodoABB nodo, int matricula) {

        if (nodo == null) {
            return null;
        }

        if (matricula < nodo.dato.getMatricula()) {

            nodo.izquierdo = eliminar(
                    nodo.izquierdo, matricula);

        } else if (matricula > nodo.dato.getMatricula()) {

            nodo.derecho = eliminar(
                    nodo.derecho, matricula);

        } else {

            // Nodo sin hijo izquierdo
            if (nodo.izquierdo == null) {
                return nodo.derecho;
            }

            // Nodo sin hijo derecho
            if (nodo.derecho == null) {
                return nodo.izquierdo;
            }

            // Nodo con dos hijos: sucesor inorden
            NodoABB sucesor = minimo(nodo.derecho);

            nodo.dato = sucesor.dato;

            nodo.derecho = eliminar(
                    nodo.derecho,
                    sucesor.dato.getMatricula());
        }

        return nodo;
    }

    private NodoABB minimo(NodoABB nodo) {

        if (nodo.izquierdo == null) {
            return nodo;
        }

        return minimo(nodo.izquierdo);
    }

    // Recorrido preorden
    public void preorden() {
        preorden(raiz);
        System.out.println();
    }

    private void preorden(NodoABB nodo) {

        if (nodo != null) {
            System.out.print(nodo.dato.getMatricula() + " ");
            preorden(nodo.izquierdo);
            preorden(nodo.derecho);
        }
    }

    // Recorrido inorden
    public void inorden() {
        inorden(raiz);
        System.out.println();
    }

    private void inorden(NodoABB nodo) {

        if (nodo != null) {
            inorden(nodo.izquierdo);
            System.out.print(nodo.dato.getMatricula() + " ");
            inorden(nodo.derecho);
        }
    }

    // Recorrido posorden
    public void posorden() {
        posorden(raiz);
        System.out.println();
    }

    private void posorden(NodoABB nodo) {

        if (nodo != null) {
            posorden(nodo.izquierdo);
            posorden(nodo.derecho);
            System.out.print(nodo.dato.getMatricula() + " ");
        }
    }

    // Validar la propiedad del ABB
    public boolean esABBValido() {
        return validar(raiz, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validar(NodoABB nodo,
                            long minimo, long maximo) {

        if (nodo == null) {
            return true;
        }

        int matricula = nodo.dato.getMatricula();

        return matricula > minimo
                && matricula < maximo
                && validar(nodo.izquierdo, minimo, matricula)
                && validar(nodo.derecho, matricula, maximo);
    }

    // Contar comparaciones de busqueda
    public int contarComparaciones(int matricula) {

        NodoABB actual = raiz;
        int comparaciones = 0;

        while (actual != null) {

            comparaciones++;

            if (matricula == actual.dato.getMatricula()) {
                break;
            }

            if (matricula < actual.dato.getMatricula()) {
                actual = actual.izquierdo;
            } else {
                actual = actual.derecho;
            }
        }

        return comparaciones;
    }
}