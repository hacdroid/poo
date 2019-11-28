package themanor;

public class Bat extends Creature implements Attackable {
    
    public Bat(){
        super(10, 1);
    }
    
    public Bat(Thing itemHidden) {
        super(10, 1, itemHidden);
    }
    
    
    @Override
    public String toString() {
        return "There is a big black bat flying in this room. It's got " +
                this.getHp() + " life point.";
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
