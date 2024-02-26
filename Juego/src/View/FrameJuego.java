package View;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FrameJuego extends javax.swing.JFrame {

    PanelInicio inicio;
    
    public FrameJuego(PanelInicio inicio) {
        super("Rutas");
        this.inicio = inicio;
        initComponents();
    }

    private void initComponents() {
        // Asegura que el programa se cierra al cerrar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Configura el JFrame en pantalla completa
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        configBotonRetroceso();

        this.add(inicio);
        setVisible(true);
    }

    private void configBotonRetroceso() {
        // Añade el botón de retroceso al Frame
        JButton btnRetroceso = new JButton("<-");
        btnRetroceso.setBackground(new Color(50,120,250));
        btnRetroceso.setBounds(10, 10, 50, 50);
        
        this.add(btnRetroceso);
        btnRetroceso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí defines lo que debe suceder cuando se presiona el botón
                // Por ejemplo, puedes querer regresar al estado inicial de PanelInicio
                inicio.resetEstadoInicial();
            }
        });
    }
}
