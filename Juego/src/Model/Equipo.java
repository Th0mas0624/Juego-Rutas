package Model;
import java.util.ArrayList;

import Model.Factory.ListFactory;
import Model.Factory.Zona;
import Model.Factory.ListFactory.listType;

public class Equipo {
    
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private int puntaje;
    private int millasRecorridas=0;
    private int turno = 0;
    private Zona seguridad, ataque, distancia, defensa;
    ListFactory list;


    public Equipo(){
        crearZonas();
    }
    
    public void crearZonas(){
        seguridad = this.list.createList(listType.LIMITEV);
        ataque = this.list.createList(listType.PUJA);
        defensa = this.list.createList(listType.DISTANCIA);
        distancia = this.list.createList(listType.SEGURIDAD);
    }

    //Verifica turno de jugador, pero aqui es para equipos, arreglar esto
    public void turnoJugador(){
        if (jugadores.size() > 1) {
            if(turno % 2 == 0){
                jugadores.get(0).jugada(this);
            }else{
                jugadores.get(1).jugada(this);
            }
        }else{
            jugadores.get(0).jugada(this);
        }
    }

    //CORREGIR ESTO, ESTA MAAL
    public void sumarMillas(int millas){
        if (distancia.getZona().size() > 0) {
            for (int i = 0; i < distancia.getZona().size(); i++) {
                if (distancia.getZona().get(i).getfuncion() == "200") {
                    
                }
            }
        }
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
