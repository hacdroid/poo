package themanor.thing.item;

import themanor.World;
import themanor.interfaces.Takable;
import themanor.thing.Thing;
import themanor.thing.item.Item;

public class Detergent extends Item implements Takable {

    public Detergent(String name) {
        super(name);
    }

    public Detergent(String name, Thing itemHidden) {
        super(name, itemHidden);
    }

    @Override
    public String toString() {
        return("a detergent bottle of a brand that does not even exist anymore");
    }
}