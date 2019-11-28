package themanor.thing.item;

import themanor.World;
import themanor.interfaces.Takable;
import themanor.thing.Thing;

public class Bottle extends Item implements Takable {

    public Bottle(String name) {
        super(name);
    }

    public Bottle(String name, Thing itemHidden) {
        super(name, itemHidden);
    }
 
    @Override
    public void use(World w) {
        System.out.println("There is nothing to do now.");
    }

    @Override
    public String toString() {
        return("a plastic bottle, it can handle some liquid");
    }
}