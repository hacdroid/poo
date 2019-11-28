package themanor.thing.item;

import themanor.World;
import themanor.thing.Thing;

public class Chair extends Item {

    public Chair(String name) {
        super(name);
    }

    public Chair(String name, Thing itemHidden) {
        super(name, itemHidden);
    }

    

    @Override
    public void use(World w) {
        System.out.println("You seat on the chair. You break the chair...\nNow, there is a stick on the ground, from the broken chair.");
        
        w.getJOUEUR().getActualPlace().getThings().remove(this.getName());
        
        w.getJOUEUR().getActualPlace().addThing(this.getItemHide());
        
    }

    @Override
    public String toString() {
        return("an old rickety chair");
    }
}//hey
