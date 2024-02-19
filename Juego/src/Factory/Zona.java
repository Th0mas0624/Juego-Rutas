package Factory;

import Builder.Carta;

public interface Zona {
    public void add(Carta carta);
    public void remove(Carta carta);
    public Carta get(int index);
}
