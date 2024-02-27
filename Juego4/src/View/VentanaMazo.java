package View;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import Controller.RondasController;
import Model.Juego;
import Model.Builder.*;

public class VentanaMazo extends JFrame {

	public VentanaMazo() {
		setTitle("Mazo de Juego");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Crea el panel del mazo
		PanelMazo panelMazo = new PanelMazo();

		// Crea una lista de cartas
		List<Carta> cartas = new ArrayList<>();
		cartas.add(new Carta("Ataque", "Choque",
				"/Users/JuanBarrera/Downloads/Juego-Rutas-Miguel 3/Juego3f/Pictures/choque.png"));
		cartas.add(new Carta("Defensa", "Combustible",
				"/Users/JuanBarrera/Downloads/Juego-Rutas-Miguel 3/Juego3f/Pictures/combustible.png"));
		cartas.add(new Carta("Comodin", "Comodin Pinchazo",
				"/Users/JuanBarrera/Downloads/Juego-Rutas-Miguel 3/Juego3f/Pictures/aprueba de pinchasos.png"));
		cartas.add(new Carta("Distancia", "100",
				"/Users/JuanBarrera/Downloads/Juego-Rutas-Miguel 3/Juego3f/Pictures/100.png"));

		// Asigna las cartas al panel
		panelMazo.setCartas(cartas);

		// Agrega el panel a la ventana
		add(panelMazo);

		setVisible(true);
	}

	public static void main(String[] args) {
		new VentanaMazo();
	}
}
