package themanor.thing.item;

import themanor.World;
import themanor.interfaces.Takable;
import themanor.thing.Thing;
import themanor.thing.item.Item;

public class Goldring extends Item implements Takable {

    public Goldring(String name) {
        super(name);
    }

    public Goldring(String name, Thing itemHidden) {
        super(name, itemHidden);
    }


    @Override
    public String toString() {
        return("a shiny tiny gold ring, it's got a perfect round shape");
    }
}