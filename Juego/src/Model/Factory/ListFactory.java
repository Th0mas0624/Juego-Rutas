package Model.Factory;

public class ListFactory {
    
    public enum listType{
        PUJA,
        LIMITEV,
        SEGURIDAD,
        DISTANCIA
    }

    public Zona createList(listType type){
        switch (type) {
            case SEGURIDAD:
                return new Seguridad();
            case LIMITEV:
                return new LimiteVelocidad();
            case PUJA:
                return new Puja();
            case DISTANCIA:
                return new Distancia();
            default:
                return null;
        }
    }
}
