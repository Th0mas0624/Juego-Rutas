package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Sockets.Cliente;
import View.PanelRondas;
import Model.Juego;

import Model.Builder.Carta;
import Model.Jugador;

public class ControllerCliente implements ActionListener {
	
 
    Juego a;
    int jugadorActualPos = 0;
    int actualPos = 0;
    Jugador jugadorActual;
    public PanelRondas tb;
    Cliente cli;

    
    public ControllerCliente() {
        this.a = new Juego();
    }
    public void conectar(int num){
        crearCliente(num);
        
    }
    
    public void crearCliente(int num){
        
        cli = new Cliente(num);
		cli.setCli(this);
        
    }

	public void mostratVista(){
		tb.setVisible(true);
	}


    public PanelRondas getTb(){
        return tb;

    }
    public void setTb(PanelRondas tb){
        this.tb = tb;
    }
    
    
    public Jugador obtenerJugadorActual(int id){
        /*if (actualPos % 2 == 0){
            jugadorActual = a.getEquipos().get(0).getJugadores().get(jugadorActualPos);
        }
        else {
            jugadorActual = a.getEquipos().get(1).getJugadores().get(jugadorActualPos);
        }
        /*if (jugadorActual.getMano().size()<7) {
            jugadorActual.robar();
            tb.setPilas(a.getJ().getEquipo1(), a.getJ().getEquipo2(), jugadorActual.getNombre());
        }*/

		if (id == actualPos){
			//tb.setButtonIcons(jugadorActual.getMano());
			tb.getPanelManoJugador().setVisible(true);
		}
		else {
			tb.getPanelManoJugador().setVisible(false);
		}

        return a.jugadorActual;
	}

	public void validarPosicionJugador() {
	    actualPos++;
	    if (actualPos == a.getEquipos().get(0).getJugadores().size() * 2) {
	        jugadorActualPos = 0;
	        actualPos = 0;
	    }
	    else if (actualPos % 2 == 0 && actualPos != 0) {
	        jugadorActualPos++;
	    }
	}

	public void cargarVista (PanelRondas ev){
	    this.tb = ev;
	}
	
	public void actionPerformed(ActionEvent e) {
	
	    /*for (JButton boton : tb.getCardButtons()) {
	        if (e.getSource() == boton) {
	            // Obtener el jugador actual según el estado del juego
				Jugador jugadorActual = obtenerJugadorActual(actualPos);
	            int indiceBoton = tb.getCardButtons().indexOf(boton);
	            int opt = tb.accion();
				Carta carta = jugadorActual.getMano().get(indiceBoton);

	            if (a.getJ().getEquipo1().encuentraJugador(jugadorActual.nombre)) {
	                if(jugadorActual.tipoAccion(indiceBoton,a.getJ().getEquipo1(), a.getJ().getEquipo2(), opt)){
						cli.makeMove(carta);
	                }
	                break;
	            }else{
	                if(jugadorActual.tipoAccion(indiceBoton,a.getJ().getEquipo2(), a.getJ().getEquipo1(), opt)){
						cli.makeMove(carta);
	                }
	                break;
	            }
	        }
	    }*/
	}

	public void refreshView(){
		tb.zonasEquipo1.repintarZonas();
        tb.zonasEequipo2.repintarZonas();
		tb.panelMano.repintarCartas();
		tb.panelMazo.repintarCartas();
		tb.panelPuntaje.actualizar();
	}
	public Juego getA() {
		return a;
	}

	public void setA(Juego a) {
		this.a = a;
	}
}