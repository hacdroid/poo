package themanor.thing.item;

import themanor.thing.item.Bottle;

public class WaterBottle extends Bottle {
    
    @Override
    public String toString() {
        return("a bottle full of fresh water");
    }
    
    @Override
    public void use() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}