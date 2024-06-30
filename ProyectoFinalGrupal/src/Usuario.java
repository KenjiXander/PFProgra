import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private int idUsuario;
    private String nombre;
    private String apellidos;
    private String numeroCedula;
    private String nombreUsuario;
    private String correoElectronico;
    private String contraseña;
    private boolean administrador;
    private List<Boleto> historialCompras;

    public Usuario(int idUsuario, String nombre, String apellidos, String numeroCedula, String nombreUsuario, String correoElectronico, String contraseña, boolean administrador) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numeroCedula = numeroCedula;
        this.nombreUsuario = nombreUsuario;
        this.correoElectronico = correoElectronico;
        this.contraseña = contraseña;
        this.administrador = administrador;
        this.historialCompras = new ArrayList<>();
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNumeroCedula() {
        return numeroCedula;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getContraseña() {
        return contraseña;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public List<Boleto> getHistorialCompras() {
        return historialCompras;
    }

    public void agregarCompra(Boleto boleto) {
        historialCompras.add(boleto);
    }

    public static Usuario registrar(int idUsuario, String nombres, String apellidos, String numeroCedula, String nombreUsuario, String genero, String fechaNacimiento, String correoElectronico, String contraseña, boolean esAdmin) {
        return new Usuario(idUsuario, nombres, apellidos, numeroCedula, nombreUsuario, correoElectronico, contraseña, esAdmin);
    }

    public static Usuario iniciarSesion(String nombreUsuario, String contraseña, List<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContraseña().equals(contraseña)) {
                return usuario;
            }
        }
        return null;
    }

//    public void verHistorialCompras() {
        //if (historialCompras.isEmpty()) {
         //   System.out.println("No hay compras en el historial.");
       // } else {
        //    for (Boleto boleto : historialCompras) {
      //          System.out.println("Boleto ID: " + boleto.getIdBoleto() + ", Evento: " + boleto.getEvento().getNombre() + ", Categoría: " + boleto.getCategoria() + ", Precio: " + boleto.getPrecio());
    //        }
  //      }
//    }
}
