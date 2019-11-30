package themanor.thing.item;

import themanor.World;
import themanor.interfaces.Takable;
import themanor.thing.Thing;
import themanor.thing.item.Item;

public class Detergent extends Item implements Takable {

    public Detergent(String name) {
        super(name,4);
    }

    public Detergent(String name, Thing itemHidden) {
        super(name, itemHidden,4);
    }
    
    @Override
    public void use(World w,Item i){
        if (i instanceof Plants){
            System.out.println("You pour detergent on " + i.getName() + ". The plants are now dissolved!\nYou can see a wire behind these.");
            w.getJOUEUR().getActualPlace().addThing(i.getItemHide());
            w.getJOUEUR().getActualPlace().getThings().remove(i.getName());
        }else{
            super.use(w, i);
        }
    }

    @Override
    public String toString() {
        return("a detergent bottle of a brand that does not even exist anymore");
    }
}