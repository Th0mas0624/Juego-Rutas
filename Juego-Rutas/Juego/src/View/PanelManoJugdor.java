package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Controller.RondasController;
import Model.Juego;

public class PanelManoJugdor extends JPanel{
    
    ArrayList<JButton> botonesDeCarta = new ArrayList<>();
    JLabel nombreJugador = new JLabel();
    ImageIcon iconCarta;
    CartaView cartaView = CartaView.getInstance();
    Juego juego;
    RondasController rController;

    public PanelManoJugdor(Juego juego, RondasController rController){

        this.juego = juego;
        this.rController = rController;
        initComponent();

        
        repintarCartas();
    }

    public void initComponent(){

        this.setPreferredSize(new Dimension(500,300));
        this.setBackground(new Color(255,255,255));
        this.setLayout(new GridLayout(1, 7));
        
        for (int i = 0; i < 6; i++) {
            botonesDeCarta.add(new JButton());
            this.add(botonesDeCarta.get(i));
        }

        
        this.add(nombreJugador);

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
            //System.out.println(llave);
            
            jButton.setForeground(new Color(0, 0, 0, 0));
            jButton.setIcon(iconCarta);    
            jButton.setContentAreaFilled(false);
            jButton.setFocusPainted(false);
            jButton.setOpaque(false);
        }
        
        nombreJugador.setText(juego.jugadorActual.getNombre());

        this.revalidate();
        this.repaint();
    }

    public int mostrarOpcionesJuego(){
        Object[] opciones = {"Jugar", "Descartar"};
        return JOptionPane.showOptionDialog(null, "¿Qué acción deseas realizar?", "Elige una opción",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);  
        
    }
}
