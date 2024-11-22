package semana3;

import java.util.Scanner;

public class PersonSinPara {

    // Clase Person
    public static class Person {
        private String nombre;
        private float altura; 
        private float peso; 

        // Constructor sin parámetros
        public Person() {
            this.nombre = "Antonio";
            this.altura = 1.75f; 
            this.peso = 70.0f;
        }

        // Getters y setters
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
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Person[] personas = new Person[3];
        for (int i = 0; i < 3; i++) {
            personas[i] = new Person();

            System.out.println("Introduce los datos de la persona " + (i + 1) + ":");

            System.out.print("Nombre: ");
            personas[i].setNombre(scanner.nextLine());

            System.out.print("Altura (en metros): ");
            personas[i].setAltura(scanner.nextFloat());

            System.out.print("Peso (en kilogramos): ");
            personas[i].setPeso(scanner.nextFloat());
            scanner.nextLine(); // Limpiar el buffer
        }

        // Determinar la persona más alta
        Person masAlta = personas[0];
        for (Person p : personas) {
            if (p.getAltura() > masAlta.getAltura()) {
                masAlta = p;
            }
        }

        // Determinar la persona que más pesa
        Person masPesada = personas[0];
        for (Person p : personas) {
            if (p.getPeso() > masPesada.getPeso()) {
                masPesada = p;
            }
        }

        System.out.println("\nResultados:");
        System.out.println("La persona más alta es " + masAlta.getNombre() + " con " + masAlta.getAltura() + " metros.");
        System.out.println("La persona que más pesa es " + masPesada.getNombre() + " con " + masPesada.getPeso() + " kg.");

        scanner.close();
    }
}

