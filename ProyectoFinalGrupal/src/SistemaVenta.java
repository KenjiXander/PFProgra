import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SistemaVenta {
    private List<Evento> eventos;
    private List<Usuario> usuarios;

    public SistemaVenta() {
        eventos = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public void agregarEvento(Evento evento) {
        eventos.add(evento);
        ordenarEventos();
    }

    public void modificarEvento(int idEvento, String lugar, String fecha, int espacioTotal, List<String> tiposButacas) {
        Evento evento = buscarEventoPorId(idEvento);
        if (evento != null) {
            evento.modificarEvento(lugar, fecha, espacioTotal, tiposButacas);
        }
    }

    public void eliminarEvento(int idEvento) {
        eventos.removeIf(evento -> evento.getIdEvento() == idEvento);
    }

    public void publicarEvento(int idEvento) {
        Evento evento = buscarEventoPorId(idEvento);
        if (evento != null) {
            evento.publicarEvento();
        }
    }

    public Evento buscarEventoPorId(int idEvento) {
        int index = Collections.binarySearch(eventos, new Evento(idEvento, "", "", "", "", "", 0), Comparator.comparingInt(Evento::getIdEvento));
        return index >= 0 ? eventos.get(index) : null;
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario iniciarSesion(String nombreUsuario, String contraseña) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContraseña().equals(contraseña)) {
                return usuario;
            }
        }
        return null;
    }

    public void mostrarEventos() {
        for (Evento evento : eventos) {
            if (evento.isPublicado()) {
                evento.mostrarInformacion();
            }
        }
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    private void ordenarEventos() {
        Collections.sort(eventos, Comparator.comparingInt(Evento::getIdEvento));
    }
}
