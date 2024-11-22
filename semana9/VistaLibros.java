package semana9;

import java.util.Scanner;

public class VistaLibros {
    private final Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\nMenú Libros:");
        System.out.println("1.- Mostrar el listado de libros");
        System.out.println("2.- Añadir un nuevo libro");
        System.out.println("3.- Eliminar un libro");
        System.out.println("4.- Modificar un libro");
        System.out.println("5.- Exportar libros a CSV");
        System.out.println("6.- Exportar libros a JSON");
        System.out.println("7.- Exportar libros a XML");
        System.out.println("8.- Importar libros desde JSON");
        System.out.println("9.- Importar libros desde XML");
        System.out.println("10.- Importar libros desde CSV");
        System.out.println("11.- Salir");
        System.out.print("Elige una opción: ");
    }

    public String leerString(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, introduce un número entero.");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        return valor;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarTabla(String cabecera, String[] filas) {
        System.out.println(cabecera);
        for (String fila : filas) {
            System.out.println(fila);
        }
    }
}
