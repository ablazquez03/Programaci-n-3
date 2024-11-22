package semana4;

public class SumaArgumentos {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Error, debes proporcionar 2 argumentos y que sean numéricos.");
            return;
        }

        try {
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);
            System.out.printf("La suma de %d y %d es: %d%n", num1, num2, num1 + num2);
        } catch (NumberFormatException e) {
            System.err.println("Error: Los argumentos deben ser numéricos.");
        }
    }
}
