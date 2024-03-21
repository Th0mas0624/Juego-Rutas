package Model;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.Builder.MazoJuego;

public class Juego {
    
    private ArrayList<Equipo> equipos = new ArrayList<>();
    private MazoJuego mazoJuego = new MazoJuego();
    public Jugador jugadorActual;
    private int numeroEquipo=0;
    private int turnoEquipo=0;

    //Funcion encargada de crear las cartas (para primera jugada) o de Recolartarlas en cada inicio de ronda
    public void iniciarCartas(boolean InicioJuego){ //InicioJuego:
        if (InicioJuego) {
            mazoJuego.crearCartas();
        }else{
            mazoJuego.recolectarCartas(equipos);
        }
        mazoJuego.revolverCartas();
        repartirCartas();
    }

    //Logica para iniciar el juego (creacion de equipos jugadores y cartas)
    public boolean iniciarJuego(int numJugadores,String modoJuego){
        if (modoJuego == "Equipos"){
            for (int i = 0; i < numJugadores/2; i++) {
                equipos.add(new Equipo("E"+Integer.toString(numeroEquipo)));
                equipos.get(i).agregarJugadores(numJugadores,"Equipos");
                numeroEquipo += 1;
            }
            System.out.println("Juego Iniciado en modo equipos"+equipos.size()+"  "+equipos.get(0).getJugadores().size());
        }else if(modoJuego == "Individual"){
            for (int i = 0; i < numJugadores; i++) {
                
                equipos.add(new Equipo("E"+Integer.toString(numeroEquipo)));
                equipos.get(i).agregarJugadores(numJugadores,"Individual");
                numeroEquipo += 1;
            }
            System.out.println("Juego Iniciado en modo solitario"+equipos.size()+"  "+equipos.get(0).getJugadores().size());
        }else{
            System.err.println("Modo de juego invalido");
        }
        iniciarCartas(true);
        return true;
    }

    //metodo encargado de repartir las cartas iniciales a cada jugador
    public void repartirCartas(){      
        for (Equipo equipo : equipos) {
            for (Jugador jugador : equipo.getJugadores()) {
                for (int i = 0; i < 6; i++) {
                    if (mazoJuego.getCartasDisponibles().size() > 0) {
                        jugador.getMano().add(mazoJuego.getCartasDisponibles().remove(mazoJuego.getCartasDisponibles().size() -1));
                        //System.out.println(jugador.getNombre() + "  :" +jugador.getMano().get(i).getfuncion()); 
                        //System.out.println("Tamaño Mazo: "+ mazoJuego.getCartasDisponibles().size());
                    }
                }
                //System.out.println(jugador.getMano().size());
            }
        }
    }

    public void jugarRonda(){ 

        if (!verificarVictoria()) {
            jugadorActual = equipos.get(turnoEquipo).turnoJugador();
            equipos.get(turnoEquipo).sumarMillas();
            //System.out.println("Tamaño del mazo al recolectar:  "+mazoJuego.getCartasDisponibles().size());
            turnoEquipo += 1;
            for (Equipo equipo : equipos) {
                if (equipo.getMillasRecorridas() >= 1000) {
                    equipo.sumarPuntos(true);
                    iniciarCartas(false);
                    for (Equipo equipo1 : equipos) {
                        equipo1.setMillasRecorridas(0);
                    }
                    JOptionPane.showMessageDialog(null,"Equipo ganador de la ronda: "+equipo.getNumeroEquipo());
                }
            }
        }

        if (turnoEquipo == equipos.size()) {
            turnoEquipo = 0;
        }
    }

    public void recogerCartaMazo(){
        if (mazoJuego.getCartasDisponibles().size() >0) {        
            jugadorActual.getMano().add(mazoJuego.getCartasDisponibles().remove(mazoJuego.getCartasDisponibles().size() -1));
        }
    }
    public boolean verificarVictoria(){
        for (Equipo equipo : equipos) {
            if (equipo.getPuntaje() >= 5000) {
                return true;
            }
        }
        return false;
    }

    //
    /*public boolean TerminarPartida(Equipo equipo){
        //Implementar esto bien, la idea es detener el juego o dar la posibilidad de comenzar otro juego
        JOptionPane.showMessageDialog(null,"El equipo "+equipo.getNumeroEquipo()+" gano la partida FELICITACIONES");

    }*/

    public ArrayList<Equipo> getEquipos(){
        return equipos;
    }

    public MazoJuego getMazoJuego(){
        return mazoJuego;
    }
    
}
