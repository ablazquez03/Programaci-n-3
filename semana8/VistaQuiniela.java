package semana8;

import java.util.Scanner;

public class VistaQuiniela {
    private final Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\nMenú Quiniela:");
        System.out.println("1.- Introducir resultados");
        System.out.println("2.- Mostrar quiniela");
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

    public void mostrarQuiniela(String cabecera, String[] filas) {
        System.out.println(cabecera);
        for (String fila : filas) {
            System.out.println(fila);
        }
    }
}
