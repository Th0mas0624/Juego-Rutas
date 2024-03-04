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
    public void jugada(ArrayList<Equipo> equipos, String nombreCarta){
        
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
        String auxilarTipoCarta = cartaSeleccionada.getClass().getName();

        if ((auxilarTipoCarta+cartaSeleccionada.getfuncion()).equals("Model.Builder.AtaqueVelocidad") ) {
            auxiliar = equipoEnemigo.getlimiteVZona().add(cartaSeleccionada);
        }else if ((auxilarTipoCarta+cartaSeleccionada.getfuncion()) == "Model.Builder.DefensaVelocidad") {
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
                    break;
                }
            }
            //mano.remove(cartaSeleccionada);
        }else{
            JOptionPane.showMessageDialog(null, "Esta Carta no se puede jugar");
        }

    }

    public Carta buscarCartaSeleccionada(String nombreCarta){

        //System.out.println("Buscada: "+nombreCarta);
        for (int i = 0; i < mano.size(); i++) {
            //System.out.println(mano.get(i).getClass().getName() + mano.get(i).getfuncion());
            if (nombreCarta.equals(mano.get(i).getClass().getName() + mano.get(i).getfuncion())) {
                //System.out.println("Si entro");
                return mano.get(i);
            }
        }
        /*for (Carta carta : mano) {
            if (nombreCarta == (carta.getClass().getName() + carta.getfuncion())) {
                return mano.remove();
            }
        }*/
        return null;
    }

    public void recogerCartaMazo(ArrayList<Carta> mazoJuego){
        if (mano.size() < 6) {
            mano.add(mazoJuego.remove(0));
        }
    }

    public void descartarCarta(){

    }

    //Solo cambia el estado del juego, por lo tanto se puede cambiar en la funcion jugada()
    public void pasarTurno(){

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
