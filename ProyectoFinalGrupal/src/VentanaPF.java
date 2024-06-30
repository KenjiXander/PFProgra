import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaPF {
    private JPanel panel1;
    private JTabbedPane SistemaVenta;
    private JPanel Comprar;
    private JPanel CrearPublicidad;
    private JPanel AgregarLocalidades;
    private JPanel ModificarArtistas;
    private JPanel NuevoEvento;
    private JTextField idEvTF;
    private JTextField nombreEvTF;
    private JTextField fechaEvTF;
    private JTextField horaEvTF;
    private JComboBox<String> ciudadEvCB;
    private JTextField lugarEvTF;
    private JTextField espaciototalEvTF;
    private JTextField agregarTipoButacaEvTF;
    private JButton agregarTButacaButton;
    private JList<String> localidadesButacasEvList;
    private JList<String> tiposButacasAgregadasEvList;
    private JButton agregarEventoButton;
    private JButton modificarEventoButton;
    private JList<Evento> listaEventosEvList;
    private JButton irACrearPublicidadButton;
    private JTextField idArtistaEvTF;
    private JTextField nombreArtistaEvTF;
    private JTextField generoMusicalArtistaEvTF;
    private JList<Evento> listEventosAArtistaEv;
    private JButton agregarArtistaButton;
    private JButton mostrarArtistasButton;
    private JTextField nombresRegTF;
    private JTextField apellidosRegTF;
    private JTextField nCedulaRegTF;
    private JTextField nombreUsuarioRegTF;
    private JTextField fechaNaciRegTF;
    private JComboBox<String> generoRegCB;
    private JTextField correoRegTF;
    private JPasswordField passRegPF;
    private JCheckBox adminCheckBox;
    private JButton registrarseButton;
    private JTextField usuarioLogTF;
    private JPasswordField passLogPF;
    private JButton iniciarSesionButton;
    private JList<Evento> listEventos;
    private JSpinner spinnerNumeroEntradas;
    private JComboBox<String> comboBoxTipoBoletoVinculadas;
    private JButton agregarAlCarritoButton;
    private JList<String> listCarrito;
    private JButton eliminarDelCarritoButton;
    private JButton modificarEntradasButton;
    private JTextField idPublicidadTF;
    private JComboBox<String> medioPublicidadCB;
    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox2;
    private JTextField presupuestoTF;
    private JTextArea presupuestoTotalHistorial;
    private JList<Evento> listEventosPublicidad;
    private JButton agregarPublicidadButton;
    private JButton modificarPublicidadButton;
    private JButton eliminarPublicidadButton;
    private JList<String> listPublicidad;
    private JTextField nombreLocalidadTF;
    private JTextField capacidadLocalidadTF;
    private JButton agregarLocalidadButton;
    private JList<String> listaLocalidades;
    private JTextField nombredelEventoTF;
    private JButton buscarButton;
    private JList<Evento> listBuscarEventos;

    private SistemaVenta sistemaVenta;
    private Lista<Evento> eventosLista;
    private Lista<String> tiposButacasLista;
    private Lista<String> localidadesButacasLista;
    private Usuario usuarioActual;

    public VentanaPF() {
        sistemaVenta = new SistemaVenta();
        eventosLista = new Lista<>(listaEventosEvList);
        tiposButacasLista = new Lista<>(tiposButacasAgregadasEvList);
        localidadesButacasLista = new Lista<>(localidadesButacasEvList);

        inicializarComponentes();
        configurarListeners();
    }

    private void inicializarComponentes() {
        ciudadEvCB.addItem("Seleccionar");
        ciudadEvCB.addItem("Ciudad A");
        ciudadEvCB.addItem("Ciudad B");
        ciudadEvCB.addItem("Ciudad C");
    }

    private void configurarListeners() {
        agregarTButacaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarTipoButaca();
            }
        });

        agregarEventoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarEvento();
            }
        });

        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarSesion();
            }
        });

        registrarseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarUsuario();
            }
        });
    }

    private void registrarUsuario() {
        String nombres = nombresRegTF.getText();
        String apellidos = apellidosRegTF.getText();
        String cedulaStr = nCedulaRegTF.getText();
        long cedula = Long.parseLong(cedulaStr);
        String nombreUsuario = nombreUsuarioRegTF.getText();
        String fechaNacimiento = fechaNaciRegTF.getText();
        String genero = (String) generoRegCB.getSelectedItem();
        String correoElectronico = correoRegTF.getText();
        String contraseña = new String(passRegPF.getPassword());

        // Validar fecha de nacimiento
        if (!validarFechaNacimiento(fechaNacimiento)) {
            JOptionPane.showMessageDialog(null, "Formato de fecha de nacimiento incorrecto. Debe ser mes/dia/año.");
            return;
        }

        // Crear usuario
        boolean esAdmin = adminCheckBox.isSelected();
        Usuario usuario = new Usuario(cedula, nombres, apellidos, correoElectronico, nombreUsuario, contraseña, esAdmin);
        sistemaVenta.registrarUsuario(usuario);
        JOptionPane.showMessageDialog(null, "Usuario registrado correctamente.");

        // Limpiar campos después del registro
        nombresRegTF.setText("");
        apellidosRegTF.setText("");
        nCedulaRegTF.setText("");
        nombreUsuarioRegTF.setText("");
        fechaNaciRegTF.setText("");
        generoRegCB.setSelectedIndex(0);
        correoRegTF.setText("");
        passRegPF.setText("");
        adminCheckBox.setSelected(false);
    }

    private void iniciarSesion() {
        String nombreUsuario = usuarioLogTF.getText();
        String contraseña = new String(passLogPF.getPassword());

        Usuario usuario = sistemaVenta.iniciarSesion(nombreUsuario, contraseña);
        if (usuario != null) {
            usuarioActual = usuario;
            JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso.");
            // Aquí deberías habilitar las funcionalidades correspondientes al tipo de usuario
            // Por ejemplo, mostrar pestañas adicionales para administradores, etc.
        } else {
            JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos.");
        }

        // Limpiar campos después del inicio de sesión
        usuarioLogTF.setText("");
        passLogPF.setText("");
    }

    private void agregarTipoButaca() {
        String tipoButaca = agregarTipoButacaEvTF.getText();
        if (!tipoButaca.isEmpty()) {
            tiposButacasLista.agregarElemento(tipoButaca);
            agregarTipoButacaEvTF.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Por favor ingresa un nombre para la butaca.");
        }
    }

    private void agregarEvento() {
        try {
            int idEvento = Integer.parseInt(idEvTF.getText());
            String nombre = nombreEvTF.getText();
            String fecha = fechaEvTF.getText();
            String hora = horaEvTF.getText();
            String ciudad = (String) ciudadEvCB.getSelectedItem();
            String lugar = lugarEvTF.getText();
            int espacioTotal = Integer.parseInt(espaciototalEvTF.getText());

            List<String> tiposButacas = tiposButacasLista.getElementos();
            List<String> localidadesButacas = localidadesButacasLista.getElementos();

            Evento evento = new Evento(idEvento, nombre, fecha, hora, ciudad, lugar, espacioTotal);
            evento.setTiposButacas(tiposButacas);
            evento.setLocalidadesButacas(localidadesButacas);

            sistemaVenta.agregarEvento(evento);
            eventosLista.agregarElemento(evento);

            limpiarCamposEvento();
            JOptionPane.showMessageDialog(null, "Evento agregado correctamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: asegúrate de ingresar valores numéricos en los campos correspondientes.");
        }
    }

    private boolean validarFechaNacimiento(String fecha) {
        // Validar el formato de la fecha: mes/dia/año
        return fecha.matches("\\d{1,2}/\\d{1,2}/\\d{4}");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistema de Venta de Eventos");
        frame.setContentPane(new VentanaPF().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
