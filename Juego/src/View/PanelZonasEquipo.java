package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.Equipo;
import Model.Builder.Carta;

/*
 * Clase encargada de visualizar el panel para las zonas
 * de cada equipo
 */
public class PanelZonasEquipo extends JPanel{
    
    Equipo equipo;
    JLabel zonaSeguridad, zonaDistancia,zonaLimiteV,zonaPuja;
    CartaView cartaView = CartaView.getInstance();

    //Array auxiliar para replicar uso en la carta de cada Zona
    ArrayList<Carta> cartasZona = new ArrayList<>();

    public PanelZonasEquipo(Equipo equipo){
        this.equipo = equipo;
        zonaDistancia = new JLabel();
        zonaLimiteV = new JLabel();
        zonaPuja = new JLabel();
        zonaSeguridad = new JLabel();
        initComponent();
    }

    public void initComponent(){
        //this.setPreferredSize(new Dimension(500,300));
        //this.setBackground(new Color(255,255,255));
        this.setBackground(new Color(255,0,0));
        this.setPreferredSize(new Dimension(600,300));
        this.setLayout(new GridLayout(4, 1));
        this.add(zonaDistancia);
        this.add(zonaLimiteV);
        this.add(zonaPuja);
        this.add(zonaSeguridad);
        repintarZonas();
    }

    public void repintarZonas(){

        cartasZona.clear();

        try {
            Carta cartaDistancia = equipo.getDistanciaZona().getZona().get(-1);
            Carta cartaSeguridad = equipo.getSeguridadZona().getZona().get(-1);
            Carta cartaLimiteV = equipo.getlimiteVZona().getZona().get(-1);
            Carta cartaPuja = equipo.getPujaZona().getZona().get(-1);

            zonaSeguridad.setIcon(cartaView.getIcon(cartaSeguridad.getClass().getName()+cartaSeguridad.getfuncion()));
            zonaDistancia.setIcon(cartaView.getIcon(cartaDistancia.getClass().getName()+cartaDistancia.getfuncion()));
            zonaLimiteV.setIcon(cartaView.getIcon(cartaLimiteV.getClass().getName()+cartaLimiteV.getfuncion()));
            zonaPuja.setIcon(cartaView.getIcon(cartaPuja.getClass().getName()+cartaPuja.getfuncion()));
            this.revalidate();
            this.repaint();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}
