package semana7;

import java.util.ArrayList;
import java.util.List;

public class ControladorBiblioteca {
    private final List<Libro> libros;
    private final VistaBiblioteca vista;

    public ControladorBiblioteca(VistaBiblioteca vista) {
        this.libros = new ArrayList<>();
        this.vista = vista;
    }

    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.leerOpcion();

            switch (opcion) {
                case "1":
                    agregarLibro();
                    break;

                case "2":
                    listarLibros();
                    break;

                case "3":
                    actualizarLibro();
                    break;

                case "4":
                    eliminarLibro();
                    break;

                case "q":
                    vista.mostrarMensaje("Saliendo del sistema...");
                    break;

                default:
                    vista.mostrarMensaje("Opción no válida. Inténtalo de nuevo.");
            }
        } while (!opcion.equals("q"));
    }

    private void agregarLibro() {
        String isbn = vista.leerString("Introduce el ISBN del libro: ");
        String titulo = vista.leerString("Introduce el título del libro: ");
        String autor = vista.leerString("Introduce el autor del libro: ");
        libros.add(new Libro(isbn, titulo, autor));
        vista.mostrarMensaje("Libro añadido con éxito.");
    }

    private void listarLibros() {
        if (libros.isEmpty()) {
            vista.mostrarMensaje("No hay libros en la biblioteca.");
        } else {
            vista.mostrarLibrosHeader();
            for (Libro libro : libros) {
                vista.mostrarLibro(libro.toString());
            }
        }
    }

    private void actualizarLibro() {
        String isbn = vista.leerString("Introduce el ISBN del libro a actualizar: ");
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                String nuevoTitulo = vista.leerString("Introduce el nuevo título (deja vacío para no cambiar): ");
                String nuevoAutor = vista.leerString("Introduce el nuevo autor (deja vacío para no cambiar): ");
                if (!nuevoTitulo.isEmpty()) libro.setTitulo(nuevoTitulo);
                if (!nuevoAutor.isEmpty()) libro.setAutor(nuevoAutor);
                vista.mostrarMensaje("Libro actualizado con éxito.");
                return;
            }
        }
        vista.mostrarMensaje("Libro no encontrado.");
    }

    private void eliminarLibro() {
        String isbn = vista.leerString("Introduce el ISBN del libro a eliminar: ");
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getIsbn().equals(isbn)) {
                libros.remove(i);
                vista.mostrarMensaje("Libro eliminado con éxito.");
                return;
            }
        }
        vista.mostrarMensaje("Libro no encontrado.");
    }
}
