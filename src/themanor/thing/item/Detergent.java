package themanor.thing.item;

import themanor.interfaces.Takable;
import themanor.thing.item.Item;

public class Detergent extends Item implements Takable {

    @Override
    public void use() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return("a detergent bottle of a brand that does not even exist anymore");
    }
}