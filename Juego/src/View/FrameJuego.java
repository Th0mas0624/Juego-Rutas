package View;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FrameJuego extends javax.swing.JFrame {

    PanelInicio inicio;
    Menu menu;
    
    public FrameJuego(PanelInicio inicio) {
        super("Ruta");
        this.inicio = inicio;
        initComponents();
        mostrarMenu();
    }
    
    public void mostrarMenu() {
        if (menu == null) {
            menu = new Menu();
            menu.setVisible(true);
            menu.setFrameJuego(this); // Configura la referencia a este FrameJuego en el menú
        }
    }
    
    public void mostrarJuego() {
    	  if (menu != null) {
    	        this.getContentPane().remove(menu); // Remueve el menú si está presente
    	        menu = null; // Limpia la referencia al menú
    	    }
    	 configBotonRetroceso();
        this.getContentPane().removeAll(); // Limpia el contenido actual
        this.add(inicio); // Agrega el panel de inicio
        this.revalidate();
        this.repaint();
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
                new Menu();
            }
        });
    }
}
