package Model;
import java.util.ArrayList;

import Model.Factory.ListFactory;
import Model.Factory.ListFactory.listType;

public class Equipo {
    
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private int puntaje;
    private int millasRecorridas=0;
    private int turno = 0;
    private ListFactory seguridad, puja,limiteV,distancia;


    public Equipo(){
        crearZonas();
    }
    
    public void crearZonas(){
        this.limiteV.createList(listType.LIMITEV);
        this.puja.createList(listType.PUJA);
        this.distancia.createList(listType.DISTANCIA);
        this.seguridad.createList(listType.SEGURIDAD);
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
        this.millasRecorridas += millas;
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
