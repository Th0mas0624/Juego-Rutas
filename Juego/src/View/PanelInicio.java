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

import Controller.InicioController;

public class PanelInicio extends javax.swing.JPanel {

    private Image imagen = Toolkit.getDefaultToolkit().getImage("Juego/Pictures/Fondo inicio.jpg");
    
    public FrameJuego frame;
    public ImageIcon iconoEscalado; //Atributo para configurar el icono de los botones
    public GridBagConstraints gbc = new GridBagConstraints(); //Restricciones para la ubicaion de los botones
    public InicioController iController; //Controlador para botones de seleccion modo de juego
    
    //Botones iniciales de juego
    private JButton equipos;
    private JButton solitario;
    private JButton info;
    //public Juego juego;
    public PanelInicio(InicioController icController){
        this.iController = icController;
        initComponents();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibuja la imagen ajustándola al tamaño del panel
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this.frame);
    }

    private void initComponents(){
        equipos = new JButton("Crear partida en modo equipos");
        equipos.setName("Equipos");
        solitario = new JButton("Crear partida en modo individual");
        solitario.setName("Individual");
        info = new JButton("Reglas del juego");
        
        this.setLayout(new GridBagLayout()); // Establece GridBagLayout como el layout manager del panel

        adquirirIconBoton();
        configRestricciones();
        configBoton(equipos);
        configBoton(solitario);
        configBoton(info);
    }

    public void configRestricciones(){
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
    }

    public void adquirirIconBoton(){
        ImageIcon iconoOriginal = new ImageIcon(Toolkit.getDefaultToolkit().getImage("Juego/Pictures/boton inicio.png"));
        Image imagen = iconoOriginal.getImage(); // Transforma el Icon en Image para poder escalarlo
        Image imagenEscalada = imagen.getScaledInstance(630, 50, Image.SCALE_SMOOTH); // Escala la imagen al tamaño del botón
        iconoEscalado = new ImageIcon(imagenEscalada); // Transforma de vuelta a ImageIcon para poder usarlo en el botón
    }

    public void configBoton(JButton boton){
        //Ajusta el tamaño del boton
        boton.setPreferredSize(new Dimension(630,50));

        //Ajusta la fuente de la letra y el tamaño
        boton.setFont(new java.awt.Font("Tempus Sans ITC", 0, 36));
        
        // Establece el icono escalado en los botones
        boton.setIcon(iconoEscalado);

        // Alinea el texto y el icono en el botón
        boton.setHorizontalTextPosition(JButton.CENTER);
        boton.setVerticalTextPosition(JButton.CENTER);

        // Elimina elementos del boton para que solo se vea la imagen y el texto
        //boton.setBorderPainted(false);
        boton.setContentAreaFilled(false);
        boton.setFocusPainted(false);
        boton.setOpaque(false);

        addButton(boton);
    }

    public void NuevosBOtones(int num){
        if (num == 1) {
            JButton dosEquipos = new JButton("2 Equipos");
            dosEquipos.setName("4"); 
            JButton tresEquipos = new JButton("3 Equipos");
            tresEquipos.setName("6");
            JButton unirse = new JButton("Unirse a partida");

            this.configRestricciones();
            this.configBoton(tresEquipos); //Se configuran los nuevos botones
            this.configBoton(dosEquipos);
            this.configBoton(unirse);
        }else{
            // Lógica para el botón Solitario
            JButton dosEquipos = new JButton("2 Jugadores");
            dosEquipos.setName("2");
            JButton tresEquipos = new JButton("3 Jugadores");
            tresEquipos.setName("3");

            this.configRestricciones(); //Se configuran nuevamente las restricciones de los botones
            this.configBoton(tresEquipos); // Se configuran los nuevos botones
            this.configBoton(dosEquipos);
        }
    }
    public void addButton(JButton boton){
        this.add(boton,gbc);
        // Incrementa 'gbc.gridy' para colocar el siguiente componente debajo del anterior
        gbc.gridy += 2; // Mueve el siguiente componente una posición hacia abajo
        boton.addActionListener(iController);
    }

    public void resetEstadoInicial() {
        // Limpia el panel y vuelve a agregar los componentes iniciales
        this.removeAll();
        initComponents();
        revalidate();
        repaint();
    }
    
    public void setFrame(FrameJuego frame){
        this.frame = frame;
    }
    
    public FrameJuego getFrame(){
        return this.frame;
    }
}
