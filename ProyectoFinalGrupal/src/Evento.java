import java.util.List;

public class Evento {
    private int idEvento;
    private String nombre;
    private String fecha;
    private String hora;
    private String ciudad;
    private String lugar;
    private int espacioTotal;
    private List<String> tiposButacas;
    private List<String> localidadesButacas;
    private boolean publicado;

    public Evento(int idEvento, String nombre, String fecha, String hora, String ciudad, String lugar, int espacioTotal) {
        this.idEvento = idEvento;
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.ciudad = ciudad;
        this.lugar = lugar;
        this.espacioTotal = espacioTotal;
        this.publicado = false;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getLugar() {
        return lugar;
    }

    public int getEspacioTotal() {
        return espacioTotal;
    }

    public boolean isPublicado() {
        return publicado;
    }

    public void setTiposButacas(List<String> tiposButacas) {
        this.tiposButacas = tiposButacas;
    }

    public void setLocalidadesButacas(List<String> localidadesButacas) {
        this.localidadesButacas = localidadesButacas;
    }

    public void publicarEvento() {
        this.publicado = true;
    }

    public void modificarEvento(String lugar, String fecha, int espacioTotal, List<String> tiposButacas) {
        this.lugar = lugar;
        this.fecha = fecha;
        this.espacioTotal = espacioTotal;
        this.tiposButacas = tiposButacas;
    }

    public void mostrarInformacion() {
        System.out.println("Evento ID: " + idEvento + ", Nombre: " + nombre + ", Fecha: " + fecha + ", Hora: " + hora + ", Ciudad: " + ciudad + ", Lugar: " + lugar + ", Espacio Total: " + espacioTotal);
    }
}
