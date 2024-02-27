package Model.Builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Model.Equipo;
import Model.Jugador;

public class MazoJuego {
    private ArrayList<Carta> cartasDisponibles;
    private ArrayList<Carta> cartasDescartadas = new ArrayList<>();

    public void revolverCartas(){
        Collections.shuffle(cartasDisponibles);
    }

    public void MeterCartaAlPozo(Carta carta){
        cartasDescartadas.add(carta);
    }   

    public void crearCartas(){
        MazoBuilder mazo = new MazoBuilder();
        cartasDisponibles = mazo.addAtaque()
                                .addDefensa()
                                .addDistancia()
                                .addSeguridad()
                                .build();
    }

    public void recolectarCartas(List<Equipo> equipos){
        for (Equipo equipo : equipos) {
            for (Jugador jugador : equipo.getJugadores()) {
                cartasDisponibles.addAll(jugador.getMano());
                jugador.getMano().clear();
            }
        }
        cartasDisponibles.addAll(cartasDescartadas);
        cartasDescartadas.clear();
    }

    public ArrayList<Carta> getCartasDisponibles(){
        return cartasDisponibles;
    }
}
