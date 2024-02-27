package Model.Factory;

import java.util.ArrayList;

import Model.Builder.Carta;



public class ZonaDistancia implements Zona{

    public ArrayList<Carta> distancia = new ArrayList<>();
    public Zona limiteV;
    public Zona puja;
    public Zona seguridad;

    //Metodo encargado de agregar la carta a la zona si cumple con la condicion y retorna un booleano dependiendo de su condicion
    @Override
    public boolean add(Carta carta) {
        int distanciaCarta = Integer.parseInt(carta.getfuncion());
        // Variable para verificar si hay una carta que de poder 
        boolean tieneSeguridad = false;

        for (Carta carta2 : seguridad.getZona()) {
            if (carta2.getfuncion() == "Siga") {
                tieneSeguridad = true;
            }
        }

        if (carta.getClass().getName() == "Distancia") {
            if (tieneSeguridad) {
                distancia.add(carta);
                return true;
            }else{
                if (limiteV.getZona().size() > 0) {           
                    if (limiteV.getZona().get(-1).getClass().getName() == "Ataque") {
                        if (distanciaCarta > 50) {
                            return false;
                        }else{
                            distancia.add(carta);
                            return true;
                        }
                    }else{
                        distancia.add(carta);
                        return true;
                    }
                }else{
                    distancia.add(carta);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public ArrayList<Carta> getZona() {
        return distancia;
    }

    public void setLimiteV(Zona limiteV){
        this.limiteV = limiteV;
    }

    public void setPuja(Zona puja){
        this.puja = puja;
    }

    public void setSeguridad(Zona seguridad){
        this.seguridad = seguridad;
    }
    
}
