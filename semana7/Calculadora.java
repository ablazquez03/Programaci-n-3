package semana7;

public class Calculadora {
    private int numero1;
    private int numero2;

    // Getters y Setters
    public int getNumero1() {
        return numero1;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public int getNumero2() {
        return numero2;
    }

    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }

    // Método para calcular la suma
    public int calcularSuma() {
        return numero1 + numero2;
    }
}
