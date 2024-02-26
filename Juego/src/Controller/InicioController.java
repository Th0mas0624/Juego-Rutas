package Controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Model.Juego;
import View.PanelInicio;

public class InicioController implements ActionListener{
 
    public PanelInicio panelInicio;
    public Juego juego;

    public InicioController(Juego juego){
        this.juego = juego;
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // Identificar qué botón fue presionado y actuar en consecuencia
        JButton button = (JButton) e.getSource();
        
        panelInicio.removeAll();
        if (button.getText().equals("Equipos")) {
            // Lógica para el botón Equipos
            JButton dosEquipos = new JButton("2 Equipos");
            dosEquipos.setName("4"); 
            JButton tresEquipos = new JButton("3 Equipos");
            tresEquipos.setName("6");

            panelInicio.configRestricciones(); //Se configuran nuevamente las restricciones de los botones
            panelInicio.configBoton(tresEquipos); //Se configuran los nuevos botones
            panelInicio.configBoton(dosEquipos);

            panelInicio.revalidate();
            panelInicio.repaint();
        } else if (button.getText().equals("Solitario")) {
            // Lógica para el botón Solitario
            JButton dosEquipos = new JButton("2 Jugadores");
            dosEquipos.setName("2");
            JButton tresEquipos = new JButton("3 Jugadores");
            tresEquipos.setName("3");

            panelInicio.configRestricciones(); //Se configuran nuevamente las restricciones de los botones
            panelInicio.configBoton(tresEquipos); // Se configuran los nuevos botones
            panelInicio.configBoton(dosEquipos);

            panelInicio.revalidate();
            panelInicio.repaint();
        }else if(button.getText().equals("2 Jugadores") || button.getText().equals("3 Jugadores")){
            juego.iniciarJuego(Integer.parseInt(button.getName()), "Solitario");
        }else if(button.getText().equals("2 Equipos") || button.getText().equals("3 Equipos")){
            juego.iniciarJuego(Integer.parseInt(button.getName()), "Equipos");
        }
        
    }
    public void setInicio(PanelInicio inicio){
        this.panelInicio = inicio;
    }
}
