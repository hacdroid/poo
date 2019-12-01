package themanor.thing.item;

import themanor.thing.Thing;


/**
 * Classe de la poussière
 * @author alexa
 */
public class Dust extends Item {

    public Dust(String name) {
        super(name);
    }

    public Dust(String name, Thing itemHidden) {
        super(name, itemHidden);
    }


    /**
     * On redéfinit la méthode toString pour chaque porte
     * @return le message type String
     */      
    @Override
    public String toString() {
        return("a huge pile of dust");
    }
}