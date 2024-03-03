import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelCarta extends JPanel {

	ImageIcon cienImg = new ImageIcon("100.png");
	ImageIcon docientosImg = new ImageIcon("200.png");
	ImageIcon venticincoImg = new ImageIcon("25.png");
	ImageIcon ciencuentaImg = new ImageIcon("50.png");
	ImageIcon seteta = new ImageIcon("75.png");
	
	public PanelCarta() {
		
	    crearCartas();
	  }

	public void crearCartas() {

		// Cartas de Ataque
		for (int i = 0; i < 12; i++) {
			JLabel label = new JLabel(cienImg);
			this.add(label);
		}

		// Cartas de Defensa
		for (int i = 0; i < 4; i++) {
			JLabel label = new JLabel(docientosImg);
			this.add(label);
		}

		// Cartas de Escudo
		for (int i = 0; i < 10; i++) {
			JLabel label = new JLabel(venticincoImg);
			this.add(label);
		}

		// Cartas de Distancia
		for (int i = 0; i < 10; i++) {
			JLabel label = new JLabel(ciencuentaImg);
			this.add(label);
		}
	}
	
	public static void main(String[] args) {
	    Object[] opciones = {"Sí", "No", "Quizás"};
		int eleccion = JOptionPane.showOptionDialog(null, "¿Te gusta programar?", "Una Pregunta Importante",
        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[2]);
		
	  }

}