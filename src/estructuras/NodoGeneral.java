package estructuras;

import modelo.Estudiante;

public class NodoGeneral {

    String codigo;
    String nombre;
    String tipo;

    Estudiante estudiante;

    NodoGeneral primerHijo;
    NodoGeneral siguienteHermano;

    public NodoGeneral(String codigo,
                       String nombre,
                       String tipo) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;

        estudiante = null;
        primerHijo = null;
        siguienteHermano = null;
    }
}
