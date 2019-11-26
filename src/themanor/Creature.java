package themanor;

public abstract class Creature extends Thing {

    private int hp;
    private final int DAMAGE;
    
    public Creature(int hp, int damage) {
        super();
        this.hp = hp;
        this.DAMAGE = damage;
    }

    public Creature(int hp, int damage , Thing itemHidden) {
        super(itemHidden);
        this.hp = hp;
        this.DAMAGE=damage;
    }
    
    
    public boolean getIsOut(){
        return (this.hp <= 0);
    }
    
    public int getHp(){
        return this.hp;
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
    
    private void attack(Player player, int damage){
        player.attacked(damage);
    }
    
    public abstract String toString();
}