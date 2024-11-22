package semana8;

public class Mainnnn {
    public static void main(String[] args) {
        VistaJugadores vista = new VistaJugadores();
        ControladorJugadores controlador = new ControladorJugadores(vista);
        controlador.iniciar();
    }
}
