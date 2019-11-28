package themanor.thing.item;

import themanor.World;
import themanor.interfaces.Takable;
import themanor.thing.Thing;
import themanor.thing.item.Item;

public class Torch extends Item implements Takable {

    public Torch(String name) {
        super(name);
    }

    public Torch(String name, Thing itemHidden) {
        super(name, itemHidden);
    }
    
    
    
    @Override
    public void use(World w) {
        System.out.println("You are using the torch on your head.");
    }

    @Override
    public String toString() {
        return("a small practical torch");
    }


}