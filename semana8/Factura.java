package semana8;

public class Factura {
    private String concepto;
    private double descuento;
    private String fecha;
    private double importe;
    private String nif;
    private String nombreCliente;
    private String direccion;
    private double iva;

    public Factura(String concepto, double descuento, String fecha, double importe, String nif, String nombreCliente, String direccion, double iva) {
        this.concepto = concepto;
        this.descuento = descuento;
        this.fecha = fecha;
        this.importe = importe;
        this.nif = nif;
        this.nombreCliente = nombreCliente;
        this.direccion = direccion;
        this.iva = iva;
    }

    public double calcularImporteFinal() {
        return importe * (1 - descuento) * (1 + iva);
    }

    public static String cabeceraTabla() {
        return String.format("| %-20s | %-10s | %-10s | %-8s | %-15s | %-20s | %-20s | %-5s |", 
                "Concepto", "Descuento", "Fecha", "Importe", "NIF", "Cliente", "Dirección", "IVA");
    }

    public String toFila() {
        return String.format("| %-20s | %-10.2f | %-10s | %-8.2f | %-15s | %-20s | %-20s | %-5.2f |", 
                concepto, descuento, fecha, importe, nif, nombreCliente, direccion, iva);
    }
}
