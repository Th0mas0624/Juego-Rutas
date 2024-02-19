package Factory;

import java.util.ArrayList;

import Builder.Carta;

public class ZonaSeguridad implements Zona{

    public ArrayList<Carta> seguridad = new ArrayList<>();
    @Override
    public void add(Carta carta) {
        carta.getClass()
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public void remove(Carta carta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public Carta get(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }
    
}
