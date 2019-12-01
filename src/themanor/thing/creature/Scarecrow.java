package themanor.thing.creature;

import themanor.thing.Thing;


/**
 * Classe d'un épouvantail
 * @author alexa
 */
public class Scarecrow extends Creature {

    public Scarecrow(String name) {
        super(name, 30, 7);
    }

    public Scarecrow(String name, Thing itemHidden) {
        super(name, 30, 7, itemHidden);
    }


    @Override
    public String toString() {
        return "a scarecrow which seems hostile. It has " +
                this.getHp() + " life points.";
    }
    
}