package semana5.paquete1;
import java.util.Arrays;
import java.util.Scanner;

public class OrdenarStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] cadenas = new String[5];
        System.out.println("Introduce 5 cadenas:");

        for (int i = 0; i < cadenas.length; i++) {
            System.out.printf("Cadena %d: ", i + 1);
            cadenas[i] = scanner.nextLine();
        }

        // Ordenar el array
        Arrays.sort(cadenas);

        System.out.println("\nCadenas ordenadas:");
        for (String cadena : cadenas) {
            System.out.println(cadena);
        }

        scanner.close();
    }
}
