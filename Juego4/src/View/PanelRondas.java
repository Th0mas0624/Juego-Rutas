package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.RondasController;
import Model.Juego;
import Model.Builder.*;
import Model.Builder.MazoJuego;

public class PanelRondas extends JPanel {

	RondasController rController;
	Juego juego;

	public PanelRondas(RondasController rController, Juego juego, MazoJuego crearCartas) {
		this.juego = juego;
		this.rController = rController;
	
		initComponent();
	}

	public void interactuarConMazo(MazoJuego cartasDisponibles) {
		// Aquí puedes interactuar con el mazo de juego
		// Por ejemplo, puedes acceder a la lista de cartas

		List<Carta> cartas = cartasDisponibles.getCartasDisponibles(); // Obtén la lista de cartas del mazo

		// Realiza las operaciones necesarias con la lista de cartas

		for (Carta carta : cartas) {
			
		    //String nombreCarta = carta.getfuncion()

			// Cargar la imagen de la carta
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
			 // Suponiendo que las imágenes tienen nombres
			// correspondientes a las cartas

		    // Crear un JLabel para mostrar la imagen
			JLabel labelCarta = new JLabel(choque);
			JLabel labelCarta2 = new JLabel(sinCombustible);
			
			// Itera sobre cada carta en la lista y realiza alguna operación si es necesario
			System.out.println(carta); // Ejemplo: Imprime cada carta en la consola
		}
	}

	

	public void initComponent() {
		this.setLayout(new BorderLayout(3, 3));

		crearPanelesEquipo();
		crearPanelMazo();
	}

	public void crearPanelMazo() {
		JPanel panelMazo = new JPanel();
		this.add(panelMazo, BorderLayout.CENTER);
	}

	public void crearPanelesEquipo() {

		if (juego.getEquipos().size() == 2) {
			JPanel panel1 = new JPanel();
			JPanel panel2 = new JPanel();
			panel1.setBackground(new Color(255, 0, 0));
			panel1.setPreferredSize(new Dimension(500, 300));
			panel2.setBackground(new Color(0, 255, 0));
			panel2.setPreferredSize(new Dimension(500, 300));

			this.add(panel1, BorderLayout.NORTH);
			this.add(panel2, BorderLayout.SOUTH);
		}

	}

}

/*
 * else{ panelesEquipos.add(new JPanel()); JPanel panel1 = new JPanel(); JPanel
 * panel2 = new JPanel(); JPanel panel3 = new JPanel(); panel1.setBackground(new
 * Color(255,0,0)); panel1.setPreferredSize(new Dimension(500,300));
 * panel2.setBackground(new Color(0,255,0)); panel2.setPreferredSize(new
 * Dimension(500,300)); panel3.setBackground(new Color(0,0,255));
 * panel3.setPreferredSize(new Dimension(500,300));
 * this.add(panel1,BorderLayout.NORTH); this.add(panel2,BorderLayout.SOUTH);
 * this.add(panel3,BorderLayout.EAST); }
 */
