package Controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Model.Juego;
import View.PanelInicio;

public class InicioController{
 
    public PanelInicio panelInicio;
    public Juego juego;

    public InicioController(Juego juego){
        this.juego = juego;    
    }
    
    /*@Override
    public void actionPerformed(ActionEvent e) {
        // Identificar qué botón fue presionado y actuar en consecuencia
        JButton button = (JButton) e.getSource();

        panelInicio.removeAll();
        if (button.getName().equals("Equipos")) {
            // Lógica para el botón Equipos
            panelInicio.NuevosBOtones(1);

            panelInicio.revalidate();
            panelInicio.repaint();
        } else if (button.getName().equals("Individual")) {
            panelInicio.NuevosBOtones(2);

            panelInicio.revalidate();
            panelInicio.repaint();
        }else if(button.getText().equals("2 Jugadores")){
            juego.iniciarJuego(Integer.parseInt(button.getName()), "Individual");      
            juego.jugarRonda();      
            panelInicio.getFrame().panelRondas();             
        }else if(button.getText().equals("2 Equipos") ){
            juego.iniciarJuego(Integer.parseInt(button.getName()), "Equipos");
            juego.jugarRonda();
            panelInicio.getFrame().panelRondas();
        }else if ((button.getName().equals("3 Equipos"))|| (button.getName().equals("3 Jugadores"))) {
            JOptionPane.showMessageDialog(null, "Esta opcion aun se esta trabajando");
        }
        
    }

    public void setInicio(PanelInicio inicio){
        this.panelInicio = inicio;
    }*/
}
