package Model.Factory;

import java.util.ArrayList;

import Model.Builder.Carta;

public class ZonaPuja implements Zona{

    public ArrayList<Carta> puja = new ArrayList<>();
    
    @Override
    public boolean add(Carta carta) {
        
        if (puja.size() > 0) {   
            if (puja.get(-1).getClass().getName() == "Model.Builder.Ataque") {
                if(carta.getClass().getName() == "Model.Builder.Defensa"){
                    puja.add(carta);
                    return true;
                }
            }else if (puja.get(-1).getClass().getName() == "Model.Builder.Defensa") {
                if(carta.getClass().getName() == "Model.Builder.Ataque"){
                    puja.add(carta);
                    return true;
                }
            }
        }else{
            if (carta.getClass().getName() == "Model.Builder.Ataque") {
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
