package Model;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.Builder.Carta;

public class Jugador {
    
    private String numero;
    private ArrayList<Carta> mano;

    public Jugador(String numero){
        this.numero = numero;
        mano = new ArrayList<>();
    }

    //
    
    
    public boolean jugada(ArrayList<Equipo> equipos, String nombreCarta){
        System.out.println("Se paso a la jugada la carta: "+nombreCarta);
        Equipo miEquipo = null;
        Equipo equipoEnemigo = null;

        for (Equipo equipo : equipos) {
            if (equipo.getJugadores().contains(this)) {
                miEquipo = equipo;
                //System.out.println("Jugador: "+this.getNombre()+" pertenece a equipo: "+equipo);
            }else{
                equipoEnemigo = equipo;
            }
        }    
        /*
         * auxiliar: ayuda a verificar si la carta se agrego correctamente a la zona 
         * cartaSeleccionada: busca la carta que se selecciono en el boton
         * auxiliarTipoCarta: ayuda a construir el nombre de la clase de la carta
         */
        boolean auxiliar = false;
        Carta cartaSeleccionada = buscarCartaSeleccionada(nombreCarta);
        System.out.println("Carta Seleccionada: "+cartaSeleccionada);
        String auxilarTipoCarta = cartaSeleccionada.getClass().getName();

        if ((auxilarTipoCarta+cartaSeleccionada.getfuncion()).equals("Model.Builder.AtaqueVelocidad") ) {
            auxiliar = equipoEnemigo.getlimiteVZona().add(cartaSeleccionada);
        }else if ((auxilarTipoCarta+cartaSeleccionada.getfuncion()).equals("Model.Builder.DefensaVelocidad")) {
            auxiliar = miEquipo.getlimiteVZona().add(cartaSeleccionada);
        }else if (auxilarTipoCarta == "Model.Builder.Ataque") {
            if (cartaSeleccionada.getfuncion() != "Velocidad") {
                auxiliar = equipoEnemigo.getPujaZona().add(cartaSeleccionada);
            }
        }else if (auxilarTipoCarta == "Model.Builder.Defensa") {
            if (cartaSeleccionada.getfuncion() != "Velocidad") {
                auxiliar = miEquipo.getPujaZona().add(cartaSeleccionada);
            }
        }else if (auxilarTipoCarta == "Model.Builder.Distancia"){
            auxiliar = miEquipo.getDistanciaZona().add(cartaSeleccionada);
        }else if (auxilarTipoCarta == "Model.Builder.Seguridad") {

            auxiliar = miEquipo.getSeguridadZona().add(cartaSeleccionada);
        }

        if (auxiliar) {
            for (Carta carta : mano) {
                if (carta == cartaSeleccionada) {
                    mano.remove(carta);
                    System.out.println("Se jugo la carta");
            
                    break;
                }
            }
            
            //mano.remove(cartaSeleccionada);
        }else{
            System.out.println("Esta Carta no se puede jugar \n Juega otra carta o descartala");
        }

        return auxiliar;
    }

    public Carta buscarCartaSeleccionada(String nombreCarta){

        //System.out.println("Buscada: "+nombreCarta);
        for (int i = 0; i < mano.size(); i++) {
            System.out.println("Mano: "+mano.get(i).getClass().getName() + mano.get(i).getfuncion());
            if (nombreCarta.equals(mano.get(i).getClass().getName() + mano.get(i).getfuncion())) {
                System.out.println("Si entro");
                return mano.get(i);
            }
        }
        return null;
    }

    // Recibe el mazo de cartas disponibles en el juego y remueve una carta
    public void recogerCartaMazo(ArrayList<Carta> mazoJuego){
        if (mano.size() < 6) {
            mano.add(mazoJuego.remove(mazoJuego.size()-1));
        }
    }

    public boolean descartarCarta(ArrayList<Carta> mazoDescarte, String nombre){
        Carta cartaSeleccionada = buscarCartaSeleccionada(nombre);
        for (int i=0; i<mano.size(); i++) {
            if (mano.get(i) == cartaSeleccionada) {
                mazoDescarte.add(mano.remove(i));
                return true;
            }
        }
        return false;
    }

    public ArrayList<Carta> getMano(){
        return mano;
    }
    public void setMano(ArrayList<Carta> mano){
        this.mano = mano;

    }
    public String getNombre(){
        return numero;
    }
}
