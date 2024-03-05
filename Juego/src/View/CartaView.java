package View;

import java.awt.Toolkit;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CartaView extends JLabel{
    
    private static CartaView instance;
    public HashMap<String, ImageIcon> imagenes = new HashMap<>();
    private String[] llaves= {"AtaqueGasolina","AtaqueVelocidad","AtaquePinchazo","AtaqueAccidente","AtaqueSiga",
                                "DefensaGasolina","DefensaVelocidad","DefensaPinchazo","DefensaAccidente","DefensaSiga",
                                "SeguridadGasolina","SeguridadPinchazo","SeguridadAccidente","SeguridadSiga",
                                "Distancia200","Distancia100","Distancia75","Distancia50","Distancia25"};
    private String[] rutas = {"falta de combustible","velocidad maxima","pinchadura","choque","stop",
    "combustible","fin velocidad maxima","rueda de auxilio","taller","siga",
    "combustible extra","a prueba de pinchasos","as del volante","prioridad de paso",
    "200","100","75","50","25"};

    public static CartaView getInstance(){
        if (instance == null) {
            instance = new CartaView();
        }
        return instance;
    }

    private CartaView(){
        String complementoLlave = "Model.Builder.";
        String complementoRuta = "Juego\\Pictures\\";

        for (int i = 0; i < llaves.length; i++) {
            String llave = complementoLlave + llaves[i];
            String ruta = complementoRuta + rutas[i] +".png";
            
            ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(ruta));

            imagenes.put(llave, icon);
        }
    }

    //La funcion recibe como atributo el nombre de la clase carta y su funcion para armar la llave
    public ImageIcon getIcon(String key){
        return imagenes.get(key);
    }
}
