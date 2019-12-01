package themanor.thing.item;

import themanor.thing.*;


/**
 * Classe de plantes
 * @author alexa
 */
public class Plants extends Item{

    public Plants(String name) {
        super(name);
    }

    public Plants(String name, Thing itemHidden) {
        super(name, itemHidden);
    }

    
    /**
     * On redéfinit la méthode toString pour chaque porte
     * @return le message type String
     */  
    @Override
    public String toString() {
        return "There are plants that prevent you to move forward.";
    }
 
}