package Model;
import java.util.ArrayList;

import Model.Factory.ListFactory;
import Model.Factory.Zona;
import Model.Factory.ZonaDistancia;
import Model.Factory.ListFactory.listType;

public class Equipo {
    
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private int puntaje;
    private int millasRecorridas=0;
    private int turno = 0;
    private Zona seguridad, puja,  limiteV;
    private ZonaDistancia distancia;
    private String numeroEquipo;
    ListFactory list;


    public Equipo(String numeroEquipo){
        this.numeroEquipo = numeroEquipo;
        list = new ListFactory();
        crearZonas();
    }
    
    public void crearZonas(){
        System.out.println("Zonas creadas");
        limiteV =  this.list.createList(listType.LIMITEV);
        puja = this.list.createList(listType.PUJA);
        seguridad = this.list.createList(listType.SEGURIDAD);
        distancia = (ZonaDistancia) this.list.createList(listType.DISTANCIA);

        distancia.setLimiteV(limiteV);
        distancia.setPuja(puja);
        distancia.setSeguridad(seguridad);
    }

    //Verifica turno de jugador
    public Jugador turnoJugador(){
        if (jugadores.size() > 1) {
            if(turno % 2 == 0){
                
                //System.out.println("Jugador 1");
                turno +=1;
                return jugadores.get(0);
            }else{
                
                //System.out.println("Jugador 2");
                turno +=1;
                return jugadores.get(1);
            }
        }else{
            
            //System.out.println("Jugador 3");
            return jugadores.get(0);
        }
    }

    //Metodo encargado de sumar las millas
    public void sumarMillas(){
        if (distancia.getZona().size() > 0) {
            millasRecorridas = 0;
            for (int i = 0; i < distancia.getZona().size(); i++) {
                millasRecorridas += Integer.parseInt(distancia.getZona().get(i).getfuncion());
            }
        }
        //this.millasRecorridas += millas;
    }

    //Por si acaso se complica la logica en turno jugador, separar las funciones
    public void addCartasZona(){
        
    }
    
    public void agregarJugadores(int numJugadores,String modoJuego){
        
        if (modoJuego == "Equipos") {
            this.jugadores.add(new Jugador(numeroEquipo + "J1"));
            this.jugadores.add(new Jugador(numeroEquipo +"J2"));
        }else{
            this.jugadores.add(new Jugador(numeroEquipo +"J1"));
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

    public Zona getSeguridadZona(){
        return seguridad;
    }
    public Zona getDistanciaZona(){
        return distancia;
    }
    public Zona getPujaZona(){
        return puja;
    }
    public Zona getlimiteVZona(){
        return limiteV;
    }
}
