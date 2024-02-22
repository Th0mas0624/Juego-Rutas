package View;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.image.BufferedImage;
public class PanelInicio extends javax.swing.JPanel {

    private Image imagen = Toolkit.getDefaultToolkit().getImage("Juego/Pictures/Fondo inicio.png");
    public FrameJuego frame;
    private JButton equipos;
    private JButton solitario;
    public PanelInicio(FrameJuego frame){
        this.frame = frame;
        initComponents();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibuja la imagen ajustándola al tamaño del panel
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this.frame);
    }

    private void initComponents(){
        configBotones();

        this.setLayout(new GridBagLayout()); // Establece GridBagLayout como el layout manager del panel
        GridBagConstraints gbc = new GridBagConstraints();
        
        
         // Configuraciones para centrar los componentes en el panel
         gbc.gridx = 0; // Posición inicial X
         gbc.gridy = 0; // Posición inicial Y
         gbc.gridwidth = 1; // Ocupa 1 columna
         gbc.anchor = GridBagConstraints.CENTER; // Centra el componente
         gbc.fill = GridBagConstraints.HORIZONTAL; // Permite que los botones se expandan horizontalmente
         
         // Configuraciones para espaciamiento entre botones
         gbc.weightx = 0;
         gbc.weighty = 0;

         gbc.insets = new Insets(10, 0, 10, 0);
 
         // Añade el primer botón 'equipos' con las restricciones
         this.add(equipos, gbc);
         
         // Incrementa 'gbc.gridy' para colocar el siguiente componente debajo del anterior
         gbc.gridy = 1; // Mueve el siguiente componente una posición hacia abajo
 
         // Añade el segundo botón 'solitario' con las restricciones
         this.add(solitario, gbc);
    }

    public void configBotones(){

        ImageIcon iconoOriginal = new ImageIcon(Toolkit.getDefaultToolkit().getImage("Juego\\Pictures\\boton inicio.png"));
        Image imagen = iconoOriginal.getImage(); // Transforma el Icon en Image para poder escalarlo
        Image imagenEscalada = imagen.getScaledInstance(200, 50, Image.SCALE_SMOOTH); // Escala la imagen al tamaño del botón
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada); // Transforma de vuelta a ImageIcon para poder usarlo en el botón
        
        equipos = new JButton("Equipos");
        solitario = new JButton("Solitario");

        //Ajusta el tamaño del boton
        equipos.setPreferredSize(new Dimension(200,50));
        solitario.setPreferredSize(new Dimension(200,50));

        //Ajusta la fuente de la letra y el tamaño
        equipos.setFont(new java.awt.Font("Tempus Sans ITC", 0, 36));
        solitario.setFont(new java.awt.Font("Tempus Sans ITC", 0, 36));
        // Establece el icono escalado en los botones
        equipos.setIcon(iconoEscalado);
        solitario.setIcon(iconoEscalado);

        // Alinea el texto y el icono en el botón
        equipos.setHorizontalTextPosition(JButton.CENTER);
        equipos.setVerticalTextPosition(JButton.CENTER);
        solitario.setHorizontalTextPosition(JButton.CENTER);
        solitario.setVerticalTextPosition(JButton.CENTER);

        // Elimina elementos del boton para que solo se vea la imagen y el texto
        equipos.setBorderPainted(false);
        equipos.setContentAreaFilled(false);
        equipos.setFocusPainted(false);
        equipos.setOpaque(false);

        solitario.setBorderPainted(false);
        solitario.setContentAreaFilled(false);
        solitario.setFocusPainted(false);
        solitario.setOpaque(false);
        
    }
}
