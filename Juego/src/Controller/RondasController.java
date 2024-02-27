package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
