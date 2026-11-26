package estructuras;

public class GrafoDinamico {

    private NodoVertice primero;
    private int cantidadVertices;
    private final boolean dirigido;

    public GrafoDinamico(boolean dirigido) {
        this.dirigido = dirigido;
        primero = null;
        cantidadVertices = 0;
    }

    // Insertar vertice
    public boolean insertarVertice(String nombre) {

        if (nombre == null || nombre.trim().isEmpty()
                || buscarVertice(nombre) != null) {
            return false;
        }

        NodoVertice nuevo = new NodoVertice(
                nombre.trim(), cantidadVertices);

        if (primero == null) {
            primero = nuevo;
        } else {

            NodoVertice actual = primero;

            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }

            actual.siguiente = nuevo;
        }

        cantidadVertices++;
        return true;
    }

    // Buscar vertice
    public NodoVertice buscarVertice(String nombre) {

        if (nombre == null) {
            return null;
        }

        NodoVertice actual = primero;

        while (actual != null) {

            if (actual.nombre.equalsIgnoreCase(nombre.trim())) {
                return actual;
            }

            actual = actual.siguiente;
        }

        return null;
    }

    // Crear conexion ponderada
    public boolean crearConexion(String origen,
                                 String destino,
                                 int peso) {

        NodoVertice a = buscarVertice(origen);
        NodoVertice b = buscarVertice(destino);

        if (a == null || b == null
                || a == b || peso <= 0
                || existeConexion(origen, destino)) {
            return false;
        }

        agregarAdyacencia(a, b, peso);

        if (!dirigido) {
            agregarAdyacencia(b, a, peso);
        }

        return true;
    }

    private void agregarAdyacencia(NodoVertice origen,
                                   NodoVertice destino,
                                   int peso) {

        NodoAdyacencia nuevo =
                new NodoAdyacencia(destino, peso);

        if (origen.primerAdyacente == null) {

            origen.primerAdyacente = nuevo;

        } else {

            NodoAdyacencia actual = origen.primerAdyacente;

            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }

            actual.siguiente = nuevo;
        }
    }

    // Verificar conexion
    public boolean existeConexion(String origen,
                                  String destino) {

        NodoVertice a = buscarVertice(origen);
        NodoVertice b = buscarVertice(destino);

        if (a == null || b == null) {
            return false;
        }

        NodoAdyacencia actual = a.primerAdyacente;

        while (actual != null) {

            if (actual.destino == b) {
                return true;
            }

            actual = actual.siguiente;
        }

        return false;
    }

    // Eliminar conexion
    public boolean eliminarConexion(String origen,
                                    String destino) {

        NodoVertice a = buscarVertice(origen);
        NodoVertice b = buscarVertice(destino);

        if (a == null || b == null
                || !existeConexion(origen, destino)) {
            return false;
        }

        quitarAdyacencia(a, b);

        if (!dirigido) {
            quitarAdyacencia(b, a);
        }

        return true;
    }

    private void quitarAdyacencia(NodoVertice origen,
                                  NodoVertice destino) {

        NodoAdyacencia actual = origen.primerAdyacente;
        NodoAdyacencia anterior = null;

        while (actual != null) {

            if (actual.destino == destino) {

                if (anterior == null) {

                    origen.primerAdyacente =
                            actual.siguiente;

                } else {

                    anterior.siguiente =
                            actual.siguiente;
                }

                return;
            }

            anterior = actual;
            actual = actual.siguiente;
        }
    }

    // Eliminar vertice y sus aristas
    public boolean eliminarVertice(String nombre) {

        NodoVertice objetivo = buscarVertice(nombre);

        if (objetivo == null) {
            return false;
        }

        NodoVertice actual = primero;

        // Eliminar aristas entrantes
        while (actual != null) {

            quitarAdyacencia(actual, objetivo);
            actual = actual.siguiente;
        }

        if (primero == objetivo) {

            primero = objetivo.siguiente;

        } else {

            actual = primero;

            while (actual.siguiente != objetivo) {
                actual = actual.siguiente;
            }

            actual.siguiente = objetivo.siguiente;
        }

        cantidadVertices--;

        // Actualizar indices
        int indice = 0;
        actual = primero;

        while (actual != null) {

            actual.indice = indice++;
            actual = actual.siguiente;
        }

        return true;
    }

    // Obtener nombres de los vertices
    public String[] obtenerVertices() {

        String[] resultado =
                new String[cantidadVertices];

        NodoVertice actual = primero;
        int i = 0;

        while (actual != null) {

            resultado[i++] = actual.nombre;
            actual = actual.siguiente;
        }

        return resultado;
    }

    // Obtener vecinos
    public String[] obtenerVecinos(String nombre) {

        NodoVertice vertice = buscarVertice(nombre);

        if (vertice == null) {
            return new String[0];
        }

        int cantidad = 0;

        NodoAdyacencia actual = vertice.primerAdyacente;

        while (actual != null) {
            cantidad++;
            actual = actual.siguiente;
        }

        String[] vecinos = new String[cantidad];

        actual = vertice.primerAdyacente;
        int i = 0;

        while (actual != null) {

            vecinos[i++] = actual.destino.nombre;
            actual = actual.siguiente;
        }

        return vecinos;
    }

    public int getCantidadVertices() {
        return cantidadVertices;
    }

    // Mostrar grafo
    public void mostrar() {

        if (primero == null) {
            System.out.println("Grafo vacio.");
            return;
        }

        NodoVertice actual = primero;

        while (actual != null) {

            System.out.print(actual.nombre + " -> ");

            NodoAdyacencia adyacente =
                    actual.primerAdyacente;

            if (adyacente == null) {
                System.out.print("Sin conexiones");
            }

            while (adyacente != null) {

                System.out.print(
                        adyacente.destino.nombre
                        + "(" + adyacente.peso + ") ");

                adyacente = adyacente.siguiente;
            }

            System.out.println();
            actual = actual.siguiente;
        }
    }
}