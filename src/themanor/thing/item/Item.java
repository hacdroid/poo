package themanor.thing.item;

import themanor.World;
import themanor.exit.Exit;
import themanor.thing.Thing;
import themanor.thing.creature.Creature;

public abstract class Item extends Thing {
    
        public Item(String name){
            super(name,0);
        }
        
        public Item(String name, Thing itemHidden){
            super(name, itemHidden, 0);
        }
    
    
        public Item(String name, int damage){
            super(name,damage);
        }

        public Item(String name, Thing itemHidden, int damage) {
            super(name, itemHidden,damage);
        }

        public void use(World w){
            System.out.println("You cannot use it this way!");
        }
        
        public void use(World w,Item i){
            System.out.println("You cannot use both together.");
        }
        
        public void use(World w,Creature c){        
            
            if (!w.getJOUEUR().isInFigth()) System.out.println("You start a fight with " + c.getName() + ", " + c.getHp() + " life points.\n");
            w.getJOUEUR().attack(c, DAMAGE);
            System.out.println("You hit the monster with " + this.getName() + "! He have " + c.getHp() + " life points.\n");
	    if (!c.getIsOut()){
                c.attack(w.getJOUEUR());
                System.out.println("The creature attack you. You have now " + w.getJOUEUR().getHp() + " life points.\n"); 
            }
            if (!w.getJOUEUR().getIsOut() && !c.getIsOut()){
                w.getJOUEUR().setFigth(true);                
            } else {
                w.getJOUEUR().setFigth(false);
            }  
            if (c.getIsOut()){
                System.out.println("You have killed the " + c.getName() + "! It was hiding a " + c.getItemHide().getName() + "!");
                w.getJOUEUR().getActualPlace().getThings().remove(c.getName());
                w.getJOUEUR().getActualPlace().addThing(c.getItemHide());
            }
        }
        
        public void use(World w,Exit e){
            System.out.println("You cannot use it on a door!");
        }

        @Override
        public abstract String toString();

}