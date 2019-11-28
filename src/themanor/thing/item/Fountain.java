package themanor.thing.item;

import themanor.World;
import themanor.thing.Thing;
import themanor.thing.item.Item;

public class Fountain extends Item {

    public Fountain(String name) {
        super(name);
    }

    public Fountain(String name, Thing itemHidden) {
        super(name, itemHidden);
    }

    
    
    @Override
    public void use(World w) {
        System.out.println("You cannot use it this way.");
    }

    @Override
    public String toString() {
        return("a clear water fountain");
    }
}