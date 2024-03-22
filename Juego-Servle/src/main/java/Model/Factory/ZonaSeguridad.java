package Model.Factory;

import java.util.ArrayList;

import Model.Builder.Carta;

public class ZonaSeguridad implements Zona{

    public ArrayList<Carta> seguridad = new ArrayList<>();
    @Override
    public boolean add(Carta carta) {
        
        if (carta.getClass().getName().equals("Model.Builder.Seguridad")) {
            seguridad.add(carta);
            return true;
        }
        return false;
    }


    @Override
    public ArrayList<Carta> getZona() {
        return seguridad;
    }
    
}
