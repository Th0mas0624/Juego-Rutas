package Model.Factory;

import java.util.ArrayList;

import Model.Builder.Carta;

public class ZonaPuja implements Zona{

    public ArrayList<Carta> puja;
    
    public ZonaPuja(){
        puja = new ArrayList<>();
    }

    @Override
    public boolean add(Carta carta) {
        
        //System.out.println("Zona Puja: "+System.identityHashCode(puja));
        //System.out.println("zona de puja: "+carta.getClass().getName()+carta.getfuncion());
        //System.out.println("tamaño zona de puja: "+puja.size());
        if (puja.size() > 0) {       
            System.out.println("4"); 
            System.out.println(puja.get(puja.size() -1).getClass().getName());
            if (puja.get(puja.size() -1).getClass().getName().equals("Model.Builder.Ataque")) {
                if(carta.getClass().getName().equals("Model.Builder.Defensa")){
                    if (carta.getfuncion().equals(puja.get(puja.size() -1).getfuncion())) {
                        System.out.println("1");
                        puja.add(carta);
                        return true;
                    }
                }
            }else if (puja.get(puja.size() -1).getClass().getName().equals("Model.Builder.Defensa")) {
                System.out.println("3");
                if(carta.getClass().getName().equals("Model.Builder.Ataque")){
                    if (puja.get(puja.size() -1).getfuncion().equals("Siga")) {
                        puja.add(carta);
                        return true;
                    }
                    if (carta.getfuncion().equals(puja.get(puja.size() -1).getfuncion())) {
                        System.out.println("2");
                        puja.add(carta);
                        return true;
                    }
                }else if (carta.getfuncion() == "Siga") {
                    puja.add(carta);
                    return true;
                }
            }
        }else{
            if (carta.getClass().getName().equals("Model.Builder.Ataque")) {
                System.out.println("Entro aquiii: "+carta.getClass().getName()+carta.getfuncion());
                puja.add(carta);
                return true;      
            }else if (carta.getClass().getName().equals("Model.Builder.Defensa")) {
                if (carta.getfuncion() == "Siga") {
                    System.out.println("5");
                    puja.add(carta);
                    return true;
                }
            }
        }
        
        return false;
    }


    @Override
    public ArrayList<Carta> getZona() {
        return puja;
    }

    
}
