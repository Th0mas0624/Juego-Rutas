package Model.Builder;

import java.util.ArrayList;

public class MazoBuilder {
    
    private ArrayList<Carta> mazo = new ArrayList<>();

    public MazoBuilder addAtaque(){
        String[] funciones = {"Gasolina", "Pinchazo", "Accidente", "Velocidad", "Stop"};
        int[] cantidades = {3, 3, 3, 4, 5};

        for (int i = 0; i < funciones.length; i++) {
            for (int j = 0; j < cantidades[i]; j++) {
                Carta carta = new Ataque();
                carta.setFuncion(funciones[i]);
                mazo.add(carta);
                System.out.println(carta.getClass().getName()+"       "+carta.getfuncion());
            }
        }
        return this;
    }

    public MazoBuilder addDefensa(){
        String[] funciones = {"Gasolina", "Pinchazo", "Accidente", "Velocidad", "Siga"};
        int[] cantidades = {6, 6, 6, 6, 14};

        for (int i = 0; i < funciones.length; i++) {
            for (int j = 0; j < cantidades[i]; j++) {
                Carta carta = new Defensa();
                carta.setFuncion(funciones[i]);
                mazo.add(carta);
            }
        }
        return this;
    }

    public MazoBuilder addSeguridad(){
        String[] funciones = {"Gasolina", "Pinchazo", "Accidente", "Siga"};
        int[] cantidades = {3, 3, 3, 4, 5};

        for (int i = 0; i < funciones.length; i++) {
            for (int j = 0; j < cantidades[i]; j++) {
                Carta carta = new Seguridad();
                carta.setFuncion(funciones[i]);
                mazo.add(carta);
            }
        }
        return this;
    }

    public MazoBuilder addDistancia(){

        String[] funciones = {"200", "100", "75", "50", "25"};
        int[] cantidades = {4, 12,10,10,10};

        for (int i = 0; i < funciones.length; i++) {
            for (int j = 0; j < cantidades[i]; j++) {
                Carta carta = new Defensa();
                carta.setFuncion(funciones[i]);
                mazo.add(carta);
            }
        }
        return this;
    }

    public ArrayList<Carta> build(){
        return mazo;
    }
}
