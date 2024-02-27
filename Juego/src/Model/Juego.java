package Model;
import java.util.ArrayList;


import Model.Builder.Carta;
import Model.Builder.MazoJuego;

public class Juego {
    
    private ArrayList<Equipo> equipos = new ArrayList<>();
    private MazoJuego mazoJuego = new MazoJuego();
    public Jugador jugadorActual;

    //Funcion encargada de crear las cartas (para primera jugada) o de Recolartarlas en cada inicio de ronda
    public void iniciarCartas(boolean InicioJuego){ //InicioJuego:
        if (InicioJuego) {
            mazoJuego.crearCartas();
            mazoJuego.revolverCartas();
            
        }else{
            mazoJuego.recolectarCartas(equipos);
            mazoJuego.revolverCartas();
        }
    }

    //Logica para iniciar el juego (creacion de equipos jugadores y cartas)
    public void iniciarJuego(int numJugadores,String modoJuego){
        if (modoJuego == "Equipos"){
            for (int i = 0; i < numJugadores/2; i++) {
                equipos.add(new Equipo());
                equipos.get(i).agregarJugadores(numJugadores,"Equipos");
            }
            System.out.println("Juego Iniciado en modo equipos"+equipos.size()+"  "+equipos.get(0).getJugadores().size());
        }else if(modoJuego == "Individual"){
            for (int i = 0; i < numJugadores; i++) {
                equipos.add(new Equipo());
                equipos.get(i).agregarJugadores(numJugadores,"Individual");
            }
            System.out.println("Juego Iniciado en modo solitario"+equipos.size()+"  "+equipos.get(0).getJugadores().size());
        }else{
            System.err.println("Modo de juego invalido");
        }
        iniciarCartas(true);
    }

    //metodo encargado de repartir las cartas iniciales a cada jugador
    public void repartirCartas(){
        
        
        for (Equipo equipo : equipos) {
            ArrayList<Carta> copyMano = new ArrayList<>();
            for (Jugador jugador : equipo.getJugadores()) {
                for (int i = 0; i < 6; i++) {
                    if (mazoJuego.getCartasDisponibles().size() > 0) {
                        copyMano.add(mazoJuego.getCartasDisponibles().remove(0));
                    }
                }
                jugador.setMano(copyMano);
                System.out.println(jugador.getMano().size());
                //copyMano.clear();
            }
        }
    }

    //WARNING: ARREGLAR ESTO PARA SEGUIR JUGANDO RONDAS EN CADA PARTIDA
    public void jugarRonda(){ 
        repartirCartas();
        for (Equipo equipo : equipos) {
            
            if(equipo.getPuntaje() >= 5000){
                TerminarPartida(equipo);
            }
            else{
                jugadorActual = equipo.turnoJugador();
                // logica encargada de ir sumando puntos cada vez que algun equipo complete las 1000 millas en cada partida
                if (equipo.getMillasRecorridas() >= 1000) {
                    equipo.sumarPuntos(true);
                }
                // Logica encargada de sumar puntos si la partida se queda sin cartas y no hay mas movimientos
                else if(mazoJuego.getCartasDisponibles().size() == 0){
                    equipo.sumarPuntos(false);
                }
            }
        }
    }

    public void TerminarPartida(Equipo equipo){
        //Implementar esto bien, la idea es detener el juego o dar la posibilidad de comenzar otro juego
        System.out.println("El ganador es el equipo"+equipo);  
    }

    public ArrayList<Equipo> getEquipos(){
        return equipos;
    }
    
}
