package themanor.thing.item;

import themanor.interfaces.Takable;
import themanor.thing.item.Item;

public class Torch extends Item implements Takable {
    
    @Override
    public void use() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return("a small practical torch");
    }


}