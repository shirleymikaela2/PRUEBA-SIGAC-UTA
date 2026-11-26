package modelo;

public class Estudiante {

    private final int matricula;
    private String nombre;
    private int edad;
    private double promedio;

    public Estudiante(int matricula, String nombre,
                      int edad, double promedio) {

        this.matricula = matricula;
        this.nombre = nombre;
        this.edad = edad;
        this.promedio = promedio;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Matricula: " + matricula
                + " | Nombre: " + nombre
                + " | Edad: " + edad
                + " | Promedio: " + promedio;
    }
}