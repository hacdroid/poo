package themanor.thing.item;

import themanor.World;
import themanor.exit.Exit;
import themanor.thing.Thing;
import themanor.thing.creature.Creature;

public abstract class Item extends Thing {
    
        public Item(String name){
            super(name);
        }

        public Item(String name, Thing itemHidden) {
            super(name, itemHidden);
        }

        public void use(World w){
            System.out.println("You cannot use it this way!");
        }
        
        public void use(World w,Item i){
            System.out.println("You cannot use both together.");
        }
        
        public void use(World w,Creature c){
            System.out.println("You cannot use it on this creature!");
        }
        
        public void use(World w,Exit e){
            System.out.println("You cannot use it on a door!");
        }

        @Override
        public abstract String toString();

}