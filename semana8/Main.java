package semana8;

public class Main {
    public static void main(String[] args) {
        VistaQuiniela vista = new VistaQuiniela();
        ControladorQuiniela controlador = new ControladorQuiniela(vista);
        controlador.iniciar();
    }
}
