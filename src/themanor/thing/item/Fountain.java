package themanor.thing.item;

import themanor.thing.Thing;


/**
 * Classe d'une fontaine
 * @author alexa
 */
public class Fountain extends Item {

    public Fountain(String name) {
        super(name);
    }

    public Fountain(String name, Thing itemHidden) {
        super(name, itemHidden);
    }

    
    /**
     * On redéfinit la méthode toString pour chaque porte
     * @return le message type String
     */  
    @Override
    public String toString() {
        return("a clear water fountain");
    }
}