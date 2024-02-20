package Model;
import java.util.ArrayList;
import java.util.List;

import Model.Builder.Carta;
import Model.Builder.MazoJuego;

public class Juego {
    
    private ArrayList<Equipo> equipos = new ArrayList<>();
    private MazoJuego mazoJuego = new MazoJuego();


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
                equipos.get(i).agregarJugadores("Equipos");
            }
        }else if(modoJuego == "Solitario"){
            for (int i = 0; i < numJugadores; i++) {
                equipos.add(new Equipo());
                equipos.get(i).agregarJugadores("Solitario");
            }
        }else{
            System.err.println("Modo de juego invalido");
        }
        iniciarCartas(true);
    }

    //metodo encargado de repartir las cartas a los jugadores
    public void repartirCartas(){
        ArrayList<Carta> copyMano = new ArrayList<>();
        for (Equipo equipo : equipos) {
            for (Jugador jugador : equipo.getJugadores()) {
                for (int i = 0; i < 6; i++) {
                    if (mazoJuego.getCartasDisponibles().size() > 0) {
                        copyMano.add(mazoJuego.getCartasDisponibles().remove(0));
                    }
                }
                jugador.setMano(copyMano);
                copyMano.clear();
            }
        }
    }

    public void JugarRonda(){

    }

    public void TerminarPartida(){

    }
    
}
