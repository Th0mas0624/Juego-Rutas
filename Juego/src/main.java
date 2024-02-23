import Controller.InicioController;
import Model.Juego;
import View.FrameJuego;
import View.PanelInicio;

public class main {
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                Juego juego = new Juego();
                PanelInicio inicio = new PanelInicio(juego); 
                FrameJuego ventana = new FrameJuego(inicio); // Crea una instancia de MiVentana

                inicio.setFrame(ventana);
            }
        });
    }
}
