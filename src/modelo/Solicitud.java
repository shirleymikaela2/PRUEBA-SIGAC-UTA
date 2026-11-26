package modelo;

public class Solicitud {

    private final int id;
    private final int matricula;
    private final String descripcion;

    public Solicitud(int id, int matricula,
                     String descripcion) {

        this.id = id;
        this.matricula = matricula;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "Solicitud: " + id
                + " | Matricula: " + matricula
                + " | Descripcion: " + descripcion;
    }
}