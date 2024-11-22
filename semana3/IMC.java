package semana3;

public class IMC {
    private String nombre;
    private float altura;
    private float peso;

    // Constructor
    public IMC(String nombre, float altura, float peso) {
        this.nombre = nombre;
        this.altura = altura;
        this.peso = peso;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
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


    // Calcular el IMC
    public float calcularIMC() {
        if (altura <= 0 || peso <= 0) {
            System.err.println("Altura y peso deben ser valores positivos.");
            return -1;
        }
        return peso / (altura * altura);
    }

    public static void main(String[] args) {
        
        // Crear objeto IMC
        IMC persona = new IMC("Antonio", 1.75f, 70.0f);

        // Calcular y mostrar el IMC
        float imc = persona.calcularIMC();
        if (imc != -1) {
            System.out.printf("El IMC de %s es %.2f%n", persona.getNombre(), imc);
        }
    }
}
