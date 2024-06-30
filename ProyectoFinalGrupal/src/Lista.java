import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Lista<T> {
    private DefaultListModel<T> modelo;

    public Lista(JList<String> localidadesButacasEvList) {
        modelo = new DefaultListModel<>();
    }

    public void configurarLista(JList<T> lista) {
        lista.setModel(modelo);
    }

    public void agregarElemento(T elemento) {
        modelo.addElement(elemento);
    }

    public List<T> getElementos() {
        List<T> elementos = new ArrayList<>();
        for (int i = 0; i < modelo.size(); i++) {
            elementos.add(modelo.get(i));
        }
        return elementos;
    }

    public void limpiarLista() {
        modelo.clear();
    }
}
