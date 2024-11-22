package semana4;

import java.util.Scanner;

public class Fruteria {
    private static final double IVA = 0.21;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el precio por kg de manzanas sin IVA: ");
        double precioManzanas = scanner.nextDouble();

        System.out.print("Introduce el precio por kg de peras sin IVA: ");
        double precioPeras = scanner.nextDouble();

        int cliente = 1;
        while (true) {
            System.out.printf("Cliente %d%n", cliente);
            System.out.print("Introduce los kg de manzanas: ");
            double kgManzanas = scanner.nextDouble();

            System.out.print("Introduce los kg de peras: ");
            double kgPeras = scanner.nextDouble();

            double totalManzanas = kgManzanas * precioManzanas * (1 + IVA);
            double totalPeras = kgPeras * precioPeras * (1 + IVA);
            double total = totalManzanas + totalPeras;

            System.out.printf("| Cliente                            | %4d   |%n", cliente);
            System.out.println("|--------------------------------------------|");
            System.out.printf("| Manzanas | %.2f kg | %.2f €/kg | %.2f € |%n", 
                              kgManzanas, precioManzanas * (1 + IVA), totalManzanas);
            System.out.printf("| Peras    | %.2f kg | %.2f €/kg | %.2f € |%n", 
                              kgPeras, precioPeras * (1 + IVA), totalPeras);
            System.out.println("|--------------------------------------------|");
            System.out.printf("| Total con IVA                        %.2f € |%n", total);
            System.out.println("|--------------------------------------------|");

            System.out.print("¿Deseas atender a otro cliente? (s/n): ");
            scanner.nextLine(); // Limpian el salto de línea
            String respuesta = scanner.nextLine();

            if (!respuesta.equalsIgnoreCase("s")) {
                break;
            }
            cliente++;
        }

        scanner.close();
    }
}
