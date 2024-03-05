package Controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Model.Juego;
import View.PanelInicio;
import Model.LecturaPdf;



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
        } else if (button.getText().equals("Individual")) {
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
        }else if(button.getText().equals("2 Jugadores")){
            juego.iniciarJuego(Integer.parseInt(button.getName()), "Individual");      
            juego.jugarRonda();      
            panelInicio.getFrame().panelRondas();             
        }else if(button.getText().equals("2 Equipos") ){
            juego.iniciarJuego(Integer.parseInt(button.getName()), "Equipos");
            juego.jugarRonda();
            panelInicio.getFrame().panelRondas();
        }else if ((button.getText().equals("3 Equipos"))|| (button.getText().equals("3 Jugadores"))) {
            JOptionPane.showMessageDialog(null, "Esta opcion aun se esta trabajando");
        }else if  (button.getText().equals("Instrucciones")) {
            String rutaArchivoPDF = "1000-Millas.pdf";
            LecturaPdf.abrirPDF(rutaArchivoPDF);
        }

       
        
        
        
    }

    public void setInicio(PanelInicio inicio){
        this.panelInicio = inicio;
    }
}
