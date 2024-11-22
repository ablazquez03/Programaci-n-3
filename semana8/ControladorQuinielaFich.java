package semana8;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class ControladorQuinielaFich {
    private final List<Partido> partidos;
    private final VistaQuiniela vista;

    public ControladorQuinielaFich(VistaQuiniela vista) {
        this.partidos = new ArrayList<>();
        this.vista = vista;

        cargarPartidosDesdeArchivo();
    }

    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.leerString("");

            switch (opcion) {
                case "1":
                    introducirResultados();
                    break;

                case "2":
                    mostrarQuiniela();
                    break;

                case "q":
                    vista.mostrarMensaje("Saliendo...");
                    return;

                default:
                    vista.mostrarMensaje("Opción no válida. Inténtalo de nuevo.");
            }
        } while (true);
    }

    private void cargarPartidosDesdeArchivo() {
        Path ruta = Paths.get(System.getProperty("user.home"), "Escritorio", "datos", "equipos.txt");
        if (Files.exists(ruta)) {
            try (BufferedReader br = Files.newBufferedReader(ruta)) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] equipos = linea.split("-");
                    if (equipos.length == 2) {
                        partidos.add(new Partido(equipos[0].trim(), equipos[1].trim()));
                    }
                }
                vista.mostrarMensaje("Partidos cargados desde 'equipos.txt'.");
            } catch (IOException e) {
                vista.mostrarMensaje("Error al cargar partidos: " + e.getMessage());
            }
        } else {
            vista.mostrarMensaje("No se encontró 'equipos.txt' en la carpeta 'datos' del escritorio.");
        }
    }

    private void introducirResultados() {
        for (Partido partido : partidos) {
            String resultado = vista.leerString("Resultado para " + partido.getEquipoLocal() + " vs " + partido.getEquipoVisitante() + " (1/X/2): ");
            while (!resultado.matches("[1X2]")) {
                resultado = vista.leerString("Resultado inválido. Introduce 1, X o 2: ");
            }
            partido.setResultado(resultado);
        }
        vista.mostrarMensaje("Resultados actualizados.");
    }

    private void mostrarQuiniela() {
        if (partidos.isEmpty()) {
            vista.mostrarMensaje("No hay partidos en la quiniela.");
            return;
        }

        String cabecera = String.format("| %-20s | %-20s | %-3s |", "Equipo Local", "Equipo Visitante", "R");
        String[] filas = partidos.stream().map(Partido::toString).toArray(String[]::new);
        vista.mostrarQuiniela(cabecera, filas);
    }
}
