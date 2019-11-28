package themanor;

public class NPC extends Creature {

    public NPC() {
        super(1, 0);
    }

    public NPC(Thing itemHidden) {
        super(1, 0, itemHidden);
    }
    

    @Override
    public String toString() {
        return ("A friendly mans spread out at the ground");
    }
    

    
}