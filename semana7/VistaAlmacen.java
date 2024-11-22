package semana7;

import java.util.Scanner;

public class VistaAlmacen {
    private final Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\nMenú:");
        System.out.println("1.- Leer tabla de ventas");
        System.out.println("2.- Leer tabla de precios");
        System.out.println("3.- Calcular ingresos totales");
        System.out.println("4.- Mostrar resultados");
        System.out.println("q.- Salir");
        System.out.print("Elige una opción: ");
    }

    public int leerEntero(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }

    public double leerDouble(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextDouble();
    }

    public String leerOpcion() {
        return scanner.next();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarTabla(String[] encabezados, double[] datos) {
        System.out.printf("| %-10s | %-10s |%n", "Almacén", "Ingresos (€)");
        System.out.println("|------------|------------|");
        for (int i = 0; i < datos.length; i++) {
            System.out.printf("| %-10d | %10.2f |%n", i + 1, datos[i]);
        }
    }
}
