package semana7;

public class Mainn {
    public static void main(String[] args) {
        Almacen modelo = new Almacen();
        VistaAlmacen vista = new VistaAlmacen();
        ControladorAlmacen controlador = new ControladorAlmacen(modelo, vista);

        controlador.iniciar();
    }
}
