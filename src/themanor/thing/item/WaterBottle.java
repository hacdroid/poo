package themanor.thing.item;

import themanor.World;
import themanor.thing.Thing;
import themanor.thing.item.Bottle;

public class WaterBottle extends Bottle {

    public WaterBottle(String name) {
        super(name);
    }

    public WaterBottle(String name, Thing itemHidden) {
        super(name, itemHidden);
    }
    
    
    
    @Override
    public String toString() {
        return("a bottle full of fresh water");
    }
    
    @Override
    public void use(World w) {
        System.out.println("Do not drink it, it is not for you!");
    }
}