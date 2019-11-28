package themanor.thing.item;

import themanor.interfaces.Takable;

public class Bread extends Item implements Takable{

    @Override
    public void use() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return("a piece of bread");
    }
}