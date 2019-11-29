package themanor.thing.item;

import themanor.World;
import themanor.interfaces.Takable;
import themanor.thing.Thing;
import themanor.thing.creature.Creature;

public class Broom extends Item implements Takable{

    public Broom(String name) {
        super(name);
    }

    public Broom(String name, Thing itemHidden) {
        super(name, itemHidden);
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
    
    public void use(World w,Creature c){
        System.out.println("You start a fight with " + c.getName() + ", " + c.getHp() + " life points.\n\n");
        w.getJOUEUR().attack(c, 10);
        System.out.println("You hit the monster with your broom! He have " + c.getHp() + " life points.\n");
        while (!w.getJOUEUR().getIsOut() && !c.getIsOut()){
            c.attack(w.getJOUEUR());
            System.out.println("The creature attack you. You have now " + w.getJOUEUR().getHp() + " life points.\n"); 
            w.getJOUEUR().attack(c, 10);
            System.out.println("You hit the monster with your broom! He have " + c.getHp() + " life points.\n");
        }
        if (c.getIsOut()){
            System.out.println("You have killed the " + c.getName() + "!\nIt was hiding " + c.getItemHide().getName() + "!");
            w.getJOUEUR().getActualPlace().addThing(c.getItemHide());
            w.getJOUEUR().getActualPlace().getCreatures().remove(c.getName());
        }
    }
    
    
    
    

    @Override
    public String toString() {
        return("an old broom");
    }
}