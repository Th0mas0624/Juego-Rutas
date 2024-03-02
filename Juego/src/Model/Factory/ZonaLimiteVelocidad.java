package Model.Factory;

import java.util.ArrayList;

import Model.Builder.Carta;

public class ZonaLimiteVelocidad implements Zona{

    public ArrayList<Carta> limite = new ArrayList<>();
    @Override
    public boolean add(Carta carta) {
        
        if (carta.getfuncion() == "Velocidad") {
            if (limite.size() > 0) {   
                if (limite.get(-1).getClass().getName() == "Model.Builder.Ataque") {
                    if(carta.getClass().getName() == "Model.Builder.Defensa"){
                        limite.add(carta);
                        return true;
                    }
                }else if (limite.get(-1).getClass().getName() == "Model.Builder.Defensa") {
                    if(carta.getClass().getName() == "Model.Builder.Ataque"){
                        limite.add(carta);
                        return true;
                    }
                }
            }else{
                limite.add(carta);
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Carta> getZona() {
        return limite;
    }
    
}
