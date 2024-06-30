public class Factura {
    private int idFactura;
    private Transaccion transaccion;
    private double total;

    public Factura(int idFactura, Transaccion transaccion, double total) {
        this.idFactura = idFactura;
        this.transaccion = transaccion;
        this.total = total;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public double getTotal() {
        return total;
    }
}
