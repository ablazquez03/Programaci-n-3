package semana8;

public class Mainn {
    public static void main(String[] args) {
        VistaQuiniela vista = new VistaQuiniela();
        ControladorQuinielaFich controlador = new ControladorQuinielaFich(vista);
        controlador.iniciar();
    }
}
