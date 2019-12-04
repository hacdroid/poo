package themanor.thing.item;

import themanor.thing.Thing;


/**
 * Classe d'un lac empoisonné
 * @author alexa
 */
public class PoisonedLake extends Item {

    public PoisonedLake(String name) {
        super(name);
    }

    public PoisonedLake(String name, Thing itemHidden) {
        super(name, itemHidden);
    }

    
    /**
     * On redéfinit la méthode toString pour chaque porte
     * @return le message type String
     */  
    @Override
    public String toString() {
        if (this.haveAHiddenItem()) return("a lake full of muddy water, something is shining...");
        else return ("a lake full of muddy water");
    }
}