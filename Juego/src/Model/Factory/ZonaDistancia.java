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
                System.out.println("Tiene prioridad de paso");
                tieneSeguridad = true;
            }
        }

        if (carta.getClass().getName().equals("Model.Builder.Distancia")) {
            System.out.println("Tamaño zona de puja: "+this.puja.getZona().size());
            System.out.println("Tamaño zona de velocidad"+this.limiteV.getZona().size());
            if (tieneSeguridad) {
                distancia.add(carta);
                return true;
            }else{
                if (!puja.getZona().isEmpty()) {
                    // Primero compruebo si hay una carta de siga en la zona de puja
                    if (puja.getZona().get(puja.getZona().size() -1).getClass().getName().equals("Model.Builder.Defensa")) {
                        if (puja.getZona().get(puja.getZona().size() -1).getfuncion().equals("Siga")) {
                            // Luego compruebo que cartas hay en la zona de limite de velocidad
                            if (!limiteV.getZona().isEmpty()) {           
                                if (limiteV.getZona().get(limiteV.getZona().size() -1).getClass().getName().equals("Model.Builder.Ataque")) {
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
                            }
                        }else{
                            return false;
                        }
                    }
                }else{
                    return false;
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
