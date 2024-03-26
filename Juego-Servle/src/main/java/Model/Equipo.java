package Model;
import java.util.ArrayList;

import Model.Builder.Carta;
import Model.Factory.ListFactory;
import Model.Factory.Zona;
import Model.Factory.ZonaDistancia;
import Model.Factory.ZonaPuja;
import Model.Factory.ListFactory.listType;

public class Equipo {
    
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private ArrayList<Zona> zonas =  new ArrayList<Zona>();
    private int puntaje;
    private int millasRecorridas=0;
    private int turno = 0;
    private Zona  limiteV,seguridad;
    private ZonaPuja puja;
    private ZonaDistancia distancia;
    private String numeroEquipo;
    
    ListFactory list;


    public Equipo(String numeroEquipo){
        this.numeroEquipo = numeroEquipo;
        list = new ListFactory();
        crearZonas();
    }
    /*Seguridad puja velocidad distancia*/
    
    public void crearZonas(){
        //System.out.println("Zonas creadas");
        limiteV =  this.list.createList(listType.LIMITEV);
        seguridad = this.list.createList(listType.SEGURIDAD);
        puja = (ZonaPuja) this.list.createList(listType.PUJA);
        distancia = (ZonaDistancia) this.list.createList(listType.DISTANCIA);

        puja.setSeguridad(seguridad.getZona());
        //System.out.println("Limite Crear Zonas: "+System.identityHashCode(puja.getZona()));
        distancia.setLimiteV(limiteV.getZona());
        distancia.setPuja(puja.getZona());
        distancia.setSeguridad(seguridad.getZona());
        
        /*
         * El ArrayList: zonas, es una creacion temporal para dibujar las cartas de cada zona  
         * en la pagina web mediante el servlet
         * por ende se deben agregar en orden de manera correcta:
         * 1. Seguridad
         * 2. Puja
         * 3. Velocidad
         * 4. Distancia
         * 
        */
        zonas.add(seguridad);
        zonas.add(puja);
        zonas.add(limiteV);
        zonas.add(distancia);   
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
        for (Carta carta : seguridad.getZona()) {
            this.puntaje += 100;
        }
        if (seguridad.getZona().size() == 4) {
            this.puntaje += 300;
        }
        for (int i=0; i<distancia.getZona().size(); i++) {
            if (distancia.getZona().get(i).getfuncion() == "200") {
                break;
            }

            if (i == distancia.getZona().size() -1) {
                this.puntaje += 300;
            }
        }
        //if ()

    }

    public void verificarVictoria(){

    }
    public int getMillasRecorridas(){
        return millasRecorridas;
    }

    public void setMillasRecorridas(int millasRecorridas){
        this.millasRecorridas = 0;
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
    public String getNumeroEquipo(){
        return numeroEquipo;
    }
    
    public ArrayList<Zona> getZonas(){
    	return zonas;
    }
}
