package themanor.thing.creature;

import themanor.Player;
import themanor.thing.Thing;

public class Bat extends Creature {
    
    public Bat(String name){
        super(name, 11, 3);
    }
    
    public Bat(String name, Thing itemHidden) {
        super(name, 11, 3, itemHidden);
    }
    
    
    @Override
    public String toString() {
        return "There is a big black bat flying in this room. It's got " +
                this.getHp() + " life point.";
    }
    

}
