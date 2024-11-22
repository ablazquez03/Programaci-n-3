package semana4;

public class Usuario {
    private String nombre;
    private float peso;
    private float altura;

    public Usuario(String nombre, float peso, float altura) {
        this.nombre = nombre;
        this.peso = peso;
        this.altura = altura;
    }

    public static Usuario fromArgs(String[] args) {
        if (args.length != 3) {
            System.err.println("Error, Debes proporcionar nombre, peso y altura, en ese orden.");
            return null;
        }

        String nombre = args[0];
        float peso = Float.parseFloat(args[1]);
        float altura = Float.parseFloat(args[2]);

        return new Usuario(nombre, peso, altura);
    }

    public float calcularIMC() {
        return peso / (altura * altura);
    }

    @Override
    public String toString() {
        return String.format("| %-10s | %-6.2f kg | %-6.2f m | IMC: %.2f |", 
                             nombre, peso, altura, calcularIMC());
    }

    public static void main(String[] args) {
        try {
            Usuario usuario = Usuario.fromArgs(args);
            System.out.println("| Nombre     | Peso     | Altura   | IMC        |");
            System.out.println("|------------|----------|----------|------------|");
            System.out.println(usuario);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
