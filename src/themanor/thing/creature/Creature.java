package themanor.thing.creature;

import themanor.Player;
import themanor.thing.Thing;

public abstract class Creature extends Thing {

    protected int hp;
    
    
    public Creature(String name, int hp, int damage) {
        super(name,damage);
        this.hp = hp;
    }

    public Creature(String name, int hp, int damage , Thing itemHidden) {
        super(name, itemHidden,damage);
        this.hp = hp;
    }
    
    
    public boolean getIsOut(){
        return (this.hp <= 0);
    }
    
    public int getHp(){
        return this.hp;
    }
    
        
    public void attacked(Player player, int damage_taken){
        if (this.hp-damage_taken>=0)
        {
            this.hp -= damage_taken;
        } else {
            this.hp=0;
        }
    }
    
    public void attack(Player player){
        player.attacked(DAMAGE);
    }
    
    @Override
    public abstract String toString();
}