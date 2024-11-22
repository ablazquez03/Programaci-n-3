package semana2;


import java.util.Scanner;

public class Anioo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce tu año de nacimiento: ");
        int anioN = scanner.nextInt();

        System.out.print("Introduce año actual: ");
        int anioA = scanner.nextInt();

        int edad = anioA - anioN;

        System.out.printf("Tienes %d años.%n", edad);

        scanner.close();
    }
}

