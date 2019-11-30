package themanor.thing.item;

import themanor.World;
import themanor.interfaces.Takable;
import themanor.thing.Thing;
import themanor.thing.item.Item;

public class Stick extends Item implements Takable {

    public Stick(String name) {
        super(name,4);
    }

    public Stick(String name, Thing itemHidden) {
        super(name, itemHidden,4);
    }
    
    public void use(World w,Item i){
        if (i instanceof Wire){
            System.out.println("You craft a " + i.getItemHide().getName() + "!");
            w.getJOUEUR().getInventory().put(i.getItemHide().getName(),(Item)i.getItemHide());
            w.getJOUEUR().getActualPlace().getThings().remove(i.getName());
            w.getJOUEUR().getInventory().remove(i.getName());
            w.getJOUEUR().getInventory().remove(this.getName());
        }else{
            super.use(w, i);
        }
    }
 
    @Override
    public String toString() {
        return("a long stick");
    }
}