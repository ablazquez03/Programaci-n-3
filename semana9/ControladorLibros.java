package semana9;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;


public class ControladorLibros {
    private final List<Libro> libros;
    private final VistaLibros vista;
    private static final Path LIBROS_BIN = Paths.get(System.getProperty("user.home"), "Escritorio", "libros.bin");
    private static final Path LIBROS_CSV = Paths.get(System.getProperty("user.home"), "Escritorio", "libros.csv");
    private static final Path LIBROS_JSON = Paths.get(System.getProperty("user.home"), "Escritorio", "libros.json");
    private static final Path LIBROS_XML = Paths.get(System.getProperty("user.home"), "Escritorio", "libros.xml");

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

    private void modificarLibro() {
        mostrarLibros();
        int indice = vista.leerEntero("Introduce el índice del libro a modificar: ");
        if (indice >= 0 && indice < libros.size()) {
            Libro libro = libros.get(indice);
            String nuevoTitulo = vista.leerString("Introduce el nuevo título (deja vacío para no cambiar): ");
            if (!nuevoTitulo.isEmpty()) libro.setTitulo(nuevoTitulo);

            String nuevoAutor = vista.leerString("Introduce el nuevo autor (deja vacío para no cambiar): ");
            if (!nuevoAutor.isEmpty()) libro.setAutor(nuevoAutor);

            int nuevoAnio = vista.leerEntero("Introduce el nuevo año de publicación (0 para no cambiar): ");
            if (nuevoAnio != 0) libro.setAnioPublicacion(nuevoAnio);

            String nuevoIsbn = vista.leerString("Introduce el nuevo ISBN (deja vacío para no cambiar): ");
            if (!nuevoIsbn.isEmpty()) libro.setIsbn(nuevoIsbn);

            vista.mostrarMensaje("Libro modificado con éxito.");
        } else {
            vista.mostrarMensaje("Índice no válido.");
        }
    }

    private void exportarCSV() {
        try (BufferedWriter bw = Files.newBufferedWriter(LIBROS_CSV)) {
            for (Libro libro : libros) {
                bw.write(String.join(",", libro.getTitulo(), libro.getAutor(),
                        String.valueOf(libro.getAnioPublicacion()), libro.getIsbn()));
                bw.newLine();
            }
            vista.mostrarMensaje("Libros exportados a 'libros.csv'.");
        } catch (IOException e) {
            vista.mostrarMensaje("Error al exportar libros: " + e.getMessage());
        }
    }

    private void exportarJSON() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(LIBROS_JSON.toFile(), libros);
            vista.mostrarMensaje("Libros exportados a 'libros.json'.");
        } catch (IOException e) {
            vista.mostrarMensaje("Error al exportar libros: " + e.getMessage());
        }
    }

    private void exportarXML() {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(LIBROS_XML.toFile(), libros);
            vista.mostrarMensaje("Libros exportados a 'libros.xml'.");
        } catch (IOException e) {
            vista.mostrarMensaje("Error al exportar libros: " + e.getMessage());
        }
    }

    private void importarCSV() {
        try (BufferedReader br = Files.newBufferedReader(LIBROS_CSV)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 4) {
                    libros.add(new Libro(partes[0], partes[1], Integer.parseInt(partes[2]), partes[3]));
                }
            }
            vista.mostrarMensaje("Libros importados desde 'libros.csv'.");
        } catch (IOException e) {
            vista.mostrarMensaje("Error al importar libros: " + e.getMessage());
        }
    }

    private void importarJSON() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Libro> importados = mapper.readValue(LIBROS_JSON.toFile(),
                    mapper.getTypeFactory().constructCollectionType(List.class, Libro.class));
            libros.addAll(importados);
            vista.mostrarMensaje("Libros importados desde 'libros.json'.");
        } catch (IOException e) {
            vista.mostrarMensaje("Error al importar libros: " + e.getMessage());
        }
    }

    private void importarXML() {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            List<Libro> importados = xmlMapper.readValue(LIBROS_XML.toFile(),
                    xmlMapper.getTypeFactory().constructCollectionType(List.class, Libro.class));
            libros.addAll(importados);
            vista.mostrarMensaje("Libros importados desde 'libros.xml'.");
        } catch (IOException e) {
            vista.mostrarMensaje("Error al importar libros: " + e.getMessage());
        }
    }
}
