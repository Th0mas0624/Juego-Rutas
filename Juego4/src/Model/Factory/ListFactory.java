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
                return new ZonaSeguridad();
            case LIMITEV:
                return new ZonaLimiteVelocidad();
            case PUJA:
                return new ZonaPuja();
            case DISTANCIA:
                return new ZonaDistancia();
            default:
                return null;
        }
    }
}
