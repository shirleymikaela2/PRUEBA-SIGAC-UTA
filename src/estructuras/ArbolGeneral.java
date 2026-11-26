package estructuras;

import modelo.Estudiante;

public class ArbolGeneral {

    private final NodoGeneral raiz;

    public ArbolGeneral() {

        raiz = new NodoGeneral(
                "UTA",
                "Universidad Tecnica de Ambato",
                "UNIVERSIDAD");

        agregarUnidad("UTA", "FISEI",
                "Facultad de Ingenieria en Sistemas",
                "FACULTAD");

        agregarUnidad("FISEI", "SOFTWARE",
                "Ingenieria en Software",
                "CARRERA");
    }

    // Buscar nodo
    public NodoGeneral buscar(String codigo) {

        if (codigo == null) {
            return null;
        }

        return buscar(raiz, codigo);
    }

    private NodoGeneral buscar(NodoGeneral nodo,
                                 String codigo) {

        if (nodo == null) {
            return null;
        }

        if (nodo.codigo.equalsIgnoreCase(codigo)) {
            return nodo;
        }

        NodoGeneral resultado = buscar(
                nodo.primerHijo, codigo);

        if (resultado != null) {
            return resultado;
        }

        return buscar(nodo.siguienteHermano, codigo);
    }

    // Agregar unidad academica
    public boolean agregarUnidad(String codigoPadre,
                                  String codigo,
                                  String nombre,
                                  String tipo) {

        if (codigo == null || codigo.trim().isEmpty()
                || nombre == null || nombre.trim().isEmpty()
                || tipo == null || buscar(codigo) != null) {
            return false;
        }

        NodoGeneral padre = buscar(codigoPadre);

        if (padre == null) {
            return false;
        }

        boolean permitido =
                (padre.tipo.equals("UNIVERSIDAD")
                    && tipo.equals("FACULTAD"))
                ||
                (padre.tipo.equals("FACULTAD")
                    && tipo.equals("CARRERA"));

        if (!permitido) {
            return false;
        }

        NodoGeneral nuevo = new NodoGeneral(
                codigo, nombre, tipo);

        agregarHijo(padre, nuevo);
        return true;
    }

    // Enlazar un hijo al final
    private void agregarHijo(NodoGeneral padre,
                             NodoGeneral nuevo) {

        if (padre.primerHijo == null) {

            padre.primerHijo = nuevo;

        } else {

            NodoGeneral actual = padre.primerHijo;

            while (actual.siguienteHermano != null) {
                actual = actual.siguienteHermano;
            }

            actual.siguienteHermano = nuevo;
        }
    }

    // Agregar estudiante a una carrera
    public boolean agregarEstudiante(String carrera,
                                     Estudiante estudiante) {

        if (estudiante == null) {
            return false;
        }

        NodoGeneral padre = buscar(carrera);

        String codigo = "EST-" + estudiante.getMatricula();

        if (padre == null
                || !padre.tipo.equals("CARRERA")
                || buscar(codigo) != null) {
            return false;
        }

        NodoGeneral nuevo = new NodoGeneral(
                codigo,
                estudiante.getNombre(),
                "ESTUDIANTE");

        nuevo.estudiante = estudiante;

        agregarHijo(padre, nuevo);
        return true;
    }

    // Eliminar estudiante de la jerarquia
    public boolean eliminarEstudiante(int matricula) {

        return eliminarHijo(
                raiz, "EST-" + matricula);
    }

    private boolean eliminarHijo(NodoGeneral padre,
                                  String codigo) {

        NodoGeneral actual = padre.primerHijo;
        NodoGeneral anterior = null;

        while (actual != null) {

            if (actual.codigo.equals(codigo)
                    && actual.tipo.equals("ESTUDIANTE")) {

                if (anterior == null) {
                    padre.primerHijo =
                            actual.siguienteHermano;
                } else {
                    anterior.siguienteHermano =
                            actual.siguienteHermano;
                }

                return true;
            }

            if (eliminarHijo(actual, codigo)) {
                return true;
            }

            anterior = actual;
            actual = actual.siguienteHermano;
        }

        return false;
    }

    // Mostrar jerarquia academica
    public void mostrar() {
        mostrar(raiz, 0);
    }

    private void mostrar(NodoGeneral nodo, int nivel) {

        if (nodo == null) {
            return;
        }

        for (int i = 0; i < nivel; i++) {
            System.out.print("    ");
        }

        if (nodo.estudiante != null) {
            System.out.println(nodo.estudiante);
        } else {
            System.out.println(
                    nodo.tipo + ": " + nodo.nombre);
        }

        mostrar(nodo.primerHijo, nivel + 1);
        mostrar(nodo.siguienteHermano, nivel);
    }
}