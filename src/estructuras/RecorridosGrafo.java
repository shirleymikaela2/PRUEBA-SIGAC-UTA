package estructuras;

public class RecorridosGrafo {

    // Recorrido BFS
    public static String bfs(GrafoDinamico grafo,
                             String inicio) {

        if (grafo == null) {
            return "Grafo inexistente.";
        }

        NodoVertice origen = grafo.buscarVertice(inicio);

        if (origen == null) {
            return "Vertice inexistente.";
        }

        int cantidad = grafo.getCantidadVertices();

        boolean[] visitado = new boolean[cantidad];

        NodoVertice[] cola = new NodoVertice[cantidad];

        int frente = 0;
        int fin = 0;

        StringBuilder resultado = new StringBuilder();

        cola[fin++] = origen;
        visitado[origen.indice] = true;

        while (frente < fin) {

            NodoVertice actual = cola[frente++];

            resultado.append(actual.nombre).append(" ");

            NodoAdyacencia vecino = actual.primerAdyacente;

            while (vecino != null) {

                NodoVertice destino = vecino.destino;

                if (!visitado[destino.indice]) {

                    visitado[destino.indice] = true;
                    cola[fin++] = destino;
                }

                vecino = vecino.siguiente;
            }
        }

        return resultado.toString().trim();
    }

    // Recorrido DFS
    public static String dfs(GrafoDinamico grafo,
                             String inicio) {

        if (grafo == null) {
            return "Grafo inexistente.";
        }

        NodoVertice origen = grafo.buscarVertice(inicio);

        if (origen == null) {
            return "Vertice inexistente.";
        }

        boolean[] visitado =
                new boolean[grafo.getCantidadVertices()];

        StringBuilder resultado = new StringBuilder();

        visitarDFS(origen, visitado, resultado);

        return resultado.toString().trim();
    }

    private static void visitarDFS(NodoVertice actual,
                                   boolean[] visitado,
                                   StringBuilder resultado) {

        visitado[actual.indice] = true;

        resultado.append(actual.nombre).append(" ");

        NodoAdyacencia vecino = actual.primerAdyacente;

        while (vecino != null) {

            if (!visitado[vecino.destino.indice]) {

                visitarDFS(
                        vecino.destino,
                        visitado,
                        resultado);
            }

            vecino = vecino.siguiente;
        }
    }

    // Identificar vertices no alcanzables
    public static String noAlcanzables(
            GrafoDinamico grafo, String inicio) {

        if (grafo == null) {
            return "Grafo inexistente.";
        }

        NodoVertice origen = grafo.buscarVertice(inicio);

        if (origen == null) {
            return "Vertice inexistente.";
        }

        boolean[] visitado =
                new boolean[grafo.getCantidadVertices()];

        visitarDFS(origen, visitado, new StringBuilder());

        String[] vertices = grafo.obtenerVertices();

        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < vertices.length; i++) {

            if (!visitado[i]) {
                resultado.append(vertices[i]).append(" ");
            }
        }

        if (resultado.length() == 0) {
            return "Todos los vertices son alcanzables.";
        }

        return resultado.toString().trim();
    }
}