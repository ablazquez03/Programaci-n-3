package semana9;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class ControladorLibros {
    private final List<Libro> libros;
    private final VistaLibros vista;
    private static final Path LIBROS_BIN = Paths.get(System.getProperty("user.home"), "Escritorio", "libros.bin");

    public ControladorLibros(VistaLibros vista) {
        this.libros = new ArrayList<>();
        this.vista = vista;
        cargarLibrosSerializados();
    }

    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.leerString("");

            switch (opcion) {
                case "1":
                    mostrarLibros();
                    break;
                case "2":
                    agregarLibro();
                    break;
                case "3":
                    eliminarLibro();
                    break;
                case "4":
                    modificarLibro();
                    break;
                case "5":
                    exportarCSV();
                    break;
                case "6":
                    exportarJSON();
                    break;
                case "7":
                    exportarXML();
                    break;
                case "8":
                    importarJSON();
                    break;
                case "9":
                    importarXML();
                    break;
                case "10":
                    importarCSV();
                    break;
                case "11":
                    guardarLibrosSerializados();
                    vista.mostrarMensaje("Saliendo...");
                    return;
                default:
                    vista.mostrarMensaje("Opción no válida. Inténtalo de nuevo.");
            }
        } while (true);
    }

    private void cargarLibrosSerializados() {
        if (Files.exists(LIBROS_BIN)) {
            try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(LIBROS_BIN))) {
                libros.addAll((List<Libro>) ois.readObject());
                vista.mostrarMensaje("Libros cargados desde el archivo binario.");
            } catch (IOException | ClassNotFoundException e) {
                vista.mostrarMensaje("Error al cargar los libros: " + e.getMessage());
            }
        } else {
            vista.mostrarMensaje("No se encontró el archivo libros.bin en el escritorio.");
        }
    }

    private void guardarLibrosSerializados() {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(LIBROS_BIN))) {
            oos.writeObject(libros);
            vista.mostrarMensaje("Libros guardados en libros.bin.");
        } catch (IOException e) {
            vista.mostrarMensaje("Error al guardar los libros: " + e.getMessage());
        }
    }

    private void mostrarLibros() {
        if (libros.isEmpty()) {
            vista.mostrarMensaje("No hay libros en la colección.");
        } else {
            String cabecera = Libro.cabeceraTabla();
            String[] filas = libros.stream().map(Libro::toString).toArray(String[]::new);
            vista.mostrarTabla(cabecera, filas);
        }
    }

    private void agregarLibro() {
        String titulo = vista.leerString("Introduce el título: ");
        String autor = vista.leerString("Introduce el autor: ");
        int anio = vista.leerEntero("Introduce el año de publicación: ");
        String isbn = vista.leerString("Introduce el ISBN: ");

        Libro nuevoLibro = new Libro(titulo, autor, anio, isbn);
        if (libros.contains(nuevoLibro)) {
            vista.mostrarMensaje("El libro ya existe en la colección.");
        } else {
            libros.add(nuevoLibro);
            vista.mostrarMensaje("Libro añadido con éxito.");
        }
    }

    // Métodos para eliminar, modificar, importar/exportar (pendientes de implementar).

    private void eliminarLibro() {
        mostrarLibros();
        int indice = vista.leerEntero("Introduce el índice del libro a eliminar: ");
        if (indice >= 0 && indice < libros.size()) {
            libros.remove(indice);
            vista.mostrarMensaje("Libro eliminado con éxito.");
        } else {
            vista.mostrarMensaje("Índice no válido.");
        }
    }
}
