package View;

import java.awt.Dimension;
import java.awt.GridLayout;

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
        
        this.setPreferredSize(new Dimension(800,300));
        this.setLayout(new GridLayout(1, 4));
        this.add(zonaDistancia);
        this.add(zonaLimiteV);
        this.add(zonaPuja);
        this.add(zonaSeguridad);
        repintarZonas();
    }

    public void repintarZonas() {
        Carta cartaDistancia = null;
        Carta cartaSeguridad = null;
        Carta cartaLimiteV = null;
        Carta cartaPuja = null;
    
        try {
            cartaDistancia = equipo.getDistanciaZona().getZona().get(equipo.getDistanciaZona().getZona().size() -1);
            zonaDistancia.setIcon(cartaView.getIcon(cartaDistancia.getClass().getName()+cartaDistancia.getfuncion()));
        } catch (Exception e) {
            zonaDistancia.setIcon(null);
        }
    
        try {
            cartaSeguridad = equipo.getSeguridadZona().getZona().get(equipo.getSeguridadZona().getZona().size() -1);
            zonaSeguridad.setIcon(cartaView.getIcon(cartaSeguridad.getClass().getName()+cartaSeguridad.getfuncion()));
        } catch (Exception e) {
            zonaSeguridad.setIcon(null);
        }
    
        try {
            cartaLimiteV = equipo.getlimiteVZona().getZona().get(equipo.getlimiteVZona().getZona().size() -1);
            zonaLimiteV.setIcon(cartaView.getIcon(cartaLimiteV.getClass().getName()+cartaLimiteV.getfuncion()));
        } catch (Exception e) {
            zonaLimiteV.setIcon(null);
        }
    
        try {
            cartaPuja = equipo.getPujaZona().getZona().get(equipo.getPujaZona().getZona().size() -1);
            zonaPuja.setIcon(cartaView.getIcon(cartaPuja.getClass().getName()+cartaPuja.getfuncion()));
        } catch (Exception e) {
            zonaPuja.setIcon(null);
        }
    
        this.revalidate();
        this.repaint();
    }
    
}
