package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import Controller.RondasController;
import Model.Juego;
import Model.Jugador;


public class PanelRondas extends JPanel{
    
    RondasController rController;
    Juego juego;
    PanelManoJugdor panelMano; 
    JPanel  panelMazo, equipo1, equipo2;
    
    public PanelRondas(RondasController rController, Juego juego){
        this.juego = juego;
        this.rController = rController;
        initComponent();
    }

    public void initComponent(){
        this.setLayout(new BorderLayout(3,3));
        
        crearPanelesDelJuego();
        
    }

    public void crearPanelesDelJuego(){
        //Panel para mostrar la mano del jugador actual
        panelMano = new PanelManoJugdor(juego, rController);
        panelMano.setPreferredSize(new Dimension(500,300));
        panelMano.setBackground(new Color(120,120,120));
        this.add(panelMano,BorderLayout.SOUTH);
        //Panel para mostrar el mazo del juego
        panelMazo = new JPanel();
        panelMazo.setBackground(new Color(255,120,120));
        
        this.add(panelMazo,BorderLayout.CENTER);
        crearPanelesEquipo();
    }

    public void crearPanelesEquipo(){
        if (juego.getEquipos().size() == 2) {
            equipo1 = new JPanel();
            equipo2 = new JPanel();
            equipo1.setBackground(new Color(255,0,0));
            equipo1.setPreferredSize(new Dimension(600,300));
            equipo2.setBackground(new Color(0,255,0));
            equipo2.setPreferredSize(new Dimension(600,300));
            
            this.add(equipo1,BorderLayout.EAST);
            this.add(equipo2,BorderLayout.WEST);
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
