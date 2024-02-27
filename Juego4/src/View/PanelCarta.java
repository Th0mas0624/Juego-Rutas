package View;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.RondasController;
import Model.Juego;


public class PanelCarta extends JPanel {
	
	
	
	
	
	
	//Cartas de Ataque
	ImageIcon choque = new ImageIcon("/Users/JuanBarrera/Downloads/Juego-Rutas-Miguel 3/Juego3f/Pictures/choque.png");
	ImageIcon sinCombustible = new ImageIcon("/Users/JuanBarrera/Downloads/Juego-Rutas-Miguel 3/Juego3f/Pictures/falta de combustible.png");
	ImageIcon pinchadura = new ImageIcon("/Users/JuanBarrera/Downloads/Juego-Rutas-Miguel 3/Juego3f/Pictures/pinchadura.png");
	ImageIcon limitVel = new ImageIcon("/Users/JuanBarrera/Downloads/Juego-Rutas-Miguel 3/Juego3f/Pictures/velocidad maxima.png");
	ImageIcon pareRojo= new ImageIcon("/Users/JuanBarrera/Downloads/Juego-Rutas-Miguel 3/Juego3f/Pictures/stop.png");

	//Cartas de Defensa
	ImageIcon combustible= new ImageIcon("/Users/JuanBarrera/Downloads/Juego-Rutas-Miguel 3/Juego3f/Pictures/combustible.png");
	ImageIcon ruedaRepuesto= new ImageIcon("/Users/JuanBarrera/Downloads/Juego-Rutas-Miguel 3/Juego3f/Pictures/rueda de auxilio.png");
	ImageIcon taller= new ImageIcon("/Users/JuanBarrera/Downloads/Juego-Rutas-Miguel 3/Juego3f/Pictures/taller.png");
	ImageIcon sinVelMax = new ImageIcon("/Users/JuanBarrera/Downloads/Juego-Rutas-Miguel 3/Juego3f/Pictures/fin velocidad maxima.png");
	ImageIcon sigaVerde= new ImageIcon("/Users/JuanBarrera/Downloads/Juego-Rutas-Miguel 3/Juego3f/Pictures/siga.png");

	//Cartas Comodin
	ImageIcon comodinPinchao = new ImageIcon("/Users/JuanBarrera/Downloads/Juego-Rutas-Miguel 3/Juego3f/Pictures/aprueba de pinchasos.png");
	ImageIcon comodinAsVolante = new ImageIcon("/Users/JuanBarrera/Downloads/Juego-Rutas-Miguel 3/Juego3f/Pictures/as del volante.png");
	ImageIcon comodinCombustible = new ImageIcon("/Users/JuanBarrera/Downloads/Juego-Rutas-Miguel 3/Juego3f/Pictures/combustible extra.png");
	ImageIcon comodinPrioridad = new ImageIcon("/Users/JuanBarrera/Downloads/Juego-Rutas-Miguel 3/Juego3f/Pictures/prioridad de Paso.png");
	
	//Cartas de Distancia
	ImageIcon cienImg = new ImageIcon("/Users/JuanBarrera/Downloads/Juego-Rutas-Miguel 3/Juego3f/Pictures/100.png");
	ImageIcon docientosImg = new ImageIcon("/Users/JuanBarrera/Downloads/Juego-Rutas-Miguel 3/Juego3f/Pictures/200.png");
	ImageIcon venticincoImg = new ImageIcon("/Users/JuanBarrera/Downloads/Juego-Rutas-Miguel 3/Juego3f/Pictures/25.png");
	ImageIcon ciencuentaImg = new ImageIcon("/Users/JuanBarrera/Downloads/Juego-Rutas-Miguel 3/Juego3f/Pictures/50.png");
	ImageIcon setetaImg = new ImageIcon("/Users/JuanBarrera/Downloads/Juego-Rutas-Miguel 3/Juego3f/Pictures/75.png");
	
	public void mostrarCartas(ArrayList<String> cartasJugador) {
        // Iterar sobre las cartas del jugador
        for (String nombreCarta : cartasJugador) {
            // Cargar la imagen de la carta
            ImageIcon imagenCarta = new ImageIcon(nombreCarta + ".png"); // Suponiendo que las imágenes tienen nombres correspondientes a las cartas

            // Crear un JLabel para mostrar la imagen
            JLabel labelCarta = new JLabel(imagenCarta);
        	}
        }
	

	
	
	
	public PanelCarta() {
		this.crearCartas();
	    crearCartas();
	  }

	public void crearCartas() {

		// Cartas de 100 millas
		for (int i = 0; i < 12; i++) {
			JLabel label = new JLabel(cienImg);
			
			this.add(label);
		}

		// Cartas de Docientas millas
		for (int i = 0; i < 4; i++) {
			JLabel label = new JLabel(docientosImg);
			
			this.add(label);
		}

		// Cartas de Venticinco millas
		for (int i = 0; i < 11; i++) {
			JLabel label = new JLabel(venticincoImg);
			
			this.add(label);
		}

		// Cartas de Ciencuenta millas
		for (int i = 0; i < 11; i++) {
			JLabel label = new JLabel(ciencuentaImg);
		
			this.add(label);
		}
		
		// Cartas de Setenta y cinco millas millas
		for (int i = 0; i < 11; i++) {
			JLabel label = new JLabel(setetaImg);
			label.setSize(100, 100);
			this.add(label);
		}
	}
	
	public void zonasJuego() {
		
	}
	
	

	/* Crea una lista de cartas
	ArrayList<Carta> cartas = new ArrayList<>();
	cartas.add(new Carta("Ataque", "Choque", "/Users/JuanBarrera/Downloads/Juego-Rutas-Miguel 3/Juego3f/Pictures/choque.png"));
	cartas.add(new Carta("Defensa", "Combustible", "/Users/JuanBarrera/Downloads/Juego-Rutas-Miguel 3/Juego3f/Pictures/combustible.png"));
	cartas.add(new Carta("Comodin", "Comodin Pinchazo", "/Users/JuanBarrera/Downloads/Juego-Rutas-Miguel 3/Juego3f/Pictures/aprueba de pinchasos.png"));
	cartas.add(new Carta("Distancia", "100", "/Users/JuanBarrera/Downloads/Juego-Rutas-Miguel 3/Juego3f/Pictures/100.png"));

	panelCarta.setCartas(cartas);
	
	*/  
	
	
	public static void main(String[] args) {
	    PanelCarta panel = new PanelCarta();

	    JFrame frame = new JFrame();
	    frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Configura el JFrame en pantalla completa
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    frame.setVisible(true);
	  }

}