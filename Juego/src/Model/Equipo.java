package Model;
import java.util.ArrayList;

import Model.Factory.ListFactory;
import Model.Factory.ListFactory.listType;

public class Equipo {
    
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private int puntaje;
    private int millasRecorridas=0;
    private int turno = 0;
    
    ListFactory list;


    public Equipo(){
        crearZonas();
    }
    
    public void crearZonas(){
        this.list.createList(listType.LIMITEV);
        this.list.createList(listType.PUJA);
        this.list.createList(listType.DISTANCIA);
        this.list.createList(listType.SEGURIDAD);
    }

    public void turnoJugador(){
        if(turno % 2 == 0){
            jugadores.get(0).jugada();
        }else{
            jugadores.get(1).jugada();
        }
    }

    //CORREGIR ESTO
    public void sumarMillas(int millas){
        //this.millasRecorridas += millas;
    }

    //Por si acaso se complica la logica en turno jugador, separar las funciones
    public void addCartasZona(){
        
    }
    
    public void agregarJugadores(int numJugadores,String modoJuego){
        if (modoJuego == "Equipos") {
            this.jugadores.add(new Jugador());
            this.jugadores.add(new Jugador());
        }else{
            this.jugadores.add(new Jugador());
        }
    }
    
    public void sumarPuntos(boolean recorridoC){
        //recorridoC identifica si hizo el recorrido completo
        if (recorridoC) {
            this.puntaje += 400;
        }
        //if ()

    }

    public void verificarVictoria(){

    }
    public int getMillasRecorridas(){
        return millasRecorridas;
    }
    public ArrayList<Jugador> getJugadores(){
        return jugadores;
    }
    public int getPuntaje(){
        return puntaje;
    }
}
