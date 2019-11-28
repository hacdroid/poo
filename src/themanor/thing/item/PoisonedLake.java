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
    public void use(World w) {
        System.out.println("You cannot use the poisoned lake water!");
    }

    @Override
    public String toString() {
        return("a lake full of muddy water, something shiny is at the bottom");
    }
}