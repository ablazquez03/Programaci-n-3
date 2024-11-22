package semana7;

public class ControladorCalculadora {
    private final Calculadora modelo;
    private final VistaCalculadora vista;

    public ControladorCalculadora(Calculadora modelo, VistaCalculadora vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.leerOpcion();

            switch (opcion) {
                case "1":
                    int numero1 = vista.leerNumero("Introduce el primer número: ");
                    int numero2 = vista.leerNumero("Introduce el segundo número: ");
                    modelo.setNumero1(numero1);
                    modelo.setNumero2(numero2);
                    vista.mostrarResultado("Números almacenados.");
                    break;

                case "2":
                    int suma = modelo.calcularSuma();
                    vista.mostrarResultado("La suma ha sido calculada.");
                    break;

                case "3":
                    suma = modelo.calcularSuma();
                    vista.mostrarResultado("El resultado de la suma es: " + suma);
                    break;

                case "q":
                    vista.mostrarResultado("Saliendo...");
                    break;

                default:
                    vista.mostrarResultado("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        } while (!opcion.equals("q"));
    }
}
