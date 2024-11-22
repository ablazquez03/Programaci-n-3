package semana7;

public class ControladorAlmacen {
    private final Almacen modelo;
    private final VistaAlmacen vista;

    public ControladorAlmacen(Almacen modelo, VistaAlmacen vista) {
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
                    leerTablaVentas();
                    break;

                case "2":
                    leerTablaPrecios();
                    break;

                case "3":
                    calcularIngresos();
                    break;

                case "4":
                    mostrarResultados();
                    break;

                case "q":
                    vista.mostrarMensaje("Saliendo...");
                    break;

                default:
                    vista.mostrarMensaje("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        } while (!opcion.equals("q"));
    }

    private void leerTablaVentas() {
        int[][] ventas = new int[5][2];
        for (int i = 0; i < ventas.length; i++) {
            for (int j = 0; j < ventas[i].length; j++) {
                ventas[i][j] = vista.leerEntero("Introduce las ventas para el almacén " + (i + 1) +
                        ", producto " + (j + 1) + ": ");
            }
        }
        modelo.setVentas(ventas);
        vista.mostrarMensaje("Tabla de ventas actualizada.");
    }

    private void leerTablaPrecios() {
        double[] precios = new double[2];
        for (int i = 0; i < precios.length; i++) {
            precios[i] = vista.leerDouble("Introduce el precio del producto " + (i + 1) + ": ");
        }
        modelo.setPrecios(precios);
        vista.mostrarMensaje("Tabla de precios actualizada.");
    }

    private void calcularIngresos() {
        double[] ingresos = modelo.calcularIngresosTotales();
        vista.mostrarMensaje("Ingresos calculados correctamente.");
    }

    private void mostrarResultados() {
        double[] ingresos = modelo.calcularIngresosTotales();
        vista.mostrarTabla(new String[]{"Almacén", "Ingresos (€)"}, ingresos);
    }
}
