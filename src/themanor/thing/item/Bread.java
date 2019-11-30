package themanor.thing.item;

import themanor.World;
import themanor.interfaces.Takable;
import themanor.thing.Thing;

public class Bread extends Item implements Takable{

    public Bread(String name) {
        super(name,2);
    }

    public Bread(String name, Thing itemHidden) {
        super(name, itemHidden,2);
    }

    @Override
    public void use(World w) {
        w.getJOUEUR().addHp(10);
        w.getJOUEUR().getInventory().remove(this.getName());
        System.out.println("Henceforth, you have " + w.getJOUEUR().getHp() + " life points!");
    }

    @Override
    public String toString() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return("a piece of bread");
    }
}