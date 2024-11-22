package semana8;

public class Jugador {
    private String nombre;
    private String equipo;
    private int edad;
    private double salario;

    public Jugador(String nombre, String equipo, int edad, double salario) {
        this.nombre = nombre;
        this.equipo = equipo;
        this.edad = edad;
        this.salario = salario;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getEquipo() {
        return equipo;
    }

    public int getEdad() {
        return edad;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return String.format("| %-15s | %-15s | %-3d | %-10.2f |", nombre, equipo, edad, salario);
    }

    public static String cabeceraTabla() {
        return String.format("| %-15s | %-15s | %-3s | %-10s |", "Nombre", "Equipo", "Edad", "Salario");
    }
}
