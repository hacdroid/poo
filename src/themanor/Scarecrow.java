package themanor;

public class Scarecrow extends Creature implements Attackable {

    public Scarecrow() {
        super(30, 5);
    }

    public Scarecrow(Thing itemHidden) {
        super(30, 5, itemHidden);
    }


    @Override
    public String toString() {
        return "a scarecrow which seems hostile. It has " +
                this.getHp() + " life points.";
    }
    
    
    public void attacked(Player player, int damage_taken){
        if (!this.getIsOut())
        {
            this.hp -= damage_taken;
            
            if (!this.getIsOut())
                this.attack(player, this.DAMAGE);
            else System.out.println("VOUS AVEZ TUE LE MONSTRE");
        }
        else System.out.println("LE MONSTRE EST DEJA MORT");
    }
    
    public void attack(Player player, int damage){
        player.attacked(damage);
    }
}