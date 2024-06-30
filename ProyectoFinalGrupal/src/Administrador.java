public class Administrador extends Usuario {
    private String credenciales;

    public Administrador(int idUsuario, String nombres, String apellidos, String nombreUsuario, String numeroCedula, String genero, String fechaNacimiento, String correo, String contraseña, String credenciales) {
        super(idUsuario, nombres, apellidos, nombreUsuario, numeroCedula, genero, fechaNacimiento, correo, contraseña, true);
        this.credenciales = credenciales;
    }

    public boolean validarSuperAdmin(String usuario, String contraseña) {
        return "admin".equals(usuario) && "admin".equals(contraseña);
    }

    public void administrar() {
        // Implementar lógica para administrar
    }
}
