package themanor.thing.item;

import themanor.World;
import themanor.interfaces.Takable;
import themanor.thing.Thing;
import themanor.thing.item.Item;

public class Wire extends Item implements Takable {

    public Wire(String name) {
        super(name,3);
    }

    public Wire(String name, Thing itemHidden) {
        super(name, itemHidden,3);
    }
    
    public void use(World w,Item i){
        if (i instanceof Stick){
            System.out.println("You craft a " + this.getItemHide().getName() + "!");
            w.getJOUEUR().getInventory().put(this.getItemHide().getName(),(Item)this.getItemHide());
            w.getJOUEUR().getInventory().remove(this);
            w.getJOUEUR().getInventory().remove(i);
        }else{
            super.use(w, i);
        }
    }

    @Override
    public String toString() {
        return("a long solid wire");
    }
}