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
            cartasDisponibles.addAll(equipo.getlimiteVZona().getZona());
            cartasDisponibles.addAll(equipo.getSeguridadZona().getZona());
            cartasDisponibles.addAll(equipo.getPujaZona().getZona());
            cartasDisponibles.addAll(equipo.getDistanciaZona().getZona());
            equipo.getlimiteVZona().getZona().clear();
            equipo.getPujaZona().getZona().clear();
            equipo.getSeguridadZona().getZona().clear();
            equipo.getDistanciaZona().getZona().clear();
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
