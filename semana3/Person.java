package semana3;
import java.util.Scanner;

public class Person {
    private String nombre;
    private float altura;
    private float peso;

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Person[] personas = new Person[3];

        for (int i = 0; i < 3; i++) {
            personas[i] = new Person();
            System.out.printf("Introduce el nombre de la persona %d: ", i + 1);
            personas[i].setNombre(scanner.nextLine());
            System.out.printf("Introduce la altura de %s (en metros): ", personas[i].getNombre());
            personas[i].setAltura(scanner.nextFloat());
            System.out.printf("Introduce el peso de %s (en kg): ", personas[i].getNombre());
            personas[i].setPeso(scanner.nextFloat());
            scanner.nextLine();
        }

        Person masAlto = personas[0];
        Person masPesado = personas[0];

        for (Person persona : personas) {
            if (persona.getAltura() > masAlto.getAltura()) masAlto = persona;
            if (persona.getPeso() > masPesado.getPeso()) masPesado = persona;
        }

        System.out.printf("La persona más alta es %s con %.2f metros.%n", masAlto.getNombre(), masAlto.getAltura());
        System.out.printf("La persona con más peso es %s con %.2f kg.%n", masPesado.getNombre(), masPesado.getPeso());

        scanner.close();
    }
}
