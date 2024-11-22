package semana8;

import java.util.Scanner;

public class VistaAlumnos {
    public final Scanner scanner;

    public VistaAlumnos() {

        this.scanner = new Scanner(System.in);

    }
    public void mostrarMenu() {
        System.out.println("\nMenú Alumnos:");
        System.out.println("1.- Calcular promedio general");
        System.out.println("2.- Listar alumnos aprobados");
        System.out.println("3.- Listar alumnos reprobados");
        System.out.println("4.- Exportar resultados a CSV");
        System.out.println("q.- Salir");
        System.out.print("Elige una opción: ");
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
