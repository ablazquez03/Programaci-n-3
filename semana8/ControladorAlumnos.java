package semana8;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class ControladorAlumnos {
    private final List<Alumno> alumnos;
    private final VistaAlumnos vista;

    public ControladorAlumnos(VistaAlumnos vista) {
        this.alumnos = new ArrayList<>();
        this.vista = vista;
        cargarAlumnosDesdeArchivo();
    }

    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.scanner.nextLine();

            switch (opcion) {
                case "1":
                    calcularPromedioGeneral();
                    break;

                case "2":
                    listarAprobados();
                    break;

                case "3":
                    listarReprobados();
                    break;

                case "4":
                    exportarResultadosCSV();
                    break;

                case "q":
                    vista.mostrarMensaje("Saliendo...");
                    return;

                default:
                    vista.mostrarMensaje("Opción no válida. Inténtalo de nuevo.");
            }
        } while (true);
    }

    private void cargarAlumnosDesdeArchivo() {
        Path ruta = Paths.get(System.getProperty("user.home"), "Escritorio", "alumnos.tsv");
        if (Files.exists(ruta)) {
            try (BufferedReader br = Files.newBufferedReader(ruta)) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] partes = linea.split("\t");
                    if (partes.length > 2) {
                        String nombre = partes[0];
                        String matricula = partes[1];
                        double[] calificaciones = new double[partes.length - 2];
                        for (int i = 2; i < partes.length; i++) {
                            calificaciones[i - 2] = Double.parseDouble(partes[i]);
                        }
                        alumnos.add(new Alumno(nombre, matricula, calificaciones));
                    }
                }
                vista.mostrarMensaje("Alumnos cargados desde 'alumnos.tsv'.");
            } catch (IOException e) {
                vista.mostrarMensaje("Error al cargar alumnos: " + e.getMessage());
            }
        } else {
            vista.mostrarMensaje("No se encontró 'alumnos.tsv' en el escritorio.");
        }
    }

    private void calcularPromedioGeneral() {
        if (alumnos.isEmpty()) {
            vista.mostrarMensaje("No hay alumnos para calcular el promedio.");
            return;
        }

        double promedio = alumnos.stream()
                .mapToDouble(Alumno::calcularPromedio)
                .average()
                .orElse(0);

        vista.mostrarMensaje("El promedio general de todos los alumnos es: " + promedio);
    }

    private void listarAprobados() {
        listarAlumnos(true);
    }

    private void listarReprobados() {
        listarAlumnos(false);
    }

    private void listarAlumnos(boolean aprobados) {
        List<Alumno> filtrados = alumnos.stream()
                .filter(a -> a.estaAprobado() == aprobados)
                .toList();

        if (filtrados.isEmpty()) {
            vista.mostrarMensaje(aprobados ? "No hay alumnos aprobados." : "No hay alumnos reprobados.");
        } else {
            String cabecera = Alumno.cabeceraTabla();
            String[] filas = filtrados.stream().map(Alumno::toString).toArray(String[]::new);
            vista.mostrarTabla(cabecera, filas);
        }
    }

    private void exportarResultadosCSV() {
        Path ruta = Paths.get(System.getProperty("user.home"), "Escritorio", "resultados_alumnos.csv");
        try (BufferedWriter bw = Files.newBufferedWriter(ruta)) {
            bw.write("Nombre,Matricula,Promedio");
            bw.newLine();
            for (Alumno alumno : alumnos) {
                bw.write(String.join(",", alumno.getNombre(), alumno.getMatricula(),
                        String.format("%.2f", alumno.calcularPromedio())));
                bw.newLine();
            }
            vista.mostrarMensaje("Resultados exportados a 'resultados_alumnos.csv'.");
        } catch (IOException e) {
            vista.mostrarMensaje("Error al exportar resultados: " + e.getMessage());
        }
    }
}
