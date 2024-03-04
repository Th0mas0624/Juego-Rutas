package View;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.Builder.Carta;
import Model.Builder.MazoJuego;

public class PanelMazo extends JPanel{
    
    MazoJuego mazo;
    JLabel cartasDisponibles, cartasDescartadas;
    CartaView cartaView = CartaView.getInstance();
    public PanelMazo(MazoJuego mazo){
        this.mazo = mazo;
        this.cartasDescartadas = new JLabel();
        this.cartasDisponibles = new JLabel();
        initComponent();
    }

    public void initComponent(){
        this.setLayout(new GridLayout(2, 1));
        this.setBackground(new Color(255,120,120));
        this.add(cartasDisponibles);
        this.add(cartasDescartadas);

        repintarCartas();
    }

    public void repintarCartas(){
        try {
            Carta cartaDisponible = mazo.getCartasDisponibles().get(mazo.getCartasDisponibles().size()-1);
            cartasDisponibles.setIcon(cartaView.getIcon(cartaDisponible.getClass().getName()+cartaDisponible.getfuncion()));
        } catch (Exception e) {
            // TODO: handle exception
        }

        try {
            Carta cartaEnMazo = mazo.getCartasDescartadas().get(mazo.getCartasDescartadas().size()-1);
            cartasDescartadas.setIcon(cartaView.getIcon(cartaEnMazo.getClass().getName()+cartaEnMazo.getfuncion()));
        } catch (Exception e) {
            // TODO: handle exception
        }

        this.revalidate();
        this.repaint();
        //Carta cartaEnPozo = mazo.getCartasDescartadas().get(mazo.getCartasDescartadas().size()-1);
    }
}
