package themanor;

public class Plants extends Creature implements Attackable{

    public Plants() {
        super(20, 3);
    }

    public Plants(Thing itemHidden) {
        super(20, 5, itemHidden);
    }

    @Override
    public String toString() {
        return "Il y a une plante carnivore qui semble hostile. Elle a " +
                this.getHp() + " point(s) de vie.";
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