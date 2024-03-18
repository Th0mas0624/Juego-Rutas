import Sockets.Cliente;
import View.PanelRondas;
import Controller.ControllerCliente;
import Controller.RondasController;
import Controller.RondasController;

public class mainClient {
    public static void main(String[] args)
    {
        // Create a BigTwoClient object
        ControllerCliente game = new
        
        ControllerCliente();
        
        PanelRondas v = new PanelRondas(game.getA());
        game.cargarVista(v);
        game.conectar(2);
        v.crearPanelesDelJuego();
        // Start the game with the shuffled deck
        // game.start(newDeck);
    }
}
