package semana8;

public class MainApp {
    public static void main(String[] args) {
        VistaAlumnos vista = new VistaAlumnos();
        ControladorAlumnos controlador = new ControladorAlumnos(vista);
        controlador.iniciar();
    }
}
