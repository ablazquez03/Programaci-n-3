package semana7;

import java.util.Scanner;

public class VistaCalculadora {
    private final Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\nMenú:");
        System.out.println("1.- Leer los números");
        System.out.println("2.- Calcular la suma");
        System.out.println("3.- Mostrar el resultado");
        System.out.println("q.- Salir");
        System.out.print("Elige una opción: ");
    }

    public int leerNumero(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }

    public void mostrarResultado(String mensaje) {
        System.out.println(mensaje);
    }

    public String leerOpcion() {
        return scanner.next();
    }
}
