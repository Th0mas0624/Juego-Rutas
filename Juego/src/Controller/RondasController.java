package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Model.Juego;
import View.PanelRondas;

public class RondasController implements ActionListener{
    
    PanelRondas pRondas;
    private Juego juego;
    public RondasController(Juego juego){
        this.juego = juego;
    }


    public void setPRondas(PanelRondas pRondas){
        this.pRondas = pRondas;
    }

    public Juego getJuego(){
        return juego;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
        JButton button = (JButton) e.getSource();
        //System.out.println(button.getName()+button.getText());
        int eleccion = pRondas.panelMano.mostrarOpcionesJuego();
        System.out.println(eleccion);
        if (eleccion== 0) {  
            boolean auxiliar =false;
            auxiliar = juego.jugadorActual.jugada(juego.getEquipos(), button.getName()+button.getText());
            if (auxiliar) {
                juego.recogerCartaMazo();
                juego.jugarRonda();
            }
        }else if (eleccion == 1) {
            juego.jugadorActual.descartarCarta(juego.getMazoJuego().getCartasDescartadas(), button.getName()+button.getText());
            juego.recogerCartaMazo();
            juego.jugarRonda();
        }
        
        pRondas.panelPuntaje.actualizar();
        pRondas.panelMano.repintarCartas();
        pRondas.zonasEquipo1.repintarZonas();
        pRondas.zonasEequipo2.repintarZonas();
        pRondas.panelMazo.repintarCartas();
        
    }
}
