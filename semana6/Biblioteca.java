package semana6;

import java.util.HashMap;
import java.util.Scanner;

class Libro {
    private String titulo;
    private String autor;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return String.format("Título: %s, Autor: %s", titulo, autor);
    }
}

public class Biblioteca {
    private static HashMap<String, Libro> libros = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("1. Agregar libro");
            System.out.println("2. Mostrar libros");
            System.out.println("3. Actualizar libro");
            System.out.println("4. Eliminar libro");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> agregarLibro();
                case 2 -> mostrarLibros();
                case 3 -> actualizarLibro();
                case 4 -> eliminarLibro();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    private static void agregarLibro() {
        System.out.print("Introduce el ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Introduce el título: ");
        String titulo = scanner.nextLine();
        System.out.print("Introduce el autor: ");
        String autor = scanner.nextLine();
        libros.put(isbn, new Libro(titulo, autor));
        System.out.println("Libro agregado.");
    }

    private static void mostrarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros disponibles.");
            return;
        }
        for (String isbn : libros.keySet()) {
            System.out.println(isbn + " -> " + libros.get(isbn));
        }
    }

    private static void actualizarLibro() {
        System.out.print("Introduce el ISBN del libro a actualizar: ");
        String isbn = scanner.nextLine();
        if (libros.containsKey(isbn)) {
            System.out.print("Introduce el nuevo título: ");
            String nuevoTitulo = scanner.nextLine();
            System.out.print("Introduce el nuevo autor: ");
            String nuevoAutor = scanner.nextLine();
            libros.put(isbn, new Libro(nuevoTitulo, nuevoAutor));
            System.out.println("Libro actualizado.");
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    private static void eliminarLibro() {
        System.out.print("Introduce el ISBN del libro a eliminar: ");
        String isbn = scanner.nextLine();
        if (libros.remove(isbn) != null) {
            System.out.println("Libro eliminado.");
        } else {
            System.out.println("Libro no encontrado.");
        }
    }
}
