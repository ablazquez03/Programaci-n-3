package semana8;

public class Main {
    public static void main(String[] args) {
        VistaAlumnos vista = new VistaAlumnos();
        ControladorAlumnos controlador = new ControladorAlumnos(vista);
        controlador.iniciar();
    }
}
