package semana2;
import com.coti.textfiletools.AuxText;
import java.util.Scanner;

public class CalculoMedi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;

        // Solicitamos un número entero mayor que cero
        while (true) {
            System.out.print("Introduce un número entero mayor que cero: ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n > 0) {
                    break;
                } else {
                    System.err.println("El número debe ser mayor que cero.");
                }
            } else {
                System.err.println("Entrada inválida. Introduce un número entero.");
                scanner.next(); 
            }
        }
       
        // Inicializamos variables para la suma y contar las iteraciones
        double suma = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Introduce el número " + i + ": ");
            double numero = scanner.nextDouble(); 
            suma += numero; // Sumamos al total
        }
       
        // Calculamos la media
        double media = suma / n;
        System.out.println("La media de los números introducidos es: " + media);

        scanner.close();
    }
}
