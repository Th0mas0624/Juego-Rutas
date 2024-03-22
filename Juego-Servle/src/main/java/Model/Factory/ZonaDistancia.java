package Model.Factory;

import java.util.ArrayList;

import Model.Builder.Carta;



public class ZonaDistancia implements Zona{

    public ArrayList<Carta> distancia = new ArrayList<>();
    public ArrayList<Carta> limiteV;
    public ArrayList<Carta> puja;
    public ArrayList<Carta> seguridad;

    //Metodo encargado de agregar la carta a la zona si cumple con la condicion y retorna un booleano dependiendo de su condicion
    @Override
    public boolean add(Carta carta) {
        int distanciaCarta = Integer.parseInt(carta.getfuncion());
        // Variable para verificar si hay una carta que de poder 
        boolean tieneSeguridad = false;

        //System.out.println("Limite Distancia: "+System.identityHashCode(puja));
        for (Carta carta2 : seguridad) {
            if (carta2.getfuncion() == "Siga") {
                System.out.println("Tiene prioridad de paso");
                tieneSeguridad = true;
            }
        }

        if (carta.getClass().getName().equals("Model.Builder.Distancia")) {
            //System.out.println("Tamaño zona de puja: "+this.puja.size());
            //System.out.println("Tamaño zona de velocidad"+this.limiteV.size());
            if (tieneSeguridad) {
                if (!puja.isEmpty()) {
                    if (puja.get(puja.size()-1).getClass().getName() == "Model.Builder.Ataque"  ) {
                        if (puja.get(puja.size()-1).getfuncion() != "Siga") {
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
            }else{
                if (!puja.isEmpty()) {
                    // Primero compruebo si hay una carta de siga en la zona de puja
                    if (puja.get(puja.size() -1).getClass().getName().equals("Model.Builder.Defensa")) {
                        if (puja.get(puja.size() -1).getfuncion().equals("Siga")) {
                            // Luego compruebo que cartas hay en la zona de limite de velocidad
                            if (!limiteV.isEmpty()) {           
                                if (limiteV.get(limiteV.size() -1).getClass().getName().equals("Model.Builder.Ataque")) {
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

    public void setLimiteV(ArrayList<Carta> limiteV){
        this.limiteV = limiteV;
    }

    public void setPuja(ArrayList<Carta> puja){
        this.puja = puja;
    }

    public void setSeguridad(ArrayList<Carta> seguridad){
        this.seguridad = seguridad;
    }
    
}
