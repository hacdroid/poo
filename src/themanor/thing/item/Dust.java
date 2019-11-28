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
    public void use(World w) {
        System.out.println("How could you use dust ?");
    }

    @Override
    public String toString() {
        return("a huge pile of dust");
    }
}