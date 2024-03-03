package View;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import Controller.RondasController;
import Model.Juego;



public class PanelRondas extends JPanel{
    
    RondasController rController;
    Juego juego;
    public PanelManoJugdor panelMano; 
    public PanelZonasEquipo zonasEquipo1,zonasEequipo2;
    JPanel  panelMazo;
    
    public PanelRondas(RondasController rController, Juego juego){
        this.juego = juego;
        this.rController = rController;
        initComponent();
    }

    public void initComponent(){
        this.setLayout(new BorderLayout(3,3));
        
        crearPanelesDelJuego();
        
    }

    // Funcion encargada de crear todos los paneles del juego
    public void crearPanelesDelJuego(){
        //Panel para mostrar la mano del jugador actual
        panelMano = new PanelManoJugdor(juego, rController); 
        this.add(panelMano,BorderLayout.SOUTH);

        //Panel para mostrar el mazo del juego
        panelMazo = new JPanel();
        panelMazo.setBackground(new Color(255,120,120));
        
        this.add(panelMazo,BorderLayout.CENTER);
        crearPanelesEquipo();
    }

    // Funcion encargada de crear los paneles de equipo
    public void crearPanelesEquipo(){
        if (juego.getEquipos().size() == 2) {
            zonasEquipo1 = new PanelZonasEquipo(juego.getEquipos().get(0));
            zonasEequipo2 = new PanelZonasEquipo(juego.getEquipos().get(1));
            
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
}
