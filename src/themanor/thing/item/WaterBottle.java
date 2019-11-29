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
    
    public void use(World w,Item i){
        if (i instanceof NPC){
            System.out.println("You give your water bottle to the man. He is really glad!\n"
                    + "In appreciation, he gives you " + i.getItemHide().getName() + "!");
            w.getJOUEUR().getInventory().put(i.getItemHide().getName(),(Item)i.getItemHide());
            w.getJOUEUR().getInventory().remove(this.getName());
        }else{
            super.use(w, i);
        }
    }   
    
    @Override
    public String toString() {
        return("a bottle full of fresh water");
    }
    
}