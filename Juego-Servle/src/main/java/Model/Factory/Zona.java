package Model.Factory;

import java.util.ArrayList;

import Model.Builder.Carta;

public interface Zona {
    public boolean add(Carta carta);

    public ArrayList<Carta> getZona();
}
