package themanor.thing.item;

import themanor.World;
import themanor.thing.Thing;
import themanor.thing.item.Item;

public class NPC extends Item {

    public NPC(String name) {
        super(name);
    }

    public NPC(String name, Thing itemHidden) {
        super(name, itemHidden);
    }
    

    @Override
    public String toString() {
        return ("A friendly mans spread out at the ground");
    }

    @Override
    public void use(World w) {
        System.out.println("You talk to the friendly man. He is so thirsty...\nHe will give anything to have a water bottle.");
    }
    

    
}