package themanor;

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