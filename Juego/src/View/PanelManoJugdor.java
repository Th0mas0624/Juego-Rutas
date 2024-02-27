package View;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Controller.RondasController;
import Model.Juego;

public class PanelManoJugdor extends JPanel{
    
    ArrayList<JButton> botonesDeCarta = new ArrayList<>();
    ImageIcon iconCarta = new ImageIcon();
    
    Juego juego;
    RondasController rController;

    public PanelManoJugdor(Juego juego, RondasController rController){
        juego.jugarRonda();
        for (int i = 0; i < 6; i++) {
            botonesDeCarta.add(new JButton());
            this.add(botonesDeCarta.get(i));
        }

        this.juego = juego;
        this.rController = rController;
        initComponent();
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
        System.out.println("AQUIIIIII "+juego.jugadorActual.getMano().size());
        for (int i=0; i<6; i++) {
            botonesDeCarta.get(i).setText(juego.jugadorActual.getMano().get(i).getfuncion());
            botonesDeCarta.get(i).setName(juego.jugadorActual.getMano().get(i).getClass().getName());
            //System.out.println(juego.jugadorActual.getMano().get(i).getClass().getName());
        }
        //{"Gasolina", "Pinchazo", "Accidente", "Siga"};
        for (JButton jButton : botonesDeCarta) {
            System.out.println("Clas2: "+jButton.getName()+"  Funcion:"+ jButton.getText());
            if (jButton.getName() == "Model.Builder.Ataque") {
                if (jButton.getText() == "Velocidad") {
                    iconCarta.setImage(Toolkit.getDefaultToolkit().getImage("Juego\\Pictures\\Velocidad maxima.png"));
                }else if (jButton.getText() == "Pinchazo") {
                    iconCarta.setImage(Toolkit.getDefaultToolkit().getImage("Juego\\Pictures\\pinchadura.png"));    
                }else if (jButton.getText() == "Accidente"){
                    iconCarta.setImage(Toolkit.getDefaultToolkit().getImage("Juego\\Pictures\\choque.png"));
                }else if(jButton.getText() == "Gasolina"){
                    iconCarta.setImage(Toolkit.getDefaultToolkit().getImage("Juego\\Pictures\\falta de combustible.png"));    
                }else if(jButton.getText() == "Stop"){
                    iconCarta.setImage(Toolkit.getDefaultToolkit().getImage("Juego\\Pictures\\stop.png"));    
                }
            }else if (jButton.getName() == "Model.Builder.Defensa") {
                if (jButton.getText() == "Velocidad") {
                    iconCarta.setImage(Toolkit.getDefaultToolkit().getImage("Juego\\Pictures\\fin velocidad maxima.png"));
                }else if (jButton.getText() == "Pinchazo") {
                    iconCarta.setImage(Toolkit.getDefaultToolkit().getImage("Juego\\Pictures\\rueda de auxilio.png"));    
                }else if (jButton.getText() == "Accidente"){
                    iconCarta.setImage(Toolkit.getDefaultToolkit().getImage("Juego\\Pictures\\taller.png"));
                }else if(jButton.getText() == "Gasolina"){
                    iconCarta.setImage(Toolkit.getDefaultToolkit().getImage("Juego\\Pictures\\combustible.png"));    
                }else if(jButton.getText() == "Siga"){
                    iconCarta.setImage(Toolkit.getDefaultToolkit().getImage("Juego\\Pictures\\siga.png"));    
                }
            }else if (jButton.getName() == "Model.Builder.Seguridad") {
                if (jButton.getText() == "Pinchazo") {
                    iconCarta.setImage(Toolkit.getDefaultToolkit().getImage("Juego\\Pictures\\A prueba de pinchasos.png"));    
                }else if (jButton.getText() == "Accidente"){
                    iconCarta.setImage(Toolkit.getDefaultToolkit().getImage("Juego\\Pictures\\as del volante.png"));
                }else if(jButton.getText() == "Gasolina"){
                    iconCarta.setImage(Toolkit.getDefaultToolkit().getImage("Juego\\Pictures\\Combustible extra.png"));    
                }else if(jButton.getText() == "Siga"){
                    iconCarta.setImage(Toolkit.getDefaultToolkit().getImage("Juego\\Pictures\\Prioridad de Paso.png"));    
                }
            }else if (jButton.getName() == "Model.Builder.Distancia") {
                if (jButton.getText() == "200") {
                    iconCarta.setImage(Toolkit.getDefaultToolkit().getImage("Juego\\Pictures\\200.png"));    
                }else if (jButton.getText() == "100"){
                    iconCarta.setImage(Toolkit.getDefaultToolkit().getImage("Juego\\Pictures\\100.png"));
                }else if(jButton.getText() == "75"){
                    iconCarta.setImage(Toolkit.getDefaultToolkit().getImage("Juego\\Pictures\\75.png"));    
                }else if(jButton.getText() == "50"){
                    iconCarta.setImage(Toolkit.getDefaultToolkit().getImage("Juego\\Pictures\\50.png"));    
                }else if(jButton.getText() == "25"){
                    iconCarta.setImage(Toolkit.getDefaultToolkit().getImage("Juego\\Pictures\\25.png"));    
                }
            }
            jButton.setIcon(iconCarta);    
        }

        this.revalidate();
        this.repaint();

    }

    public void pintarCartasJugador(){

    }
}
