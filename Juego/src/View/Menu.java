package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Menu extends JFrame {
	private FrameJuego frameJuego;

    public Menu() {
        super("Menú");
        this.frameJuego = frameJuego;
        initComponents();
    }

    private void initComponents() {
        setLayout(null);

        JButton btnJugar = new JButton("Jugar");
        btnJugar.setBounds(50, 50, 150, 50);
        add(btnJugar);

        JButton btnReglas = new JButton("Reglas");
        btnReglas.setBounds(50, 120, 150, 50);
        add(btnReglas);

        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(50, 190, 150, 50);
        add(btnSalir);

        btnJugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              // Oculta el menú
              setVisible(false);

              // Muestra el panel de juego
              frameJuego.mostrarJuego();
            }
        });

        btnReglas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarVentanaReglas();
            }

            private void mostrarVentanaReglas() {
                VentanaReglas ventanaReglas = new VentanaReglas();
            }
				
			}
        );
        

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cierra la aplicación
                System.exit(0);
            }
        });

        setSize(250, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void setFrameJuego(FrameJuego frameJuego) {
        this.frameJuego = frameJuego;
    }
}
