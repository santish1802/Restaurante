public class Mesa {
    private int numero;
    private String cliente;
    private String mesero;
    private double dineroFacturado;
    private int tiempoOcupacion; // Tiempo en minutos

    public Mesa(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getMesero() {
        return mesero;
    }

    public void setMesero(String mesero) {
        this.mesero = mesero;
    }

    public double getDineroFacturado() {
        return dineroFacturado;
    }

    public void setDineroFacturado(double dineroFacturado) {
        this.dineroFacturado = dineroFacturado;
    }

    public int getTiempoOcupacion() {
        return tiempoOcupacion;
    }

    public void setTiempoOcupacion(int tiempoOcupacion) {
        this.tiempoOcupacion = tiempoOcupacion;
    }

    @Override
    public String toString() {
        return "Mesa " + numero + " - Cliente: " + cliente + ", Mesero: " + mesero + ", Dinero Facturado: " + dineroFacturado + ", Tiempo Ocupación: " + tiempoOcupacion + " min";
    }
}
