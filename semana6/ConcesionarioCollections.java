package semana6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Coche implements Comparable<Coche> {
    private String marca;
    private String modelo;
    private double precio;

    public Coche(String marca, String modelo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return String.format("| %-10s | %-10s | %10.2f € |", marca, modelo, precio);
    }

    @Override
    public int compareTo(Coche other) {
        return Double.compare(this.precio, other.precio);
    }
}

public class ConcesionarioCollections {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Coche> coches = new ArrayList<>();

        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Añadir coche");
            System.out.println("2. Listar coches");
            System.out.println("3. Editar coche");
            System.out.println("4. Eliminar coche");
            System.out.println("5. Ordenar por precio");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    // Añadir coche
                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Precio: ");
                    double precio = scanner.nextDouble();
                    coches.add(new Coche(marca, modelo, precio));
                    System.out.println("Coche añadido.");
                    break;

                case 2:
                    // Listar coches
                    if (coches.isEmpty()) {
                        System.out.println("No hay coches en el stock.");
                    } else {
                        System.out.println("| Marca      | Modelo     |    Precio (€) |");
                        System.out.println("|------------|------------|---------------|");
                        for (Coche coche : coches) {
                            System.out.println(coche);
                        }
                    }
                    break;

                case 3:
                    // Editar coche
                    System.out.print("Introduce el índice del coche a editar (0-" + (coches.size() - 1) + "): ");
                    int indiceEditar = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    if (indiceEditar >= 0 && indiceEditar < coches.size()) {
                        Coche coche = coches.get(indiceEditar);
                        System.out.println("Editando: " + coche);
                        System.out.print("Nueva marca (deja vacío para no cambiar): ");
                        String nuevaMarca = scanner.nextLine();
                        System.out.print("Nuevo modelo (deja vacío para no cambiar): ");
                        String nuevoModelo = scanner.nextLine();
                        System.out.print("Nuevo precio (introduce -1 para no cambiar): ");
                        double nuevoPrecio = scanner.nextDouble();
                        scanner.nextLine(); // Limpiar el buffer

                        if (!nuevaMarca.isEmpty()) coche.setMarca(nuevaMarca);
                        if (!nuevoModelo.isEmpty()) coche.setModelo(nuevoModelo);
                        if (nuevoPrecio >= 0) coche.setPrecio(nuevoPrecio);

                        System.out.println("Coche editado.");
                    } else {
                        System.out.println("Índice no válido.");
                    }
                    break;

                case 4:
                    // Eliminar coche
                    System.out.print("Introduce el índice del coche a eliminar (0-" + (coches.size() - 1) + "): ");
                    int indiceEliminar = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    if (indiceEliminar >= 0 && indiceEliminar < coches.size()) {
                        coches.remove(indiceEliminar);
                        System.out.println("Coche eliminado.");
                    } else {
                        System.out.println("Índice no válido.");
                    }
                    break;

                case 5:
                    // Ordenar por precio
                    Collections.sort(coches);
                    System.out.println("Coches ordenados por precio.");
                    break;

                case 6:
                    // Salir
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 6);

        scanner.close();
    }
}
