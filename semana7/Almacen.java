package semana7;

public class Almacen {
    private int[][] ventas; // Ventas por almacén y producto
    private double[] precios; // Precios de los productos

    public Almacen() {
        this.ventas = new int[5][2]; // 5 almacenes y 2 productos
        this.precios = new double[2]; // Precios para 2 productos
    }

    // Getters y setters para ventas
    public int[][] getVentas() {
        return ventas;
    }

    public void setVentas(int[][] ventas) {
        this.ventas = ventas;
    }

    // Getters y setters para precios
    public double[] getPrecios() {
        return precios;
    }

    public void setPrecios(double[] precios) {
        this.precios = precios;
    }

    // Calcular ingresos totales por almacén
    public double[] calcularIngresosTotales() {
        double[] ingresos = new double[5]; // Ingresos por almacén
        for (int i = 0; i < ventas.length; i++) {
            for (int j = 0; j < ventas[i].length; j++) {
                ingresos[i] += ventas[i][j] * precios[j];
            }
        }
        return ingresos;
    }
}
