package Model.Builder;

public class Defensa implements Carta {

    private String funcion;
    @Override
    public String getfuncion() {
        return funcion;
    }
    
    @Override
    public void setFuncion(String funcion){
        this.funcion = funcion;
    }
}
