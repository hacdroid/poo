package themanor.thing.creature;

import themanor.Player;
import themanor.thing.Thing;


/**
 * Classe abstraite des monstres du jeu
 * @author alexa
 */
public abstract class Creature extends Thing {
    protected int hp;
    
    
    /**
     * Consctructeur des monstres
     * @param name correspond au nom du monstre
     * @param hp correspond à la vie du monstre
     * @param damage correspond aux dégats produit par le monstre
     */
    public Creature(String name, int hp, int damage) {
        super(name,damage);
        this.hp = hp;
    }

    
    /**
     * Consctructeur des monstres
     * @param name correspond au nom du monstre
     * @param hp correspond à la vie du monstre
     * @param damage correspond aux dégats produit par le monstre
     * @param itemHidden correspond à une entité débloquable
     */
    public Creature(String name, int hp, int damage , Thing itemHidden) {
        super(name, itemHidden,damage);
        this.hp = hp;
    }
    
    
    /**
     * Cette méthode indique si le monstre est tué ou non
     * @return l'état du monstre de type booléen
     */
    public boolean getIsOut(){
        return (this.hp <= 0);
    }
    
    
    /**
     * Cette méthode donne la quantité de points de vie du monstre
     * @return les points de vie sous forme d'entier
     */
    public int getHp(){
        return this.hp;
    }
    
      
    /**
     * Cette méthode retire des points de vie selon une attaque effectuée
     * @param damage_taken correspond aux points de vie perdu de type int
     */
    public void attacked(int damage_taken){
        if (this.hp-damage_taken>=0)
        {
            this.hp -= damage_taken;
        } else {
            this.hp=0;
        }
    }
    
    
    /**
     * Cette méthode permet de retirer des points de vie d'un joueur
     * selon la force du monstre
     * @param player correspond au joueur attaqué
     */
    public void attack(Player player){
        player.attacked(DAMAGE);
    }
    
    
    /**
     * On redéfinit la méthode toString pour chaque porte
     * @return le message type String
     */    
    @Override
    public abstract String toString();
}