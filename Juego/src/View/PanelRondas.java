package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

import Controller.RondasController;
import Model.Juego;


public class PanelRondas extends JPanel{
    
    RondasController rController;
    Juego juego;
    
    public PanelRondas(RondasController rController, Juego juego){
        this.juego = juego;
        this.rController = rController;
        initComponent();
    }

    public void initComponent(){
        this.setLayout(new BorderLayout(3,3));
        
        crearPanelesEquipo();
        crearPanelMazo();
    }

    public void crearPanelMazo(){
        JPanel panelMazo = new JPanel();
        this.add(panelMazo,BorderLayout.CENTER);
    }
    public void crearPanelesEquipo(){
        
        if (juego.getEquipos().size() == 2) {
            JPanel panel1 = new JPanel();
            JPanel panel2 = new JPanel();
            panel1.setBackground(new Color(255,0,0));
            panel1.setPreferredSize(new Dimension(500,300));
            panel2.setBackground(new Color(0,255,0));
            panel2.setPreferredSize(new Dimension(500,300));
            
            this.add(panel1,BorderLayout.NORTH);
            this.add(panel2,BorderLayout.SOUTH);
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
