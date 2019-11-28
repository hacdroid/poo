package themanor.thing.item;

import themanor.World;
import themanor.interfaces.Takable;
import themanor.thing.Thing;
import themanor.thing.item.Item;

public class Stick extends Item implements Takable {

    public Stick(String name) {
        super(name);
    }

    public Stick(String name, Thing itemHidden) {
        super(name, itemHidden);
    }
 
    @Override
    public void use(World w) {
        System.out.println("You hurt your head with the stick, pay attention!");
    }

    @Override
    public String toString() {
        return("a long stick");
    }
}