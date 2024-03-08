import javax.swing.JOptionPane;

import Controller.InicioController;
import Model.Juego;
import View.FrameJuego;
import View.PanelInicio;
import game.net.GameClient;
import game.net.GameServer;

public class main {

	private static GameClient socketClient;
	private static GameServer socketServer;
    
    public static void main(String[] args) {
    	
    	
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	
            	if(JOptionPane.showConfirmDialog(null, "Prender servidor?")==0) {
            		socketServer = new GameServer(this);
            		socketServer.start();
            	}
            	
            	socketClient = new GameClient("localhost");
            	socketClient.start();

                // Crea la clase para iniciar el juego
                Juego juego = new Juego();
                // Crea el controlador encargado de controlar el inicio del juego
                InicioController iController = new InicioController(juego);
                // Panel de inicio para la seleccion del modo de juego
                PanelInicio inicio = new PanelInicio(iController); 
                // Frame del juego
                FrameJuego ventana = new FrameJuego(inicio, juego); // Crea una instancia de MiVentana
                iController.setInicio(inicio);
                inicio.setFrame(ventana);
                socketClient.sendData("ping".getBytes());
            }
        });
    }
}
