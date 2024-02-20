package Model.Factory;

public class ListFactory {
    
    public enum listType{
        PUJA,
        LIMITEV,
        SEGURIDAD,
        DISTANCIA
    }

    public void createList(listType type){
        switch (type) {
            case SEGURIDAD:
                
                break;
            case LIMITEV:
                
                break;
            case PUJA:

                break;
            case DISTANCIA:
                break;
        
            default:
                break;
        }
    }
}
