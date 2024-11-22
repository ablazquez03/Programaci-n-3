package semana8;

public class Mainnn {
    public static void main(String[] args) {
        VistaFacturas vista = new VistaFacturas();
        ControladorFacturas controlador = new ControladorFacturas(vista);
        controlador.iniciar();
    }
}
