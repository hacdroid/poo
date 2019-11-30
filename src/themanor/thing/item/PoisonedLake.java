package themanor.thing.item;

import themanor.World;
import themanor.thing.Thing;

public class PoisonedLake extends Item {

    public PoisonedLake(String name) {
        super(name);
    }

    public PoisonedLake(String name, Thing itemHidden) {
        super(name, itemHidden);
    }


    @Override
    public String toString() {
        if (this.getItemHide()!=null) return("a lake full of muddy water, something is shining...");
        else return ("a lake full of muddy water");
    }
}