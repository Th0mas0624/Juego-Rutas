package View;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VentanaReglas extends JFrame {
    public VentanaReglas() {
        super("Reglas del Juego");
        initComponents();
    }

    private void initComponents() {
        JTextArea areaReglas = new JTextArea("No se puede poner una carta de ataque en el contrario si este ya cuenta con una carta de problema en el sector de puja\r\n"
        		+ "- 3 Sin gasolina\r\n"
        		+ "- 3 Pinchazo\r\n"
        		+ "- 3 Accidente\r\n"
        		+ "- 4 Limite de Velocidad\r\n"
        		+ "- 5 Semaforo rojo (STOP)\r\n"
        		+ "\r\n"
        		+ "DEFENSA (VERDE): 38\r\n"
        		+ "- 6 Gasolina\r\n"
        		+ "- 6 Rueda Recambio\r\n"
        		+ "- 6 Reparaciones\r\n"
        		+ "- 6 Fin Limite de velocidad\r\n"
        		+ "- 14 Semaforo Verde (SIGA)\r\n"
        		+ "\r\n"
        		+ "\r\n"
        		+ "CARTA ESCUDOS (AMARILLO): 4 cartas\r\n"
        		+ "Siempre que se baje una carta de seguridad se gana un turno extra\r\n"
        		+ "- 1 Cisterna de Gasolina\r\n"
        		+ "- 1 Impinchable\r\n"
        		+ "- 1 As del Volante\r\n"
        		+ "- 1 Vehiculo prioritario\r\n"
        		+ "\r\n"
        		+ "CARTAS DE DISTANCIA (BLANCAS): 46\r\n"
        		+ "Solo se pueden jugar si en el sector de puja hay una carta de \"SIGA\"\r\n"
        		+ "O de lo contrario si en el sector de seguridad hay una carta prioridad de paso\r\n"
        		+ "- 4 de 200M\r\n"
        		+ "- 12 de 100M\r\n"
        		+ "- 10 de 75M\r\n"
        		+ "- 10 de 50M\r\n"
        		+ "- 10 de 25M\r\n"
        		+ "\r\n"
        		+ "\r\n"
        		+ "ZONAS DE JUEGO: 4\r\n"
        		+ "SECTOR DE SEGURIDAD: Se hubican las cartas de velocidad, cuando se juegan\r\n"
        		+ "previamente se colocan en la misma direccion que las otras cartas, pero si \r\n"
        		+ "se juega como jugada \"TK\" se colocan transversalmente\r\n"
        		+ "SECTOR LIMITE DE VELOCIDAD: van las cartas de ataque y defensa de limite de velocidad\r\n"
        		+ "SECTOR DE PUJA: Aqui van las cartas de problemas y de soluciones\r\n"
        		+ "PARCIALES DE DISTANCIA: Van las cartas de distancia\r\n"
        		+ "\r\n"
        		+ "POSIBLES JUGADAS EN CADA TURNO:\r\n"
        		+ "- Jugar Carta de Siga en el sector de puja\r\n"
        		+ "- Jugar carta de seguridad (Escudo) y jugar un turno extra\r\n"
        		+ "- Bajar una carta de problema al contrario (Solo si el contrario tiene carta de siga en el sector de puja)\r\n"
        		+ "- Jugar carta de distancia\r\n"
        		+ "- Si no se puede hacer ninguna de las jugadas anteriores se debe descartar una carta y coger otra del mazo\r\n"
        		+ "\r\n"
        		+ "\r\n"
        		+ "PUNTAJES: \r\n"
        		+ "Viaje completo: 400 puntos\r\n"
        		+ "Seguridad I: 100 puntos por cada carta de seguridad usada\r\n"
        		+ "Seguridad II: 300 puntos adicionales si jugo todas las cartas de seguridad\r\n"
        		+ "Viaje seguro: Si el jugador no utilizo cartas de 200M\r\n"
        		+ "Bloqueo: 500 puntos adicionales al ganador si el equipo contrario no pudo jugar cartas de distancia");
        areaReglas.setEditable(false);
        
        add(areaReglas);
        
        JScrollPane scrollPane = new JScrollPane(areaReglas);
        
        
        add(scrollPane);

        setSize(700,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
