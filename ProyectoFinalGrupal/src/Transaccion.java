import java.util.ArrayList;
import java.util.List;

public class Transaccion {
    private int idTransaccion;
    private Usuario usuario;
    private Evento evento;
    private String tipoBoleto;
    private List<Transaccion> carrito;

    public Transaccion(int idTransaccion, Usuario usuario, Evento evento, String tipoBoleto) {
        this.idTransaccion = idTransaccion;
        this.usuario = usuario;
        this.evento = evento;
        this.tipoBoleto = tipoBoleto;
        this.carrito = new ArrayList<>();
    }

    public void agregarAlCarrito(Transaccion transaccion) {
        carrito.add(transaccion);
    }

    public void checkout() {
        // Implementar lógica para checkout
    }

    public int getIdTransaccion() {
        return idTransaccion;

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Evento getEvento() {
        return evento;
    }

}
