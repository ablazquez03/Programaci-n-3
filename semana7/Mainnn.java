package semana7;

public class Mainnn {
    public static void main(String[] args) {
        VistaBiblioteca vista = new VistaBiblioteca();
        ControladorBiblioteca controlador = new ControladorBiblioteca(vista);
        controlador.iniciar();
    }
}
