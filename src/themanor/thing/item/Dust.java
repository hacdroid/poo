package themanor.thing.item;

import themanor.World;
import themanor.thing.Thing;

public class Dust extends Item {

    public Dust(String name) {
        super(name);
    }

    public Dust(String name, Thing itemHidden) {
        super(name, itemHidden);
    }


    @Override
    public String toString() {
        return("a huge pile of dust");
    }
}