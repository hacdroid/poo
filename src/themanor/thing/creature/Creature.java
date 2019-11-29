package themanor.thing.creature;

import themanor.Player;
import themanor.thing.Thing;

public abstract class Creature extends Thing {

    protected int hp;
    protected final int DAMAGE;
    
    public Creature(String name, int hp, int damage) {
        super(name);
        this.hp = hp;
        this.DAMAGE = damage;
    }

    public Creature(String name, int hp, int damage , Thing itemHidden) {
        super(name, itemHidden);
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
        }
    }
    
    public void attack(Player player){
        player.attacked(DAMAGE);
    }
    
    @Override
    public abstract String toString();
}