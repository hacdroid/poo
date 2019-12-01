package themanor.exit;

import themanor.place.Place;


/**
 * Porte nécessitant une clé avec le bon code
 * @author alexa
 */
public class LockedDoor extends Exit {
    private final int CODE_KEY;
    
    
    /**
     * Constructeur d'une porte à clé
     * @param place correspond au lieu lié à la sortie
     * @param code correspond au code  lié à la clé
     */
    public LockedDoor (Place place, int code){
       super(place);
       this.CODE_KEY = code;
    }
    
    
    /**
     * On définit une méthode open puis qu'elle nécessite
     * le code de la clé correspondante.
     * @param code correspond au code de la clé
     * @return un booléen
     */    
    public boolean open(int code){
        if (this.CODE_KEY == code){
            this.isOpen=true;
            return true;
        }
        else{
            return false;
        }
    }    
    
    
    /**
     * On redéfinit la méthode toString pour chaque porte
     * @return le message type String
     */    
    @Override
    public String toString() {
        String desc = ""; 
        
        if (this.isOpen()) {
            desc = desc.concat("an unlocked");
        } else desc = desc.concat("a locked");
        
        desc = desc.concat(" door, it leads to " + this.getPlace().toString());
        return desc;
    }
}