package themanor.thing.item;

import themanor.World;
import themanor.interfaces.Takable;
import themanor.thing.Thing;
import themanor.thing.creature.Creature;

public class Broom extends Item implements Takable{

    public Broom(String name) {
        super(name,10);
    }

    public Broom(String name, Thing itemHidden) {
        super(name, itemHidden,10);
    }
    
        public void use(World w,Item i){
        if (i instanceof Dust){
            System.out.println("You sweep the dust... There was " + i.getItemHide().getName() + " under the dust!\nThere is now, a key on the ground.");
            w.getJOUEUR().getActualPlace().addThing(i.getItemHide());
            w.getJOUEUR().getActualPlace().getThings().remove(i.getName());
        }else{
            super.use(w, i);
        }
    }
    


    @Override
    public String toString() {
        return("an old broom");
    }
}