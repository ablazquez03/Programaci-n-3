package semana6;

import java.util.ArrayList;
import java.util.Scanner;

class Coche {
    private String matricula;
    private String marca;
    private String modelo;

    public Coche(String matricula, String marca, String modelo) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return String.format("Matrícula: %s, Marca: %s, Modelo: %s", matricula, marca, modelo);
    }
}

public class Concesionario {
    private static ArrayList<Coche> coches = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("1. Agregar coche");
            System.out.println("2. Mostrar coches");
            System.out.println("3. Actualizar coche");
            System.out.println("4. Eliminar coche");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> agregarCoche();
                case 2 -> mostrarCoches();
                case 3 -> actualizarCoche();
                case 4 -> eliminarCoche();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    private static void agregarCoche() {
        System.out.print("Introduce la matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Introduce la marca: ");
        String marca = scanner.nextLine();
        System.out.print("Introduce el modelo: ");
        String modelo = scanner.nextLine();
        coches.add(new Coche(matricula, marca, modelo));
        System.out.println("Coche agregado.");
    }

    private static void mostrarCoches() {
        if (coches.isEmpty()) {
            System.out.println("No hay coches disponibles.");
            return;
        }
        for (Coche coche : coches) {
            System.out.println(coche);
        }
    }

    private static void actualizarCoche() {
        System.out.print("Introduce la matrícula del coche a actualizar: ");
        String matricula = scanner.nextLine();
        for (Coche coche : coches) {
            if (coche.getMatricula().equals(matricula)) {
                System.out.print("Introduce la nueva marca: ");
                String nuevaMarca = scanner.nextLine();
                System.out.print("Introduce el nuevo modelo: ");
                String nuevoModelo = scanner.nextLine();
                coches.remove(coche);
                coches.add(new Coche(matricula, nuevaMarca, nuevoModelo));
                System.out.println("Coche actualizado.");
                return;
            }
        }
        System.out.println("Coche no encontrado.");
    }

    private static void eliminarCoche() {
        System.out.print("Introduce la matrícula del coche a eliminar: ");
        String matricula = scanner.nextLine();
        coches.removeIf(coche -> coche.getMatricula().equals(matricula));
        System.out.println("Coche eliminado si existía.");
    }
}

