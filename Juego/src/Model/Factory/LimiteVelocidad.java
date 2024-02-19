package Model.Factory;

import java.util.ArrayList;

import Model.Builder.Carta;

public class LimiteVelocidad implements Zona{

    public ArrayList<Carta> limite = new ArrayList<>();
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
