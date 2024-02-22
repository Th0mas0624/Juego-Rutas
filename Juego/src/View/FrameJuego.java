package View;

import javax.swing.JFrame;

public class FrameJuego extends javax.swing.JFrame {

    PanelInicio inicio = new PanelInicio(this);
    public FrameJuego() {
        super("Rutas");
        initComponents();
    }

    private void initComponents() {
        // Asegura que el programa se cierra al cerrar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Configura el JFrame en pantalla completa
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.add(inicio);
        setVisible(true);
    }
}
