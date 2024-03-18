package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.RondasController;
import Model.Juego;



public class PanelRondas extends JFrame{
    

    RondasController rController;
    Juego juego;
    public PanelManoJugdor panelMano; 
    public PanelZonasEquipo zonasEquipo1;
    public PanelZonasEquipo zonasEequipo2;
    public PanelMazo  panelMazo;
    public PanelPuntajeYMilla panelPuntaje;
    

    public PanelRondas(Juego juego){
        super("Juego");
        rController = new RondasController(juego);
        setSize(1920, 1080);
        this.juego = juego;

        initComponent();
    }

    public void initComponent(){
        this.setLayout(new BorderLayout(3,3));
        
        //crearPanelesDelJuego();
        
    }

    // Funcion encargada de crear todos los paneles del juego
    public void crearPanelesDelJuego(){

        //Panel para mostrar la mano del jugador actual
        panelMano = new PanelManoJugdor(juego, rController); 
        
        this.add(panelMano,BorderLayout.SOUTH);

        //Panel para mostrar el mazo del juego
        panelMazo = new PanelMazo(juego.getMazoJuego());    
        this.add(panelMazo,BorderLayout.CENTER);

        panelPuntaje = new PanelPuntajeYMilla(juego);
        this.add(panelPuntaje, BorderLayout.NORTH);

        crearPanelesEquipo();

        
        
    }
        
    // Funcion encargada de crear los paneles de equipo
    public void crearPanelesEquipo(){
        System.out.println("AQUIIIIII "+juego.getEquipos().size());
        if (juego.getEquipos().size() == 2) {
            //ImageIcon icon1 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(ruta));
            //ImageIcon icon2 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(ruta));
            zonasEquipo1 = new PanelZonasEquipo(juego.getEquipos().get(0)){
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    ImageIcon fondo = new ImageIcon("Juego/Pictures/equipo 1.png"); // Asegúrate de poner la ruta correcta a tu imagen.
                    g.drawImage(fondo.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
                }
            };
            zonasEquipo1.setBackground(Color.blue);
            zonasEequipo2 = new PanelZonasEquipo(juego.getEquipos().get(1)){
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    ImageIcon fondo = new ImageIcon("Juego/Pictures/equipo 2.png"); // Asegúrate de poner la ruta correcta a tu imagen.
                    g.drawImage(fondo.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
                }
            };
            zonasEequipo2.setBackground(Color.red);
            this.add(zonasEquipo1,BorderLayout.EAST);
            this.add(zonasEequipo2,BorderLayout.WEST);
        }/*else{
            panelesEquipos.add(new JPanel());
            JPanel panel1 = new JPanel();
            JPanel panel2 = new JPanel();
            JPanel panel3 = new JPanel();
            panel1.setBackground(new Color(255,0,0));
            panel1.setPreferredSize(new Dimension(500,300));
            panel2.setBackground(new Color(0,255,0));
            panel2.setPreferredSize(new Dimension(500,300));
            panel3.setBackground(new Color(0,0,255));
            panel3.setPreferredSize(new Dimension(500,300));
            this.add(panel1,BorderLayout.NORTH);
            this.add(panel2,BorderLayout.SOUTH);
            this.add(panel3,BorderLayout.EAST);
        }*/
    }

    public PanelManoJugdor getPanelManoJugador(){
        return panelMano;
    }

    

}
