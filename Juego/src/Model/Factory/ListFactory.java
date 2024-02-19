package Model.Factory;

public class ListFactory {
    
    public enum listType{
        SEGURIDAD,
        ATAQUE,
        DEFENSA,
        DISTANCIA
    }

    public void createList(listType type){
        switch (type) {
            case SEGURIDAD:
                
                break;
            case ATAQUE:
                
                break;
            case DEFENSA:

                break;
            case DISTANCIA:
                break;
        
            default:
                break;
        }
    }
}
