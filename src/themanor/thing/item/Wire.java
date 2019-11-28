package themanor.thing.item;

import themanor.World;
import themanor.interfaces.Takable;
import themanor.thing.Thing;
import themanor.thing.item.Item;

public class Wire extends Item implements Takable {

    public Wire(String name) {
        super(name);
    }

    public Wire(String name, Thing itemHidden) {
        super(name, itemHidden);
    }

    @Override
    public void use(World w) {
        System.out.println("Do not play with it, you will break the wire...");
    }

    @Override
    public String toString() {
        return("a long solid wire");
    }
}