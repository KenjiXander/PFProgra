public class Boleto {
    private int idBoleto;
    private Evento evento;
    private Usuario usuario;
    private String categoria;
    private double precio;
    private String codigoQR;
    private String estado;

    public Boleto(int idBoleto, Evento evento, Usuario usuario, String categoria, double precio, String codigoQR, String estado) {
        this.idBoleto = idBoleto;
        this.evento = evento;
        this.usuario = usuario;
        this.categoria = categoria;
        this.precio = precio;
        this.codigoQR = codigoQR;
        this.estado = estado;
    }

    public void generarQR() {
        // Lógica para generar el código QR
    }

    public void validarBoleto() {
        // Lógica para validar el boleto
    }

    public void marcarUsado() {
        estado = "Usado";
    }

    public void reembolsar() {
        estado = "Reembolsado";
    }
}
