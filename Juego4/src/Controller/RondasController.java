package Controller;

import Model.Juego;
import View.PanelRondas;

public class RondasController {
    
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
}
