package semana8;

import java.util.ArrayList;
import java.util.List;

public class ControladorQuiniela {
    private final List<Partido> partidos;
    private final VistaQuiniela vista;

    public ControladorQuiniela(VistaQuiniela vista) {
        this.partidos = new ArrayList<>();
        this.vista = vista;

        inicializarPartidos();
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

    private void inicializarPartidos() {
        partidos.add(new Partido("Real Madrid", "FC Barcelona"));
        partidos.add(new Partido("Atlético de Madrid", "Valencia CF"));
        partidos.add(new Partido("Sevilla FC", "Real Betis"));
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
