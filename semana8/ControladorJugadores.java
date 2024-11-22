package semana8;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class ControladorJugadores {
    private final List<Jugador> jugadores;
    private final VistaJugadores vista;
    private List<Jugador> jugadoresFiltrados;

    public ControladorJugadores(VistaJugadores vista) {
        this.jugadores = new ArrayList<>();
        this.jugadoresFiltrados = new ArrayList<>();
        this.vista = vista;
        cargarJugadoresDesdeArchivo();
    }

    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.leerString("");

            switch (opcion) {
                case "1":
                    listarPorEquipo();
                    break;

                case "2":
                    listarPorRangoEdad();
                    break;

                case "3":
                    listarPorSalario();
                    break;

                case "4":
                    exportarJugadoresCSV();
                    break;

                case "q":
                    vista.mostrarMensaje("Saliendo...");
                    return;

                default:
                    vista.mostrarMensaje("Opción no válida. Inténtalo de nuevo.");
            }
        } while (true);
    }

    private void cargarJugadoresDesdeArchivo() {
        Path ruta = Paths.get(System.getProperty("user.home"), "Escritorio", "jugadores.tsv");
        if (Files.exists(ruta)) {
            try (BufferedReader br = Files.newBufferedReader(ruta)) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] partes = linea.split("\t");
                    if (partes.length == 4) {
                        jugadores.add(new Jugador(
                                partes[0], partes[1], Integer.parseInt(partes[2]), Double.parseDouble(partes[3])
                        ));
                    }
                }
                vista.mostrarMensaje("Jugadores cargados desde 'jugadores.tsv'.");
            } catch (IOException e) {
                vista.mostrarMensaje("Error al cargar jugadores: " + e.getMessage());
            }
        } else {
            vista.mostrarMensaje("No se encontró 'jugadores.tsv' en el escritorio.");
        }
    }

    private void listarPorEquipo() {
        String equipo = vista.leerString("Introduce el nombre del equipo: ");
        jugadoresFiltrados = jugadores.stream()
                .filter(j -> j.getEquipo().equalsIgnoreCase(equipo))
                .toList();

        mostrarFiltrados();
    }

    private void listarPorRangoEdad() {
        int edadMin = vista.leerEntero("Introduce la edad mínima: ");
        int edadMax = vista.leerEntero("Introduce la edad máxima: ");
        jugadoresFiltrados = jugadores.stream()
                .filter(j -> j.getEdad() >= edadMin && j.getEdad() <= edadMax)
                .toList();

        mostrarFiltrados();
    }

    private void listarPorSalario() {
        double salarioMin = vista.leerDouble("Introduce el salario mínimo: ");
        jugadoresFiltrados = jugadores.stream()
                .filter(j -> j.getSalario() > salarioMin)
                .toList();

        mostrarFiltrados();
    }

    private void mostrarFiltrados() {
        if (jugadoresFiltrados.isEmpty()) {
            vista.mostrarMensaje("No se encontraron jugadores con los criterios especificados.");
        } else {
            String cabecera = Jugador.cabeceraTabla();
            String[] filas = jugadoresFiltrados.stream().map(Jugador::toString).toArray(String[]::new);
            vista.mostrarTabla(cabecera, filas);
        }
    }

    private void exportarJugadoresCSV() {
        if (jugadoresFiltrados.isEmpty()) {
            vista.mostrarMensaje("No hay jugadores filtrados para exportar.");
            return;
        }

        Path ruta = Paths.get(System.getProperty("user.home"), "Escritorio", "jugadores_filtrados.csv");
        try (BufferedWriter bw = Files.newBufferedWriter(ruta)) {
            for (Jugador jugador : jugadoresFiltrados) {
                bw.write(String.join(",", jugador.getNombre(), jugador.getEquipo(), 
                        String.valueOf(jugador.getEdad()), String.valueOf(jugador.getSalario())));
                bw.newLine();
            }
            vista.mostrarMensaje("Jugadores exportados a 'jugadores_filtrados.csv'.");
        } catch (IOException e) {
            vista.mostrarMensaje("Error al exportar jugadores: " + e.getMessage());
        }
    }
}
