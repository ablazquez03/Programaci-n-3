package semana8;

public class Partido {
    private String equipoLocal;
    private String equipoVisitante;
    private String resultado; // "1", "X", "2"

    public Partido(String equipoLocal, String equipoVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.resultado = ""; // Sin definir
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return String.format("| %-20s | %-20s | %-3s |", equipoLocal, equipoVisitante, resultado.isEmpty() ? "ND" : resultado);
    }
}
