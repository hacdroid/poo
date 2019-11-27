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
        return ("A friendly mans pread out at the ground");
    }
    
    public void attacked(Player player, int damage_taken){
        System.out.println("Aïe.");
    }
    
}