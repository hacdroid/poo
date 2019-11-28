package themanor.thing.item;

import themanor.World;
import themanor.thing.Thing;

public abstract class Item extends Thing {
    
        public Item(String name){
            super(name);
        }

        public Item(String name, Thing itemHidden) {
            super(name, itemHidden);
        }


        public abstract void use(World w);

        @Override
        public abstract String toString();

}