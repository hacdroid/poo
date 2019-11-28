package themanor.thing.item;

import themanor.thing.Thing;

public abstract class Item extends Thing {
    
        public Item(){
            super();
        }

        public Item(Thing itemHidden) {
            super(itemHidden);
        }


        public abstract void use();

        public abstract String toString();

}