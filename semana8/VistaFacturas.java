package semana8;

import java.util.Scanner;

public class VistaFacturas {
    private final Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\nMenú Facturas:");
        System.out.println("1.- Listar clientes con facturas superiores al importe mínimo");
        System.out.println("2.- Mostrar todas las facturas");
        System.out.println("3.- Exportar facturas a HTML");
        System.out.println("4.- Exportar facturas a CSV");
        System.out.println("q.- Salir");
        System.out.print("Elige una opción: ");
    }

    public String leerString(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public double leerDouble(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextDouble();
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
