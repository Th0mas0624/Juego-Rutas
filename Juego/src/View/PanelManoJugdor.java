package View;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Controller.RondasController;
import Model.Juego;

public class PanelManoJugdor extends JPanel{
    
    ArrayList<JButton> botonesDeCarta = new ArrayList<>();
    ImageIcon iconCarta;
    CartaView cartaView = CartaView.getInstance();
    Juego juego;
    RondasController rController;

    public PanelManoJugdor(Juego juego, RondasController rController){
        
        for (int i = 0; i < 6; i++) {
            botonesDeCarta.add(new JButton());
            this.add(botonesDeCarta.get(i));
        }

        this.juego = juego;
        this.rController = rController;
        initComponent();

        //Esto tampoco va aqui, fue para probar
        repintarCartas();
    }

    public void initComponent(){
        this.setLayout(new GridLayout(1, 6));
     
        for (JButton jButton : botonesDeCarta) {
            jButton.addActionListener(rController);
            this.add(jButton);
        }
    }

    // Se encarga de repintar las cartas del jugador actual
    public void repintarCartas(){
        //System.out.println("AQUIIIIII "+juego.jugadorActual.getMano().size());
        for (int i=0; i<6; i++) {
            botonesDeCarta.get(i).setText(juego.jugadorActual.getMano().get(i).getfuncion());
            botonesDeCarta.get(i).setName(juego.jugadorActual.getMano().get(i).getClass().getName());
            //System.out.println(juego.jugadorActual.getMano().get(i).getClass().getName());
        }
        //{"Gasolina", "Pinchazo", "Accidente", "Siga"};
        for (JButton jButton : botonesDeCarta) {

            String llave = jButton.getName() + jButton.getText();
            iconCarta = cartaView.getIcon(llave);
            System.out.println(llave);
            
            jButton.setForeground(new Color(0, 0, 0, 0));
            jButton.setIcon(iconCarta);    
            jButton.setContentAreaFilled(false);
            jButton.setFocusPainted(false);
            jButton.setOpaque(false);
        }
        

        this.revalidate();
        this.repaint();
    }

    public void pintarCartasJugador(){

    }
}
