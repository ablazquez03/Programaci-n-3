package semana8;

import java.util.Scanner;

public class VistaJugadores {
    private final Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\nMenú Jugadores:");
        System.out.println("1.- Listar jugadores por equipo");
        System.out.println("2.- Listar jugadores por rango de edad");
        System.out.println("3.- Listar jugadores con salario superior a un valor");
        System.out.println("4.- Exportar jugadores filtrados a CSV");
        System.out.println("q.- Salir");
        System.out.print("Elige una opción: ");
    }

    public String leerString(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }
    public int leerEntero(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }

    public double leerDouble(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextDouble();
    }


    public void mostrarTabla(String cabecera, String[] filas) {
        System.out.println(cabecera);
        for (String fila : filas) {
            System.out.println(fila);
        }
    }

    public void mostrarMensaje(String mensaje) {

        System.out.println(mensaje);

    }
}
