package semana4;

import java.util.Scanner;

class Alumno {
    String nombre;
    double parcial1;
    double parcial2;
    double finalExamen;
    double notaFinal;

    public Alumno(String nombre, double parcial1, double parcial2, double finalExamen) {
        this.nombre = nombre;
        this.parcial1 = parcial1;
        this.parcial2 = parcial2;
        this.finalExamen = finalExamen;
        this.notaFinal = parcial1 * 0.1 + parcial2 * 0.1 + finalExamen * 0.8;
    }
}

public class Calificaciones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el número de alumnos: ");
        int numAlumnos = scanner.nextInt();
        scanner.nextLine();

        Alumno[] alumnos = new Alumno[numAlumnos];

        for (int i = 0; i < numAlumnos; i++) {
            System.out.printf("Introduce el nombre del alumno %d: ", i + 1);
            String nombre = scanner.nextLine();
            System.out.print("Nota parcial 1: ");
            double parcial1 = scanner.nextDouble();
            System.out.print("Nota parcial 2: ");
            double parcial2 = scanner.nextDouble();
            System.out.print("Nota final: ");
            double finalExamen = scanner.nextDouble();
            scanner.nextLine();

            alumnos[i] = new Alumno(nombre, parcial1, parcial2, finalExamen);
        }

        System.out.println("| Nombre    | Parcial 1 | Parcial 2 | Final  | Nota Final |");
        double totalP1 = 0, totalP2 = 0, totalFinal = 0;

        for (Alumno alumno : alumnos) {
            totalP1 += alumno.parcial1;
            totalP2 += alumno.parcial2;
            totalFinal += alumno.notaFinal;
            System.out.printf("| %-9s | %9.2f | %9.2f | %6.2f | %10.2f |%n", 
                              alumno.nombre, alumno.parcial1, alumno.parcial2, alumno.finalExamen, alumno.notaFinal);
        }

        System.out.println("|-----------|-----------|-----------|--------|------------|");
        System.out.printf("Medias:      %9.2f   %9.2f   %6.2f   %10.2f%n", 
                          totalP1 / numAlumnos, totalP2 / numAlumnos, totalFinal / numAlumnos);

        scanner.close();
    }
}
