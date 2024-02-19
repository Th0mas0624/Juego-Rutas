package Factory;

import java.util.ArrayList;

import Builder.Carta;

public class Puja implements Zona{

    public ArrayList<Carta> puja = new ArrayList<>();
    @Override
    public boolean add(Carta carta) {
        
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
