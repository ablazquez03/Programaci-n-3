package semana3;

public class FlujoEjecucion {

    private String nombre = "No tiene nombre";
    private int edad = 0;

    // Constructor
    public FlujoEjecucion() {
        System.out.println("Creando objeto FlujoEjecucion");
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Método principal
    public static void main(String[] args) {
        System.out.println("Inicio");

        // Instanciar objeto
        FlujoEjecucion objeto = new FlujoEjecucion();

        // Modificar atributos con setters
        objeto.setNombre("Juan");
        objeto.setEdad(25);

        // Imprimir
        System.out.printf("Nombre: %s, Edad: %d%n", objeto.getNombre(), objeto.getEdad());

        System.out.println("Fin del programa");
    }
}
