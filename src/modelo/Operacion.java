package modelo;

public class Operacion {

    private final String tipo;
    private final Solicitud solicitud;

    public Operacion(String tipo, Solicitud solicitud) {
        this.tipo = tipo;
        this.solicitud = solicitud;
    }

    public String getTipo() {
        return tipo;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    @Override
    public String toString() {
        return tipo + " | " + solicitud;
    }
}