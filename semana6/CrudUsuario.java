package semana6;

import java.util.ArrayList;
import java.util.Scanner;

class Usuario {
    private String nombre;
    private int edad;
    private String email;

    public Usuario(String nombre, int edad, String email) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s, Edad: %d, Email: %s", nombre, edad, email);
    }
}

public class CrudUsuario {
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Usuarios ---");
            System.out.println("1. Agregar usuario");
            System.out.println("2. Mostrar usuarios");
            System.out.println("3. Actualizar usuario");
            System.out.println("4. Eliminar usuario");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1 -> agregarUsuario();
                case 2 -> mostrarUsuarios();
                case 3 -> actualizarUsuario();
                case 4 -> eliminarUsuario();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    private static void agregarUsuario() {
        System.out.print("Introduce el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce la edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Introduce el email: ");
        String email = scanner.nextLine();

        usuarios.add(new Usuario(nombre, edad, email));
        System.out.println("Usuario agregado.");
    }

    private static void mostrarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
        System.out.println("\n--- Lista de Usuarios ---");
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    private static void actualizarUsuario() {
        System.out.print("Introduce el nombre del usuario a actualizar: ");
        String nombre = scanner.nextLine();
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equalsIgnoreCase(nombre)) {
                System.out.print("Introduce el nuevo nombre: ");
                usuario.setNombre(scanner.nextLine());
                System.out.print("Introduce la nueva edad: ");
                usuario.setEdad(scanner.nextInt());
                scanner.nextLine(); // Limpiar el buffer
                System.out.print("Introduce el nuevo email: ");
                usuario.setEmail(scanner.nextLine());
                System.out.println("Usuario actualizado.");
                return;
            }
        }
        System.out.println("Usuario no encontrado.");
    }

    private static void eliminarUsuario() {
        System.out.print("Introduce el nombre del usuario a eliminar: ");
        String nombre = scanner.nextLine();
        if (usuarios.removeIf(usuario -> usuario.getNombre().equalsIgnoreCase(nombre))) {
            System.out.println("Usuario eliminado.");
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }
}
