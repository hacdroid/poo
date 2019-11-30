package themanor.thing.item;

import themanor.World;
import themanor.interfaces.Takable;
import themanor.thing.Thing;

public class Bottle extends Item implements Takable {

    public Bottle(String name) {
        super(name,1);
    }

    public Bottle(String name, Thing itemHidden) {
        super(name, itemHidden,1);
    }
 
    
    public void use(World w,Item i){
        if (i instanceof Fountain){
            System.out.println("You fill your bottle with water from the fountain.");
            w.getJOUEUR().getInventory().put(i.getItemHide().getName(),(Item)i.getItemHide());
            w.getJOUEUR().getInventory().remove(this.getName());
        }else{
            super.use(w, i);
        }
    }

    @Override
    public String toString() {
        return("a plastic bottle, it can handle some liquid");
    }
}