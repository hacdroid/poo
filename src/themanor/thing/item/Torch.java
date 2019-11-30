package themanor.thing.item;

import themanor.World;
import themanor.interfaces.Takable;
import themanor.thing.Thing;
import themanor.thing.item.Item;

public class Torch extends Item implements Takable {

    public Torch(String name) {
        super(name,3);
    }

    public Torch(String name, Thing itemHidden) {
        super(name, itemHidden,3);
    }
    
    
    
    @Override
    public void use(World w) {
        System.out.println("You already are using the torch.");
    }

    @Override
    public String toString() {
        return("a small practical torch");
    }


}