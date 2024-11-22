package semana8;

public class Alumno {
    private String nombre;
    private String matricula;
    private double[] calificaciones;

    public Alumno(String nombre, String matricula, double[] calificaciones) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.calificaciones = calificaciones;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public double[] getCalificaciones() {
        return calificaciones;
    }

    // Calcular promedio de calificaciones
    public double calcularPromedio() {
        double suma = 0;
        for (double calificacion : calificaciones) {
            suma += calificacion;
        }
        return suma / calificaciones.length;
    }

    // Verificar si está aprobado (promedio >= 6.0)
    public boolean estaAprobado() {
        return calcularPromedio() >= 6.0;
    }

    @Override
    public String toString() {
        return String.format("| %-20s | %-10s | %-6.2f |", nombre, matricula, calcularPromedio());
    }

    public static String cabeceraTabla() {
        return String.format("| %-20s | %-10s | %-6s |", "Nombre", "Matrícula", "Promedio");
    }
}
