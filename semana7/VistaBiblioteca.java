package semana7;

import java.util.Scanner;

public class VistaBiblioteca {
    private final Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\nMenú Biblioteca:");
        System.out.println("1.- Añadir libro");
        System.out.println("2.- Listar libros");
        System.out.println("3.- Actualizar libro");
        System.out.println("4.- Eliminar libro");
        System.out.println("q.- Salir");
        System.out.print("Elige una opción: ");
    }

    public String leerString(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarLibrosHeader() {
        System.out.println("| ISBN          | Título               | Autor           |");
        System.out.println("|---------------|----------------------|-----------------|");
    }

    public void mostrarLibro(String libroInfo) {
        System.out.println(libroInfo);
    }

    public String leerOpcion() {
        return scanner.nextLine();
    }
}
