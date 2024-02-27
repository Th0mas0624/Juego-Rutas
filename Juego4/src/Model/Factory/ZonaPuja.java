package Model.Factory;

import java.util.ArrayList;

import Model.Builder.Carta;

public class ZonaPuja implements Zona{

    public ArrayList<Carta> puja = new ArrayList<>();
    
    @Override
    public boolean add(Carta carta) {
        
        if (puja.size() > 0) {   
            if (puja.get(-1).getClass().getName() == "Ataque") {
                if(carta.getClass().getName() == "Defensa"){
                    puja.add(carta);
                    return true;
                }
            }else if (puja.get(-1).getClass().getName() == "Defensa") {
                if(carta.getClass().getName() == "Ataque"){
                    puja.add(carta);
                    return true;
                }
            }
        }else{
            if (carta.getClass().getName() == "Ataque") {
                puja.add(carta);
                return true;
                
            }
        }
        
        return false;
    }


    @Override
    public ArrayList<Carta> getZona() {
        return puja;
    }

    
}
