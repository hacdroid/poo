package themanor.thing.item;

import themanor.interfaces.Takable;

public class Broom extends Item implements Takable{

    public Broom() {
        super();
    }


    @Override
    public void use() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return("an old broom");
    }
}