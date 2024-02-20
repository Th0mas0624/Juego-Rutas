package Model.Factory;

import java.util.ArrayList;

import Model.Builder.Carta;

public interface Zona {
    public boolean add(Carta carta);
    public void remove(Carta carta);
    public Carta get(int index);
    public ArrayList<Carta> getZona();
}
