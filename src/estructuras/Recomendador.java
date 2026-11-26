package estructuras;

public class Recomendador {

    public static String recomendar(
            GrafoDinamico grafo, String usuario) {

        if (grafo == null) {
            return "Grafo inexistente.";
        }

        NodoVertice origen = grafo.buscarVertice(usuario);

        if (origen == null) {
            return "Usuario inexistente.";
        }

        String[] vertices = grafo.obtenerVertices();

        String[] candidatos = new String[vertices.length];
        int[] puntuaciones = new int[vertices.length];

        int cantidad = 0;

        for (String nombre : vertices) {

            NodoVertice candidato =
                    grafo.buscarVertice(nombre);

            // Excluir al usuario y sus amigos directos
            if (candidato == origen
                    || sonVecinos(origen, candidato)) {
                continue;
            }

            int comunes = contarComunes(origen, candidato);

            if (comunes > 0) {

                candidatos[cantidad] = nombre;
                puntuaciones[cantidad] = comunes;

                cantidad++;
            }
        }

        ordenar(candidatos, puntuaciones, cantidad);

        if (cantidad == 0) {
            return "No existen recomendaciones.";
        }

        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < cantidad; i++) {

            resultado.append(i + 1)
                    .append(". ")
                    .append(candidatos[i])
                    .append(" | Amigos en comun: ")
                    .append(puntuaciones[i])
                    .append("\n");
        }

        return resultado.toString().trim();
    }

    // Contar amigos en comun
    private static int contarComunes(NodoVertice a,
                                     NodoVertice b) {

        int cantidad = 0;

        NodoAdyacencia actual = a.primerAdyacente;

        while (actual != null) {

            if (sonVecinos(b, actual.destino)) {
                cantidad++;
            }

            actual = actual.siguiente;
        }

        return cantidad;
    }

    // Verificar amistad directa
    private static boolean sonVecinos(NodoVertice origen,
                                      NodoVertice destino) {

        NodoAdyacencia actual = origen.primerAdyacente;

        while (actual != null) {

            if (actual.destino == destino) {
                return true;
            }

            actual = actual.siguiente;
        }

        return false;
    }

    // Ordenamiento por insercion
    private static void ordenar(String[] nombres,
                                int[] puntos,
                                int cantidad) {

        for (int i = 1; i < cantidad; i++) {

            String nombre = nombres[i];
            int puntuacion = puntos[i];

            int j = i - 1;

            while (j >= 0
                    && (puntos[j] < puntuacion
                    || (puntos[j] == puntuacion
                    && nombres[j].compareToIgnoreCase(nombre) > 0))) {

                nombres[j + 1] = nombres[j];
                puntos[j + 1] = puntos[j];

                j--;
            }

            nombres[j + 1] = nombre;
            puntos[j + 1] = puntuacion;
        }
    }
}