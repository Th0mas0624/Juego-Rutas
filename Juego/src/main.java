import Controller.InicioController;
import Model.Juego;
import Sockets.Servidor;
import View.FrameJuego;
import View.PanelInicio;

public class main {
    
   /*public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {

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
            }
        });
    }*/

    public static void main(String[] args) {
        Servidor server = new Servidor("localhost", 2);
        if (args.length > 0) {
            server.start(Integer.parseInt(args[0]));
            /* 
            // PANTALLA DE INICIO
            // PANTALLA DE SELECCION DE NUMERO DE JUGADORES
            // PANTALLA DE FINALIZACIÓN
            */
        } else {
            server.start(2396);
        }
    }
}
