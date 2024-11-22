package semana8;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class ControladorFacturas {
    private final List<Factura> facturas;
    private final VistaFacturas vista;

    public ControladorFacturas(VistaFacturas vista) {
        this.facturas = new ArrayList<>();
        this.vista = vista;
        cargarFacturasDesdeArchivo();
    }

    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.leerString("");

            switch (opcion) {
                case "1":
                    listarClientesPorImporte();
                    break;

                case "2":
                    mostrarFacturas();
                    break;

                case "3":
                    exportarFacturasHTML();
                    break;

                case "4":
                    exportarFacturasCSV();
                    break;

                case "q":
                    vista.mostrarMensaje("Saliendo...");
                    return;

                default:
                    vista.mostrarMensaje("Opción no válida. Inténtalo de nuevo.");
            }
        } while (true);
    }

    private void cargarFacturasDesdeArchivo() {
        Path ruta = Paths.get(System.getProperty("user.home"), "Escritorio", "facturas.tsv");
        if (Files.exists(ruta)) {
            try (BufferedReader br = Files.newBufferedReader(ruta)) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] partes = linea.split("\t");
                    if (partes.length == 8) {
                        facturas.add(new Factura(
                                partes[0], Double.parseDouble(partes[1]), partes[2], Double.parseDouble(partes[3]),
                                partes[4], partes[5], partes[6], Double.parseDouble(partes[7])
                        ));
                    }
                }
                vista.mostrarMensaje("Facturas cargadas desde 'facturas.tsv'.");
            } catch (IOException e) {
                vista.mostrarMensaje("Error al cargar facturas: " + e.getMessage());
            }
        } else {
            vista.mostrarMensaje("No se encontró 'facturas.tsv' en el escritorio.");
        }
    }

    private void listarClientesPorImporte() {
        double minimo = vista.leerDouble("Introduce el importe mínimo: ");
        String[] filas = facturas.stream()
                .filter(f -> f.calcularImporteFinal() > minimo)
                .map(f -> String.format("| %-20s | %-15s | %-8.2f |", f.getNombreCliente(), f.getNif(), f.calcularImporteFinal()))
                .toArray(String[]::new);

        if (filas.length == 0) {
            vista.mostrarMensaje("No hay clientes con facturas superiores al importe mínimo.");
        } else {
            String cabecera = String.format("| %-20s | %-15s | %-8s |", "Cliente", "NIF", "Importe Final");
            vista.mostrarTabla(cabecera, filas);
        }
    }

    private void mostrarFacturas() {
        if (facturas.isEmpty()) {
            vista.mostrarMensaje("No hay facturas para mostrar.");
        } else {
            String cabecera = Factura.cabeceraTabla();
            String[] filas = facturas.stream().map(Factura::toFila).toArray(String[]::new);
            vista.mostrarTabla(cabecera, filas);
        }
    }

    private void exportarFacturasHTML() {
        Path ruta = Paths.get(System.getProperty("user.home"), "Escritorio", "facturas.html");
        try (BufferedWriter bw = Files.newBufferedWriter(ruta)) {
            bw.write("<html><body><table border='1'>");
            bw.write("<tr>" + Factura.cabeceraTabla().replace("|", "<th>").replace("-", "") + "</tr>");
            for (Factura factura : facturas) {
                bw.write("<tr>" + factura.toFila().replace("|", "<td>").replace("-", "") + "</tr>");
            }
            bw.write("</table></body></html>");
            vista.mostrarMensaje("Facturas exportadas a 'facturas.html'.");
        } catch (IOException e) {
            vista.mostrarMensaje("Error al exportar facturas: " + e.getMessage());
        }
    }

    private void exportarFacturasCSV() {
        Path ruta = Paths.get(System.getProperty("user.home"), "Escritorio", "facturas.csv");
        try (BufferedWriter bw = Files.newBufferedWriter(ruta)) {
            for (Factura factura : facturas) {
                bw.write(String.join(",", factura.toFila().split("\\|")));
                bw.newLine();
            }
            vista.mostrarMensaje("Facturas exportadas a 'facturas.csv'.");
        } catch (IOException e) {
            vista.mostrarMensaje("Error al exportar facturas: " + e.getMessage());
        }
    }
}
