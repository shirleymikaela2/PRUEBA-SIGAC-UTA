package modelo;

public class Equipo {

    private final String codigo;
    private final String tipo;

    public Equipo(String codigo, String tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return codigo + " | " + tipo;
    }
}