package Model.Builder;

public class Ataque implements Carta{

    //Stop, Pinchazo, gasolia, etc.
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
