package themanor.thing.item;

import themanor.World;
import themanor.interfaces.Takable;
import themanor.thing.Thing;

public class Broom extends Item implements Takable{

    public Broom(String name) {
        super(name);
    }

    public Broom(String name, Thing itemHidden) {
        super(name, itemHidden);
    }

    @Override
    public void use(World w) {
        System.out.println("You sweep the floor.");
    }

    @Override
    public String toString() {
        return("an old broom");
    }
}