package semana2;
import java.io.Console;

public class CalculoEdadConsol {
    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) {
            System.out.println("No se puede usar Console. Intenta ejecutar desde la terminal.");
            return;
        }

        int anioNacimiento = Integer.parseInt(console.readLine("Introduce tu año de nacimiento: "));
        int anioActual = Integer.parseInt(console.readLine("Introduce el año actual: "));

        int edad = anioActual - anioNacimiento;
        System.out.printf("Tienes %d años.%n", edad);
    }
}
