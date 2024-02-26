package Model;
import java.util.ArrayList;

import Model.Builder.Carta;

public class Jugador {
    private int numero;
    private ArrayList<Carta> mano;

    public void jugada(Equipo equipo){

    }

    public void recogerCartaMazo(){

    }

    public void descartarCarta(){

    }

    //Solo cambia el estado del juego, por lo tanto se puede cambiar en la funcion jugada()
    public void pasarTurno(){

    }

    public ArrayList<Carta> getMano(){
        return mano;
    }
    public void setMano(ArrayList<Carta> mano){
        this.mano = mano;

    }
}
