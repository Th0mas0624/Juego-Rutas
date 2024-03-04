package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.Juego;

public class PanelPuntajeYMilla extends JPanel{

    JPanel equipo1, equipo2;
    JPanel contenedorEquipos = new JPanel();
    JLabel puntajeEquipo1;
    JLabel millasEquipo1;
    JLabel puntajeEquipo2;
    JLabel millasEquipo2;
    Juego juego;
    public PanelPuntajeYMilla(Juego juego){
        this.juego = juego;
        equipo1 = new JPanel();
        equipo2 = new JPanel();
        millasEquipo1 = new JLabel();
        millasEquipo2 = new JLabel();
        puntajeEquipo1 = new JLabel();
        puntajeEquipo2 = new JLabel();

        initComponent();
    }

    public void initComponent(){
        if (juego.getEquipos().size() == 2) {
            this.setLayout(new BorderLayout());
            
            contenedorEquipos.setLayout(new GridLayout(1, 2)); // GridLayout para el contenedor de equipos
            equipo1.setLayout(new GridLayout(1, 2));
            equipo2.setLayout(new GridLayout(1, 2));
            equipo1.setBackground(Color.blue);
            equipo2.setBackground(Color.red);

            millasEquipo1.setPreferredSize(new Dimension(300,50));
            puntajeEquipo1.setPreferredSize(new Dimension(300,50));
            millasEquipo2.setPreferredSize(new Dimension(300,50));
            puntajeEquipo2.setPreferredSize(new Dimension(300,50));
            equipo1.add(millasEquipo1);
            equipo1.add(puntajeEquipo1);
            equipo2.add(millasEquipo2);
            equipo2.add(puntajeEquipo2);

            this.add(equipo1,BorderLayout.EAST);

            this.add(equipo2,BorderLayout.WEST);

            //this.add(contenedorEquipos, BorderLayout.SOUTH); // Añadir el contenedor de equipos en la parte inferior

            actualizar();
        }
        
    }

    public void actualizar(){

        if (juego.getEquipos().size() == 2) {
            //System.out.println("Millas recorridas:  "+Integer.toString(juego.getEquipos().get(0).getMillasRecorridas()));
            //System.out.println("Puntaje:  "+Integer.toString(juego.getEquipos().get(0).getPuntaje()));
            millasEquipo1.setText("Millas Recorridas:  "+Integer.toString(juego.getEquipos().get(0).getMillasRecorridas()));
            puntajeEquipo1.setText("Puntaje:  "+Integer.toString(juego.getEquipos().get(0).getPuntaje()));
            millasEquipo2.setText("Millas Recorridas:  "+Integer.toString(juego.getEquipos().get(1).getMillasRecorridas()));
            puntajeEquipo2.setText("Puntaje:  "+Integer.toString(juego.getEquipos().get(1).getPuntaje()));   
        }
    }
}
